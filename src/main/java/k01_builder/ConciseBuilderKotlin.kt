package k01_builder

import java.time.LocalDate
import java.time.LocalDate.parse

class ConciseBuilderKotlin{
    data class Person(
        val name: String? = null,
        val dateOfBirth: LocalDate? = null,
        val dateOfDeath: LocalDate? = null
    )

    fun example() {
        Person(
            name = "antonio",
            dateOfBirth = parse("1989-11-03")
        )
    }
}
