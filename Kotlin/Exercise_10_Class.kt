class BankAccount(val accountNumber: String, var balance: Double) {

    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Successfully deposited $amount. New balance: $balance")
        } else {
            println("Invalid deposit amount.")
        }
    }

    fun withdraw(amount: Double) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount
                println("Successfully withdrew $amount. New balance: $balance")
            } else {
                println("Insufficient funds. Cannot withdraw $amount. Current balance: $balance")
            }
        } else {
            println("Invalid withdrawal amount.")
        }
    }

    fun printBalance() {
        println("Current balance: $balance")
    }
}

fun main() {
    val account = BankAccount("123456789", 1000.0)

    account.printBalance() 

    account.deposit(500.0) 
    account.printBalance()

    account.withdraw(200.0) 
    account.printBalance()

    account.withdraw(1500.0) 
    account.printBalance()

    account.deposit(-100.0) 
    account.printBalance()
}