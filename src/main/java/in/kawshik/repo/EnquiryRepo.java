package in.kawshik.repo;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.kawshik.entity.Enquiry;

public interface EnquiryRepo extends JpaRepository<Enquiry, Integer> {
	
	
	@Query(value = "select count(*) from enquiry where counsellor_Id=:id",nativeQuery = true)
	public Long totalEnquiries(Integer id);
	
	
	@Query(value = "select count(*) from enquiry where counsellor_Id=:id and status=:status",nativeQuery = true)
	public Long getEnquiries(Integer id,String status);

	
	

}
