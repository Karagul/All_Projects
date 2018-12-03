/// Time series plot
function timeseries(BCHvalue,BTCvalue,DASHvalue,ETCvalue,ETHvalue,LTCvalue,NEOSvalue,STRvalue,XMRvalue,XRPvalue) {
    d3.csv('cryptotime.csv',function(data){
      let bch = [];
      let btc = [];
      let dash = [];
      let etc = [];
      let eth = [];
      let ltc = [];
      let neos = [];
      let str = [];
      let xmr = [];
      let xrp = [];
      let date =[];
      colorscale=['rgb(165,0,60)', 'rgb(215,48,39)', 'rgb(244,109,67)','Yellow','Orange', 'green',
            'rgb(171,217,233)', 'rgb(116,173,209)', 'rgb(69,117,180)','rgb(49,54,149)'];
      
      for(var i = 0; i<data.length;i++){
        bch.push(data[i].bch_usd);
        btc.push(data[i].btc_usd);
        dash.push(data[i].dash_usd);
        etc.push(data[i].etc_usd);
        eth.push(data[i].eth_usd);
        ltc.push(data[i].ltc_usd);
        neos.push(data[i].neos_usd);
        str.push(data[i].str_usd);
        xmr.push(data[i].xmr_usd);
        xrp.push(data[i].xrp_usd);
        date.push(data[i][""]);
      }
      var trace1 ={};
      var trace2 ={};
      var trace3 ={};
      var trace4 ={};
      var trace5 ={};
      var trace6 ={};
      var trace7 ={};
      var trace8 ={};
      var trace9 ={};
      var trace10 ={};
    
      if (BCHvalue === "bchtrue"){
        trace1 = {
        type: "scatter",
        mode: "lines",
        name: 'BCH',
        x: date,
        y: bch,
        line: {color: colorscale[0]}
      }
    }
      else {
        trace1 ={};
      }
      //console.log(BTCvalue);
    
      if (BTCvalue === "btctrue"){
      trace2 = {
        type: "scatter",
        mode: "lines",
        name: 'BTC',
        x: date,
        y: btc,
        line: {color:colorscale[1]}
      }
    }
    else {
      trace2={};
    }
     if (DASHvalue === "dashtrue"){
      trace3 = {
        type: "scatter",
        mode: "lines",
        name: 'DASH',
        x: date,
        y: dash,
        line: {color: colorscale[2]}
      }
    }
    else{ trace3={};}
    
    if (ETCvalue === "etctrue"){
      trace4 = {
        type: "scatter",
        mode: "lines",
        name: 'ETC',
        x: date,
        y: etc,
        line: {color: colorscale[3]}
      }
    }
    else{
      trace4 ={};
    }
    if (ETHvalue === "ethtrue"){
      trace5 = {
        type: "scatter",
        mode: "lines",
        name: 'ETH',
        x: date,
        y: eth,
        line: {color: colorscale[4]}
      }
    }
    else {
      trace5={};
    }
    if (LTCvalue === "ltctrue"){
      trace6 = {
        type: "scatter",
        mode: "lines",
        name: 'LTC',
        x: date,
        y: ltc,
        line: {color: colorscale[5]}
      }
    }
    else {
      trace6= {};
    }
    
    if (NEOSvalue === "neostrue"){
      trace7 = {
        type: "scatter",
        mode: "lines",
        name: 'NEOS',
        x: date,
        y: neos,
        line: {color: colorscale[6]}
      }
    }
    else{
      trace7={};
    }
    
    if (STRvalue === "strtrue"){
      trace8 = {
        type: "scatter",
        mode: "lines",
        name: 'STR',
        x: date,
        y: str,
        line: {color: colorscale[7]}
      }
    }
    else {
      trace8={};
    }
    if (XMRvalue === "xmrtrue"){
      trace9 = {
        type: "scatter",
        mode: "lines",
        name: 'XMR',
        x: date,
        y: xmr,
        line: {color: colorscale[8]}
      }
    }
    else {
      trace9={};
    }
    if (XRPvalue === "xrptrue"){
      trace10 = {
        type: "scatter",
        mode: "lines",
        name: 'XRP',
        x: date,
        y: xrp,
        line: {color: colorscale[9]}
      }
    }
    else {
      trace10={};
    }

    var layout = {
      title: 'Prices of the Coin over 1 Year',
      titlefont: {
        "size": 30
      },
        xaxis: {
            title:'Date'
        }
      ,
        yaxis:{ title:`Price(USD)`}
          };
          
      var data = [trace1,trace2,trace3,trace4,trace5,trace6,trace7,trace8,trace9,trace10];
      Plotly.newPlot('time', data,layout);
    })
     }
     
     //let bch = d3.select("#bch").property('value')+$("#bch").prop('checked');
     // let btc = d3.select("#btc").property('value')+$("#btc").prop('checked');
     // console.log(bch+btc);
     timeseries("bchtrue","btctrue","dashtrue","etctrue","ethtrue","ltctrue","neostrue","strtrue","xmrtrue","xrptrue");
    
    function plotclick() {
      //console.log(a.value + a.checked);
      let bch = d3.select("#bch").property('value')+$("#bch").prop('checked');
      let btc = d3.select("#btc").property('value')+$("#btc").prop('checked');
      let dash = d3.select("#dash").property('value')+$("#dash").prop('checked');
      let etc = d3.select("#etc").property('value')+$("#etc").prop('checked');
      let eth = d3.select("#eth").property('value')+$("#eth").prop('checked');
      let ltc = d3.select("#ltc").property('value')+$("#ltc").prop('checked');
      let neos = d3.select("#neos").property('value')+$("#neos").prop('checked');
      let str = d3.select("#str").property('value')+$("#str").prop('checked');
      let xmr = d3.select("#xmr").property('value')+$("#xmr").prop('checked');
      let xrp = d3.select("#xrp").property('value')+$("#xrp").prop('checked');
    
        timeseries(bch,btc,dash,etc,eth,ltc,neos,str,xmr,xrp);
     }
     // Social plot

