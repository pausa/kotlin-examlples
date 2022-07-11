package k01_builder

import java.time.LocalDate
import java.time.LocalDate.*

class VerboseBuilderKotlin {
    class Person private constructor(
        val name: String?,
        val dateOfBirth: LocalDate?,
        val dateOfDeath: LocalDate?
    ) {

        companion object {
            fun builder(): PersonBuilder {
                return PersonBuilder()
            }
        }

        class PersonBuilder internal constructor() {
            var name: String? = null
            var dateOfBirth: LocalDate? = null
            var dateOfDeath: LocalDate? = null

            fun build(): Person {
                return Person(name, dateOfBirth, dateOfDeath)
            }
        }
    }

    fun example(){
        Person.builder()
            .apply {
                name = "Antonio"
                dateOfBirth = parse("1989-11-03")
            }
            .build()
    }
}