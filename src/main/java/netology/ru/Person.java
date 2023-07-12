package netology.ru;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    private String name;
    private String surname;
    private int age;
    private String address;

    Person(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAddress(address)
                .setAge(0);
    }

    public void happyBirthday(){
        age++;
    }

    public boolean hasAge(){
        return age > 0;
    }

    public boolean hasAddress(){
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(hasAge() ? age : 0);
    }

    public String getAddress() {
        if (hasAddress()){
            return address;
        }
        return "Место жительства не установлено";
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
