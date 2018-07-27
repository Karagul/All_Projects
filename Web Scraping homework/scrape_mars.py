from splinter import Browser
from bs4 import BeautifulSoup
import pandas as pd

def init_browser():
    # @NOTE: Replace the path with your actual path to the chromedriver
    executable_path = {"executable_path": "chromedriver.exe"}
    return Browser("chrome", **executable_path, headless=False)


def scrape():
    browser = init_browser()
    marsdata = {}
    # 1-NASA Mars News
    url = "https://mars.nasa.gov/news/?page=0&per_page=40&order=publish_date+desc%2Ccreated_at+desc&search=&category=19%2C165%2C184%2C204&blank_scope=Latest"
    browser.visit(url)
    html = browser.html
    soup = BeautifulSoup(html, "html.parser")
    # Extract the lastest title and its article teaser on the NASA Mars News
    news_title = soup.find('div', class_='content_title').text.strip()
    news_p = soup.find('div',class_='article_teaser_body').text.strip()
    linknews = "https://mars.nasa.gov/" + soup.find('div', class_='content_title')('a')[0]["href"]
    marsdata["newstitle"] =news_title
    marsdata["newscontenteaser"] = news_p
    marsdata["linknews"]=linknews

    # 2- JPL Mars Space Images - Featured Image
    url_image = "https://www.jpl.nasa.gov/spaceimages/?search=&category=Mars"
    browser.visit(url_image)
    html = browser.html
    soup = BeautifulSoup(html, "html.parser")
    imagelink = soup.find('ul', class_='articles')('li',class_= "slide")[0]('a',class_="fancybox")[0]["data-fancybox-href"]
    imagefullink = "https://www.jpl.nasa.gov" + imagelink
    marsdata["Marslatestimagelink"] = imagefullink

    # 3- Mars Weather
    url_weather = "https://twitter.com/marswxreport?lang=en"
    browser.visit(url_weather)
    html = browser.html
    soup = BeautifulSoup(html, "html.parser")
    
    #Since all tweets will be quote stored in li tags with class_="js-stream-item stream-item stream-item '")
    weathercheck = soup.find_all('li',class_='js-stream-item stream-item stream-item ')
    check = ""
    for weather in weathercheck:
    #But just tweet from original Mars Weather using the class: tweet js-stream-tweet js-actionable-tweet js-profile-popup-actionable dismissible-content original-tweet js-original-tweet 
        if (weather('div',class_="tweet js-stream-tweet js-actionable-tweet js-profile-popup-actionable dismissible-content original-tweet js-original-tweet ")):
            check = weather('div',class_="tweet js-stream-tweet js-actionable-tweet js-profile-popup-actionable dismissible-content original-tweet js-original-tweet ")
            #This condition is redundant but to make sure tweet is from MARS WEATHER and for weather data by every single tweet frm Mars Weather will be displayed "MarsWxReport"
            if (check[0]["data-screen-name"] == "MarsWxReport"):
                #After find the first one with above conditions then assign as lastest tweet
                break
    #Slice weather data of that lastest tweet 
    mars_weather = check[0]('div',class_="js-tweet-text-container")[0]('p',class_="TweetTextSize TweetTextSize--normal js-tweet-text tweet-text")[0].text
    marsdata["weatherinfo"] = mars_weather

    # 4- Mars Facts
    urlmarsfacts = 'https://space-facts.com/mars/'
    table = pd.read_html(urlmarsfacts)
    dfmars=table[0]
    dfmars.columns=['Description','Value']
    dfmars.set_index('Description',inplace= True)
    html_tablemarsfacts = dfmars.to_html()
    html_tablemarsfacts = html_tablemarsfacts.replace('\n', '')
    marsdata["marsfact"] = html_tablemarsfacts

    # 5- Mars Hemispheres
    urlHemispheres = 'https://astrogeology.usgs.gov/search/results?q=hemisphere+enhanced&k1=target&v1=Mars'
    browser.visit(urlHemispheres)
    html = browser.html
    soup = BeautifulSoup(html, 'html.parser')
    #Find the links
    links = soup.find_all('div',class_="item")
    link = []
    for lnk in links:
        link.append("https://astrogeology.usgs.gov" + lnk('a',class_="itemLink product-item")[0]["href"])
    
    hemisphere_image_urls=[]
    for detail in link:
        title = ""
        img_url=""
        listitem={"title":"","img_url":""}
        browser.visit(detail)
        html = browser.html
        soup = BeautifulSoup(html, 'html.parser')
        title = soup('h2',class_="title")[0].text
        img_url= soup('div',class_="wide-image-wrapper")[0]('a')[0]["href"]
        listitem["title"] = title
        listitem["img_url"]=img_url
        hemisphere_image_urls.append(listitem)
    marsdata["link"] = link
    marsdata["marshemisphereimage"] = hemisphere_image_urls

    return marsdata