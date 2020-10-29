package com.usian.service;

import com.github.pagehelper.util.StringUtil;
import com.usian.dao.StudentMapper;
import com.usian.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service("studentService")
public class StudentService {
    @Autowired(required = false)
    private StudentMapper studentMapper;

    public List<Student> getAll(String name, String starttime, String endtime) {
        Example example = new Example(Student.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(name)){
            criteria.andLike("name", "%"+name+"%");
        }
        if(StringUtil.isNotEmpty(starttime)){
            criteria.andGreaterThanOrEqualTo("birthday",starttime);
        }
        if(StringUtil.isNotEmpty(endtime)){
            criteria.andLessThanOrEqualTo("birthday",endtime);
        }
        List<Student> studentList = studentMapper.selectByExample(example);
        return studentList;
    }

    public void add(Student student) {
        studentMapper.insertSelective(student);
    }

    public void delete(int id) {
        studentMapper.deleteByPrimaryKey(id);
    }

    public Student getStudent(int id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    public void update(Student student) {
        studentMapper.updateByPrimaryKeySelective(student);
    }
}
