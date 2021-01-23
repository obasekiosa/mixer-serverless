package com.serverless.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.serverless.util.DbConnection

/**
 * finds a match for user
 */

class FindMatch: RequestHandler<Map<String,Any>, String> {
    override fun handleRequest(input: Map<String, Any>?, context: Context?): String {
        TODO("Not yet implemented")

        // query all users that meet the criteria
//        users.find()
        // pick first one or random one prefarable random
        // update both users match
        // post both users on a msg notification queue

    }

    companion object {
        private val users = DbConnection.users
    }
}