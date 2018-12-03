// saving new data to MLAB
function newstoMlab() {

$.get("https://min-api.cryptocompare.com/data/v2/news/?lang=EN", function(data, status){
 
  var sourcenews = [];
   for(let i = 1; i<=10;i++) { 
    let date = new Date(data.Data[i].published_on*1000);
    sourcenews.push({"title":data.Data[i].title,"link":data.Data[i].guid,"body":data.Data[i].body,"date":date.toString().slice(0,25)});
  }

  $.ajax( { url: "https://api.mlab.com/api/1/databases/cryptocurrency/collections/cryptonews?apiKey=BiFVfOzkzS0l9zD2toWP8k6ZCZ6JJUK6",
  data: JSON.stringify([]),
  type: "PUT",
  contentType: "application/json" } );
 console.log(sourcenews);
  $.ajax( { url: "https://api.mlab.com/api/1/databases/cryptocurrency/collections/cryptonews?apiKey=BiFVfOzkzS0l9zD2toWP8k6ZCZ6JJUK6",
  data: JSON.stringify(sourcenews),
  type: "POST",
  contentType: "application/json" } );
});
}

// Saving top 10 cryptocurrencies to MLAB

function top10Mlab() {
  /// top 10
  var top10data= [];
  $.get("https://min-api.cryptocompare.com/data/top/volumes?tsym=USD", function(data, status){
    for(let i = 1; i<=10;i++) {
        top10data.push({"SYMBOL":data.Data[i].SYMBOL,"FULLNAME":data.Data[i].FULLNAME,"VOLUME24HOURTO":data.Data[i].VOLUME24HOURTO});
            }
    $.ajax( { url: "https://api.mlab.com/api/1/databases/cryptocurrency/collections/cryptolist?apiKey=BiFVfOzkzS0l9zD2toWP8k6ZCZ6JJUK6",
    data: JSON.stringify([]),
    type: "PUT",
    contentType: "application/json"} );
     console.log(top10data);
    $.ajax( { url: "https://api.mlab.com/api/1/databases/cryptocurrency/collections/cryptolist?apiKey=BiFVfOzkzS0l9zD2toWP8k6ZCZ6JJUK6",
    data: JSON.stringify(top10data),
    type: "POST",
    contentType: "application/json"} );
 
  });
}


