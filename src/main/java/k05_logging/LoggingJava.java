package k05_logging;

import k03_extensions.Person;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingJava {
    public void example(Person person) {
        try {
            log.info("Doing some stuff for {}, born {}", person.getName(), person.getDateOfBirth());
        } catch (Exception e) {
            log.error("Something happened! {}", e.getMessage(), e);
        }
    }
}
