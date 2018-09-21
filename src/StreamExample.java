import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * Created by wangshunhui on 2018/3/26.
 */
public class StreamExample {
    public static void main(String[] args) {
        //找出年龄大于18岁的人的名字，按照字典值排序，并输出到控制台
        List<Person> personList = Arrays.asList(
                new Person("banana",19,80),
                new Person("haha",20,80),
                new Person("apple",21,89),
                new Person("bombom",10,89)
        );

        List<String> personNames = new ArrayList<>();
        for(Person person:personList){
            if(person.getAge()>18){
                personNames.add(person.getName());
            }
        }
        Collections.sort(personNames);
        for(String name:personNames){
            System.out.println(name);
        }

        System.out.println("------------------------------");

        //Lambda表达式
        personList.stream().filter(p->p.getAge()>18).map(p->p.getName()).sorted().forEach(name -> System.out.println(name));

    }
}
