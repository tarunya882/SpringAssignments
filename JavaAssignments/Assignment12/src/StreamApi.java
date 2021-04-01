import  java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;
public class StreamApi {

    //2.enrolled students after 2018
    public List<String> enrolledListAfterTwentyEighteen(List<Student> studentList) {
        List<String> names = studentList.stream().filter(y -> y.yearOfEnrollment >= 2018).map(Student::getName).toList();
        System.out.println(names);
        return names;
    }
    //3
    public List<Student> getAllMaleInDepartment(List<Student>studentList,String department){
        return studentList.stream().filter(p -> p.getGender().equals("Male") && p.getDept().equals(department)).collect(Collectors.toList());
    }
    //4.No of male and female students
    public void countOfMaleAndFemale(List<Student> studentList) {
        Map<String, List<Student>> studentGender = studentList.stream().collect(Collectors.groupingBy(Student::getGender));
        for (String key : studentGender.keySet()) {
            System.out.println("No of " + key + " is " + studentGender.get(key).size());
        }
    }
   //5
    public void avgAgeOfMaleAndFemale(List<Student>studentList){
        Map<String, Double> avgAgeOfMaleAndFemaleEmployees=studentList.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.out.println(avgAgeOfMaleAndFemaleEmployees);

    }
    //6
    public Optional<Student> getStudentOfHighPercentage(List<Student>studentList){
        return studentList.stream().max(Comparator.comparingDouble(Student::getPerTillDate));
    }
   //7
    public void noOfStudentsInEachDepartment(List<Student> studentList) {
        Map<String, List<Student>> studentDept = studentList.stream().collect(Collectors.groupingBy(Student::getDept));
        for (String key : studentDept.keySet()) {
            System.out.println("No of " + key + " students is " + studentDept.get(key).size());
        }
    }
    //8
    public void avgPercentageInEachDepartment(List<Student>studentList){
        Map<String, Double> avgPercentageOfDepartments=
                studentList.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.averagingDouble(Student::getPerTillDate)));
        for (String s:avgPercentageOfDepartments.keySet()){
            System.out.println(s+" "+avgPercentageOfDepartments.get(s));
        }
    }
    //9
     public void youngStudentInDepartment(List<Student>studentList,String department,String gender){
        Optional<Student>student= studentList.stream().filter(e -> e.getGender().equals(gender)&& e.getDept().equals(department)).min(Comparator.comparingInt(Student::getAge));
        Student s1=student.get();
         System.out.println("Age is "+s1.getAge());
     }

    // 10.male and female in cse
    public void noOfMaleAndFemaleInDepartment(List<Student> studentList,String department) {
        Map<String, List<Student>> studentGender1 = studentList.stream().filter(d -> d.getDept().equals(department)).collect(Collectors.groupingBy(Student::getGender));
        for (String key : studentGender1.keySet()) {
            System.out.println("No of " + key + " in cse is " + studentGender1.get(key).size());
        }
    }
}