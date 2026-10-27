package exercises.classes

fun main() {
    val account = BankAccount("Laura García")
    println(account)                                   // Laura García: 0,00 €

    account.deposit(150.0)
    println("After deposit: $account")                 // 150,00 €

    // withdraw returns a Boolean: we use it to inform the user.
    val ok = account.withdraw(40.0)
    println(if (ok) "Withdrawal done: $account" else "Not enough money")

    val notPossible = account.withdraw(500.0)
    println(if (notPossible) "Withdrawal done" else "Not enough money. Balance: ${account.balance}")

}