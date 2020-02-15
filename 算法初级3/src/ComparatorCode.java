/*
       比较器
 */

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorCode {

    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    //自定义比较器类
    public static class  IdAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    public static class  IdDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    public static class AgeAscending implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }

    public static class AgeDescending implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.age - o1.age;
        }
    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
        System.out.println("===========================");
    }


    public static void main(String[] args) {
        Student student1 = new Student("张三",1,18);
        Student student2 = new Student("李四",2,15);
        Student student3 = new Student("王五",3,17);

        Student[] students = {student1,student2,student3};

        Arrays.sort(students,new IdAscendingComparator());
        printStudents(students);

        System.out.println("==========================");

        Arrays.sort(students,new AgeDescending());
        printStudents(students);
    }
}
