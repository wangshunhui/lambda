/**
 * Created by wangshunhui on 2018/3/25.
 */
@FunctionalInterface
public interface Animal {
    void eat();
    public static void run(){
    }
    default   void sleep(String s){
    };

}
