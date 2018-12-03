# coding: utf-8

# *BTC
# *BCH
# *ETC
# *ETH
# *XRP
# *XMR
# *STR
# *LTC
# *DASH
# *NEOS

import numpy as np
import pandas as pd
import quandl
import pickle
import os
from datetime import datetime
from config import API_KEY
from config_poloniex import api_key
import pymongo
import requests
import json


def crypto_data():

    quandl.ApiConfig.api_key =API_KEY
    data_directory='data/'
    
    def save_quandl_data(quandl_pair):
        pickle_path='{}{}.pk1'.format(data_directory,quandl_pair.replace("/","_"))

        try:
            file_cache_=open(pickle_path,"rb")
            stream_df=pickle.load(file_cache)
#       print(f"{quandl_pair} data loading")
        except (OSError,IOError,NameError) as e:
#       print(f"Downloading {quandl_pair} data from quandl")
            stream_df = quandl.get(quandl_pair,returns="pandas")
            stream_df.to_pickle(pickle_path)

        return stream_df

    btc_exchanges=['OKCOIN','BITFLYER','BITSTAMP','KRAKEN']

    for btc_exchange in btc_exchanges:
        database_exchange='BCHARTS/{}USD'.format(btc_exchange)
        save_quandl_data(database_exchange)

    btc_okcoin_df=pd.read_pickle('data/BCHARTS_OKCOINUSD.pk1')
    btc_bitflyer_df=pd.read_pickle('data/BCHARTS_BITFLYERUSD.pk1')
    btc_bitstamp_df=pd.read_pickle('data/BCHARTS_BITSTAMPUSD.pk1')
    btc_kraken_df=pd.read_pickle('data/BCHARTS_KRAKENUSD.pk1')

    first_merge=pd.merge(btc_okcoin_df, btc_kraken_df[['Weighted Price']], how='outer',right_index=True,left_index=True, suffixes=['_okcoin','_kraken'])
    second_merge=pd.merge(first_merge,btc_bitflyer_df[['Weighted Price']],how='outer',right_index=True,left_index=True)
    btc_rate_data=pd.merge(second_merge,btc_bitstamp_df[['Weighted Price']], how='outer',right_index=True,left_index=True,suffixes=['_bitflyer','_bitstamp'])
    btc_rate_data=btc_rate_data[['Weighted Price_okcoin',
                     'Weighted Price_kraken',
                               'Weighted Price_bitflyer',
                              'Weighted Price_bitstamp']]

    btc_rate_data.replace(0,np.nan, inplace=True)
    btc_rate_data['btc_usd_gwa'] = btc_rate_data.mean(axis=1)


    data_directory_2='data/'
    def get_json(url,file_name):
        cache_path_json='{}{}.pk1'.format(data_directory_2,file_name.replace("/","_"))
        try:
            cache=open(cache_path_json,'rb')
            json_data_df=pickle.load(cache)
#             print('{} loaded from cache'.format(file_name))
        except (OSError,IOError) as e:
