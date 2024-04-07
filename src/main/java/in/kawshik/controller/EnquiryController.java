package in.kawshik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.kawshik.dashboard.Dashboard;
import in.kawshik.entity.Enquiry;
import in.kawshik.service.IEnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;

//import in.kawshik.service.IEnquiryService;

@Controller
public class EnquiryController {

	@Autowired
	private IEnquiryService enquiryService;
	
	
	
	
	
	@GetMapping("/dashboard")
	public String getDashboard(Model m,HttpServletRequest req) {
		
		HttpSession session = req.getSession(false);
		Object attribute = session.getAttribute("cid");
		
		Dashboard dashboard = enquiryService.getDashboard((Integer) attribute);
		
		m.addAttribute("dashboard", dashboard);
		return "dashboard";
	}
	
	
	
	
	
	@GetMapping("/addEnquiry")
	public String getAddEnquiry(Model m) {
		
		m.addAttribute("addObj",new Enquiry());
		return "addEnquiry";
	}
	
	
	@PostMapping("/addEnquiry")
	public String sendEnquiry(@ModelAttribute("addObj") Enquiry e,Model m,HttpServletRequest req) {
		
		HttpSession session = req.getSession(false);
		Object attribute = session.getAttribute("cid");
		
//		}
		if(e.getEnquiryName()!=null) {
			enquiryService.saveEnquiry(e, (Integer) attribute);
			m.addAttribute("smsg","Recored inserted succesfully");
		}else {
			m.addAttribute("emsg","Something went wrong ");
		}
		m.addAttribute("addObj",new Enquiry());
	
		return "addEnquiry";
	}
	
	
	
	
	@GetMapping("/edit/{enquiryId}")
	public String getEditView(@PathVariable("enquiryId") Integer id,Model m,HttpServletRequest req) {
		
		
		Enquiry editEnquiry = enquiryService.editEnquiry(id);
		
		m.addAttribute("addObj", editEnquiry);
		
		return "addEnquiry";
	}
	
	
//	
//	@PostMapping("/edit/{enquiryId}")
//	public String saveEditView(@PathVariable("enquiryId") Integer id,@ModelAttribute("editEnquiry") Enquiry enquiry,Model m,HttpServletRequest req) {
//		
//		HttpSession session = req.getSession(false);
//		Object attribute = session.getAttribute("cid");
//		
////		Enquiry editEnquiry = enquiryService.editEnquiry(id);
//		
//		Enquiry editedEnquiry = enquiryService.editEnquiry(id);
//	    editedEnquiry.setEnquiryName(enquiry.getEnquiryName());
//	    editedEnquiry.setEnquiryPhne(enquiry.getEnquiryPhne());
//	    editedEnquiry.setCourse(enquiry.getCourse());
//	    editedEnquiry.setMode(enquiry.getMode());
//	    editedEnquiry.setStatus(enquiry.getStatus());
//		
//		
//		
//		
//		enquiryService.saveEnquiry(editedEnquiry,(Integer) attribute);
//		
//		return "redirect:/view";
//	}
	
	
	@GetMapping("/view")
	public String getViews(Model m, HttpServletRequest req,
	                       @RequestParam(value = "course", required = false) String course,
	                       @RequestParam(value = "mode", required = false) String mode,
	                       @RequestParam(value = "status", required = false) String status) {

	    HttpSession session = req.getSession(false);
	    Object attribute = session.getAttribute("cid");

	    // Create a new Enquiry object with the provided filter parameters
	    Enquiry enquiry = new Enquiry();
	    enquiry.setCourse(course);
	    enquiry.setMode(mode);
	    enquiry.setStatus(status);

	    // Pass the Enquiry object to the service method
	    List<Enquiry> enquiryList = enquiryService.getEnquiry(enquiry, (Integer) attribute);

	    // Add the filtered enquiry list to the model
	    m.addAttribute("viewObj", enquiryList);

	    return "view";
	}


	
	
}
