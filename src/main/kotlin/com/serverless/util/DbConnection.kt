package com.serverless.util

import com.google.gson.Gson
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.serverless.lambda.CreateUser
import org.apache.logging.log4j.LogManager

object DbConnection {
    private val LOG = LogManager.getLogger(DbConnection::class.java)
    private val URI = "mongodb+srv://seki:seki2178@mixer-cluster.hr5hv.mongodb.net/mixer?retryWrites=true&w=majority"
    private val DB_URI: MongoClientURI = MongoClientURI(URI)
    val client: MongoClient = MongoClient(DB_URI)
    val mixerDatabase = client.getDatabase("mixer")
    val users = mixerDatabase.getCollection("users")
}
