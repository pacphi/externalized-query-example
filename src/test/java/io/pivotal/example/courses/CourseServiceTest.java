package io.pivotal.example.courses;

import static org.hamcrest.CoreMatchers.equalTo;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.pivotal.example.courses.Course;
import io.pivotal.example.courses.CourseService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseServiceTest {

    @Autowired
    private CourseService courseService;
    
    @Before
    public void setUp() {
        Assert.assertThat(3L, equalTo(courseService.countAllCoursesEverOffered()));
    }
    
    @Test
    public void testThatCoursesAreFoundWhenTitleAndNextStartDateTimeSupplied() {
        List<Course> courses = courseService.getCoursesByTitleAndNextStartDateTime(
                "Ad hoc Analysis & Analytic Methods", 
                LocalDateTime.of(2018,1,10,17,0));
        Assert.assertThat(1, equalTo(courses.size()));
    }
    
    @Test
    public void testThatCoursesAreFoundWhenLocationSupplied() {
        List<Course> courses = courseService.getCoursesByLocation("Bellevue, WA");
        Assert.assertThat(1, equalTo(courses.size()));
    }

}
