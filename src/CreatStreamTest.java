import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by wangshunhui on 2018/3/27.
 */
public class CreatStreamTest {
    public static void main(String[] args) {
       // (a)Java8 中的 Collection 接口被扩展， 供了两个获取流的方法: stream()与parallelStream()
        List<Integer> list = Arrays.asList(2,2);
        Stream<Integer> stream = list.stream();
        stream.forEach(System.out::println);

       // (b)通过Arrays中的Stream获取一个数组流
        Stream<String> stringStream = Arrays.stream(new String[]{"1"});
        stringStream.forEach(System.out::println);

       // (c)通过Stream类中静态方法of()
        Stream<Integer> integerStream = Stream.of(1,2);
        integerStream.forEach(System.out::println);

        // (d)创建无限流
        //迭代
       Stream.iterate(0,x->x+2).limit(2).forEach(System.out::println);
       //生成
        Stream.generate(Math::random).limit(3).forEach(System.out::println);

        System.out.println("hall".contains("Hall"));
    }
}
