package com.example.demo.Course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private List<Course> topics = new ArrayList<>( Arrays.asList(
            new Course("1","cs"),
            new Course("2","dbms")
    ));

    public List<Course> getAllTopics(){
        return topics;
    }

    public Course getTopic(String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Course topic) {
        topics.add(topic);
    }

    public void updateTopic(String id, Course topic) {
        for(int i=0; i<topics.size(); i++) {
            Course t = topics.get(i);
            if(t.getId().equals(id)) {
                topics.set(i, topic);
                return;
            }
        }

    }

    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
    }
}