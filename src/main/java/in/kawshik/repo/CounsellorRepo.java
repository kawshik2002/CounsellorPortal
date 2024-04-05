package in.kawshik.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.kawshik.entity.Counsellor;

public interface CounsellorRepo extends JpaRepository<Counsellor, Integer> {
	
	public Counsellor findByCounsellorEmail(String email);
	
	public Counsellor findByCounsellorEmailAndCounsellorPwd(String email,String pwd);

}
