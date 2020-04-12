package other;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Description
 * Date 2019-12-03 10:36
 * @author shentao
 */
public class Person implements Serializable {

    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
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
}

class WriteObject {
    public static void main(String[] args) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
            Person person = new Person("擦拭", 131);
            System.out.println(person);
            oos.writeObject(person);

            //修改name
            person.setName("托尔斯泰b");
            System.out.println(person);
            oos.writeObject(person);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.txt"));
            Person person = (Person) ois.readObject();
            System.out.println(person);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}