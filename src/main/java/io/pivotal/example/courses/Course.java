package io.pivotal.example.courses;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COURSE")
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

    
    private Course() {}
    
	public Course(Long id, String title, String description, String location, String duration,
			LocalDateTime startDateTime) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = location;
		this.duration = duration;
		this.startDateTime = startDateTime;
	}

	private Course(Builder builder) {
		this.id = builder.id;
		this.title = builder.title;
		this.description = builder.description;
		this.location = builder.location;
		this.duration = builder.duration;
		this.startDateTime = builder.startDateTime;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long id;
		private String title;
		private String description;
		private String location;
		private String duration;
		private LocalDateTime startDateTime;

		private Builder() {
		}

		public Builder withId(Long id) {
			this.id = id;
			return this;
		}

		public Builder withTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder withDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder withLocation(String location) {
			this.location = location;
			return this;
		}

		public Builder withDuration(String duration) {
			this.duration = duration;
			return this;
		}

		public Builder withStartDateTime(LocalDateTime startDateTime) {
			this.startDateTime = startDateTime;
			return this;
		}

		public Course build() {
			return new Course(this);
		}
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getLocation() {
		return location;
	}

	public String getDuration() {
		return duration;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}
    
}
