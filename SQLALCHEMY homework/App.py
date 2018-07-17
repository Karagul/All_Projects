!pip install flask
from flask import Flask, jsonify
app = Flask(__name__)

# Flask Routes 
@app.route("/") 
def welcome():
    return( 
         f"List all available api routes."
         f"/api/v1.0/precipitation<br/>" 
         f"- List of last year's temperature from all stations<br/>" 
         f"/api/v1.0/stations<br/>" 
         f"- List of stations <br/>" 
         f"/api/v1.0/tobs<br/>" 
         f"- List of Temperature Observations (tobs) for the previous year<br/>" 
         f"/api/v1.0/start<br/>" 
         f"- With start date, come out the MAX, MIN and AVG temperature for all dates from that date of last year  to greater than and equal to that date<br/>" 
         f"/api/v1.0/start/end<br/>" 
         f"- With start date and the end date, come out the MAX, MIN and AVG temperature in between of those dates<br/>" 
     ) 
@app.route("/api/v1.0/precipitation")
def precipitation():
    lastestdate = session.query(Measurement.date).order_by(Measurement.date.desc()).first()
    last12months = datetime.datetime.strptime(lastestdate[0],"%Y-%m-%d").date()-datetime.timedelta(days=365)
    yeartemp = session.query(Measurement.date,Measurement.tobs).filter(Measurement.date.between(last12months,lastestdate[0])).all()
    dictionary = {}
    for x in yeartemp:
        dictionary[x[0]]=x[1]
    """Return the justice league data as json"""
    return jsonify(dictionary)
@app.route("/api/v1.0/stations")
def stations():
    station = session.query(Station.station).all()
    liststation = []
    for i in station:
        liststation.append(i[0])
    return jsonify(liststation)

@app.route("/api/v1.0/tobs")
def tobs():
    lastestdate = session.query(Measurement.date).order_by(Measurement.date.desc()).first()
    last12months = datetime.datetime.strptime(lastestdate[0],"%Y-%m-%d").date()-datetime.timedelta(days=365)
    temp = session.query(Measurement.tobs).filter(Measurement.date.between(last12months,lastestdate[0])).all()
    listtemp = []
    for i in temp:
        listtemp.append(i[0])
    return jsonify(listtemp)

@app.route("/api/v1.0/<start>")
def start(startdate):
    starttemp=session.query(func.min(Measurement.tobs),func.max(Measurement.tobs),func.avg(Measurement.tobs)).filter(Measurement.date >= startdate).all()
    listtemp=[]
    for x in starttemp:
        listtemp.append(x[0])
        listtemp.append(x[1])
        listtemp.append(x[2])
    return jsonify(listtemp)

@app.route("/api/v1.0/<start>/<end>")
def startend(startdate,enddate):
    startendtemp = session.query(func.min(Measurement.tobs),func.max(Measurement.tobs),func.avg(Measurement.tobs)).filter(Measurement.date.between(startdate,enddate)).all()
    listtemp=[]
    for x in startendtemp:
        listtemp.append(x[0])
        listtemp.append(x[1])
        listtemp.append(x[2])
    return jsonify(listtemp)
        
if __name__ == "__main__":
    app.run(debug=True)
