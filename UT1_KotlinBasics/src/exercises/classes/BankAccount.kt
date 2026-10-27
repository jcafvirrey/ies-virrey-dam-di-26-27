package exercises.classes

/*
 * EXERCISE 2 · BANK ACCOUNT
 *
 * Encapsulation in practice: anybody can READ the balance, but only the account itself
 * can CHANGE it, through deposit() and withdraw(), which apply the rules.
 */
class BankAccount(val owner: String) {

    // private set (section 2.2): readable from outside, writable only inside the class.
    var balance = 0.0
        private set

    // init (section 3) runs when the object is created. If the owner is blank,
    // the account is never created: "if an object exists, it is valid".
    init {
        require(owner.isNotBlank()) { "The owner's name cannot be empty" }
    }

    fun deposit(amount: Double) {
        // require is for PROGRAMMING errors: depositing 0 or -50 makes no sense,
        // so whoever calls this method with that value has made a mistake.
        require(amount > 0) { "The amount to deposit must be greater than 0" }
        balance += amount
    }

    fun withdraw(amount: Double): Boolean {
        require(amount > 0) { "The amount to withdraw must be greater than 0" }

        // Not having enough money is NOT a programming error: it is a normal situation.
        // We do not stop the program; we return false and the caller decides what to do.
        if (amount > balance) return false      // guard clause (Block 3)

        balance -= amount
        return true
    }

    override fun toString(): String = "$owner: ${"%.2f".format(balance)} €"
}