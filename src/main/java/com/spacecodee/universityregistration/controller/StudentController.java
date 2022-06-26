package com.spacecodee.universityregistration.controller;

import com.spacecodee.universityregistration.dto.student.ListCoursesLikesDto;
import com.spacecodee.universityregistration.service.StudentServiceImpl;
import com.spacecodee.universityregistration.utils.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@CrossOrigin(origins = "http://localhost:4200/")
public class StudentController {

    private final StudentServiceImpl studentLikesCourseService;

    public StudentController(StudentServiceImpl studentLikesCourseService) {
        this.studentLikesCourseService = studentLikesCourseService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/student-course-likes/{studentId}")
    public ResponseEntity<Message<ListCoursesLikesDto>> findCoursesLikeByStudentId(
            @PathVariable(name = "studentId") int studentId) {
        final Message<ListCoursesLikesDto> messages = new Message<>();
        ListCoursesLikesDto coursesLikesDto = this.studentLikesCourseService.getCoursesLikeByStudentId(studentId);
        System.out.println("coursesLikesDto = " + coursesLikesDto);
        if (coursesLikesDto == null) {
            messages.setMessage("El estudiante no tiene cursos favoritos");
            return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
        }
        else {
            messages.setMessage("Cursos favoritos del estudiante");
            messages.setData(coursesLikesDto);
            return new ResponseEntity<>(messages, HttpStatus.OK);
        }
    }
}
