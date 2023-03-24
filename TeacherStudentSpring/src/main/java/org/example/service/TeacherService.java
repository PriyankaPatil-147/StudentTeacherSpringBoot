package org.example.service;

import org.example.model.Student;
import org.example.model.Teacher;
import org.example.repo.TeacherRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService implements TeacherServiceImpl{

    @Autowired
    TeacherRepoImpl repo;
    @Override
    public void insertsingle(Teacher teacher) {

        repo.insertsingle(teacher);
    }
    @Override
    public void insertMultiple(List<Teacher> teacherstudentList) {
        for (int i = 0; i < teacherstudentList.size(); i++) {
            repo.insertsingle(teacherstudentList.get(i));
        }
    }
    @Override
    public Teacher selectSingle(int id, int rollNo)
    {
       return repo.selectSingle(id,rollNo);
    }
    @Override
    public List<Teacher> selectMultiple(List<Integer> id,List<Integer> rollNos){
        List<Teacher> teacherstudentList = new ArrayList<>();
        for (int i = 0; i < id.size(); i++) {
            Teacher s1= repo.selectSingle(id.get(i),rollNos.get(i));
            teacherstudentList.add(s1);
        }
        return teacherstudentList;
    }

    @Override
    public List<Teacher> selectAll(){
        return repo.selectAll();
    }
    @Override
    public Teacher updateSingle(Teacher teacher){
        return repo.updateSingle(teacher);
    }

    @Override
    public List<Teacher> updateMultiple(List<Teacher> teachers){
        List<Teacher> teacherstudentList = new ArrayList<>();
        for (int i = 0; i < teachers.size(); i++) {
            Teacher s1= repo.updateSingle(teachers.get(i));
            teacherstudentList.add(s1);
        }
        return teacherstudentList;
    }
    @Override
    public boolean deleteSingle(int id,int rollNo){
        return repo.deleteSingle(id,rollNo);
    }

    @Override
    public List<Boolean> deleteMultiple(List<Integer> id,List<Integer> rollNos) {
        List<Boolean> teacherList = new ArrayList<>();
        for(int i = 0; i < id.size(); i++)
        {
            Boolean b1 = repo.deleteSingle(id.get(i),rollNos.get(i));
            teacherList.add(b1);
        }
        return teacherList;
    }
    @Override
    public Boolean deleteAll(){

        return repo.deleteAll();
    }

}
