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


def crypto_1000_data():

    response = requests.get("https://min-api.cryptocompare.com/data/top/volumes?tsym=USD")
    data = response.json()
    top10 = []
    for i in range(1,11):
        top10.append(data["Data"][i]["SYMBOL"])

    url="https://min-api.cryptocompare.com/data/histoday?fsym={}&tsym=USD&limit=999"
    url_list=[]
    data_list=[]
    for i in top10:
        url_list.append(url.format(i))
    for j in url_list:
        response=requests.get(j)
        data=response.json()
        data_list.append(data['Data'])  

    for i in data_list:
        for dictionary in data_list[data_list.index(i)]:
            dictionary['coin']='{}'.format(top10[data_list.index(i)])
            
    list_of_crypto_dicts=[]
    for lst in data_list:
        for dicti in lst:
            list_of_crypto_dicts.append(dicti)

    return(list_of_crypto_dicts)

data =  crypto_1000_data()
dbuser = "admin"
dbpassword = "dinhdinh1981"
conn=f"mongodb://{dbuser}:{dbpassword}@ds245082.mlab.com:45082/cryptocurrency"
client = pymongo.MongoClient(conn)
db = client.cryptocurrency
cryptopython10 = db.cryptopython10
db.drop_collection(cryptopython10)
cryptopython10.insert_many(data)