package com.yonghyun.BoShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yonghyun.BoShow.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByEmailAndPwd(String email, String pwd);
}