package com.serverless.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.google.gson.Gson
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import org.apache.logging.log4j.LogManager
import org.bson.Document

/**
 * updates an already created user
 */


class UpdateUser:RequestHandler<Map<String, Any>, String> {
    override fun handleRequest(input: Map<String, Any>, context: Context): String {

        users.updateOne(Document(), Document())
        // if match changes from false to true then place on matching queue
        // if match changes from true to false then remove from matching queue
        return "User Updated"
    }

    companion object {
        private val LOG = LogManager.getLogger(CreateUser::class.java)
        private val URI = "mongodb+srv://seki:seki2178@mixer-cluster.hr5hv.mongodb.net/mixer?retryWrites=true&w=majority"
        private val DB_URI: MongoClientURI = MongoClientURI(URI)
        private val GSON : Gson = Gson()
        private val client: MongoClient = MongoClient(DB_URI)
        private val mixerDatabase = client.getDatabase("mixer")
        private val users = mixerDatabase.getCollection("users")
    }
}