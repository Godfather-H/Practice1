package practice;

public class Worker {
    private String name;
    private int age;

    public void eat(){
        System.out.println("工人正在工作...");
    }

    public void work(){
        System.out.println("工人正在工作...");
    }

    public Worker() {
    }

    public Worker(String name, int age) {
        this.name = name;
        this.age = age;
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
        return "Worker{name = " + name + ", age = " + age + "}";
    }
}
