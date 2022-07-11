package k01_builder;

import java.time.LocalDate;

import static java.time.LocalDate.parse;

public class VerboseBuilderJava {
    public static class Person {
        public final String name;
        public final LocalDate dateOfBirth;
        public final LocalDate dateOfDeath;

        Person(String name, LocalDate dateOfBirth, LocalDate dateOfDeath) {
            this.name = name;
            this.dateOfBirth = dateOfBirth;
            this.dateOfDeath = dateOfDeath;
        }

        public static PersonBuilder builder() {
            return new PersonBuilder();
        }

        public static class PersonBuilder {
            private String name;
            private LocalDate dateOfBirth;
            private LocalDate dateOfDeath;

            PersonBuilder() {
            }

            public PersonBuilder name(String name) {
                this.name = name;
                return this;
            }

            public PersonBuilder dateOfBirth(LocalDate dateOfBirth) {
                this.dateOfBirth = dateOfBirth;
                return this;
            }

            public PersonBuilder dateOfDeath(LocalDate dateOfDeath) {
                this.dateOfDeath = dateOfDeath;
                return this;
            }

            public Person build() {
                return new Person(name, dateOfBirth, dateOfDeath);
            }
        }
    }

    void example() {
        Person.builder()
                .name("Antonio")
                .dateOfBirth(parse("1989-11-03"))
                .build();
    }
}
