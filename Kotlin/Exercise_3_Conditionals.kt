fun main() {
    println("Enter the numeric grade:")
    val numericGrade = readLine()?.toIntOrNull()

    val letterGrade = when (numericGrade) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        in 0..59 -> "F"
        else -> "Invalid grade"
    }

    println("Letter grade: $letterGrade")
}