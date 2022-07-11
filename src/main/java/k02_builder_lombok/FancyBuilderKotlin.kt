package k02_builder_lombok

import java.time.LocalDate
import java.time.LocalDate.parse

class FancyBuilderKotlin {
    data class Person(
        val name: String,
        val dateOfBirth: LocalDate,
        val dateOfDeath: LocalDate? = null
    )

    fun example() {
        val antonio = Person(
            name = "antonio",
            dateOfBirth = parse("1989-11-03")
        )

        val twin = antonio.copy(
            name = "Costanzo"
        )
    }
}