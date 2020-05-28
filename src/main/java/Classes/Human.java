package Classes;


public class Human {
    private String name, patronymic, surname;
    private int age;

    public Human(String name, String patronymic, String surname, int age) {
        if(age<0)throw new IllegalArgumentException("wrong age");
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return o.hashCode() == this.hashCode();

    }

    @Override
    public int hashCode() {
        return (name + patronymic + surname + age).hashCode();
    }
}
