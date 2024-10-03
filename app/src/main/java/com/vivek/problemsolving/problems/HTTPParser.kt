package com.vivek.problemsolving.problems


fun getResponses(
    valid_auth_tokens: List<String>,
    requests: List<List<String>>
): List<String> {
    val validResponses = mutableListOf<String>()

    for (request in requests) {
        val method = request[0]
        val url = request[1]
        val params = url.substringAfter("?").split("&").map {
            it.split("=")
        }.associate { it[0] to it[1] }

        val token = params["token"] ?: ""
        val csrf = params["csrf"]

        if (token !in valid_auth_tokens) {
            validResponses.add("INVALID")
            continue
        }

        if (method == "POST") {
            if (csrf == null || !csrf.matches(Regex("^[a-z0-9]{8,}\$"))) {
                validResponses.add("INVALID")
                continue
            }
        }

        val response = mutableListOf("VALID")
        for ((key, value) in params) {
            if (key != "token" && key != "csrf") {
                response.add(key)
                response.add(value)
            }
        }
        validResponses.add(response.joinToString(","))
    }

    return validResponses
}

// Sample usage:
fun main() {
    val validAuthTokens = listOf("et51u8i9p1q7", "b8nn5j4om76v", "r5b0191m1p09")
    val requests = listOf(
        listOf("GET", "https://example.com/?token=et51u8i9p1q7&id=2e3rt&name=alex"),
        listOf("POST", "https://example.com/?token=r5b0191m1p09&csrf=b8nn5j4om76v&id=u78we&name=evan")
    )
    val responses = getResponses(validAuthTokens, requests)
    responses.forEach { println(it) }
}