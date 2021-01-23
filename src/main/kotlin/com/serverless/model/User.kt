package com.serverless.model

data class User(val username: String, val age: Int) {

    fun toMap() : Map<String, Any> {
        val map = mutableMapOf<String, Any>()
        map.put("username", this.username)
        map.put("age", this.age)

        return map
    }
}
