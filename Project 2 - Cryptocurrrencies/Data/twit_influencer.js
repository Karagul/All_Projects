Plotly.d3.csv("output/twitter/analyzed_@CharlieShrem_tweets.csv", function(err, rows){

    function unpack(rows, key) {
    return rows.map(function(row) { return row[key]; });
  }
  
  
  var trace1 = {
    type: "scatter",
    mode: "markers",
    name: '@CharlieShrem Positive Tweet Sentiment',
    x: unpack(rows, 'time'),
    y: unpack(rows, 'positive'),
    line: {color: 'orange'}
  }
  
  var trace2 = {
    type: "scatter",
    mode: "markers",
    name: '@CharlieShrem Negative Tweet Sentiment',
    x: unpack(rows, 'time'),
    y: unpack(rows, 'negative'),
    line: {color: 'navy'}
  }
  
  var data = [trace1,trace2];
  
  var layout = {
    title: 'Crypto Influence @CharlieShrem Tweet Sentiment',
  };
  
  Plotly.newPlot('myDiv4', data, layout);
  })