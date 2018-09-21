import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**Stream终止操作
 * Created by wangshunhui on 2018/3/27.
 */
public class StreamEndTest {
    /**
     * 查询与匹配
     */
    @Test
    public void test1(){
        //allMatch 检查匹配所有元素
        List<Integer> list = Arrays.asList(8,1,2,4,9,3);
        System.out.println(list.stream().allMatch(x->x==2));
        System.out.println("----------------------------------");

        //anyMatch 至少匹配一个元素
        System.out.println(list.stream().anyMatch(x->x==2));
        System.out.println("-----------------------------");

        //noneMatch 检查是否没有匹配的元素
        System.out.println(list.stream().noneMatch(x->x==2));
        System.out.println("-----------------------------");

        //
        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());
        System.out.println(list.stream().count());
        System.out.println(list.stream().max(Integer::compareTo).get());
        System.out.println(list.stream().min(Integer::compareTo).get());
        System.out.println("-----------------------------");

        //forEach
        list.stream().forEach(System.out::println);

    }

    /**
     * 归约
     */
    @Test
    public void test2(){
        //可以将流中元素反复结合起来，得到一个值。 返回 Optional< T>
        List<Integer> list = Arrays.asList(1,2,4,5);
        int sum = list.stream().reduce(0,Integer::sum);
        System.out.println(sum);
        System.out.println("---------------------");

        Optional<Integer> optional = list.stream().reduce(Integer::max);
        System.out.println(optional.get());
    }

    /**
     * 收集
     */
    @Test
    public void test3(){
        //收集
        List<Person> list = Arrays.asList(
                new Person("haha",18,90),
                new Person("apple",30,80),
                new Person("boom",20,85));
        List<Person> personList = list.stream().collect(Collectors.toList());

        Set<Person> set = list.stream().collect(Collectors.toSet());

        Map<String,Person> map = list.stream().collect(Collectors.toMap(Person::getName, Function.identity()));

        HashSet<Person> hashSet = list.stream().collect(Collectors.toCollection(HashSet::new));

        //收集统计
        long count = list.stream().collect(Collectors.counting());
        System.out.println(count);

        double avgAge = list.stream().collect(Collectors.averagingDouble(Person::getAge));
        System.out.println(avgAge);

        double d = list.stream().collect(Collectors.summingDouble(Person::getScore));
        System.out.println(d);

        int max = list.stream().map(Person::getAge).collect(Collectors.maxBy(Integer::compare)).get();
        System.out.println(max);

        System.out.println("---------------------------------------------");

        DoubleSummaryStatistics dss = list.stream().collect(Collectors.summarizingDouble(Person::getAge));
        System.out.println(dss.getAverage());
        System.out.println(dss.getCount());
        System.out.println(dss.getSum());
        System.out.println(dss.getMax());
        System.out.println(dss.getMin());
        System.out.println("---------------------------------------------");

        //收集分组
        Map<String,Integer> map1= list.stream().collect(Collectors.groupingBy(Person::getName,Collectors.summingInt(Person::getAge)));
        System.out.println("map1:::"+map1);
        Map<String,Map<Integer,List<Person>>> map2 = list.stream().collect(Collectors.groupingBy(Person::getName,Collectors.groupingBy(Person::getAge)));
        System.out.println(map2);
        System.out.println("----------------------------------------------");

        //分区，依照条件分为true和false两个区
        Map<Boolean,List<Person>> map3 =  list.stream().collect(Collectors.partitioningBy(p->p.getName().equals("haha")));
        System.out.println(map3);
        System.out.println("----------------------------------------------");

        //joining，连接流中每个字符串
        String str = list.stream().map(Person::getName).collect(Collectors.joining(",","----","----"));
        System.out.println(str);

    }
}
