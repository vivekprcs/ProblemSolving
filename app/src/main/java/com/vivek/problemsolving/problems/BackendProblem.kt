import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonArray
import com.google.gson.JsonParser
import com.google.gson.JsonNull
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

fun main() {
    val url = URL("https://coderbyte.com/api/challenges/json/wizard-list")
    val connection = url.openConnection() as HttpURLConnection
    connection.requestMethod = "GET"

    try {
        val reader = BufferedReader(InputStreamReader(connection.inputStream))
        val response = StringBuilder()
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            response.append(line)
        }
        val gson = Gson()
        val jsonElement = JsonParser.parseString(response.toString())
        val processedJson = processJson(jsonElement)

        println(gson.toJson(processedJson))
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        connection.disconnect()
    }
}

fun processJson(element: JsonElement): JsonElement {
    return when {
        element.isJsonArray -> {
            val jsonArray = element.asJsonArray
            val resultArray = JsonArray()
            for (item in jsonArray) {
                val processedItem = processJson(item)
                if (processedItem.isJsonObject && processedItem.asJsonObject.entrySet().isNotEmpty() ||
                    processedItem.isJsonArray && processedItem.asJsonArray.size() > 0 ||
                    processedItem !is JsonArray && processedItem !is JsonObject) {
                    resultArray.add(processedItem)
                }
            }
            resultArray
        }
        element.isJsonObject -> {
            val jsonObject = element.asJsonObject
            val sortedObject = JsonObject()
            jsonObject.entrySet()
                .sortedBy { it.key.lowercase() }
                .forEach { (key, value) ->
                    val processedValue = processJson(value)
                    if (processedValue.isJsonObject && processedValue.asJsonObject.entrySet().isNotEmpty() ||
                        processedValue.isJsonArray && processedValue.asJsonArray.size() > 0 ||
                        processedValue !is JsonArray && processedValue !is JsonObject) {
                        sortedObject.add(key, processedValue)
                    }
                }
            // Remove empty or null values
            sortedObject.entrySet().removeIf { (_, value) ->
                value == JsonNull.INSTANCE ||
                        (value.isJsonPrimitive && value.asJsonPrimitive.isString && value.asJsonPrimitive.asString.isEmpty()) ||
                        (value.isJsonArray && value.asJsonArray.none { item -> item != JsonNull.INSTANCE &&
                                !(item.isJsonPrimitive && item.asJsonPrimitive.isString && item.asJsonPrimitive.asString.isEmpty()) }) ||
                        (value.isJsonObject && value.asJsonObject.entrySet().isEmpty())
            }
            sortedObject
        }
        else -> element
    }
}