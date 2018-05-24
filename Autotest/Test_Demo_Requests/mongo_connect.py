# coding=utf-8

from pymongo import MongoClient
import pymongo
import json

client = MongoClient('121.199.5.116', 3717)

db = client.get_database('activity')
db.authenticate("helong", "helong")
print (db.collection_names())
print 'aa'
#print (client.database_names())