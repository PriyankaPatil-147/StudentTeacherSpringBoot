package org.example.service;

import org.example.model.Teacher;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TeacherServiceImpl {
    void insertsingle (Teacher teacher);

    void insertMultiple(List<Teacher> teacherstudentList);
    Teacher selectSingle(int id, int rollNo);

    List<Teacher> selectMultiple(List<Integer> id,List<Integer> rollNos);

    List<Teacher> selectAll();
    Teacher updateSingle(Teacher teacher);
    List<Teacher> updateMultiple(List<Teacher> teachers);

    boolean deleteSingle(int id,int rollNo);

    List<Boolean> deleteMultiple(List<Integer> id,List<Integer> rollNos);

    Boolean deleteAll();
}
