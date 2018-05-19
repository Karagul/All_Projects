

```python
import pandas as pd
import numpy
```


```python
#Output File Name
file_output_purchases_json = "generated_data/purchase_data.json"
purchasing_df = pd.read_json(file_output_purchases_json)
```

# Player Count


```python
total = len(purchasing_df["SN"].value_counts()) 
total_player = pd.DataFrame({"Total Players":[total]}) 
total_player
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Total Players</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>573</td>
    </tr>
  </tbody>
</table>
</div>



# Purchasing Analysis


```python
unique_item = len(purchasing_df["Item ID"].unique())
average_price = round(purchasing_df["Price"].mean(),2)
no_purchases = len(purchasing_df)
total_revenue = purchasing_df["Price"].sum()

purchasing_analysis = pd.DataFrame({"Number of Unique Items" :[unique_item], "Average Price":[average_price], "Number of Purchases":[no_purchases],"Total Revenue":[total_revenue]},
                                  columns=["Number of Unique Items","Average Price", "Number of Purchases","Total Revenue"])
purchasing_analysis["Total Revenue"] = purchasing_analysis["Total Revenue"].map("${:.2f}".format)
purchasing_analysis["Average Price"] = purchasing_analysis["Average Price"].map("${:.2f}".format)
purchasing_analysis
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Number of Unique Items</th>
      <th>Average Price</th>
      <th>Number of Purchases</th>
      <th>Total Revenue</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>183</td>
      <td>$2.93</td>
      <td>780</td>
      <td>$2286.33</td>
    </tr>
  </tbody>
</table>
</div>



# Gender Demographics


```python
gender_count= purchasing_df.drop_duplicates('SN')
total_gender = gender_count["Gender"].value_counts()
average = round(total_gender/total_gender.sum() * 100,2)
gender_demogra = pd.DataFrame({"Total Count":total_gender,"Percentage of Players":average})
gender_demogra
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Percentage of Players</th>
      <th>Total Count</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>Male</th>
      <td>81.15</td>
      <td>465</td>
    </tr>
    <tr>
      <th>Female</th>
      <td>17.45</td>
      <td>100</td>
    </tr>
    <tr>
      <th>Other / Non-Disclosed</th>
      <td>1.40</td>
      <td>8</td>
    </tr>
  </tbody>
</table>
</div>



# Purchasing Analysis (Gender)


```python
grouped_purchasing_gender = purchasing_df.groupby(['Gender'])
total_each_gender = grouped_purchasing_gender['Price'].sum()
purchase_count = grouped_purchasing_gender['Item ID'].count()
average_purchase = grouped_purchasing_gender['Price'].mean()
count_gender_unique = purchasing_df.drop_duplicates('SN') # Find gender after removed duplicates in purchasing file(json file)
norn_total = total_each_gender/count_gender_unique['Gender'].value_counts() # or reuse total_gender value from above question
#norn_total = (grouped_purchasing_gender['Price'] - grouped_purchasing_gender['Price'].min())/(grouped_purchasing_gender['Price'].max()-grouped_purchasing_gender['Price'].min())
purchase_gender_df = pd.DataFrame({"Purchase Count":purchase_count,"Average Purchase Price":round(average_purchase,2), "Total Purchase Value":total_each_gender,"Normalized Totals":round(norn_total,2)},
                     columns=["Purchase Count","Average Purchase Price","Total Purchase Value","Normalized Totals"]
                     )
purchase_gender_df["Average Purchase Price"] = purchase_gender_df["Average Purchase Price"].map("${:.2f}".format)
purchase_gender_df["Normalized Totals"] = purchase_gender_df["Normalized Totals"].map("${:.2f}".format)
purchase_gender_df["Total Purchase Value"] = purchase_gender_df["Total Purchase Value"].map("${:.2f}".format)
purchase_gender_df
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Purchase Count</th>
      <th>Average Purchase Price</th>
      <th>Total Purchase Value</th>
      <th>Normalized Totals</th>
    </tr>
    <tr>
      <th>Gender</th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>Female</th>
      <td>136</td>
      <td>$2.82</td>
      <td>$382.91</td>
      <td>$3.83</td>
    </tr>
    <tr>
      <th>Male</th>
      <td>633</td>
      <td>$2.95</td>
      <td>$1867.68</td>
      <td>$4.02</td>
    </tr>
    <tr>
      <th>Other / Non-Disclosed</th>
      <td>11</td>
      <td>$3.25</td>
      <td>$35.74</td>
      <td>$4.47</td>
    </tr>
  </tbody>
</table>
</div>



 # AGE DEMOGRAPHIC


