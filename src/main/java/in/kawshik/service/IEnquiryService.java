package in.kawshik.service;

import java.util.List;

import in.kawshik.dashboard.Dashboard;

import in.kawshik.entity.Enquiry;

public interface IEnquiryService {
	
	public Dashboard getDashboard(Integer counsellorId);
	
	
	public boolean saveEnquiry(Enquiry e,Integer counsellorId);
	
	
	public List<Enquiry>  getEnquiry(Enquiry e,Integer counsellorId);
	
	
	public Enquiry editEnquiry(Integer enquiryId);
	
//	public boolean enquiryPresent(Integer id);

}
