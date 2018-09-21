import java.util.List;
import java.util.stream.Stream;

/**语法规范
 * Created by wangshunhui on 2018/3/25.
 */
public class LambdaType {
    public static void main(String[] args) {
        //1.无参数，无返回
        Animal animal = new Animal(){
            @Override
            public void eat() {
                System.out.println("aaa");
            }
        };
        animal = ()->{System.out.println("aaa");};
        //只有一个表达式时，可以把大括号省略
        animal = ()->System.out.println("aaa");


        //2.只有一个参数(可以省略小括号)，无返回值
        Stream.of(1,2,3).forEach(x-> System.out.println(x));

        //3.有两个以上参数，有返回值
        Stream.of(1,2,3).reduce((Integer x, Integer y)->{return x+y;});
//        Stream.of(1,2,3).reduce(0,Integer::sum);
        //参数类型可以省略，只有一个表达式时可以把return和大括号
        Stream.of(1,2,3).reduce(( x, y)-> x+y);
    }
}
