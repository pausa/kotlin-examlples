package k03_extensions

import java.time.LocalDate
import java.time.LocalDate.parse

data class Person(
    val name: String,
    val dateOfBirth: LocalDate,
    val dateOfDeath: LocalDate? = null
) {
    companion object {
        @JvmStatic
        val ANTONIO = Person(name = "Antonio", dateOfBirth = parse("1989-11-03"))
    }
}