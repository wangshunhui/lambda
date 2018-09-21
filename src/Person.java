import java.util.List;

/**
 * Created by wangshunhui on 2018/3/25.
 */
public class Person {
    private String name;
    private int age;
    private int score;

    public List<String> getHobbys() {
        return hobbys;
    }

    public void setHobbys(List<String> hobbys) {
        this.hobbys = hobbys;
    }

    private List<String> hobbys;

    public Person(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public Person(int age, int score) {
        this.age = age;
        this.score = score;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
