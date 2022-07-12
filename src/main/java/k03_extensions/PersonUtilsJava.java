package k03_extensions;

import lombok.val;

import java.time.Period;

import static java.time.LocalDate.now;

public class PersonUtilsJava {

    public static class PersonUtils {
        public static int getAge(Person person) {
            val endDate = person.getDateOfDeath() == null ? now() : person.getDateOfDeath();
            return Period.between(person.getDateOfBirth(), endDate).getYears();
        }
    }

    public void example() {
        PersonUtils.getAge(Person.getANTONIO());
    }
}
