package com.allen.springboot.mapper;

import com.allen.springboot.entity.Grade;
import com.allen.springboot.entity.Student;
import com.allen.springboot.entity.Subject;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 功能:
 *
 * @date: 2018-10-08 16:20
 * @author: llwang@wisdombud.com
 * @version: 0.0.4-snapshot
 * @since: JDK 1.8
 **/
//@Mapper
public interface StudentMapper {
    @Select("SELECT A.ID,A.NAME,A.AGE,A.SEX,B.ID gradeId,B.NAME gradeName,c.id subjectId,c.name subjectName FROM T_STUDENT A "
            + "LEFT JOIN T_GRADE B ON (A.GRADEID=B.ID) LEFT JOIN T_SUBJECT C ON(A.SUBJECTID=C.ID)")
    @Results({@Result(property = "grade", column = "gradeId"), @Result(property = "subject", column = "subjectId")})
    List<Student> findAll();
    
    @Select("SELECT * FROM t_grade")
    List<Grade> findGrade();
    
    @Select("SELECT * FROM t_subject")
    List<Subject> findSubject();
    
    @Insert("INSERT INTO t_student(name,age,sex,gradeId,subjectId) VALUES(#{name}, #{age}, #{sex},#{grade},#{subject})")
    void addStudent(Student student);
    
    @Update("UPDATE t_student SET name=#{name},age=#{age},sex=#{sex},gradeId=#{grade},subjectId=#{subject} WHERE id =#{id}")
    void updateStudent(Student student);
    
    @Select("SELECT * FROM t_student WHERE id = #{id}")
    @Results({@Result(property = "grade", column = "gradeId"), @Result(property = "subject", column = "subjectId")})
    Student findStudentById(Integer id);
    
    @Delete("DELETE FROM t_student WHERE id =#{id}")
    void delStudent(Integer id);
    
    @Select({"<script>",
             "SELECT A.ID,A.NAME,A.AGE,A.SEX,B.ID gradeId,B.NAME gradeName,c.id subjectId,c.name subjectName",
             "FROM T_STUDENT A LEFT JOIN T_GRADE B ON (A.GRADEID=B.ID) LEFT JOIN T_SUBJECT C ON(A.SUBJECTID=C.ID)",
             "WHERE 1=1",
             "<when test='grade!=0'>",
             "AND B.ID = #{grade} ",
             "</when>",
             "<when test='sex!=null'>",
             "AND A.SEX LIKE CONCAT('%',#{sex},'%')",
             "</when>",
             "<when test='name!=null'>",
             "AND A.NAME LIKE CONCAT('%',#{name},'%')",
             "</when>",
             "</script>"})
    List<Student> queryStudent(Student student);
    
    /*
       
        @Select("Select * from teacher where name = #{name}")
        占位符# like select * from teacher where name = ?;
        @Select("Select * from teacher where name = ${name}")
        占位符$  like select * from teacher where name = 'someName';
    */
}
