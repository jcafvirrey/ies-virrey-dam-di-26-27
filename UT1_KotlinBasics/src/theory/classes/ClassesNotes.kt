package theory.classes

interface Pet{
    fun beFriendly()
    fun play(){
        println("Playing....")
    }
}
//6. Inheritance: Open and Override
open class Example(name: String){
    open fun exampleOpenMethod(){

    }
    fun exampleCloseMethod(){

    }
}
class Child(name:String, age:Int):Example(name){
    override fun exampleOpenMethod() {
        super.exampleOpenMethod()
    }
}
abstract class Animal(val name: String){
    abstract fun makeNoise()
    fun sleep(){
        println("$name sleeps.")
    }
    open fun eat(){
        println("$name eats.")
    }
}


class Dog(name:String):Animal(name), Pet{
    override fun makeNoise() {
        println("$name: Woof!")
    }

    override fun beFriendly() {
        println("$name wags its tail")
    }

    override fun play() {
        println("$name runs after the ball.")
    }
}

class Hippo(name:String):Animal(name){
    override fun makeNoise() {
        println("$name: Make noise")
    }

    override fun eat() {
        super.eat()
        println("$name eats 40 kg of grass")
    }
}
class Cat(name: String): Animal(name), Pet{
    override fun makeNoise() {
        println("$name:Meow!!")
    }

    override fun beFriendly() {
        println("$name purss")
    }
}
fun describe(animal: Animal){
    if(animal is Pet){
        animal.beFriendly()
    }else{
        println("${animal.name} is not a pet.")
    }
}
fun favoriteFood(animal:Animal):String {
    when(animal){
        is Dog ->return "Bones"
        is Cat ->return "Fish"
        else -> return "Grass"
    }
}
fun main(){
    //6. Inheritance: Open and Override
    val rex = Dog("Rex")
    rex.makeNoise()
    rex.sleep()
    //6.1 Calling the parent version: super
    Hippo("Gloria").eat()
    //7. Abstract classes
    val tom = Cat("Tom")
    tom.makeNoise()
    tom.eat()
    //8. Interfaces
    rex.play()
    tom.play()
    tom.beFriendly()
    //9. Polymorphism, is and smart casts
    val animals: List<Animal> = listOf(Dog("Rex"),Cat("Tom"), Hippo("Gloria"))
    for(animal in animals) {
        animal.makeNoise()
        describe(animal)
        favoriteFood(animal)
    }

}
