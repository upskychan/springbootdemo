package com.upsky.springboot.service.impl;

import com.upsky.springboot.mapper.StudentMapper;
import com.upsky.springboot.model.Student;
import com.upsky.springboot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 注入spring boot自动配置好的RedisTemplate.
     */
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    /**
     * 查询所有学生信息.
     */
    public List<Student> selectAllStudents(Boolean includeDel) {
        // 设置RedisTemplate的key的序列化器
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);

        List<Student> studentList = null;
        if(includeDel){// 包含已删除学员
            studentList = (List<Student>)redisTemplate.opsForValue().get("Students_All");
            // 使用双重检测锁解决高并发下缓存穿透的问题
            if(null == studentList) {
                synchronized (this) {
                    studentList = (List<Student>) redisTemplate.opsForValue().get("Students_All");
                    // 若缓存中没有，则从数据库中查询
                    if (null == studentList) {
                        System.out.println("查询数据库……");
                        studentList = studentMapper.selectAllStudents(null);
                        // 同时将数据放入缓存
                        redisTemplate.opsForValue().set("Students_All", studentList);
                    }
                }
            }
        }else {// 不包含已删除学员
            studentList = (List<Student>)redisTemplate.opsForValue().get("Students_NotDel");
            if(null == studentList) {
                synchronized (this) {
                    studentList = (List<Student>) redisTemplate.opsForValue().get("Students_NotDel");
                    // 若缓存中没有，则从数据库中查询
                    if(null == studentList) {
                        System.out.println("查询数据库……");
                        studentList = studentMapper.selectAllStudents((byte)0);
                        // 同时将数据放入缓存
                        redisTemplate.opsForValue().set("Students_NotDel",studentList);
                    }
                }
            }
        }
        return studentList;
    }

    @Override
    /**
     * 更新学生信息。
     */
    @Transactional
    public int updateStudentById() {
        Student student = new Student();
        student.setId((long) 10);
        student.setTimes(new Date());

        int result = studentMapper.updateByPrimaryKeySelective(student);
        System.out.println("更新结果："+result);

        return result;
    }

    @Override
    /**
     * 更新学生信息，测试异常回滚。
     */
    @Transactional
    public int updateStudentById2() {
        Student student = new Student();
        student.setId((long)9);
        student.setName("Zhigang Wang");
        student.setTimes(new Date());

        int result = studentMapper.updateByPrimaryKeySelective(student);
        System.out.println("更新结果："+result);

        // 除数不能为0，所以此处会抛出一个运行时异常
        int a = 10 / 0;
        return result;
    }

    /**
     * 通过ID获取学生信息。
     * @param studentId 学生ID
     * @return 学生信息
     */
    @Override
    public Student getStudentById(Long studentId) {
        if(null != studentId) {
            return studentMapper.selectByPrimaryKey(studentId);
        }
        return null;
    }
}
