package com.allen.springboot.controller;

import com.allen.springboot.entity.Grade;
import com.allen.springboot.entity.Student;
import com.allen.springboot.entity.Subject;
import com.allen.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 功能: 学生控制层
 *
 * @date: 2018-10-08 16:21
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
@Controller
public class StudentController {
    @Autowired
    StudentMapper studentMapper;
    
    @RequestMapping("/addStudentPage")
    public ModelAndView toAddStudent(String id) {
        ModelAndView mv = new ModelAndView("student/student-edit");
        mv.addObject("id", id);
        return mv;
    }
    
    @RequestMapping("/delStudent")
    public ModelAndView delStudent(Integer id) {
         studentMapper.delStudent(id);
        return new ModelAndView("forward:/listStudent");
    }
    
    
    @RequestMapping("/addOrUpdateStudent")
    public ModelAndView addOrUpdateStudent(Student student) {
        Integer id = student.getId();
        if (id == null || id == 0) {
            studentMapper.addStudent(student);
        }else{
            studentMapper.updateStudent(student);
        }
        
        return new ModelAndView("forward:/listStudent");
    }
    
    @RequestMapping("/listStudent")
    public String listStudent(Model model) {
        List<Student> students = studentMapper.findAll();
        model.addAttribute("students", students);
        
        return "student/student-list";
    }
    
    @RequestMapping("/findStudentById")
    @ResponseBody
    // 将相应主体返回
    public Student findStudentById(Integer id) {
    
        Student student = studentMapper.findStudentById(id);
        return student;
    }
    @RequestMapping("/queryStudent")
    @ResponseBody
    public List<Student> queryStudent(Student student,Model model) {
        List<Student> students = studentMapper.queryStudent(student);
        return students;
    }
    
    @RequestMapping("/loadGrade")
    @ResponseBody
    // 将相应主体返回
    public List<Grade> loadGrade() {
        
        List<Grade> list = studentMapper.findGrade();
        return list;
    }
    
    @RequestMapping("/loadSubject")
    @ResponseBody
    // 将相应主体返回
    public List<Subject> loadSubject() {
        
        List<Subject> list = studentMapper.findSubject();
        return list;
    }
    
}
