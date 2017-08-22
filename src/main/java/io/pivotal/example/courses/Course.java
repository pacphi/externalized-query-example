package io.pivotal.example.courses;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="COURSE")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Course {

    @Id @GeneratedValue @Column(name="ID")
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
