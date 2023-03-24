package org.example.repo;


import org.example.model.Student;
import org.example.model.Teacher;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TeacherRepo implements TeacherRepoImpl{
    @Override
    public void insertsingle (Teacher teacher){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "");
            Statement st = con.createStatement();
            st.executeUpdate("insert into stud3 values('" +teacher.getStudent().getRollNo() + "','" + teacher.getStudent().getName() + "','" + teacher.getStudent().getEmail() + "')");
            st.executeUpdate("insert into teacher values('" +teacher.getId() + "','" + teacher.getName() + "','" + teacher.getEmail() + "')");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public Teacher selectSingle(int id, int rollNo)
    {
        Teacher teacher=new Teacher();
        Student student=new Student();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "");
            Statement st = con.createStatement();

            ResultSet rs1 = st.executeQuery("select * from teacher where id = '" + id + "'");
            while (rs1.next()) {
                    teacher.setId(rs1.getInt(1));
                    teacher.setName(rs1.getString(2));
                    teacher.setEmail(rs1.getString(3));
            }

            ResultSet rs = st.executeQuery("select * from stud3 where rollno = '" + rollNo + "'");
            while (rs.next()) {
                    student.setRollNo(rs.getInt(1));
                    student.setName(rs.getString(2));
                    student.setEmail(rs.getString(3));
            }
            teacher.setStudent(student);
        } catch (Exception e) {
            System.out.println(e);
        }
        return teacher;
    }

    @Override
    public List<Teacher> selectAll()
    {
        List<Teacher> teacherList=new ArrayList<>();
        List<Student> studentList=new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "");
            Statement st = con.createStatement();

            ResultSet rs1 = st.executeQuery("select * from teacher");
            while (rs1.next()) {
                Teacher teacher=new Teacher();
                teacher.setId(rs1.getInt(1));
                teacher.setName(rs1.getString(2));
                teacher.setEmail(rs1.getString(3));
                teacherList.add(teacher);
            }

            ResultSet rs = st.executeQuery("select * from stud3 ");
            while (rs.next()) {
                Student student = new Student();
                student.setRollNo(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
                studentList.add(student);
            }
            for(int i=0; i<teacherList.size();i++){
                Teacher t1=teacherList.get(i);
                t1.setStudent(studentList.get(i));
            }
        }

        catch (Exception e) {
            System.out.println(e);
        }
        return teacherList;
    }
    @Override
    public Teacher updateSingle(Teacher teacher){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","");
            Statement st = con.createStatement();
            st.executeUpdate("update teacher set name='"+teacher.getName()+"',email='"+teacher.getEmail()+"' where id='"+teacher.getId()+"'");
            st.executeUpdate("update stud3 set name='"+teacher.getStudent().getName()+"',email='"+teacher.getStudent().getEmail()+"' where rollno='"+teacher.getStudent().getRollNo()+"'");
        }
        catch (Exception e){
            System.out.println(e);
        }
       return selectSingle(teacher.getId(),teacher.getStudent().getRollNo());
    }
    @Override
    public boolean deleteSingle(int id,int rollNo){
        boolean result=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","");
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from teacher where id ='"+id+"'");
            int count1= st.executeUpdate("delete from stud3 where rollno='"+rollNo+"'");
            if (count>0 && count1>0){
                result = true;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
    @Override
    public Boolean deleteAll(){
        Boolean result=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","");
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from teacher");
            int count1 = st.executeUpdate("delete from stud3");
            if (count!=0 && count!=0){
                result = true;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return result;
    }
}
