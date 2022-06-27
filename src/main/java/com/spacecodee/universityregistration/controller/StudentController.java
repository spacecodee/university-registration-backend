package com.spacecodee.universityregistration.controller;

import com.spacecodee.universityregistration.dto.course_rating.CoursesRatingDto;
import com.spacecodee.universityregistration.service.student.StudentServiceImpl;
import com.spacecodee.universityregistration.utils.MessageData;
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
    public ResponseEntity<MessageData<CoursesRatingDto>> findCoursesLikeByStudentId(
            @PathVariable(name = "studentId") int studentId) {
        final MessageData<CoursesRatingDto> messages = new MessageData<>();
        CoursesRatingDto coursesRatingDto = this.studentLikesCourseService.getCoursesLikeByStudentId(studentId);

        if (coursesRatingDto == null) {
            messages.setMessage("El estudiante no tiene cursos favoritos");
            return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
        }
        else {
            messages.setMessage("Cursos favoritos del estudiante");
            messages.setData(coursesRatingDto);
            return new ResponseEntity<>(messages, HttpStatus.OK);
        }
    }
}
