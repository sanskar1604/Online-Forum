package com.dxc.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dxc.forum.entity.Certification;

public interface CertificationRepo extends JpaRepository<Certification, Long>{
	
	@Query("SELECT COUNT(*) FROM Certification WHERE status = 'Pass'")
	public Long totalExamStatusPass();
	
	@Query("SELECT COUNT(*) FROM Certification WHERE status = 'Scheduled'")
	public Long totalExamStatusScheduled();
	
	@Query("SELECT COUNT(*) FROM Certification WHERE status = 'Expired' OR status = 'Fail'")
	public Long totalExamStatusExpiredAndFail();
	
	@Query("SELECT COUNT(*) from Certification WHERE status = 'Expired' OR status = 'Pass' OR status = 'Fail' OR status = 'Scheduled'")
	public Long totalVoucherIssued();

}
