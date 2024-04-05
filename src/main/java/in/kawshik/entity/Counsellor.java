package in.kawshik.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;


@Entity
public class Counsellor {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer counsellorId;
	
	private String counsellorName;
	
	
	private String counsellorEmail;
	
	private String counsellorPwd;
	
	private Long counsellorPhno;
	
	@CreationTimestamp
	private LocalDate createdDate;
	
	@UpdateTimestamp
	private LocalDate updatedDate;

	@OneToMany(mappedBy = "counsellor_Id",cascade = CascadeType.ALL)
	private List<Enquiry> enquiries;
	
	public Integer getCounsellorId() {
		return counsellorId;
	}

	public void setCounsellorId(Integer counsellorId) {
		this.counsellorId = counsellorId;
	}

	public String getCounsellorName() {
		return counsellorName;
	}

	public void setCounsellorName(String counsellorName) {
		this.counsellorName = counsellorName;
	}

	

	public String getCounsellorPwd() {
		return counsellorPwd;
	}

	public void setCounsellorPwd(String counsellorPwd) {
		this.counsellorPwd = counsellorPwd;
	}

	public Long getCounsellorPhno() {
		return counsellorPhno;
	}

	public void setCounsellorPhno(Long counsellorPhno) {
		this.counsellorPhno = counsellorPhno;
	}

	public String getCounsellorEmail() {
		return counsellorEmail;
	}

	public void setCounsellorEmail(String counsellorEmail) {
		this.counsellorEmail = counsellorEmail;
	}

	public List<Enquiry> getEnquiries() {
		return enquiries;
	}

	public void setEnquiries(List<Enquiry> enquiries) {
		this.enquiries = enquiries;
	}

	
	
}
