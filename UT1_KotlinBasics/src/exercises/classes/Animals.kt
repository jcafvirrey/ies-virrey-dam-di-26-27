package exercises.classes

/*
 * EXERCISE 3 · THE ANIMAL FAMILY  (Head First Java hierarchy, written in Kotlin)
 *
 *                 Animal (abstract)            Pet (interface)
 *          ┌────────┬───┴────┬────────┐          |      |
 *         Dog      Cat     Wolf     Hippo       Dog    Cat
 */

// abstract (section 7): nobody can create "an animal"; only dogs, cats...
// Abstract classes are open automatically, so we do not write "open class".
abstract class Animal(val name: String) {

    // abstract = no body. Every subclass MUST implement it ("a mandatory open").
    abstract fun makeNoise()

    // open = it has a body, and subclasses MAY override it.
    open fun eat() {
        println("$name eats.")
    }

    // normal = it has a body, and subclasses CANNOT override it (final by default).
    fun sleep() {
        println("$name sleeps.")
    }

}

// An interface says what an object CAN DO, not what it IS (section 8).
interface Pet {
    fun beFriendly()                 // no body -> must be implemented

    fun play() {                     // body -> optional to override
        println("Playing...")
    }
}

// The header: ": Animal(name)" calls the parent constructor (like super(name) in Java).
// "name" has no val: Dog only receives it to pass it to Animal, which stores it.
// ", Pet" has no parentheses because interfaces have no constructor.
class Dog(name: String) : Animal(name), Pet {
    override fun makeNoise() = println("$name: Woof!")
    override fun beFriendly() = println("$name wags its tail.")
    override fun play() = println("$name runs after the ball.")    // replaces the default play()
}

class Cat(name: String) : Animal(name), Pet {
    override fun makeNoise() = println("$name: Meow!")
    override fun beFriendly() = println("$name purrs.")
    // play() is not overridden: Cat uses the default implementation of Pet.
}

// Wolf is an animal, but NOT a pet: it does not implement Pet.
class Wolf(name: String) : Animal(name) {
    override fun makeNoise() = println("$name: Auuuuu!")
}

class Hippo(name: String) : Animal(name) {
    override fun makeNoise() = println("$name: Grunt!")

    // EXTENDING instead of REPLACING (section 6.1):
    // first what every animal does (super.eat()), then the hippo's own part.
    override fun eat() {
        super.eat()
        println("$name eats 40 kg of grass.")
    }
}