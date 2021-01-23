package com.serverless.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.google.gson.Gson
import com.mongodb.MongoClientURI
import org.apache.logging.log4j.LogManager

/**
 * checks if user already exists in the database
 *
 */
class ValidateUser: RequestHandler<Map<String, Any>, String> {
    override fun handleRequest(input: Map<String, Any>, context: Context): String {
        return "user validated"
    }

    companion object {
        private val LOG = LogManager.getLogger(CreateUser::class.java)
        private val URI = "mongodb+srv://seki:seki2178@mixer-cluster.hr5hv.mongodb.net/mixer?retryWrites=true&w=majority"
        private val DB_URI: MongoClientURI = MongoClientURI(URI)
        private val GSON : Gson = Gson()
    }
}