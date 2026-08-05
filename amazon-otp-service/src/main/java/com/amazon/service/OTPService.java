package com.amazon.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.entity.AmazonEntity;
import com.amazon.repository.AmazonRepository;

@Service
public class OTPService {
	
	@Autowired
	AmazonRepository otpRepository;
	
	
	public int saveOTP(String mobile, String name)
	{
		AmazonEntity amazonRepo = new AmazonEntity();
		
		amazonRepo.setOtp(createOTP());
		amazonRepo.setStatus("Active");
		amazonRepo.setName(name);
		amazonRepo.setMobile(mobile);
		AmazonEntity response = otpRepository.save(amazonRepo);
		
		if(response.getId() > 0)
		{
			System.out.println("ptp saved successfully...!");
		}
		else {
			
			System.out.println("unable to save otp");
		}
		
		return response.getOtp();
	}
	
	public int createOTP()
	{
		Random random = new Random();

        int otp = 100000 + random.nextInt(900000);
        System.out.println("Generated otp is: " + otp);
        return otp;
	}
	
	public String validateOTP(String mobile, int otp)
	{
		AmazonEntity entity = otpRepository.findByMobile(mobile);
		
		if(entity == null)
		{
			  return "Mobile number not found.";
		}
		
		if(entity.getOtp()==otp)
		{
			entity.setStatus("Verified");
			otpRepository.save(entity);
			
			return "OTP Verified.....!";
		}
		else {
			return "Invailid OTP";
		}
	}

}
