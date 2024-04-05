package in.kawshik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.kawshik.entity.Counsellor;
import in.kawshik.service.ICounsellorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounselllorController {
	
	
	@Autowired
	private ICounsellorService counsellorService;
	
	
	@PostMapping("/logout")
	public String getLogout(HttpServletRequest req,Model m){
		
		HttpSession session = req.getSession(false);
		if(session!=null) {
			session.invalidate();
		}
		
		return "redirect:/login";
		
		
	}
	
	
	@GetMapping("/login")
	public String getLogin(Model m) {
		m.addAttribute("loginObj",new Counsellor());
		
		return "index";
	}
	
	
	@PostMapping("/login")
	public String sendLogin(@ModelAttribute("loginObj") Counsellor c,Model m,HttpServletRequest req) {
		String counsellorEmail = c.getCounsellorEmail();
		String counsellorPwd = c.getCounsellorPwd();
		
		
		
		Counsellor login = counsellorService.login(counsellorEmail, counsellorPwd);
		
		if(login!=null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("cid", login.getCounsellorId());
			
		return "redirect:/dashboard";
		
		}
		
		
		m.addAttribute("emsg", "invalid credentials");
		
		return "index";
	}
	
	@GetMapping("/register")
	public String getRegister(Model m) {
		
		m.addAttribute("regObj", new Counsellor());
		
		
		return "register";
	}
	
	@PostMapping("/register")
	public String sendRegister(@ModelAttribute("regObj") Counsellor c,Model m) {
		
		
		boolean register = counsellorService.register(c);
		if(register) {
			m.addAttribute("smsg", "Account created successfully");
//			return "register";
		}
		else {
			m.addAttribute("emsg", "SomethingWent wrong");
			
		}
		
		m.addAttribute("userObj", new Counsellor());
		return "register";
	}

}
