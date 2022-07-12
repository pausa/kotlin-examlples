package k03_extensions

import java.time.LocalDate.now
import java.time.Period

class PersonUtilsKotlin {

    class PersonUtils {
        companion object {
            fun getAge(person: Person): Int {
                val endDate = if (person.dateOfDeath == null) now() else person.dateOfDeath
                return Period.between(person.dateOfBirth, endDate).years
            }
        }
    }

    fun example() {
        PersonUtils.getAge(Person.ANTONIO)
    }
}