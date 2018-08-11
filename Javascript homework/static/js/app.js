// from data.js
var tableData = data;
var tableufo = d3.select("tbody");
// YOUR CODE HERE!
//Fetching all date to html table each refresh
data.forEach(function(UFOReport) {
    console.log(UFOReport);
    var row = tableufo.append("tr");
    Object.entries(UFOReport).forEach(function([key, value]) {
      console.log(key, value);
 //     // Append a cell to the row for each value
 //     // in the UFO report
      var cell = tableufo.append("td");
      cell.text('\xa0\xa0\xa0\xa0\xa0'+ value);
    });
  });

//Create select tag with optionals for searching/filtering
var listgroup = d3.select("select");
//create this variable to pass value to Click function below(default = datetime)
var listvalued = "datetime";
listgroup.on("change", () =>{
    let placeholder = d3.select("#datetime");
    //window.alert(listgroup.property('value'));
    let labelname = d3.select("label")
    if (listgroup.property('value') =="city") {
    // change the name display in Input field
    labelname.html("Enter a City");
    //check if optional' value choosen then assign to value to listvalued
    listvalued = "city";
    //set input value to Null after choose another option for searching
    document.getElementById('datetime').value = "";
    //set value placeholder(suggesstion value)
    placeholder.attr('placeholder',"benton");
    
    }
    else if (listgroup.property('value') =="state"){
        labelname.html("Enter a State");
        listvalued = "state";
        document.getElementById('datetime').value = "";
        placeholder.attr('placeholder',"ca");
    }
    else if (listgroup.property('value') =="country"){
        labelname.html("Enter a Country");
        listvalued = "country";
        document.getElementById('datetime').value = "";
        placeholder.attr('placeholder',"us");
    }
    else if (listgroup.property('value') =="datetime"){
        labelname.html("Enter a Date");
        listvalued = "datetime";
        document.getElementById('datetime').value = "";
        placeholder.attr('placeholder',"1/11/2011");
    }
    else if (listgroup.property('value') =="shape"){
        labelname.html("Enter a Shape");
        listvalued = "shape";
        document.getElementById('datetime').value = "";
        placeholder.attr('placeholder',"circle");
    }
});


  var submit = d3.select("#filter-btn");
  submit.on("click", () => {
    //var marquee = document.getElementById("marquee");
   // marquee.parentNode.removeChild(marquee);
    let marqueelist = d3.select(".hero");
    // Prevent the page from refreshing
    d3.event.preventDefault();
    
    // Select the input element and get the raw HTML node
    let inputElement = d3.select("#datetime");
    // Get the value property of the input element
    let inputValue = inputElement.property('value');
    // Use the form input to filter the data by listvalued
    console.log(tableData);
    let filteredData = tableData.filter(tableData => tableData[listvalued] === inputValue);
    // remove all data before inserting data from each search data
    var tableufofilter =  d3.select("tbody").html("");
    // check if search not found any records and print out message
    if (filteredData.length==0) {
        var row = tableufofilter.append("tr");
        var cell = tableufofilter.append("td");
        cell.text("\xa0\xa0\xa0\xa0\xa0 No UFO file found");
    }

// if search found then fetching out date to html
    else {
    let  listufo = "";
    d3.selectAll("marquee").remove();  
    filteredData.forEach(function(UFOReport) {
        var row = tableufofilter.append("tr");
        Object.entries(UFOReport).forEach(function([key, value]) {
          //console.log(key, value);
         // Append a cell to the row for each value
          // in the UFO report object
          var cell = tableufofilter.append("td");
          cell.text('\xa0\xa0\xa0\xa0\xa0'+ value);
  //***Extra part: print out with animation tag using marquee with results ***/
          //formatting text before print out into marquee tag
          if (key == "city") {
            value = value.charAt(0).toUpperCase() +value.slice(1) +" " +key+",";
            key = "at"
            
           }
           else if (key=="state") {
            key="";
            value = value.charAt(0).toUpperCase() +value.slice(1)+ ",";
           }
           else if (key == "country") {
            key="";
            value = value.toUpperCase();
           }
           
           else if (key =="datetime") {
             key= key.charAt(0).toUpperCase() +key.slice(1)+":";
             //key.style.color("#ff0000");
             value=value;
           }
           else{
            key= "-"+" "+key.charAt(0).toUpperCase() +key.slice(1)+":";
            value=value;
           }
          listufo = listufo + "     "+key+"     "  + value;
        });
        listufo=listufo+ "\xa0\xa0\xa0\xa0\xa0\xa0\xa0";
      });
      // append text to marquee tag
      var lists =  marqueelist.append("marquee");
      //animated UFO gif
      var list1 =  marqueelist.append("marquee");
      list1.append("img")
      .attr('width', 200)
      .attr('height', 150)
      .attr("src","static/images/Al.gif");
      lists.text(listufo);
      
      d3.selectAll("marquee").attr('onmouseover','this.stop()');
      d3.selectAll("marquee").attr('onmouseout','this.start()');
      d3.selectAll("marquee").attr('scrollamount','3');
    }
    
  });

 