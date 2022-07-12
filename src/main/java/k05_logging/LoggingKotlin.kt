package k05_logging

import k03_extensions.Person
import mu.KotlinLogging

class LoggingKotlin {
    private val log = KotlinLogging.logger { }

    fun example(person: Person) {
        try {
            log.info { "Doing some stuff for ${person.name}, born ${person.dateOfBirth}" }
        } catch (e: Exception) {
            log.error(e) { "Something happened! ${e.message}" }
        }
    }
}