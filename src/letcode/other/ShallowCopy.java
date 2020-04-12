package other;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description 浅拷贝
 * Date 2019-10-17 16:34
 */
public class ShallowCopy {

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
         *  重写clone()方法
         * @return
         */
        public Object clone() {
            //浅拷贝
            try {
                // 直接调用父类的clone()方法
                return super.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }
    }

    public void test1(){
        Student student = new Student(new Subject("数学"),"测试1");
        Student clone = (Student)student.clone();

        System.out.println("两个的subj相同？"+(student.getSubj() == clone.getSubj()));

        System.out.println("是否相等:"+(student == clone));
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

        new ShallowCopy().test1();

    }
}
