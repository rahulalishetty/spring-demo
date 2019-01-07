package com.example.demo.Course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/courses")
    public List<Course> getAllTopics() {
        return courseService.getAllTopics();
    }

    @RequestMapping("/courses/{id}")
    public Course getTopic(@PathVariable String id) {
        return courseService.getTopic(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/courses")
    public void addTopic(@RequestBody Course topic) {
        courseService.addTopic(topic);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/courses/{id}")
    public void addTopic(@RequestBody Course topic, @PathVariable String id) {
        courseService.updateTopic(id, topic);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/courses/{id}")
    public void deleteTopic(@PathVariable String id) {
        courseService.deleteTopic(id);
    }
}
