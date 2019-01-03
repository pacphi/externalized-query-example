package io.pivotal.example.courses;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="sql.course")
public class CourseQueries {

    private String byTitleAndNextStartDateTime;

	public String getByTitleAndNextStartDateTime() {
		return byTitleAndNextStartDateTime;
	}

	public void setByTitleAndNextStartDateTime(String byTitleAndNextStartDateTime) {
		this.byTitleAndNextStartDateTime = byTitleAndNextStartDateTime;
	}
    
}
