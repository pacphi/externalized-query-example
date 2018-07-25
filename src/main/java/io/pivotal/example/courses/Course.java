package io.pivotal.example.courses;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="COURSE")
@Data
@Builder
@AllArgsConstructor(access=AccessLevel.PACKAGE)
@NoArgsConstructor(access=AccessLevel.PACKAGE)
public class Course {

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    
    @Column(name="TITLE")
    private String title;
    
    @Column(name="DESCRIPTION", length=2000)
    private String description;
    
    @Column(name="LOCATION")
    private String location;
    
    @Column(name="DURATION")
    private String duration;
    
    @Column(name="START_DATE_TIME")
    private LocalDateTime startDateTime;
    
}
