package com.serverless.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.google.gson.Gson
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.client.FindIterable
import org.apache.logging.log4j.LogManager
import org.bson.Document


/**
 * gets a user from the database
 * if no user is specified gets all users (pagination must be implemented)
 */

class GetUser: RequestHandler<Map<String, Any>, String> {
    override fun handleRequest(input: Map<String, Any>, context: Context): String {
        val allUsers: FindIterable<Document>? = users.find()
        val result: MutableList<String> = mutableListOf("s")
        allUsers?.forEach { result.add(it.toJson()) }
        return "$result"
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