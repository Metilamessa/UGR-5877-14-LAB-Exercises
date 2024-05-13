fun main() {
    println("Enter the original price:")
    val originalPrice = readLine()?.toDoubleOrNull() ?: return

    println("Enter the discount percentage (as a decimal between 0 and 1):")
    val discountPercentage = readLine()?.toDoubleOrNull() ?: return

    val threshold = 0.5 
    var finalPrice: Double 

    if (discountPercentage > threshold) {
        println("The discount is too high!")
        finalPrice = originalPrice * threshold 
    } else {
        finalPrice = originalPrice * (1 - discountPercentage) 
    }

    println("Original price: $originalPrice")
    println("Discount percentage: ${discountPercentage * 100}%")
    println("Final price: $finalPrice")
}