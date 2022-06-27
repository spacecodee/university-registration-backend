package com.spacecodee.universityregistration.controller;

import com.spacecodee.universityregistration.dto.course_like.CourseRatingLikeDto;
import com.spacecodee.universityregistration.entity.CourseEntity;
import com.spacecodee.universityregistration.entity.StudentEntity;
import com.spacecodee.universityregistration.entity.course_like.CourseRatingEntity;
import com.spacecodee.universityregistration.entity.course_like.CourseRatingKey;
import com.spacecodee.universityregistration.mapper.CourseRatingMapper;
import com.spacecodee.universityregistration.mapper.StudentMapper;
import com.spacecodee.universityregistration.service.course.CourseServiceImpl;
import com.spacecodee.universityregistration.service.course_rating.CourseLikeServiceImpl;
import com.spacecodee.universityregistration.service.student.StudentServiceImpl;
import com.spacecodee.universityregistration.utils.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course-rating")
@CrossOrigin(origins = "http://localhost:4200/")
public class CourseRatingController {

    private final CourseLikeServiceImpl courseLikeService;
    private final StudentServiceImpl studentService;
    private final CourseServiceImpl courseService;

    public CourseRatingController(CourseLikeServiceImpl courseLikeService,
                                  StudentServiceImpl studentService,
                                  CourseServiceImpl courseService) {
        this.courseLikeService = courseLikeService;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/add-course-rating")
    public ResponseEntity<Message> addCourseRating(
            @RequestBody CourseRatingLikeDto courseRatingLikeDto) {
        final Message messages = new Message();

        boolean isCourseAdd = this.courseService.addUpdateCourse(
                CourseRatingMapper.mapCourseRatingAddDtoToCourseEntity(courseRatingLikeDto));
        if (!isCourseAdd) {
            messages.setMessage("El curso no se pudo agregar");
            return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
        }

        boolean isUserAdd = this.studentService.addUpdateStudent(
                StudentMapper.mapCourseRatingAddDtoToStudentEntity(courseRatingLikeDto));

        if (!isUserAdd) {
            messages.setMessage("El estudiante no se pudo agregar");
            return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
        }

        final StudentEntity studentEntity = this.studentService.findStudentByName(
                courseRatingLikeDto.getStudentDto().getName());
        final CourseEntity courseEntity = this.courseService.findCourseByName(
                courseRatingLikeDto.getCourseDto().getName());

        if (studentEntity == null || courseEntity == null) {
            messages.setMessage("Al parecer ocurrio un error");
            return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
        }

        CourseRatingEntity courseRatingEntity1 = new CourseRatingEntity(
                new CourseRatingKey(studentEntity.getStudentId(), courseEntity.getCourseId()),
                studentEntity,
                courseEntity,
                courseRatingLikeDto.getRating()
        );

        final boolean isAdded = courseLikeService.addCourseLike(courseRatingEntity1);
        if (isAdded) {
            messages.setMessage("El curso se ha agregado a favoritos");
            return new ResponseEntity<>(messages, HttpStatus.OK);
        }
        else {
            messages.setMessage("El curso no se ha agregado a favoritos");
            return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
        }
    }
}
