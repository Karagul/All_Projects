Plotly.d3.csv("output/pushshift/results/litecoin.csv", function(err, rows){

  function unpack(rows, key) {
  return rows.map(function(row) { return row[key]; });
}


var trace1 = {
  type: "scatter",
  mode: "lines",
  name: 'Reddit Comments Positive Sentiment',
  x: unpack(rows, 'Timestamp'),
  y: unpack(rows, 'comments_pos'),
  line: {color: 'red'}
}

var trace2 = {
  type: "scatter",
  mode: "lines",
  name: 'Reddit Comments Negative Sentiment',
  x: unpack(rows, 'Timestamp'),
  y: unpack(rows, 'comments_neg'),
  line: {color: 'blue'}
}

var data = [trace1,trace2];

var layout = {
  title: 'Reddit Comments Sentiment for Litecoin Over 1 Year',
};

Plotly.newPlot('myDiv2', data, layout);
})