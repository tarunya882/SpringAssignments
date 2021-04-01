import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainClass {
    public static void main(String[] args) {
        Student s1=new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8);
        Student s2=new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2);
        Student s3=new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3);
        Student s4=new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80);
        Student s5=new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70);
        Student s6=new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70);
        Student s7=new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70);
        Student s8=new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80);
        Student s9=new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85);
        Student s10=new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82);
        Student s11=new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83);
        Student s12=new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4);
        Student s13=new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6);
        Student s14=new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8);
        Student s15=new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4);
        Student s16=new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4);
        Student s17=new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5);
        List<Student> studentList=new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        studentList.add(s6);
        studentList.add(s7);
        studentList.add(s8);
        studentList.add(s9);
        studentList.add(s10);
        studentList.add(s11);
        studentList.add(s12);
        studentList.add(s13);
        studentList.add(s14);
        studentList.add(s15);
        studentList.add(s16);
        studentList.add(s17);
        //1
        PrintDepartments p=new PrintDepartments();
        p.print(studentList);
        StreamApi sa=new StreamApi();
        //2
        sa.enrolledListAfterTwentyEighteen(studentList);
        //3
        List<Student>allMaleList=sa.getAllMaleInDepartment(studentList,"ComputerScience");
        System.out.println("Male students in given computer science department is "+allMaleList);
        //4
        sa.countOfMaleAndFemale(studentList);
        //5
        sa.avgAgeOfMaleAndFemale(studentList);
        //6
        Optional<Student>highestPercentageStudent=sa.getStudentOfHighPercentage(studentList);
        System.out.println("Student having highest percentage is "+highestPercentageStudent);
        //7
        sa.noOfStudentsInEachDepartment(studentList);
        //8
        sa.avgPercentageInEachDepartment(studentList);
        //9
        sa.youngStudentInDepartment(studentList,"Electronic","Male");
        System.out.println(sa.getStudentOfHighPercentage(studentList));
        //10
        sa.noOfMaleAndFemaleInDepartment(studentList,"Computer Science");
    }
}
