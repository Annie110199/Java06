package Classes;

public class Student extends Human {
    String facultet;
    public Student(String name, String patronymic, String surname, int age, String facultet) {
        super(name, patronymic, surname, age);
        this.facultet = facultet;
    }
}
