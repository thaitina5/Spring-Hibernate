package ControllerAdvice.Entity;

public class Student {
    private int id;
    private String name;
    private int age;
    private String subject;
    private double score;

    public Student() {
    }

    public Student(int id, String name, int age, String subject, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.subject = subject;
        this.score = score;
    }

    //jackson hoạt động dựa vào get và set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