function clickchange(BCHvalue,BTCvalue,IOTvalue,ETCvalue,ETHvalue,LTCvalue,NEOSvalue,STRvalue,XMRvalue,XRPvalue){
  var trace1 = {};
  var trace2={};
  var trace1_1={};
  var trace3 = {};
  var trace4={};
  var trace1_2={};
  var trace5 = {};
  var trace6={};
  var trace1_3={};
  var trace7 = {};
  var trace8={};
  var trace1_4={};
  var trace9 = {};
  var trace10={};
  var trace1_5={};
  var trace11 = {};
  var trace12={};
  var trace1_6={};
  var trace13 = {};
  var trace14={};
  var trace1_7={};
  var trace15 = {};
  var trace16={};
  var trace1_8={};
  var trace17 = {};
  var trace18={};
  var trace1_9={};
  var trace19 = {};
  var trace20={};
  var trace1_10={};
  // Litecoin
  Plotly.d3.csv("litecoin_smooth.csv", function(err, rows){
  
    function unpack(rows, key) {
    return rows.map(function(row) { return row[key]; });
  }
    
  if (LTCvalue === "ltctrue"){
  trace1 = {
    type: "lines",
   
    name: 'Reddit Comments Positive Sentiment for Litecoin',
    x:  unpack(rows, 'Timestamp'),
    y: unpack(rows, 'comments_pos'),
  }
  
  trace2 = {
    type: "scatter",
    mode: "lines",
    name: 'Reddit Comments Negative Sentiment for Litecoin',
    x: unpack(rows, 'Timestamp'),
    y: unpack(rows, 'comments_neg'),
  }
    trace1_1= {
      type: "bar",
    name: 'Reddit Total Comments for Litecoin',
    x: unpack(rows, 'Timestamp'),
    y: unpack(rows, 'Comments')
    }
  
  }
  else {
    trace1={};
    trace2={};
    trace1_1={};
  }
  
  // MONERO
  Plotly.d3.csv("Monero_smooth.csv", function(err, rows1){
  
    function unpack(rows1, key) {
    return rows1.map(function(row) { return row[key]; });
  }
  if (XMRvalue === "xmrtrue"){
  trace3 = {
    type: "lines",
    name: 'Reddit Comments Positive Sentiment for Monero',
    x:  unpack(rows1, 'Timestamp'),
    y: unpack(rows1, 'comments_pos'),
  }
  
  trace4 = {
    type: "lines",
    name: 'Reddit Comments Negative Sentiment for Monero',
    x:  unpack(rows1, 'Timestamp'),
    y: unpack(rows1, 'comments_neg')
  }
  trace1_2= {
    type: "bar",
    name: 'Reddit Total Comments for Monero',
    x: unpack(rows1, 'Timestamp'),
    y: unpack(rows1, 'Comments')
    }
  }
  else {
    trace3={};
    trace4={};
    trace1_2={};
  }
  
  
  
  
  // Bitcoin Cash
  Plotly.d3.csv("Bitcoincash_smooth.csv", function(err, rows2){
  
    function unpack(rows2, key) {
    return rows2.map(function(row) { return row[key]; });
  }
  
  
  if (BCHvalue === "bchtrue"){
    trace5 = {
      type: "lines",
      name: 'Reddit Comments Positive Sentiment for Bitcoin Cash',
      x:  unpack(rows2, 'Timestamp'),
      y: unpack(rows2, 'comments_pos'),
    }
    
    trace6 = {
      type: "lines",
      name: 'Reddit Comments Negative Sentiment for Bitcoin Cash',
      x:  unpack(rows2, 'Timestamp'),
      y: unpack(rows2, 'comments_neg'),
    }

    trace1_3= {
      type: "bar",
      name: 'Reddit Total Comments for Bitcoin Cash',
      x: unpack(rows2, 'Timestamp'),
      y: unpack(rows2, 'Comments')
      }
    }
    else {
      trace5={};
      trace6={};
      trace1_3={};
    }
    // ETH
    Plotly.d3.csv("Ethereum_smooth.csv", function(err, rows3){
  
      function unpack(rows3, key) {
      return rows3.map(function(row) { return row[key]; });
    }
    if (ETHvalue === "ethtrue"){
      trace7 = {
        type: "lines",
        name: 'Reddit Comments Positive Sentiment for Ethereum ',
        x:  unpack(rows3, 'Timestamp'),
        y: unpack(rows3, 'comments_pos'),
      }
      
      trace8 = {
        type: "lines",
        name: 'Reddit Comments Negative Sentiment for Ethereum',
        x:  unpack(rows3, 'Timestamp'),
        y: unpack(rows3, 'comments_neg'),
      }

      trace1_4= {
        type: "bar",
        name: 'Reddit Total Comments for Ethereum',
        x: unpack(rows3, 'Timestamp'),
        y: unpack(rows3, 'Comments')
        }
      }
      else {
        trace7={};
        trace8={};
        trace1_4={};
      }
  // ETC
  Plotly.d3.csv("EthereumClassic_smooth.csv", function(err, rows4){
  
    function unpack(rows4, key) {
    return rows4.map(function(row) { return row[key]; });
  }
  if (ETCvalue === "etctrue"){
    trace9 = {
      type: "lines",
      name: 'Reddit Comments Positive Sentiment for Ethereum Classic',
      x:  unpack(rows4, 'Timestamp'),
      y: unpack(rows4, 'comments_pos'),
    }
    
    trace10 = {
      type: "lines",
      name: 'Reddit Comments Negative Sentiment for Ethereum Classic',
      x:  unpack(rows4, 'Timestamp'),
      y: unpack(rows4, 'comments_neg'),
    }
    trace1_5= {
      type: "bar",
      name: 'Reddit Total Comments for Ethereum Classic',
      x: unpack(rows4, 'Timestamp'),
      y: unpack(rows4, 'Comments')
      }
    
    }
    else {
      trace9={};
      trace10={};
      trace1_5={};
    }
    // NEOS
  Plotly.d3.csv("NEO_smooth.csv", function(err, rows5){
  
    function unpack(rows5, key) {
    return rows5.map(function(row) { return row[key]; });
  }
  if (NEOSvalue === "neostrue"){
    trace11 = {
      type: "lines",
      name: 'Reddit Comments Positive Sentiment for NEOS',
      x:  unpack(rows5, 'Timestamp'),
      y: unpack(rows5, 'comments_pos'),
    }
    
    trace12 = {
      type: "lines",
      name: 'Reddit Comments Negative Sentiment for NEOS',
      x:  unpack(rows5, 'Timestamp'),
      y: unpack(rows5, 'comments_neg'),
    }

    trace1_6= {
      type: "bar",
      name: 'Reddit Total Comments for NEOS',
      x: unpack(rows5, 'Timestamp'),
      y: unpack(rows5, 'Comments')
      }

    }
    else {
      trace11={};
      trace12={};
      trace1_6={};
    }
  // Ripple
  Plotly.d3.csv("Ripple_smooth.csv", function(err, rows6){
  
    function unpack(rows6, key) {
    return rows6.map(function(row) { return row[key]; });
  }
  if (XRPvalue === "xrptrue"){
    trace13 = {
      type: "lines",
      name: 'Reddit Comments Positive Sentiment for Ripple',
      x:  unpack(rows6, 'Timestamp'),
      y: unpack(rows6, 'comments_pos'),
    }
    
    trace14 = {
      type: "lines",
      name: 'Reddit Comments Negative Sentiment for Ripple',
      x:  unpack(rows6, 'Timestamp'),
      y: unpack(rows6, 'comments_neg'),
    }
     
    trace1_7= {
      type: "bar",
      name: 'Reddit Total Comments for Ripple',
      x: unpack(rows6, 'Timestamp'),
      y: unpack(rows6, 'Comments')
      }

    }
    else {
      trace13={};
      trace14={};
      trace1_7={};
    }
    // Stellars
  Plotly.d3.csv("Stellar_smooth.csv", function(err, rows7){
  
    function unpack(rows7, key) {
    return rows7.map(function(row) { return row[key]; });
  }
  if (STRvalue === "strtrue"){
    trace15 = {
      type: "lines",
      name: 'Reddit Comments Positive Sentiment for Stellar',
      x:  unpack(rows7, 'Timestamp'),
      y: unpack(rows7, 'comments_pos'),
    }
    
    trace16 = {
      type: "lines",
      name: 'Reddit Comments Negative Sentiment for Stellar',
      x:  unpack(rows7, 'Timestamp'),
      y: unpack(rows7, 'comments_neg'),
    }

    trace1_8= {
      type: "bar",
      name: 'Reddit Total Comments for Stellar',
      x: unpack(rows7, 'Timestamp'),
      y: unpack(rows7, 'Comments')
      }
    }
    else {
      trace15={};
      trace16={};
      trace1_8={};
    }
    
    // Bitcoin
  Plotly.d3.csv("Bitcoin_smooth.csv", function(err, rows8){
  
    function unpack(rows8, key) {
    return rows8.map(function(row) { return row[key]; });
  }
  if (BTCvalue === "btctrue"){
    trace17 = {
      type: "lines",
      name: 'Reddit Comments Positive Sentiment for Bitcoin',
      x:  unpack(rows8, 'Timestamp'),
      y: unpack(rows8, 'comments_pos'),
    }
    
    trace18 = {
      type: "lines",
      name: 'Reddit Comments Negative Sentiment for Bitcoin',
      x:  unpack(rows8, 'Timestamp'),
      y: unpack(rows8, 'comments_neg'),
    }

    trace1_9= {
      type: "bar",
      name: 'Reddit Total Comments for Bitcoin',
      x: unpack(rows8, 'Timestamp'),
      y: unpack(rows8, 'Comments')
      }

      console.log(unpack(rows8, 'Comments'))
    }
    else {
      trace17={};
      trace18={};
      trace1_9={}
    }
    // IOT
  Plotly.d3.csv("IOT_smooth.csv", function(err, rows9){
  
    function unpack(rows9, key) {
    return rows9.map(function(row) { return row[key]; });
  }
  if (IOTvalue === "iottrue"){
    trace19 = {
      type: "lines",
      name: 'Reddit Comments Positive Sentiment for IOTA',
      x:  unpack(rows9, 'Timestamp'),
      y: unpack(rows9, 'comments_pos'),
    }
    
    trace10 = {
      type: "lines",
      name: 'Reddit Comments Negative Sentiment for IOTA',
      x:  unpack(rows9, 'Timestamp'),
      y: unpack(rows9, 'comments_neg'),
    }

    trace1_10= {
      type: "bar",
            name: 'Reddit Total Comments for IOTA',
      x: unpack(rows9, 'Timestamp'),
      y: unpack(rows9, 'Comments')
      }
    }
    else {
      trace19={};
      trace20={};
      trace1_10={};
    }
  
    var layout = {
      title: 'Reddit Comments Sentiment Over 1 Year',
      titlefont: {
        "size": 30
      },
        xaxis: {
            title:'Date'
        }
      ,
        yaxis:{ title:`Sentiment`}
          };
     
          var layout1 = {
            title: 'Reddit Total Comments  Over 1 Year',
            titlefont: {
              "size": 30
            },
              xaxis: {
                  title:'Date'
              }
            ,
              yaxis:{ title:`Number of Comments`}
                };

    var data = [trace1,trace2,trace3,trace4,trace5,trace6,trace7,trace8,trace9,trace10,trace11,trace12,trace13,trace14,trace15,trace16,trace17,trace18,trace19,trace20];
    var data1 = [trace1_1,trace1_2,trace1_3,trace1_4,trace1_5,trace1_6,trace1_7,trace1_8,trace1_9,trace1_10];
    Plotly.newPlot('lines', data,layout);
    Plotly.newPlot('bars', data1,layout1);

  });
  });
  });
  });
  });
  });
    });
  });
  });
  });
  }

clickchange("bchtrue","btctrue","iottrue","etctrue","ethtrue","ltctrue","neostrue","strtrue","xmrtrue","xrptrue");

//control social plot function
function plotclick1() {
  //console.log(a.value + a.checked);
  let bch = d3.select("#bch").property('value')+$("#bch").prop('checked');
  let btc = d3.select("#btc").property('value')+$("#btc").prop('checked');
  let iot = d3.select("#iot").property('value')+$("#iot").prop('checked');
  let etc = d3.select("#etc").property('value')+$("#etc").prop('checked');
  let eth = d3.select("#eth").property('value')+$("#eth").prop('checked');
  let ltc = d3.select("#ltc").property('value')+$("#ltc").prop('checked');
  let neos = d3.select("#neos").property('value')+$("#neos").prop('checked');
  let str = d3.select("#str").property('value')+$("#str").prop('checked');
  let xmr = d3.select("#xmr").property('value')+$("#xmr").prop('checked');
  let xrp = d3.select("#xrp").property('value')+$("#xrp").prop('checked');

  clickchange(bch,btc,iot,etc,eth,ltc,neos,str,xmr,xrp);
 }