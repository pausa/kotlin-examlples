package k02_builder_lombok;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;

import static java.time.LocalDate.parse;

public class FancyBuilderJava {
    @Value
    @Builder(toBuilder = true)
    static class Person{
        @NonNull
        String name;
        @NonNull
        LocalDate dateOfBirth;
        @Builder.Default
        LocalDate dateOfDeath = null;
    }

    void example(){
        val antonio = Person.builder()
                .name("Antonio")
                .dateOfBirth(parse("1989-11-03"))
                .build();

        val twin = antonio.toBuilder()
                .name("Costanzo")
                .build();
    }

}
