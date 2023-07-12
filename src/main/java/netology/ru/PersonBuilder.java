package netology.ru;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder() {
        super();
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 150) {
           throw new IllegalStateException("Не корректный возраст");
        } else {
            this.age = age;
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null | surname == null) {
            throw new IllegalStateException("Не хватает данных для создания объекта!");
        } else {
            Person person;
            if (age == 0) {
                person = new Person(name, surname);
            } else {
                person = new Person(name, surname, age);
            }
            if (address != null) {
                person.setAddress(address);
            }
            return person;
        }
    }
}