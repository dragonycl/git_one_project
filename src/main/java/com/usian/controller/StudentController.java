package com.usian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.usian.pojo.Student;
import com.usian.pojo.User;
import com.usian.service.StudentService;
import com.usian.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    /**
     * 页面跳转
     */
    @RequestMapping("/login")
    public String showPage() {
        return "login";
    }

    @RequestMapping("/goLogin")
    public String goLogin(User user, HttpServletRequest request, Model model){
        User users=userService.login(user);
        if(users==null){
            request.setAttribute("z", "用户名错误");
            return "login";
        }
        if(users.getPassword().equals(user.getPassword())==false){
            request.setAttribute("p", "密码错误");
            return "login";
        }
        request.getSession().setAttribute("user", user);
        return "redirect:studentList";
    }

    @RequestMapping("/studentList")
    public String studentList(String starttime, String endtime, String name,
                              @RequestParam(value = "pageSize",defaultValue = "2")int pageSize,
                              @RequestParam(value = "pageNum",defaultValue = "1")int pageNum, Model model){
        PageHelper.startPage(pageNum,pageSize);
        List<Student> studentList=studentService.getAll(name,starttime,endtime);
        PageInfo<Student> pageInfo=new PageInfo<>(studentList);
        model.addAttribute("list",pageInfo);
        model.addAttribute("starttime",starttime);
        model.addAttribute("endtime",endtime);
        model.addAttribute("name",name);
        return "list";
    }

    @RequestMapping("/add")
    public String add() {
        return "add";
    }

    @RequestMapping("/addStudent")
    public String b(Student student){
        studentService.add(student);
        return "redirect:studentList";
    }

    @RequestMapping("/delete")
    public String delete(String id){
        studentService.delete(Integer.parseInt(id));
        return "redirect:studentList";
    }

    @RequestMapping("/findStudentById")
    public String findStudentById(String id,Model model){
        Student student=studentService.getStudent(Integer.parseInt(id));
        model.addAttribute("student",student);
        return "update";
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(Student student) {
        studentService.update(student);
        return "redirect:studentList";
    }
}
