package other;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Description 深拷贝
 * Date 2019-10-17 17:06
 */
public class DeepCopy {
    @Data
    @AllArgsConstructor
    public class Subject {
        private String name;
    }

    @Data
    @AllArgsConstructor
    public class Student implements Cloneable {

        // 对象引用
        private Subject subj;
        private String name;

        /**
         * 重写clone()方法
         *
         * @return
         */
        public Object clone() {
            //深拷贝
            // 直接调用父类的clone()方法
            return new Student(new Subject(subj.getName()), name);
        }
    }

    public void test1() {
        Student student = new Student(new Subject("数学"), "测试1");
        Student clone = (Student) student.clone();

        System.out.println("两个的subj相同？"+(student.getSubj() == clone.getSubj()));

        System.out.println("是否相等:" + (student == clone));
        System.out.println(student.toString());
        System.out.println(clone.toString());

        student.setName("测试2");
        System.out.println("修改源对象的name值，不影响clone");
        System.out.println(student.toString());
        System.out.println(clone.toString());

        System.out.println("修改源对象中的subj对象的name值,影响clone");
        student.getSubj().setName("语文");
        System.out.println(student.toString());
        System.out.println(clone.toString());

        System.out.println("修改源对象中的subj对象值,不影响clone");
        student.setSubj(new Subject("英语"));
        System.out.println(student.toString());
        System.out.println(clone.toString());


    }

    public static void main(String[] args) {

        new DeepCopy().test1();

    }

    @Data
    public class SerializableDeep implements Serializable{
        private int x;
        private int y;
    }

    public void test3(){
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        
    }
}
