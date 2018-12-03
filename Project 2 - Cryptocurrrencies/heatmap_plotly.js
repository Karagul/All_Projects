// You can reproduce this figure in plotly.js with the following code!

// Learn more about plotly.js here: https://plot.ly/javascript/getting-started

/* Here's an example minimal HTML template
 *
 * <!DOCTYPE html>
 *   <head>
 *     <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
 *   </head>
 *   <body>
 *   <!-- Plotly chart will be drawn inside this div -->
 *   <div id="plotly-div"></div>
 *     <script>
 *     // JAVASCRIPT CODE GOES HERE
 *     </script>
 *   </body>
 * </html>
 */

trace1 = {
  z: [[1, 0.83680393, 0.78484907, 0.69204815, 0.79582311, 0.82071123, 0.75878761, 0.86178453, 0.71505808, 0.53622679], [0.83680393, 1, 0.84103623, 0.74558147, 0.86371303, 0.77364055, 0.70846441, 0.89472105, 0.77694078, 0.42260357], [0.78484907, 0.84103623, 1, 0.7018624, 0.80510741, 0.77902185, 0.70402442, 0.85336949, 0.73683403, 0.43186972], [0.69204815, 0.74558147, 0.7018624, 1, 0.70386572, 0.61265687, 0.62686741, 0.73372878, 0.65609933, 0.37536922], [0.79582311, 0.86371303, 0.80510741, 0.70386572, 1, 0.79039562, 0.77228873, 0.84678244, 0.73946051, 0.42062024], [0.82071123, 0.77364055, 0.77902185, 0.61265687, 0.79039562, 1, 0.71291926, 0.78676854, 0.71746816, 0.46718563], [0.75878761, 0.70846441, 0.70402442, 0.62686741, 0.77228873, 0.71291926, 1, 0.74995252, 0.67507398, 0.47011642], [0.86178453, 0.89472105, 0.85336949, 0.73372878, 0.84678244, 0.78676854, 0.74995252, 1, 0.77745796, 0.43116587], [0.71505808, 0.77694078, 0.73683403, 0.65609933, 0.73946051, 0.71746816, 0.67507398, 0.77745796, 1, 0.34217324], [0.53622679, 0.42260357, 0.43186972, 0.37536922, 0.42062024, 0.46718563, 0.47011642, 0.43116587, 0.34217324, 1]], 
  x: ['Bitcoin(BTC)', 'Ethereum', 'Bitcoin Cash', 'Ethereum Classic', 'Ripple', 'Monero',
  'Stellar', 'Litecoin', 'DASH', 'NEOS'],
  y: ['Bitcoin', 'Ethereum', 'Bitcoin Cash', 'Ethereum Classic', 'Ripple', 'Monero',
  'Stellar', 'Litecoin', 'Dash', 'Neos'],
  
  // ['btc_usd', 'eth_usd', 'bch_usd', 'etc_usd', 'xrp_usd', 'xmr_usd',
  // 'str_usd', 'ltc_usd', 'dash_usd', 'neos_usd'],
  colorscale: [['-1.0', 'rgb(0, 24, 165)'], ['-0.5', 'rgb(0, 118, 165)'], ['0.0', 'rgb(255,255,255)'], ['0.5', 'rgb(224, 232, 248)'], ['1.0', 'rgb(72, 67, 244)']], 
  type: 'heatmap', 
  zsrc: 'saramhse:5:'
};

// var layout = {
//   autosize: false,
//   width: 500,
//   height: 500,
//   margin: {
//     l: 100,
//     r: 100,
//     b: 100,
//     t: 100,
//     pad: 1
//   },

// };

var layout = {
  title: 'Cryptocurrency/USD Historical Exchange Rates Correlation Heatmap' ,
  titlefont: {
    "size": 22
  },
  yaxis: {
    automargin: true
  }
};

data = [trace1];

Plotly.plot('plotly-div', data, layout);


// Plotly.plot('plotly-div', {
//   data: data

// });