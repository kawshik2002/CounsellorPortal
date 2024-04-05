package in.kawshik.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Enquiry {
	
	

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enquiryId;
	
	private String enquiryName;
	
	private String course;
	
	private String mode;
	
	private String status;
	
	private Long enquiryPhne;
	
	@CreationTimestamp
	private LocalDate createdDate;
	
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	@ManyToOne
	@JoinColumn(name = "counsellorId")
	private Counsellor counsellor_Id;

	public Integer getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(Integer enquiryId) {
		this.enquiryId = enquiryId;
	}

	public String getEnquiryName() {
		return enquiryName;
	}

	public void setEnquiryName(String enquiryName) {
		this.enquiryName = enquiryName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getEnquiryPhne() {
		return enquiryPhne;
	}

	public void setEnquiryPhne(Long enquiryPhne) {
		this.enquiryPhne = enquiryPhne;
	}

	public Counsellor getCounsellor_Id() {
		return counsellor_Id;
	}

	public void setCounsellor_Id(Counsellor counsellor_Id) {
		this.counsellor_Id = counsellor_Id;
	}

	

	
	
	
	
	

}
