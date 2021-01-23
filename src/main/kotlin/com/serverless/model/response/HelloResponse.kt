package com.serverless.model.response

data class HelloResponse(val message: String, val input: Map<String, Any>) : Response()
