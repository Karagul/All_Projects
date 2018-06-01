

```python
# Dependencies
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
from scipy import stats
import matplotlib.patches as mpatches
from matplotlib.lines import Line2D
from bokeh import plotting
import matplotlib.text as mtext
```


```python
city_data = pd.read_csv("raw_data/city_data.csv")
ride_data = pd.read_csv("raw_data/ride_data.csv")

```


```python
ride_data_cal = ride_data.groupby('city')
#Calculate average fare per city
average_ride_fare = round(ride_data_cal['fare'].mean(),2)
average_ride_fare
#Calculate total ride per city
total_ride = ride_data_cal['ride_id'].count()
total_ride
#Create new dataframe with 2 new data
ride_data_cal = pd.DataFrame({ "average fare":average_ride_fare,"total ride": total_ride})
ride_data_cal.reset_index('city',inplace=True)
#Merge new dataframe with city_data to correspond the cities with its types(Urban, Suburban, Rural)
consol_data = pd.merge(ride_data_cal,city_data,how="left", on=["city", "city"])
```

# Bubble Plot of Ride Sharing Data


```python
#fig,ax = plt.subplots()

#Filter data based on City Types
urban_data = consol_data[consol_data['type']=='Urban']
suburban_data = consol_data[consol_data['type']=='Suburban']
rural_data = consol_data[consol_data['type']=='Rural']
#Plot out
plt.figure(figsize=(9,6))
plt.scatter(urban_data['total ride'], urban_data['average fare'], s=urban_data['driver_count']*15,alpha=0.75,c='lightcoral',label='Urban',edgecolor='black',linewidths=0.75)
plt.scatter(suburban_data['total ride'], suburban_data['average fare'], s=suburban_data['driver_count']*15,alpha=0.75,c='lightskyblue',label='Suburban',edgecolor='black',linewidths=0.75)
plt.scatter(rural_data['total ride'], rural_data['average fare'], s=rural_data['driver_count']*15,alpha=0.75,c='gold',label='Rural',edgecolor='black',linewidths=0.75)

#for key, row in consol_data.iterrows():
#    if row['type'] =='Urban':
 #       plt.scatter(row['total ride'], row['average fare'], s=row['driver_count']*8,alpha=0.5,c='lightcoral',label='Urban')
  #      #urban_patch = mpatches.Patch(color='red', label='Urban',linestyle = 'dotted')
   # elif row['type'] =='Suburban':
    #    plt.scatter(row['total ride'], row['average fare'], s=row['driver_count']*7, alpha=0.5,c='lightskyblue',label='Suburban')
        #suburban_patch = mpatches.Patch(color='blue', label='Suburban')
    #elif row['type'] =='Rural':
     #   plt.scatter(row['total ride'], row['average fare'], s=row['driver_count']*6, alpha=0.5,c='gold',label='Rural')
        #rural_patch = mpatches.Patch(color='yellow', label='Rural')
#legend_elements = [Line2D([0], [0], marker = 'o', color='red',label='Urban',markerfacecolor='red', markersize=5),
 #                  Line2D([0], [0], marker='o', color='blue', label='Suburban',markerfacecolor='blue', markersize=5),
  #                 Line2D([0], [0], marker = 'o', color='yellow',label='Rural',markerfacecolor='yellow', markersize=5)]
#handles, labels = ax.get_legend_handles_labels()
#labels = ['Urban','Suburban','Rural']
#handles = ['red','yellow','blue']
#check1 = plt.legend(frameon=False)
#check1.legendHandles[0]._sizes=[45]
#check1.legendHandles[0].set_color('lightcoral')
#check1.legendHandles[1]._sizes=[35]
#check1.legendHandles[1].set_color('lightskyblue')
#check1.legendHandles[2]._sizes=[50]
#check1.legendHandles[2].set_color('gold')

plt.xlim(min(consol_data['total ride'])-5, max(consol_data['total ride'])+5)
plt.ylim(min(consol_data['average fare'])-5, max(consol_data['average fare'])+5)
plt.suptitle("Pyber Ride Share Data(2016)", fontsize = 16, fontweight="bold")
plt.title('Note:\nCircle size correlates with driver count per city',x=1.4,y=0.5)
plt.xlabel('Total Nmber of Ride (per City)')
plt.ylabel('Average Fare($)')
#Set legend title and size of points
fontsiz = plt.legend(frameon=False,labelspacing=0.9)
fontsiz.set_title("City Types", prop = {'size':12})
fontsiz.legendHandles[0]._sizes=[45]
fontsiz.legendHandles[1]._sizes=[45]
fontsiz.legendHandles[2]._sizes=[45]
plt.grid()
plt.savefig("Images/Pyberrideshare.png")
plt.show()



```


![png](output_4_0.png)



```python
#Using seaborn to chart out
import seaborn as sns
seadata = consol_data.rename(columns={"type": "City Types"})
sns.lmplot(x="total ride", y="average fare", data=seadata , fit_reg=False, hue="City Types", legend=True, legend_out=False)
plt.suptitle("Pyber Ride Share Data(2016)", fontsize = 16, fontweight="bold",y=1.1)
plt.title('Note: Circle size correlates with driver count per city',x=1.7,y=0.5)
plt.xlabel('Total Nmber of Ride(per City)')
plt.ylabel('Average Fare($)')
plt.grid()
plt.legend(title='City Types',frameon=False)
plt.show()

```


![png](output_5_0.png)


# Total Fares by City Type


