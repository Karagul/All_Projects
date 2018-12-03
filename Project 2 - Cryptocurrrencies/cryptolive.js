
  //Calculate month timeline
  function MonthsPrior(date,timeline) {
    // Copy date so don't affect original
    var d = new Date(date);
    // Get the current month number
    var m = d.getMonth();
    // Subtract 6 months
    d.setMonth(d.getMonth() - timeline);
    // If the new month number isn't m - 6, set to last day of previous month
    // Allow for cases where m < 6
    var diff = (m + 12 - d.getMonth()) % 12;
    if (diff < timeline) d.setDate(0)
    return d;
  }
  
  // plot for each single coin data
  function buildplot(coinname,currency,time) {
     

     let timeline = [];
     let totalvolumne = [];
     let startvolume=[];
     let highprice =[];
     let lowprice = [];
     
     $.get(`https://min-api.cryptocompare.com/data/histoday?fsym=${coinname}&tsym=${currency}&limit=${time}`,function(data){
         
         for(var i=0; i < data.Data.length ;i++)
        {
          let date = new Date(data.Data[i].time*1000);
          timeline.push(date.toString().slice(4,15));
          totalvolumne.push(data.Data[i].volumeto);
          highprice.push(data.Data[i].high);
          lowprice.push(data.Data[i].low);
          startvolume.push(data.Data[i].volumefrom)
          }
      //plot with line
      if (parseInt(time) === 0){
          timeline.shift(); 
          totalvolumne.shift(); 
          highprice.shift(); 
          lowprice.shift(); 
          startvolume.shift(); 
      }
      
      var trace1 = {
        x: timeline,
        y: totalvolumne,
        type: "bar",
        name: "Total Volume"
      };
      
      
        var layout = {
        title: ` Total Volume of ${coinname}`,
        titlefont: {
          "size": 25
        },
        xaxis: {
            title:'Date'
        }
      ,
        yaxis:{ title:`Total Volume (${currency})`},barmode: 'stack'
          };

      var trace2 = {
        x: timeline,
        y: startvolume,
        type:"bar",
        name: "Opened Volume"
      };

        var data = [trace1,trace2];
      

        Plotly.newPlot("bar", data, layout);

        var trace3 = {
          x: timeline,
          y: highprice,type:"line",
          name: 'Highest Price'};
        var trace4 = {
            x: timeline,
            y: lowprice,type:"line", name: 'Lowest Price'
          };

            var layout1 = {
              title: ` Lowest & Highest Price`,
              titlefont: {
                "size": 25
              },
              xaxis: {
                  title:'Date'
              }
            ,
              yaxis:{ title:`Price(${currency})`}
                };
          console.log( [trace3,trace4]);
      Plotly.newPlot("timeseries", [trace3,trace4],layout1); 
  });
  }

/// top 10
d3.json('https://api.mlab.com/api/1/databases/cryptocurrency/collections/cryptolist?apiKey=BiFVfOzkzS0l9zD2toWP8k6ZCZ6JJUK6', function(data) { 
  var top10data= [];
  var fullname=[];
  var top10volume=[];
for(let i = 0;i<data.length;i++){
  top10data.push(data[i].SYMBOL);
    fullname.push(data[i].FULLNAME)
  top10volume.push(parseFloat(data[i].VOLUME24HOURTO));
     }
  colorscale=['rgb(165,0,60)', 'rgb(215,48,39)', 'rgb(244,109,67)','Yellow','Orange', 'green',
        'rgb(171,217,233)', 'rgb(116,173,209)', 'rgb(69,117,180)','rgb(49,54,149)'];
    //plot top 10 daily
    var trace1 = {
        x: top10data,
        y: top10volume,
        text: fullname,
        marker: {
          color:colorscale
        },
        
        type: "bar"
      };
      
      var data = [trace1];
      
      var layout = {
        title : "Top 10 Cryptocurrency by volume daily",
        titlefont: {
          "size": 25
        },
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
  var selectorcheckbox = d3.select("#time");
  // Use the list of coin names to populate the select options
    top10data.forEach((name) => {
      selector
        .append("option")
        .text(name)
        .property("value", name);
     /* selectorcheckbox
        .append ("label")
        .text(name)
        .append("input")
        .text("&nbsp;&nbsp;")
        .attr("type", "checkbox")
        .attr('id',name.toLowerCase())
        .attr('value',name.toLowerCase())
        .attr('onclick','plotclick()');*/
      });

    
      
    // Use the first coin from the list to build the initial plots
    const firstcoin = top10data[0];
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
    source.push({"title":data[i].title,"link":data[i].link,"date":data[i].date,"body":data[i].body});
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





