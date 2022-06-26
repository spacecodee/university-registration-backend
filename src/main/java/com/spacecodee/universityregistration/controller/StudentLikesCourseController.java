package com.spacecodee.universityregistration.controller;

import com.spacecodee.universityregistration.dto.student.ListCoursesLikesDto;
import com.spacecodee.universityregistration.service.StudentLikesCourseServiceImpl;
import com.spacecodee.universityregistration.utils.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course-likes")
@CrossOrigin(origins = "http://localhost:4200/")
public class StudentLikesCourseController {

    private final StudentLikesCourseServiceImpl studentLikesCourseService;

    public StudentLikesCourseController(StudentLikesCourseServiceImpl studentLikesCourseService) {
        this.studentLikesCourseService = studentLikesCourseService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/student-course-likes-by/{studentId}")
    public ResponseEntity<Message<ListCoursesLikesDto>> loadPeoples(@PathVariable(name = "studentId") int studentId) {
        final Message<ListCoursesLikesDto> messages = new Message<>();
        ListCoursesLikesDto coursesLikesDto = this.studentLikesCourseService.getCoursesLikesByStudentId(studentId);
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
