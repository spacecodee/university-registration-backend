package com.spacecodee.universityregistration.controller;

import com.spacecodee.universityregistration.service.course.CourseServiceImpl;
import com.spacecodee.universityregistration.utils.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/courses")
@CrossOrigin(origins = "http://localhost:4200/")
public class CourseController {

    private final CourseServiceImpl courseService;

    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/delete-course/{courseId}")
    public ResponseEntity<Message> addCourseRating(@PathVariable(name = "courseId") int courseId) {
        final Message message = new Message();
        if (this.courseService.deleteCourseById(courseId)) {
            message.setMessage("El curso se ha eliminado exitosamente");
        }
        else {
            message.setMessage("Hubo un error al eliminar el curso");
        }

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
