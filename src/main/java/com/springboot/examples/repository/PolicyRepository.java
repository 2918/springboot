package com.springboot.examples.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.examples.model.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer>{
	
	List<Policy> findTop10ByPremium(String premium);
	
	@Query("select p from Policy p where p.claims IS EMPTY")
	public List<Policy> findPolicyWithClaims();
	
	@Query("select p from Policy p where p.nextPremiumDate <= :date" )
	public List<Policy> findExpiredPolicy(@Param("date") Date date);
}
