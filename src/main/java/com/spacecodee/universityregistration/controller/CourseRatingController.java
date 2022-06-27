package com.spacecodee.universityregistration.controller;

import com.spacecodee.universityregistration.dto.course_rating.CourseRatingKeyDto;
import com.spacecodee.universityregistration.dto.course_rating.CourseRatingLikeDto;
import com.spacecodee.universityregistration.entity.CourseEntity;
import com.spacecodee.universityregistration.entity.StudentEntity;
import com.spacecodee.universityregistration.entity.course_rating.CourseRatingEntity;
import com.spacecodee.universityregistration.entity.course_rating.CourseRatingKey;
import com.spacecodee.universityregistration.mapper.CourseRatingMapper;
import com.spacecodee.universityregistration.mapper.StudentMapper;
import com.spacecodee.universityregistration.service.course.CourseServiceImpl;
import com.spacecodee.universityregistration.service.course_rating.CourseRatingServiceImpl;
import com.spacecodee.universityregistration.service.student.StudentServiceImpl;
import com.spacecodee.universityregistration.utils.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course-rating")
@CrossOrigin(origins = "http://localhost:4200/")
public class CourseRatingController {

    private final CourseRatingServiceImpl courseLikeService;
    private final StudentServiceImpl studentService;
    private final CourseServiceImpl courseService;

    public CourseRatingController(CourseRatingServiceImpl courseLikeService, StudentServiceImpl studentService,
                                  CourseServiceImpl courseService) {
        this.courseLikeService = courseLikeService;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/add-course-rating")
    public ResponseEntity<Message> addCourseRating(@RequestBody CourseRatingLikeDto courseRatingLikeDto) {
        final Message message = new Message();

        final String validateExistsStudentOrCourse = validateExistsStudentOrCourse(courseRatingLikeDto);
        message.setMessage(validateExistsStudentOrCourse);
        if (!validateExistsStudentOrCourse.equals("ok")) return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

        final String addCourseAndStudent = addCourseAndStudent(courseRatingLikeDto);
        message.setMessage(addCourseAndStudent);

        if (!addCourseAndStudent.equals("ok")) return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

        final StudentEntity studentEntity = this.studentService.findStudentByIdentification(
                courseRatingLikeDto.getStudentDto().getIdentification());
        final CourseEntity courseEntity = this.courseService.findCourseByName(
                courseRatingLikeDto.getCourseDto().getName());

        if (studentEntity == null || courseEntity == null) {
            message.setMessage("El estudiante o curso no se han podido registrar");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        final CourseRatingEntity courseRatingEntity1 = CourseRatingMapper.mapCourseRatingDtoToEntity(
                courseRatingLikeDto, studentEntity, courseEntity);

        final boolean isAdded = courseLikeService.addCourseLike(courseRatingEntity1);
        if (isAdded) {
            message.setMessage("El curso se ha agregado a favoritos");
        }
        else {
            message.setMessage("El curso no se ha agregado a favoritos");
        }

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/delete-course-rating")
    public ResponseEntity<Message> deleteCourseRating(@RequestBody CourseRatingKeyDto courseRatingKeyDto) {
        final Message message = new Message();

        final CourseRatingKey courseKey = CourseRatingMapper.mapCourseKeyDtoToEntity(courseRatingKeyDto);
        if (this.courseLikeService.deleteCourseRating(courseKey)) {
            message.setMessage("Rating a Curso eliminado exitosamente");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        else {
            message.setMessage("Al parecer hubo un error eliminando el rating");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }

    private String addCourseAndStudent(CourseRatingLikeDto courseRatingLikeDto) {
        boolean isCourseAdd = this.courseService.addUpdateCourse(
                CourseRatingMapper.mapCourseRatingAddDtoToCourseEntity(courseRatingLikeDto));
        if (!isCourseAdd) {
            return "El curso no se pudo agregar";
        }

        boolean isUserAdd = this.studentService.addUpdateStudent(
                StudentMapper.mapCourseRatingAddDtoToStudentEntity(courseRatingLikeDto));
        if (!isUserAdd) {
            return "El estudiante no se pudo agregar";
        }
        return "ok";
    }

    private String validateExistsStudentOrCourse(CourseRatingLikeDto courseRatingLikeDto) {
        if (this.studentService.existsStudentByIdentification(
                courseRatingLikeDto.getStudentDto().getIdentification())) {
            return "¡Ups, el estudiante ya existe!";
        }

        if (this.courseService.existsCourseByName(courseRatingLikeDto.getCourseDto().getName())) {
            return "¡Ups, el curso ya existe!";
        }

        return "ok";
    }
}
