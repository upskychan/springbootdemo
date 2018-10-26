package com.upsky.springboot.service;

import com.upsky.springboot.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> selectAllStudents(Boolean includeDel);

    int updateStudentById();

    int updateStudentById2();

    /**
     * 获取学生信息。
     * @param studentId 学生ID
     * @return 学生信息
     */
    Student getStudentById(Long studentId);
}
