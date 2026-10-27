package exercises.classes

fun main() {
    // The type of the list is List<Animal>: it can hold ANY subclass of Animal.
    val animals: List<Animal> = listOf(Dog("Rex"), Cat("Tom"), Wolf("Akela"), Hippo("Gloria"))

    println("--- Everybody makes a noise (polymorphism) ---")
    // Same message, different answers: each object runs ITS OWN makeNoise().
    // If tomorrow we add a Lion, this loop does not change at all.
    for (animal in animals) {
        animal.makeNoise()
    }

    println("--- Dinner time ---")
    // eat() is open: Hippo extends it, the others use the version of Animal.
    animals.forEach { it.eat() }

    println("--- Only the pets play (option 1: is + smart cast) ---")
    for (animal in animals) {
        // The variable is Animal, so animal.play() would NOT compile here.
        // After "is Pet", Kotlin applies a smart cast: inside the if, animal is a Pet.
        if (animal is Pet) {
            animal.beFriendly()
            animal.play()
        }
    }

    println("--- Only the pets play (option 2: filterIsInstance) ---")
    // filterIsInstance<Pet>() returns a List<Pet>: no checks are needed afterwards.
    val pets: List<Pet> = animals.filterIsInstance<Pet>()
    pets.forEach { it.play() }

    println("--- Who is not a pet? ---")
    // !is is the opposite of is.
    val wildAnimals = animals.filter { it !is Pet }
    println(wildAnimals.map { it.name })       // [Akela, Gloria]

    // val generic = Animal("?")   // ERROR: cannot create an instance of an abstract class
}