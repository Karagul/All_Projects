# import necessary libraries
from flask import Flask, render_template, jsonify, redirect
from flask_pymongo import PyMongo
import scrape_mars

# create instance of Flask app
app = Flask(__name__)
app.config["MONGO_URI"] = "mongodb://localhost:27017/myDatabase"
mongo = PyMongo(app)

# create route that renders index.html template and finds documents from mongo
@app.route("/")
def index():
    dbmars = mongo.db.dbmars.find_one()
    return render_template("index.html", dbmars=dbmars)


@app.route("/scrape")
def scrape():
    dbmars = mongo.db.dbmars
    marsdata = scrape_mars.scrape()
    dbmars.update(
        {},
        marsdata,
        upsert=True
    )
    return redirect("http://localhost:5000/", code=302)


if __name__ == "__main__":
    app.run(debug=True)