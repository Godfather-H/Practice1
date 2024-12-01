package reflection;

public class Student {
    private String name;
    private int age;
    public String gender;

    public Student() {
    }

    private Student(String name) {
        this.name = name;
    }

    protected Student(int age){
        this.age = age;
    }

    public Student(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }

    public void sleep(){
        System.out.println("睡觉");
    }

    private String eat(String food){
        System.out.println("在吃" + food);
        return "饱了";
    }
}
