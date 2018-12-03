Plotly.d3.csv("output/pushshift/results/bitcoin.csv", function(err, rows){

    function unpack(rows, key) {
    return rows.map(function(row) { return row[key]; });
  }
  
  
  var trace1 = {
    type: "scatter",
    mode: "lines",
    name: 'Number of Comments Posted',
    x: unpack(rows, 'Timestamp'),
    y: unpack(rows, '# Comments'),
    line: {color: 'green'}
  }
  
 
  var data = [trace1];
  
  var layout = {
    title: 'Number of Comments Posted in the Bitcoin Subreddit',
  };
  
  Plotly.newPlot('myDiv3', data, layout);
  })