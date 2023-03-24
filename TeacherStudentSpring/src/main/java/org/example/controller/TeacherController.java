package org.example.controller;

import org.example.model.Teacher;
import org.example.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    TeacherServiceImpl service;

    @RequestMapping("/insertsingle")
    @ResponseBody
    void insertsingle (@RequestBody Teacher teacher){
        service.insertsingle(teacher);
    }

    @RequestMapping("/insertMultiple")
    @ResponseBody
    void insertMultiple(@RequestBody List<Teacher> teacherstudentList){
        service.insertMultiple(teacherstudentList);
    }

    @RequestMapping("/selectSingle")
    @ResponseBody
    Teacher selectSingle(@RequestParam int id,@RequestParam int rollNo)
    {
        return service.selectSingle(id, rollNo);
    }


    @RequestMapping("/selectMultiple")
    @ResponseBody
    List<Teacher> selectMultiple(@RequestParam List<Integer> id,@RequestParam List<Integer> rollNos){
        return service.selectMultiple(id,rollNos);
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    List<Teacher> selectAll() {
        return service.selectAll();
    }
    @RequestMapping("/updateSingle")
    @ResponseBody
    Teacher updateSingle(@RequestBody Teacher teacher){
        return service.updateSingle(teacher);
    }

    @RequestMapping("/updateMultiple")
    @ResponseBody
    List<Teacher> updateMultiple(@RequestBody List<Teacher> teachers){
        return service.updateMultiple(teachers);
    }
    @RequestMapping("/deleteSingle")
    @ResponseBody
    boolean deleteSingle(@RequestParam int id,@RequestParam int rollNo){
        return service.deleteSingle(id, rollNo);
    }
    @RequestMapping("/deleteMultiple")
    @ResponseBody
    public List<Boolean> deleteMultiple(@RequestParam List<Integer> id,@RequestParam List<Integer> rollNos){
        return service.deleteMultiple(id,rollNos);
    }
    @RequestMapping("/deleteAll")
    @ResponseBody
    public Boolean deleteAll(){
        return service.deleteAll();
    }

}