// uploading data to MLab




 



  function hisdataMlab (coinname,time=366) {
   // Historical data
   let histdata= [];
   let totalvolumeto= 0;
   let totalvolume= 0;
   let currency = ["USD","BTC","ETH","EUR","GBP","JPY","KRW"];
   for(let k = 0;k<currency.length;k++) {
     if (currency[k] != coinname) {
  $.get(`https://min-api.cryptocompare.com/data/histoday?fsym=${coinname}&tsym=${currency[k]}&limit=${time}`, function(data) 
  {
    //call data from MLAB to check update status
  //check condition if current data @MLAB with date < date from APIs then update, if not the date up todated  
 
    for(var i = 0; i < data.Data.length ;i++)
    {
      totalvolume = data.Data[i].volumeto;
      totalvolumeto = data.Data[i].volumefrom;
          histdata.push({"date":data.Data[i].time,"close":data.Data[i].close,"high":data.Data[i].high,"high":data.Data[i].high,
      "low":data.Data[i].low,"open":data.Data[i].open,"volumnfrom":totalvolume,"volumnto":totalvolumeto});
     }
     console.log(totalvolumeto);
     console.log(totalvolume);
     $.ajax( { url: `https://api.mlab.com/api/1/databases/cryptocurrency/collections/crypto${coinname}-${currency[k]}?apiKey=BiFVfOzkzS0l9zD2toWP8k6ZCZ6JJUK6`,
     data: JSON.stringify(histdata),
     type: "POST",
     contentType: "application/json"});
     histdata=[];
    });
    
  }
  }
  }

  function hisdataMlabupdate (coinname,timeline=366) {
    // Historical data
    let histdata= [];
   let totalvolumeto= 0;
   let totalvolume= 0;
   let currency = ["USD","BTC","ETH","EUR","GBP","JPY","KRW"];
   for(let k = 0;k<currency.length;k++) {
     if (currency[k] != coinname) {
   $.get(`https://min-api.cryptocompare.com/data/histoday?fsym=${coinname}&tsym=${currency[k]}&limit=${timeline}`, function(data, status) 
   {
     //call data from MLAB to check update status by date
       $.get(`https://api.mlab.com/api/1/databases/cryptocurrency/collections/crypto${coinname}-${currency[k]}?apiKey=BiFVfOzkzS0l9zD2toWP8k6ZCZ6JJUK6`, function(datamlab, status) {
       
   //check condition if current data @MLAB with date < date from APIs then update, if not the date up todated 
 
   if (data.Data[timeline].time > datamlab[(datamlab.length-1)].date ) {
   // find the latest update date on data on Mlab to find index with that date in API
     for(var i= timeline; i >=0 ;i--)
     {
      if (data.Data[i].time > datamlab[(datamlab.length-1)].date ) {
        totalvolume = data.Data[i].volumeto;
        totalvolumeto = data.Data[i].volumefrom;
        histdata.push({"date":data.Data[i].time,"close":data.Data[i].close,"high":data.Data[i].high,"high":data.Data[i].high,
        "low":data.Data[i].low,"open":data.Data[i].open,"volumnfrom":totalvolume,"volumnto":totalvolumeto});
      }
    }
     console.log(histdata);
     $.ajax( { url: `https://api.mlab.com/api/1/databases/cryptocurrency/collections/crypto${coinname}-${currency[k]}?apiKey=BiFVfOzkzS0l9zD2toWP8k6ZCZ6JJUK6`,
     data: JSON.stringify(histdata),
     type: "POST",
     contentType: "application/json"});
     histdata=[];
     }
     else {
       console.log("Nothing to up to dated");
     }
    });
   });
  }}
  }
  
  //Fetching top 10 cryptocurrencies

  d3.json('https://api.mlab.com/api/1/databases/cryptocurrency/collections/cryptolist?apiKey=BiFVfOzkzS0l9zD2toWP8k6ZCZ6JJUK6', function(data) { 
  var top10= [];
  for(let i = 0;i<data.length;i++){
    top10.push(data[i].SYMBOL); 
  }
 // for create data
  var selector = d3.select("#selDataset");
  // Use the list of coin names to populate the select options
    top10.forEach((name) => {
      selector
        .append("option")
        .text(name)
        .property("value", name);
      });
// for update data
      var selector = d3.select("#selDataset1");
      // Use the list of coin names to populate the select options
        top10.forEach((name) => {
          selector
            .append("option")
            .text(name)
            .property("value", name);
          });
});

function createcoin(newcoin) {
  window.alert(newcoin +"  "+ "updated to Mongo");
  hisdataMlab(newcoin);
}

function updatecoin(newcoin) {
  window.alert(newcoin +"'s Data was "+ "updated to Mongo");
  hisdataMlabupdate (newcoin);
}

function deletedata() {

  $.ajax( { url: `https://api.mlab.com/api/1/databases/crytocurrency/collections/cryptolist?apiKey=BiFVfOzkzS0l9zD2toWP8k6ZCZ6JJUK6`,
data: JSON.stringify([]),
type: "PUT",
contentType: "application/json" } );
//news
$.ajax( { url: `https://api.mlab.com/api/1/databases/crytocurrency/collections/cryptonews?apiKey=BiFVfOzkzS0l9zD2toWP8k6ZCZ6JJUK6`,
data: JSON.stringify([]),
type: "PUT",
contentType: "application/json" } );

}

function cryptodata() {
  newstoMlab();
  top10Mlab();
  
}

function cryptopython() {
  $.ajax({
    url: "Top10data.py",
   context: document.body
  }).done(function() {
   alert('finished python script to MLAB');;
  });

}

function cryptoaggr() {
  $.ajax({
    url: "Historicaldata.py",
   context: document.body
  }).done(function() {
   alert('finished python script to MLAB');;
  });
}