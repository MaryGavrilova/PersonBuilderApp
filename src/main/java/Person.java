import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public boolean hasAge() {
        if (age >= 0) {
            return true;
        } else return false;
    }

    public boolean hasAddress() {
        if (!(address == null)) {
            return true;
        } else return false;
    }

    public void setAddress(String city) {
        this.address = city;
    }

    public void happyBirthday() {
        if (hasAge() == true) {
            age++;
            System.out.println("Happy birthday, today you are " + age + " years old.");
        } else {
            System.out.println("Happy birthday, but your age is unknown.");
        }

    }

    @Override
    public String toString() {
        if (hasAge() == false && hasAddress() == false) {
            return name + " " + surname;
        } else if (hasAge() == false && hasAddress() == true) {
            return name + " " + surname + ", адрес: " + address;
        } else if (hasAge() == true && hasAddress() == false) {
            return name + " " + surname + ", возраст: " + age;
        } else {
            return name + " " + surname + ", возраст: " + age + ", адрес: " + address;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAddress(address);
    }
}
