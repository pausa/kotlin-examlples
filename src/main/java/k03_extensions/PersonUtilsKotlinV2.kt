package k03_extensions

import k03_extensions.PersonUtilsKotlinV2.PersonUtils.Companion.getAge
import java.time.LocalDate.now
import java.time.Period

class PersonUtilsKotlinV2 {
    class PersonUtils {
        companion object {
            fun Person.getAge(): Int =
                Period.between(dateOfBirth, dateOfDeath ?: now()).years
        }
    }

    fun example() {
        // implicit receiver
        Person.ANTONIO.getAge()

        // explicit receiver
        with(PersonUtils) {
            Person.ANTONIO.getAge()
        }
    }
}