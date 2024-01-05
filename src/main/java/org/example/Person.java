package org.example;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
        protected final String name;
        protected final String surname;
        protected OptionalInt age;
        protected String address;

        public boolean hasAge() {
                return age.isPresent();
        }

        public boolean hasAddress() {
                return address != null;
        }

        public String getName() {
                return name;
        }

        public String getSurname() {
                return surname;
        }

        public OptionalInt getAge() {
                return age;
        }

        public String getAddress() {
                return address;
        }

        public void happyBirthday() {
                if (age.isPresent()) {
                        age = OptionalInt.of(age.getAsInt() + 1);
                }
        }

        @Override
        public String toString() {
                return "Person{" +
                        "name='" + name + '\'' +
                        ", surname='" + surname + '\'' +
                        ", age=" + age +
                        ", address='" + address + '\'' +
                        '}';
        }

        public PersonBuilder newChildBuilder() {
                PersonBuilder builder = new PersonBuilder();
                if (surname != null) {
                        builder.setSurname(surname);
                }
                if (age.isPresent()) {
                        builder.setAge(age.getAsInt());
                }
                if (address != null) {
                        builder.setAddress(address);
                }
                return builder;
        }

        @Override
        public int hashCode() {
                return Objects.hash(name, surname, age, address);
        }
        protected Person(PersonBuilder builder) {
                this.name = builder.name;
                this.surname = builder.surname;
                this.age = builder.age;
                this.address = builder.address;
        }
}

