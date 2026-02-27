public class Student {

    private int id;
    private String name;
    private int age;
    private Dept dept;   // Composition (HAS-A relationship)

    public Student(int id, String name, int age, Dept dept) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Dept getDept() {
        return dept;
    }
}