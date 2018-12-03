Plotly.d3.csv("output/pushshift/results/Ripple.csv", function(err, rows){

  function unpack(rows, key) {
  return rows.map(function(row) { return row[key]; });
}

var trace1 = {
    type: "scatter",
    mode: "scatter",
    name: 'Reddit Submission Text Sentiment',
    x: unpack(rows, 'Timestamp'),
    y: unpack(rows, 'submission_compound'),
    line: {color: '#17BECF'}
}

var trace2 = {
type: "scatter",
mode: "scatter",
name: 'Reddit Submission Title Sentiment',
x: unpack(rows, 'Timestamp'),
y: unpack(rows, 'title_compound'),
line: {color: '#7F7F7F'}
}

var data = [trace1,trace2];

var layout = {
  title: 'Ripple Sentiment Over 2 Months',
  xaxis: {
    range: ['2018-07-01', '2018-09-01'],
    type: 'date'},
  yaxis: {
    autorange: false,
    range: [-3.0, 3.0],
    type: 'linear'
  }
};

Plotly.newPlot('myDiv', data, layout);
})