```python
bins = [0, 9, 14, 19, 24, 29, 34, 39, 100] #Create Bins
# Create labels for these bins
age_ranges = ["<10", "10-14", "15-19", "20-24", "25-29","30-34","35-39", "40+"]
purchasing_df["Age Summary"] = pd.cut(purchasing_df["Age"], bins, labels= age_ranges)
#Drop duplicates values before count age.
grouped_purchasing = purchasing_df.drop_duplicates('SN')
total_age_ranges = grouped_purchasing["Age Summary"].value_counts()
average_age= round(total_age_ranges/total_age_ranges.sum() * 100,2)
age_demogra_df = pd.DataFrame({"Total Count":total_age_ranges,"Percentage of Players":average_age})
#age_demogra.sort_values(by=['Percentage of Players','Total Count'],ascending=False)
#Sorting data
#age_demogra_df.reset_index()
#age_demogra_df.sort_values(by=['index'])
age_demogra_df.sort_values(by='Percentage of Players')

```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Percentage of Players</th>
      <th>Total Count</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>40+</th>
      <td>1.92</td>
      <td>11</td>
    </tr>
    <tr>
      <th>&lt;10</th>
      <td>3.32</td>
      <td>19</td>
    </tr>
    <tr>
      <th>10-14</th>
      <td>4.01</td>
      <td>23</td>
    </tr>
    <tr>
      <th>35-39</th>
      <td>4.71</td>
      <td>27</td>
    </tr>
    <tr>
      <th>30-34</th>
      <td>8.20</td>
      <td>47</td>
    </tr>
    <tr>
      <th>25-29</th>
      <td>15.18</td>
      <td>87</td>
    </tr>
    <tr>
      <th>15-19</th>
      <td>17.45</td>
      <td>100</td>
    </tr>
    <tr>
      <th>20-24</th>
      <td>45.20</td>
      <td>259</td>
    </tr>
  </tbody>
</table>
</div>



# Purchasing Analysis (Age)


```python
#Purchasing Analysis (Age)
grouped_purchasing_age = purchasing_df["Age Summary"].value_counts()
grouped_purchasing = purchasing_df.groupby(['Age Summary'])
total_each_age = grouped_purchasing['Price'].sum()
average_purchase_age = grouped_purchasing['Price'].mean()
norn_total_age = total_each_age/total_age_ranges #or reuse total_age_ranges value from above question
purchase_age_df =pd.DataFrame({"Purchase Count":grouped_purchasing_age,"Total Purchase Price":total_each_age,"Average Purchase Price":round(average_purchase_age,2),"Normalized Totals":round(norn_total_age,2)},columns=["Purchase Count","Average Purchase Price","Total Purchase Price","Normalized Totals"])
#Formatting $
purchase_age_df["Average Purchase Price"] = purchase_age_df["Average Purchase Price"].map("${:.2f}".format)
purchase_age_df["Normalized Totals"] = purchase_age_df["Normalized Totals"].map("${:.2f}".format)
purchase_age_df["Total Purchase Price"] = purchase_age_df["Total Purchase Price"].map("${:.2f}".format)
#Set index for sorting 
purchase_age_df.sort_values(by='Purchase Count')
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Purchase Count</th>
      <th>Average Purchase Price</th>
      <th>Total Purchase Price</th>
      <th>Normalized Totals</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>40+</th>
      <td>17</td>
      <td>$3.16</td>
      <td>$53.75</td>
      <td>$4.89</td>
    </tr>
    <tr>
      <th>&lt;10</th>
      <td>28</td>
      <td>$2.98</td>
      <td>$83.46</td>
      <td>$4.39</td>
    </tr>
    <tr>
      <th>10-14</th>
      <td>35</td>
      <td>$2.77</td>
      <td>$96.95</td>
      <td>$4.22</td>
    </tr>
    <tr>
      <th>35-39</th>
      <td>42</td>
      <td>$2.84</td>
      <td>$119.40</td>
      <td>$4.42</td>
    </tr>
    <tr>
      <th>30-34</th>
      <td>64</td>
      <td>$3.08</td>
      <td>$197.25</td>
      <td>$4.20</td>
    </tr>
    <tr>
      <th>25-29</th>
      <td>125</td>
      <td>$2.96</td>
      <td>$370.33</td>
      <td>$4.26</td>
    </tr>
    <tr>
      <th>15-19</th>
      <td>133</td>
      <td>$2.91</td>
      <td>$386.42</td>
      <td>$3.86</td>
    </tr>
    <tr>
      <th>20-24</th>
      <td>336</td>
      <td>$2.91</td>
      <td>$978.77</td>
      <td>$3.78</td>
    </tr>
  </tbody>
</table>
</div>



# Top Spenders


```python
#Top Spenders
grouped_purchasing_spender = purchasing_df.groupby(['SN'])
total_each_spender = grouped_purchasing_spender['Price'].sum()
purchase_count_spender = grouped_purchasing_spender['Item ID'].count()
average_purchase_spender = grouped_purchasing_spender['Price'].mean()
spender_df = pd.DataFrame({"Purchase Count":purchase_count_spender,"Average Purchase Price":round(average_purchase_spender,2), "Total Purchase Value":total_each_spender},
                     columns=["Purchase Count","Average Purchase Price","Total Purchase Value"])

spender_df_temp = spender_df.nlargest(5,'Total Purchase Value')

spender_df_temp["Total Purchase Value"] =spender_df_temp["Total Purchase Value"].map("${:.2f}".format)
spender_df_temp["Average Purchase Price"] = spender_df_temp["Average Purchase Price"].map("${:.2f}".format)

