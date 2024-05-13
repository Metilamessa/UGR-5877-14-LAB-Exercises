fun analyzeString(input: String): Triple<Int, Int, Int> {
    val wordCount = input.split("\\s+".toRegex()).size 
    val uppercaseCount = input.count { it.isUpperCase() } 
    val vowelCount = input.count { it.toLowerCase() in "aeiou" } 

    return Triple(wordCount, uppercaseCount, vowelCount)
}

fun main() {
    println("Enter a string:")
    val inputString = readLine() ?: return
    val (wordCount, uppercaseCount, vowelCount) = analyzeString(inputString)

    println("Number of words: $wordCount")
    println("Number of uppercase letters: $uppercaseCount")
    println("Number of vowels: $vowelCount")
}