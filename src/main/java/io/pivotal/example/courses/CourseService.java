package io.pivotal.example.courses;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseQueries courseQueries;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CourseService(
            CourseRepository courseRepository,
            CourseQueries courseQueries,
            DataSource dataSource
            ) {
                this.courseRepository = courseRepository;
                this.courseQueries = courseQueries;
                this.jdbcTemplate = new JdbcTemplate(dataSource);
        
    }
    
    @Transactional(readOnly=true)
    public List<Course> getCoursesByLocation(String location) {
        return courseRepository.findByLocation(location);
    }
    
    @Transactional(readOnly=true)
    public List<Course> getCoursesByTitleAndNextStartDateTime(
            String title,
            LocalDateTime startDate) {
        return jdbcTemplate.query(
                courseQueries.getByTitleAndNextStartDateTime(), 
                new Object[] {title, startDate}, 
                new ResultSetExtractor<List<Course>>() {

                    @Override
                    public List<Course> extractData(ResultSet rs) throws SQLException, DataAccessException {
                        List<Course> courses = new ArrayList<>();
                        while(rs.next()) {
                            Course c = new Course(
                                    rs.getLong("ID"), 
                                    rs.getString("TITLE"),
                                    rs.getString("DESCRIPTION"),
                                    rs.getString("LOCATION"),
                                    rs.getString("DURATION"),
                                    rs.getTimestamp("START_DATE_TIME").toLocalDateTime());
                            courses.add(c);
                        }
                        return courses;
                    }
                    
                } );
    }
    
    @Transactional(readOnly=true)
    public long countAllCoursesEverOffered() {
        return courseRepository.count();
    }
    
}