#             print('Downloading data {}'.format(url))
            json_data_df=pd.read_json(url)
            json_data_df.to_pickle(cache_path_json)
        return(json_data_df)

    poloniex_url="https://poloniex.com/public?command=returnChartData&currencyPair={}&start={}&end={}&period={}"
    currency_pairs=['BTC_BCH','BTC_ETC','BTC_ETH','BTC_XRP','BTC_XMR','BTC_STR','BTC_LTC','BTC_DASH','BTC_NEOS']
    start_date=datetime.strptime('2014-01-01','%Y-%m-%d')
    end_date=datetime.now()
    period=86400

    def get_poloniex_data(currency_pair):
        pair_json_url=poloniex_url.format(currency_pair,start_date.timestamp(),end_date.timestamp(),period)
        currency_pair_data=get_json(pair_json_url,currency_pair)
        return(currency_pair_data)


    poloniex_df_list=[]
    df_lengths=[]
    for i in currency_pairs:
    
        data=get_poloniex_data(i)
        poloniex_df_list.append(data)
    

    poloniex_df_list[0]["coin_pair"] = "BTC_BCH"
    poloniex_df_list[0]=poloniex_df_list[0][['coin_pair','date','close','high','low','open','quoteVolume','volume','weightedAverage']]

    poloniex_df_list[1]["coin_pair"] = "BTC_ETC"
    poloniex_df_list[1]=poloniex_df_list[1][['coin_pair','date','close','high','low','open','quoteVolume','volume','weightedAverage']]

    poloniex_df_list[2]["coin_pair"] = "BTC_ETH"
    poloniex_df_list[2]=poloniex_df_list[2][['coin_pair','date','close','high','low','open','quoteVolume','volume','weightedAverage']]

    poloniex_df_list[3]["coin_pair"] = "BTC_XRP"
    poloniex_df_list[3]=poloniex_df_list[3][['coin_pair','date','close','high','low','open','quoteVolume','volume','weightedAverage']]

    poloniex_df_list[4]["coin_pair"] = "BTC_XMR"
    poloniex_df_list[4]=poloniex_df_list[4][['coin_pair','date','close','high','low','open','quoteVolume','volume','weightedAverage']]

    poloniex_df_list[5]["coin_pair"] = "BTC_STR"
    poloniex_df_list[5]=poloniex_df_list[5][['coin_pair','date','close','high','low','open','quoteVolume','volume','weightedAverage']]

    poloniex_df_list[6]["coin_pair"] = "BTC_LTC"
    poloniex_df_list[6]=poloniex_df_list[6][['coin_pair','date','close','high','low','open','quoteVolume','volume','weightedAverage']]

    poloniex_df_list[7]["coin_pair"] = "BTC_DASH"
    poloniex_df_list[7]=poloniex_df_list[7][['coin_pair','date','close','high','low','open','quoteVolume','volume','weightedAverage']]

    poloniex_df_list[8]["coin_pair"] = "BTC_NEOS"
    poloniex_df_list[8]=poloniex_df_list[8][['coin_pair','date','close','high','low','open','quoteVolume','volume','weightedAverage']]

    btc_rate_data['coin_pair']='BTC_USD'


    poloniex_df_list_revised=[]
    for df in poloniex_df_list:
        df=df.reset_index()
        df=df.set_index('date')
        del df['index']
        df['price_usd'] =  df['weightedAverage'] * btc_rate_data['btc_usd_gwa']
        poloniex_df_list_revised.append(df)


    poloniex_single_df = pd.concat(poloniex_df_list_revised)

    poloniex_single_df=poloniex_single_df.reset_index()
    poloniex_single_df=poloniex_single_df[['coin_pair','date','close','high','low','open','quoteVolume','volume','weightedAverage','price_usd']]

    btc_rate_data['quoteVolume']='placeholder'
    btc_rate_data['volume']='placeholder'
    btc_rate_data['weightedAverage']='placeholder'
    btc_rate_data=btc_rate_data.reset_index()

    btc_rate_data=btc_rate_data.rename(columns={'Date':'date',
                                                'Weighted Price_okcoin':'close',
                                            'Weighted Price_kraken':'high',
                                           'Weighted Price_bitflyer':'low',
                                           'Weighted Price_bitstamp':'open',
                                           'btc_usd_gwa':'price_usd'})

    btc_rate_data=btc_rate_data[['coin_pair','date','close','high','low','open','quoteVolume','volume','weightedAverage','price_usd']]


    concat_list=[poloniex_single_df,btc_rate_data]
    coin_data=pd.concat(concat_list)

    coin_data=coin_data.to_dict(orient='records')

    return (coin_data)

data = crypto_data()
dbuser = "admin"
dbpassword = "dinhdinh1981"
conn=f"mongodb://{dbuser}:{dbpassword}@ds245082.mlab.com:45082/cryptocurrency"
client = pymongo.MongoClient(conn)
db = client.cryptocurrency
cryptopython = db.cryptopython
db.drop_collection(cryptopython)
cryptopython.insert_many(data)
