fun main() {
    val distance = 10.0 
    val unit = "kilometers" 

    val convertedDistance = when (unit) {
        "kilometers" -> distance * 0.621371 
        "miles" -> distance * 1.60934 
        else -> {
            println("Invalid unit")
            return
        }
    }

    // Print the converted distance
    println("Converted: $convertedDistance")
}