```python
#Reuse city_data calculate, merge with ride data to calculate total fare.
merge_data = pd.merge(ride_data,city_data, how="left", on=["city", "city"])
#all Charts below relate to City Type so will use this dataframe 'total_type'
total_type = merge_data.groupby('type')
chart_fare = total_type['fare'].sum().reset_index()

colors = ["gold", "lightskyblue", "lightcoral"]
explode = (0, 0, 0.1)
plt.figure(figsize=(12,10))
#total_percentage_chart = chart_fare.plot(kind="pie",explode=explode,colors=colors, autopct="%1.1f%%",shadow=True, startangle=160, title="% of Total Fares by City Type")
plt.pie(chart_fare['fare'],explode=explode,labels=chart_fare['type'],colors=colors,autopct="%1.1f%%", shadow=True, startangle=160)
plt.savefig("Images/totalfarescity.png")
plt.show()
```


![png](output_7_0.png)





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
      <th>city</th>
      <th>date</th>
      <th>fare</th>
      <th>ride_id</th>
      <th>driver_count</th>
      <th>type</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>Sarabury</td>
      <td>2016-01-16 13:49:27</td>
      <td>38.35</td>
      <td>5403689035038</td>
      <td>46</td>
      <td>Urban</td>
    </tr>
    <tr>
      <th>1</th>
      <td>South Roy</td>
      <td>2016-01-02 18:42:34</td>
      <td>17.49</td>
      <td>4036272335942</td>
      <td>35</td>
      <td>Urban</td>
    </tr>
    <tr>
      <th>2</th>
      <td>Wiseborough</td>
      <td>2016-01-21 17:35:29</td>
      <td>44.18</td>
      <td>3645042422587</td>
      <td>55</td>
      <td>Urban</td>
    </tr>
    <tr>
      <th>3</th>
      <td>Spencertown</td>
      <td>2016-07-31 14:53:22</td>
      <td>6.87</td>
      <td>2242596575892</td>
      <td>68</td>
      <td>Urban</td>
    </tr>
    <tr>
      <th>4</th>
      <td>Nguyenbury</td>
      <td>2016-07-09 04:42:44</td>
      <td>6.28</td>
      <td>1543057793673</td>
      <td>8</td>
      <td>Urban</td>
    </tr>
    <tr>
      <th>1625</th>
      <td>Port James</td>
      <td>2016-12-04 06:16:36</td>
      <td>15.77</td>
      <td>2259499336994</td>
      <td>15</td>
      <td>Suburban</td>
    </tr>
    <tr>
      <th>1626</th>
      <td>Port James</td>
      <td>2016-12-04 06:16:36</td>
      <td>15.77</td>
      <td>2259499336994</td>
      <td>3</td>
      <td>Suburban</td>
    </tr>
    <tr>
      <th>1627</th>
      <td>New Samanthaside</td>
      <td>2016-06-05 14:36:58</td>
      <td>39.38</td>
      <td>3647873452658</td>
      <td>16</td>
      <td>Suburban</td>
    </tr>
    <tr>
      <th>1628</th>
      <td>Port Alexandria</td>
      <td>2016-07-29 09:30:09</td>
      <td>24.86</td>
      <td>2962960319234</td>
      <td>27</td>
      <td>Suburban</td>
    </tr>
    <tr>
      <th>1629</th>
      <td>Lake Brenda</td>
      <td>2016-08-26 03:07:30</td>
      <td>20.97</td>
      <td>5231983896020</td>
      <td>24</td>
      <td>Suburban</td>
    </tr>
    <tr>
      <th>2282</th>
      <td>Horneland</td>
      <td>2016-07-19 10:07:33</td>
      <td>12.63</td>
      <td>8214498891817</td>
      <td>8</td>
      <td>Rural</td>
    </tr>
    <tr>
      <th>2283</th>
      <td>Kinghaven</td>
      <td>2016-05-18 23:28:12</td>
      <td>20.53</td>
      <td>6432117120069</td>
      <td>3</td>
      <td>Rural</td>
    </tr>
    <tr>
      <th>2284</th>
      <td>New Johnbury</td>
      <td>2016-04-21 08:30:25</td>
      <td>56.60</td>
      <td>9002881309143</td>
      <td>6</td>
      <td>Rural</td>
    </tr>
    <tr>
      <th>2285</th>
      <td>South Joseph</td>
      <td>2016-02-17 01:41:29</td>
      <td>57.52</td>
      <td>7365786843443</td>
      <td>3</td>
      <td>Rural</td>
    </tr>
    <tr>
      <th>2286</th>
      <td>Kennethburgh</td>
      <td>2016-10-19 13:13:17</td>
      <td>24.43</td>
      <td>2728236352387</td>
      <td>3</td>
      <td>Rural</td>
    </tr>
  </tbody>
</table>
</div>



# Total Rides by City Type


```python
plt.figure(figsize=(12,10))
chart_ride = total_type['ride_id'].count().reset_index()
plt.pie(chart_ride['ride_id'],explode=explode,labels=chart_ride['type'],colors=colors,autopct="%1.1f%%", shadow=True, startangle=160)
plt.savefig("Images/totalridescity.png")
plt.show()

```


![png](output_9_0.png)


# Total Drivers by City Type


```python
plt.figure(figsize=(12,10))
chart_driver = total_type['driver_count'].sum().reset_index()
plt.pie(chart_driver['driver_count'],explode=explode,labels=chart_driver['type'],colors=colors,autopct="%1.1f%%", shadow=True, startangle=160)
plt.savefig("Images/totaldriverscity.png")
plt.show()
```


![png](output_11_0.png)

