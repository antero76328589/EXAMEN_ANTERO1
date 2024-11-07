package com.demodj.demo_examen.controller;


import com.demodj.demo_examen.entity.Course;
import com.demodj.demo_examen.service.impl.CourseServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/course")
public class CourseController {

    private final CourseServiceImpl courseService;

    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/listar")
    public String listAllCourses(Model model) {
        model.addAttribute("title", "Lista de Cursos");
        model.addAttribute("listaCourse", courseService.getAllCourses());
        return "pages/list-course";
    }

    @GetMapping("/nuevo")
    public String addCourse(Model model) {
        Course course = new Course();
        model.addAttribute("title", "Agregar Curso");
        model.addAttribute("course", course);
        return "pages/form-course";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.addCourse(course);
        return "redirect:/course/listar";
    }

    @GetMapping("/showUpdateCourse/{id}")
    public String updateCourse(@PathVariable(value = "id") Long id, Model model) {
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        return "pages/form-courseActualizar";
    }

    @PostMapping("/update")
    public String updateCourse(@ModelAttribute("course") Course course) {
        courseService.updateCourse(course);
        return "redirect:/course/listar";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable(value = "id") Long id) {
        courseService.deleteCourse(id);
        return "redirect:/course/listar";
    }
}
