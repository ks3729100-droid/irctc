package com.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazon.entity.AmazonEntity;
import java.util.List;


@Repository
public interface AmazonRepository extends JpaRepository<AmazonEntity, Integer> {
	
	AmazonEntity findByMobile(String mobile);

}
