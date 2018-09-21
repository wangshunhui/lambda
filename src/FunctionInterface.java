import java.util.function.*;

/**函数接口
 * Created by wangshunhui on 2018/3/25.
 */
public class FunctionInterface {
    public static void main(String[] args) {
        //1.使用Predicate接口，判断某个Person对象是否大于18岁
        Predicate<Person> predicate = p->p.getAge()>18;
        System.out.println(predicate.test(new Person("boy",19,80)));

        //2.使用Consumer接口，传入一个字符串，判断字符串长度
        Consumer<String> consumer = str-> System.out.println(str);
        consumer.accept("-----------Consumer-----");

        //3.使用Function接口，传入一个字符串，返回字符串长度
        Function<String,Integer> function = str->str.length();
        System.out.println(function.apply("Function"));

        //4.使用Supplier接口，创建一个对象
        Supplier<Person> supplier = ()->new Person("haha",20,90);
        System.out.println(supplier.get());

        //5.使用UnaryOperator接口，传入一个字符串，返回全转大写的字符串
        UnaryOperator<String> unaryOperator = str->str.toUpperCase();
        System.out.println(unaryOperator.apply("UnaryOperator"));
    }
}
