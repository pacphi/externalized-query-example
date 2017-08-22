package io.pivotal.example.courses;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix="sql.course")
public class CourseQueries {

    private String byTitleAndNextStartDateTime;
    
}
