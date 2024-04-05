package in.kawshik.service;

import in.kawshik.entity.Counsellor;

public interface ICounsellorService {
	
   

	public boolean register(Counsellor c);
	
	
	public Counsellor login(String email,String pwd);
	
	
	
	
}
