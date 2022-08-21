package domain.model;

public class Employee extends User {

    private String position;
    private int salary;
    private int experience;
    private String dataEnterForWork;

    public Employee(String firstName, String lastName, int age, String email, char[] login, char[] password, String position, int salary, int experience, String dataEnterForWork) {
        super(firstName, lastName, age, email, login, password);
        this.position = position;
        this.salary = salary;
        this.experience = experience;
        this.dataEnterForWork = dataEnterForWork;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getDataEnterForWork() {
        return dataEnterForWork;
    }

    public void setDataEnterForWork(String dataEnterForWork) {
        this.dataEnterForWork = dataEnterForWork;
    }
}
