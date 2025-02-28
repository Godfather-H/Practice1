import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

@SuppressWarnings("all")
public class Test1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1, 2, 3, 4, 5);
        //list.forEach(System.out::println);
        list.forEach((s)->prints(s));
    }
    @MyAnnotation(name="Tom",age=21)
    public static void prints(Integer num){
        System.out.println("hello"+num);
    }
}
