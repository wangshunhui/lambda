import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**方法引用
 * Created by wangshunhui on 2018/3/26.
 */
public class FunctionQuote {
    public static void main(String[] args) {
        //1.对象 :: 实例方法名
        Consumer<String> consumer = x-> System.out.println(x);
        consumer = System.out::println;
        consumer.accept("--------方法引用---------");


        //2. 类 :: 静态方法名
        Function<String,Integer> function = str->Integer.valueOf(str);
        function = Integer::valueOf;
        System.out.println(function.apply("90"));

        //3.类 :: 实例方法名
        Comparator<Integer> comparator = (x,y)->x.compareTo(y);
        comparator = Integer::compareTo;
        System.out.println( comparator.compare(1,2));


        //4.构造器引用
        Supplier<Person> supplier1 = ()->new Person();
        supplier1 = Person::new;

        Function<String,Person> function1 = name->new Person(name);
        function1 = Person::new;
        System.out.println(function1.apply("wang").getName());

        //5.数组引用
        Function<Integer,String[]> function2 = i->new String[i];
        function2 = String[]::new;
        System.out.println(function2.apply(2).length);


    }
}
