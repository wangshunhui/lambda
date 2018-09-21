import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by wangshunhui on 2018/3/25.
 */
public class InnerClass {
    public static void main(String[] args) {
        List<Integer> list =  Arrays.asList(1,2,3,4,5);
        //内部类
        class Pred<Integer> implements  Predicate<Integer>{
            @Override
            public boolean test(Integer num) {
                return !num.equals(4);
            }
        }
        Predicate<Integer> pred = new Pred<Integer>();
        list.stream().filter(pred).forEach(System.out::println);

        //匿名内部类
        list.stream().filter(new Predicate<Integer>(){
            @Override
            public boolean test(Integer num) {
                return !num.equals(4);
            }
        }).forEach(System.out::println);

        //Lambda表达式
        Predicate<Integer> pridicate = num->!num.equals(4);
        list.stream().filter(pridicate).forEach(System.out::println);

        list.stream().filter(num->!num.equals(4)).forEach(System.out::println);



        class ThreadTest implements Runnable{

            @Override
            public void run() {
                System.out.println("内部类");
            }
        }
        new Thread(new ThreadTest()).start();


        //匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        new Thread(()->{

        }).start();
    }


}
