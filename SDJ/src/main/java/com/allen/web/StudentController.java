package com.allen.web;

import com.allen.dao.GradeRepository;
import com.allen.dao.StudentInfoRepository;
import com.allen.dao.StudentRepository;
import com.allen.dao.SubjectRepository;
import com.allen.entity.Grade;
import com.allen.entity.Student;
import com.allen.entity.StudentInfo;
import com.allen.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

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
    StudentInfoRepository studentInfoRepository;
    
    @Autowired
    StudentRepository studentRepository;
    
    @Autowired
    GradeRepository gradeRepository;
    
    @Autowired
    SubjectRepository subjectRepository;
    
    @RequestMapping("/addStudentPage")
    public ModelAndView toAddStudent(String id) {
        ModelAndView mv = new ModelAndView("student/student-edit");
        mv.addObject("id", id);
        return mv;
    }
    
    @RequestMapping("/delStudent")
    public ModelAndView delStudent(Long id) {
        studentRepository.deleteById(id);
        return new ModelAndView("forward:/listStudent");
    }
    
    
    @RequestMapping("/addOrUpdateStudent")
    public ModelAndView addOrUpdateStudent(Student student) {
        Long id = student.getId();
        studentRepository.save(student);
        return new ModelAndView("forward:/listStudent");
    }
    
    @RequestMapping("/listStudent")
    public String listStudent(Model model) {
        Page<StudentInfo> students = studentInfoRepository.queryStudentInfo((new PageRequest(0,10)));
        model.addAttribute("students", students);
        
        return "student/student-list";
    }
    
    @RequestMapping("/findStudentById")
    @ResponseBody
    // 将相应主体返回
    public  Optional<Student> findStudentById(Long id) {
    
        Optional<Student> student = studentRepository.findById(id);
        return student;
    }
   /* @RequestMapping("/queryStudent")
    @ResponseBody
    public List<Student> queryStudent(Student student,Model model) {
        List<Student> students = studentMapper.queryStudent(student);
        return students;
    }*/
    
    @RequestMapping("/loadGrade")
    @ResponseBody
    // 将相应主体返回
    public List<Grade> loadGrade() {
        
        List<Grade> list = gradeRepository.findAll();
        return list;
    }
    
    @RequestMapping("/loadSubject")
    @ResponseBody
    // 将相应主体返回
    public List<Subject> loadSubject() {
        
        List<Subject> list = subjectRepository.findAll();
        return list;
    }
    
}
