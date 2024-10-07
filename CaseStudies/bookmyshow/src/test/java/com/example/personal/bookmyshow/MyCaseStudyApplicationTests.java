package com.example.personal.bookmyshow;

import com.example.personal.bookmyshow.controllers.UserController;
import com.example.personal.bookmyshow.dto.UserLoginRequestDto;
import com.example.personal.bookmyshow.dto.UserLoginResponseDto;
import com.example.personal.bookmyshow.dto.UserSignUpRequestDto;
import com.example.personal.bookmyshow.dto.UserSignUpResponseDto;
import com.example.personal.bookmyshow.enums.ResponseStatus;
import com.example.personal.bookmyshow.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyCaseStudyApplicationTests {
	@Autowired
	private UserController userController;

	@Test
	void contextLoads() {
	}

	@Test
	public void testSignUpUser() {
		UserSignUpRequestDto requestDto = new UserSignUpRequestDto();
		requestDto.setEmail("guptavitul@gmail.com");
		requestDto.setPassword("Vitul@123");
		requestDto.setUsername("Vitul Gupta");
		UserSignUpResponseDto user = userController.signUp(requestDto);

		System.out.println(user.getUserId());
	}

	@Test
	public void testLoginUser() {
		UserLoginRequestDto requestDto = new UserLoginRequestDto();
		requestDto.setEmail("guptavitul@gmail.com");
		requestDto.setUsername("Vitul Gupta");
		requestDto.setPassword("Vitul@123");

		UserLoginResponseDto user = userController.login(requestDto);

		if(user.getStatus() == ResponseStatus.SUCCESS) {
			System.out.println("login successfully");
		}else {
			System.out.println("invalid password");
		}
	}

}
