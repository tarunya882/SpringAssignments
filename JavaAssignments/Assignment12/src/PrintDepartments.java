import java.util.List;

public class PrintDepartments extends StreamApi{
    public void print(List<Student>studentList){
        StreamApi sa=new StreamApi();
        List<String> department=studentList.stream().map(Student::getDept).distinct().toList();
        System.out.println("Departments list:"+department);
    }
}
