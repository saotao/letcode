package other;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * Description 深拷贝浅拷贝
 * Date 2019-10-17 14:48
 */
@Data
public class BeanCopy {

    @Data
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    static class A {
        private int id;
        private String name ;
        private C age;
    }

    @Data
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    static class B {
        private int id;
        private String name ;
        private C age;
    }

    @Data
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    static class C {
        private int id;
        private int age;
        private String ca;

    }

    public static void main(String[] args) {
        A a1 = new A();
        a1.setId(1);
        a1.setName("aaaa");
        a1.setAge(new C(1,33,"走路"));

        A a2 = a1;

        System.out.println("赋值");
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println("_________");

        a1.setName("bbb");
        a1.setId(2);
        a1.getAge().setCa("跑步");
        System.out.println("赋值后改变id,name,ca");
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println("_________");

        B b1 = new B();
        BeanUtils.copyProperties(a1,b1);
        System.out.println("beanUtils.copy");
        System.out.println(b1.toString());
        System.out.println("_________");

        a1.setId(3);
        a1.setName("ccc");
        a1.getAge().setCa("游泳");
        System.out.println(a1.toString());
        System.out.println(b1.toString());
        System.out.println("_________");

        b1.setAge(new C(a1.getAge().id,a1.getAge().age,a1.getAge().getCa()));
        a1.getAge().setCa("飞");
        System.out.println(a1.toString());
        System.out.println(b1.toString());
        System.out.println("_________");


    }

}
