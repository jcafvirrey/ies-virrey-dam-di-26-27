package theory.classes

data class Product(val name:String, val price:Double, val stock: Int = 0)

fun main(){
    //10. Data classes
    val keyboard = Product("Keyboard",25.0,10)
    println(keyboard)

    val sameKeyBoard = Product("Keyboard", 25.0, 10)
    println(keyboard == sameKeyBoard)

    val cheaper = keyboard.copy(price = 19.99)
    println(cheaper)
//
    val (name,price,quantity) = keyboard
    val name2 = keyboard.name
    val price2 = keyboard.price
    val stock2 = keyboard.stock
    println("$name costs $price and has $quantity units")
    //10.1 Data classes and collections
    val catalogue = listOf(
        Product("Keyboard", 25.0, 10),
        Product("Mouse", 12.5, 0),
        Product("Monitor", 149.99, 3)
    )
    val available = catalogue.filter { it.stock > 0 }
    val names = available.map { it.name }
    val mostExpensive = catalogue.maxByOrNull { it.price }
    val stockValue = catalogue.sumOf { it.price * it.stock }
    println(names) // [Keyboard, Monitor]
    println(mostExpensive?.name) // Monitor
    println("%.2f".format(stockValue)) // 699.97
}