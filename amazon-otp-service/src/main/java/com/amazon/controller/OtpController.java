package com.amazon.controller;

import com.amazon.AmazonOtpServiceApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.request.OTPRequest;
import com.amazon.service.OTPService;
import com.kodewala.response.ResponseOTP;

@RestController
@RequestMapping("otp")
public class OtpController {
	
	private final AmazonOtpServiceApplication amazonOtpServiceApplication;
	@Autowired
	OTPService otpService;

	OtpController(AmazonOtpServiceApplication amazonOtpServiceApplication) {
		this.amazonOtpServiceApplication = amazonOtpServiceApplication;
	}
	
	@PostMapping("/generate")
	public String gernerateOTP(@RequestBody OTPRequest otpRequest){
		
		String name = otpRequest.getName();
		String mobile = otpRequest.getMobile();
		int otp = otpService.saveOTP(mobile, name);
		
		return"Your OTP is: " + otp;
	}
	
	  @PostMapping("/validateOTP")
	public String vailidOTP(@RequestBody ResponseOTP response)
	{
		System.out.println("Verified otp generation.....!");
		
		String mobile = response.getMobile();
		int otp = response.getOtp();
		return otpService.validateOTP(mobile, otp);
	}

}
