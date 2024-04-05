package in.kawshik.service;


import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import in.kawshik.dashboard.Dashboard;
import in.kawshik.entity.Counsellor;
import in.kawshik.entity.Enquiry;
import in.kawshik.repo.CounsellorRepo;
import in.kawshik.repo.EnquiryRepo;


@Service
public class EnquiryImp implements IEnquiryService {
	
	@Autowired
	private CounsellorRepo counRepo;
	
	@Autowired
	private EnquiryRepo enqRepo;



	@Override
	public Dashboard getDashboard(Integer counsellorId) {
		
		Long totalEnquiries = enqRepo.totalEnquiries(counsellorId);
		Long openEnquiries = enqRepo.getEnquiries(counsellorId, "new");
		Long closeEnquiries = enqRepo.getEnquiries(counsellorId, "lost");
		Long enrollEnquiries = enqRepo.getEnquiries(counsellorId, "enrolled");
		
		Dashboard d=new Dashboard();
		
		d.setTotalEnquiry(totalEnquiries);
		d.setCloseEnquiry(closeEnquiries);
		d.setEnrolledEnquiry(enrollEnquiries);
		d.setOpenEnquiry(openEnquiries);
		
		
		
		return d;
	}

	
	@Override
	public boolean saveEnquiry(Enquiry e, Integer counsellorId) {
		 Counsellor counsellor = counRepo.findById(counsellorId).orElseThrow();
		 
		 e.setCounsellor_Id(counsellor);
		 
		 Enquiry save = enqRepo.save(e);
		 return save.getEnquiryId()!=null;
	}

	
	
	
	@Override
	public List<Enquiry> getEnquiry(Enquiry e,Integer counsellorId) {
	    // Create an ExampleMatcher for ignoring null values, ignoring case, and matching with containing substring
	    ExampleMatcher matcher = ExampleMatcher.matching()
	            .withIgnoreNullValues()
	            .withIgnoreCase()
	            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

	    Counsellor counsellor = new Counsellor();
	    counsellor.setCounsellorId(counsellorId);
	    e.setCounsellor_Id(counsellor);

	    // Create an Example instance based on the Enquiry object
	    Example<Enquiry> example = Example.of(e, matcher);

	    // Retrieve the list of Enquiry objects based on the Example
	    return enqRepo.findAll(example);
	}

	


	@Override
	public Enquiry editEnquiry(Integer enquiryId) {
		if(enquiryId!=null) {
			Enquiry e = enqRepo.findById(enquiryId).orElseThrow();
			return e;
		}
		return null;
	}

}
