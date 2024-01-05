package org.example;

import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected OptionalInt age;
    protected String address;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (surname == null || name == null) {
            throw new IllegalStateException("Имя и Фамилия должны быть указаны");
        }
        return new Person(this);

    }
}