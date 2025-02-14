package com.laioffer.twitch.hello;


import net.datafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public Person hello(@RequestParam(required = false) String name) {
        Faker faker = new Faker();
        if (name == null) {
            name = faker.name().fullName();
        }

        String company = faker.company().name();
        String street = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String country = faker.address().country();
        String bookTitle = faker.book().title();
        String bookAuthor = faker.book().author();
        Address address = new Address(street, city, state, country);
        Book book = new Book(bookTitle, bookAuthor);
        return new Person(name, company, address, book);
    }
}