spender_df_temp
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Purchase Count</th>
      <th>Average Purchase Price</th>
      <th>Total Purchase Value</th>
    </tr>
    <tr>
      <th>SN</th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>Undirrala66</th>
      <td>5</td>
      <td>$3.41</td>
      <td>$17.06</td>
    </tr>
    <tr>
      <th>Saedue76</th>
      <td>4</td>
      <td>$3.39</td>
      <td>$13.56</td>
    </tr>
    <tr>
      <th>Mindimnya67</th>
      <td>4</td>
      <td>$3.18</td>
      <td>$12.74</td>
    </tr>
    <tr>
      <th>Haellysu29</th>
      <td>3</td>
      <td>$4.24</td>
      <td>$12.73</td>
    </tr>
    <tr>
      <th>Eoda93</th>
      <td>3</td>
      <td>$3.86</td>
      <td>$11.58</td>
    </tr>
  </tbody>
</table>
</div>



# Most Popular Items


```python
#Most Popular Items
most_popular_item = purchasing_df.groupby(['Item ID','Item Name'])

purchase_count_popular = most_popular_item['Item ID'].count()
total_purchase_popular = most_popular_item['Price'].sum()
item_price = most_popular_item["Price"].unique()

popular_df = pd.DataFrame({"Purchase Count":purchase_count_popular,"Item Price":item_price.str.get(0), "Total Purchase Value":total_purchase_popular},columns=["Purchase Count","Item Price","Total Purchase Value"])

popular_df_temp= popular_df.nlargest(5,'Purchase Count')

popular_df_temp["Total Purchase Value"] =popular_df_temp["Total Purchase Value"].map("${:.2f}".format)
popular_df_temp["Item Price"] = popular_df_temp["Item Price"].map("${:.2f}".format)

popular_df_temp

```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th></th>
      <th>Purchase Count</th>
      <th>Item Price</th>
      <th>Total Purchase Value</th>
    </tr>
    <tr>
      <th>Item ID</th>
      <th>Item Name</th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>39</th>
      <th>Betrayal, Whisper of Grieving Widows</th>
      <td>11</td>
      <td>$2.35</td>
      <td>$25.85</td>
    </tr>
    <tr>
      <th>84</th>
      <th>Arcane Gem</th>
      <td>11</td>
      <td>$2.23</td>
      <td>$24.53</td>
    </tr>
    <tr>
      <th>13</th>
      <th>Serenity</th>
      <td>9</td>
      <td>$1.49</td>
      <td>$13.41</td>
    </tr>
    <tr>
      <th>31</th>
      <th>Trickster</th>
      <td>9</td>
      <td>$2.07</td>
      <td>$18.63</td>
    </tr>
    <tr>
      <th>34</th>
      <th>Retribution Axe</th>
      <td>9</td>
      <td>$4.14</td>
      <td>$37.26</td>
    </tr>
  </tbody>
</table>
</div>



# Most Profitable Items


```python
#Most profitable Items
most_profitable_item = purchasing_df.groupby(['Item ID','Item Name'])

purchase_count_profitable = most_profitable_item['Item ID'].count()
total_purchase_profitable = most_profitable_item['Price'].sum()
item_price_profitable = most_profitable_item["Price"].unique()

profitable_df = pd.DataFrame({"Purchase Count":purchase_count_profitable,"Item Price":item_price_profitable.str.get(0), "Total Purchase Value":total_purchase_profitable},columns=["Purchase Count","Item Price","Total Purchase Value"])

profitable_df_temp = profitable_df.nlargest(5,'Total Purchase Value')

profitable_df_temp["Total Purchase Value"] =profitable_df_temp["Total Purchase Value"].map("${:.2f}".format)
profitable_df_temp["Item Price"] = profitable_df_temp["Item Price"].map("${:.2f}".format)

profitable_df_temp
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th></th>
      <th>Purchase Count</th>
      <th>Item Price</th>
      <th>Total Purchase Value</th>
    </tr>
    <tr>
      <th>Item ID</th>
      <th>Item Name</th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>34</th>
      <th>Retribution Axe</th>
      <td>9</td>
      <td>$4.14</td>
      <td>$37.26</td>
    </tr>
    <tr>
      <th>115</th>
      <th>Spectral Diamond Doomblade</th>
      <td>7</td>
      <td>$4.25</td>
      <td>$29.75</td>
    </tr>
    <tr>
      <th>32</th>
      <th>Orenmir</th>
      <td>6</td>
      <td>$4.95</td>
      <td>$29.70</td>
    </tr>
    <tr>
      <th>103</th>
      <th>Singed Scalpel</th>
      <td>6</td>
      <td>$4.87</td>
      <td>$29.22</td>
    </tr>
    <tr>
      <th>107</th>
      <th>Splitter, Foe Of Subtlety</th>
      <td>8</td>
      <td>$3.61</td>
      <td>$28.88</td>
    </tr>
  </tbody>
</table>
</div>


