package com.allen.dao;

import com.allen.entity.StudentInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface StudentInfoRepository {
    
    @Query(value="select stu as student,sub.name as subject,gra.grade from Student stu left join Subject sub on(stu.subjectId=sub.id) left join Grade gra on(stu.gradeId=gra.id)")
    Page<StudentInfo> queryStudentInfo(Pageable pageable);
}
