package com.example.Project_01.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Project_01.Model.User_Ws;


public interface UserRepository2 extends JpaRepository<User_Ws, Long> {
	
	// 이메일 정보로 아이디 조회
	public User_Ws findByEmail(String email);
	
	// 로그인 - 이메일과 비밀번호로 조회
	public User_Ws findByEmailAndPwd(String email, String pwd);
	
}