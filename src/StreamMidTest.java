import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

/**Stream中间操作
 * Created by wangshunhui on 2018/3/27.
 */
public class StreamMidTest {
    public static void main(String[] args) {

        //1.filter过滤，找出等于2的人的，并输出名字
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6);
        stream.filter(p->p==2).forEach(System.out::println);
        //注意：流只能消费一次
//        stream.forEach(System.out::println);
        System.out.println("------------------------------------------");

        //2.skip(n)跳过n个值，limit(m)取m个值，
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5,6);
        stream1.skip(2).limit(3).forEach(System.out::println);
        System.out.println("------------------------------------------");

        //3.distinct去重
        Stream<Integer> stream2 = Stream.of(1,1,1,4,5,1,1);
        stream2.distinct().forEach(System.out::println);

    }

    @Test
    public void test1(){
        //1.map 接收一个函数作为参数，该函数会被应用到每个元 素上，并将其映射成一个新的元素。
        List<Person> strings = Arrays.asList(new Person("ab"),new Person("cd"));
        strings.stream().map(Person::getName).forEach(System.out::println);
        System.out.println("-----------------------------------");

        List<Person> persons = new ArrayList<>();
        Person person = new Person("1");
        person.setHobbys(Arrays.asList("read","writer"));

        Person person2 = new Person("2");
        person2.setHobbys(Arrays.asList("movie","music"));

        Person person3 = new Person("3");
        person3.setHobbys(Arrays.asList("play game"));
        persons.add(person);
        persons.add(person2);
        persons.add(person3);

        //2.flatMap接收一个流作为参数，将流中每一个元素都转换成另一个流，然后将所有流合并成一个流
        persons.stream().flatMap(p->p.getHobbys().stream()).forEach(System.out::println);
        System.out.println("------------------------------------------");
        //flatMap
        Stream.of(Arrays.asList("a","b"),Arrays.asList("c","d")).flatMap(x->x.stream()).forEach(
                x-> System.out.println(x)
        );
    }

    @Test
    public void test2(){
        //自然排序
        List<Integer> list = Arrays.asList(1,2,9,5,3);
        list.stream().sorted().forEach(System.out::println);

        //定制排序
        Comparator<Integer> comparator = (a,b)->Integer.compare(b,a);
        list.stream().sorted(comparator).forEach(System.out::println);
    }
}


