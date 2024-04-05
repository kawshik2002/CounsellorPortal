package in.kawshik.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.kawshik.entity.Counsellor;
import in.kawshik.repo.CounsellorRepo;

@Service
public class CounsellorImp implements ICounsellorService {

	
	@Autowired
	private CounsellorRepo counRepo;
	
	
	
	@Override
	public boolean register(Counsellor c) {
		
		if(counRepo.findByCounsellorEmail(c.getCounsellorEmail())!=null) {
			return false;
		}
		
		Counsellor save = counRepo.save(c);
		if(save.getCounsellorId()!=null) {
			return true;
		}
		return false;
	}

	@Override
	public Counsellor login(String email, String pwd) {
		Counsellor c = counRepo.findByCounsellorEmailAndCounsellorPwd(email, pwd);
		if(c.getCounsellorId()!=null) {
			return c;
		}
		return null;
	}

}
