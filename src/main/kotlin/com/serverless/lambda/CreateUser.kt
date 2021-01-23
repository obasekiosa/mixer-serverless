package com.serverless.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.google.gson.Gson
import com.mongodb.MongoClient
import com.mongodb.MongoClientURI

import com.serverless.model.User
import com.serverless.model.response.ApiGatewayResponse
import com.serverless.model.response.HelloResponse
import org.apache.logging.log4j.LogManager
import org.bson.Document

/**
 * called by aws cognito on successfully creating a user
 * in order to create a user in the database with defaults
 */

class CreateUser:RequestHandler<Map<String, Any>, ApiGatewayResponse> {

  val client: MongoClient = MongoClient(DB_URI)
  val mixerDatabase = client.getDatabase("mixer")
  val users = mixerDatabase.getCollection("users")

  override fun handleRequest(input:Map<String, Any>, context:Context):ApiGatewayResponse {
    LOG.info("received: " + input.keys.toString())
    val username = input["username"] as String
    val age = input["age"] as Int
    val user = User(username, age)
    val resp = users.insertOne(Document(user.toMap()))


    // insert user into db with only gotten credentials in place
    // return success on completion

    return ApiGatewayResponse.build {
      statusCode = 200
      objectBody = HelloResponse("Go Serverless v1.x! Your Kotlin function executed successfully! resp = $resp", input)
      headers = mapOf("X-Powered-By" to "AWS Lambda & serverless")
    }
  }

  companion object {
    private val LOG = LogManager.getLogger(CreateUser::class.java)
    private val URI = "mongodb+srv://seki:seki2178@mixer-cluster.hr5hv.mongodb.net/mixer?retryWrites=true&w=majority"
    private val DB_URI: MongoClientURI = MongoClientURI(URI)
    private val GSON : Gson = Gson()
  }
}
