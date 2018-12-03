
  //Calculate 6 month timeline
  function sixMonthsPrior(date) {
    // Copy date so don't affect original
    var d = new Date(date);
    // Get the current month number
    var m = d.getMonth();
    // Subtract 6 months
    d.setMonth(d.getMonth() - 6);
    // If the new month number isn't m - 6, set to last day of previous month
    // Allow for cases where m < 6
    var diff = (m + 12 - d.getMonth()) % 12;
    if (diff < 6) d.setDate(0)
    return d;
  }
  
  // plot for each single coin data
  function buildplot(coinname,currency,time) {
     

     let timeline = [];
     let totalvolumne = [];
     var trace1 ={};
  
     $.ajax( { url: 'https://api.mlab.com/api/1/databases/cryptocurrency/collections/cryptoBTC-USD?apiKey=BiFVfOzkzS0l9zD2toWP8k6ZCZ6JJUK6',
     success: function(data1) {
      console.log(data1);
  
    //d3.json(`https://api.mlab.com/api/1/databases/cryptocurrency/collections/crypto${coinname}-${currency}?apiKey=BiFVfOzkzS0l9zD2toWP8k6ZCZ6JJUK6`, function(data1, status) {
       //console.log(`https://api.mlab.com/api/1/databases/cryptocurrency/collections/crypto${coinname}-${currency}?apiKey=BiFVfOzkzS0l9zD2toWP8k6ZCZ6JJUK6`);
        //console.log(data1)
       for(var key = time; key < data1.length ;key++)
        {
        //let now = new Date();
        //console.log(now.toString().slice(4,15));
      //  console.log(data1.Data[key]);
        //let sixmonth = sixMonthsPrior(now);
        //console.log(sixmonth);
        let date = new Date(data1[key].time*1000);
       // if (date > sixmonth){
          timeline.push(date.toString().slice(4,15));
          totalvolumne.push(data1[key].volumeto);
          //console.log("coin: " +coinname + "  " + date.toString().slice(4,15)+ " " +data1.Data[key].volumefrom + " " + data1.Data[key].volumeto);
          trace1 = {
            x: timeline,
            y: totalvolumne,
            type: "bar"
          };
        }

      //plot with line

    
      
      var data = [trace1];
      var layout = {
        
      };
      
      var layout = {
        title: ` Total Volume of ${coinname} (in 2 quarters)`,
        xaxis: {
            title:'Timeline'
        }
      ,
        yaxis:{ title:`Total Volume (${currency})`,
      }
          };

      Plotly.newPlot("bar", data, layout);

      data = [{
        x: timeline,
        y: totalvolumne }];

      var LINE = document.getElementById("line");
      Plotly.newPlot(LINE, data); 
      
  }
  });
  }

/// top 10
d3.json('https://api.mlab.com/api/1/databases/cryptocurrency/collections/crypto10?apiKey=BiFVfOzkzS0l9zD2toWP8k6ZCZ6JJUK6', function(data) { 
  var top10= [];
  var fullname=[];
  var top10volume=[];
for(let i = 0;i<data.length;i++){
  top10.push(data[i].SYMBOL);
  fullname.push(data[i].FULLNAME)
  top10volume.push(parseFloat(data[i].VOLUME24HOURTO));
   
  }
    //plot top 10 daily
    var trace1 = {
        x: top10,
        y: top10volume,
        text: fullname,
        type: "bar"
      };
      
      var data = [trace1];
      
      var layout = {
        title : "Top 10 Cryptocurrency by volume daily",
        xaxis: {
            title:'Cryptocurrency Name'
        }
      ,
        yaxis:{ title:'Total Volume',
      }
          };
        
      
      Plotly.newPlot("top10", data, layout);

    //Anystock chart check 
 //fetching coin in drop list

 function init() {
  // Grab a list of coin to the dropdown 
  var selector = d3.select("#selDataset");
  // Use the list of coin names to populate the select options
    top10.forEach((name) => {
      selector
        .append("option")
        .text(name)
        .property("value", name);
      });
      
    // Use the first coin from the list to build the initial plots
    const firstcoin = top10[0];
    //currency value
    let curr =  d3.select("#selDataset1").property('value');
    let time =  d3.select("#selDataset2").property('value');
  //  console.log(time);
    buildplot(firstcoin,curr,time);
   
}
init();
});

function optionChanged(newcoin) {
  
  // Fetch new data each time a new sample is selected
  curr =  d3.select("#selDataset1").property('value');
  let time =  d3.select("#selDataset2").property('value');
  buildplot(newcoin,curr,time);
}

function optionChanged1() {
  
  let curr =  d3.select("#selDataset1").property('value');
  let coin =  d3.select("#selDataset").property('value');
  let time =  d3.select("#selDataset2").property('value');
  buildplot(coin,curr,time);
}

function optionChanged2() {
  
  let curr =  d3.select("#selDataset1").property('value');
  let coin =  d3.select("#selDataset").property('value');
  let time =  d3.select("#selDataset2").property('value');
  buildplot(coin,curr,time);
}

//BITCOIN NEWS

$.get("https://api.mlab.com/api/1/databases/cryptocurrency/collections/cryptonews?apiKey=BiFVfOzkzS0l9zD2toWP8k6ZCZ6JJUK6", function(data, status){
  console.log(data);
  var source = [];
  for(let i = 0; i<data.length;i++) { 
    //let date = new Date(data[i].published_on*1000);
    source.push({"title":data[i].title,"link":data[i].link,"date":data[i].date});
  } 

  var svg = d3.select("#news");
  var chartGroup = svg.append("g");
  console.log(source);
  chartGroup.selectAll("div")
    .data(source)
    .enter()
    .append("div")
    .append("a")
    .text(d=> d.date+ "- "+ d.title)
    .attr("xlink:href", d => d.link)
    .on("click", function(d){
      window.open(d.link)});
});




