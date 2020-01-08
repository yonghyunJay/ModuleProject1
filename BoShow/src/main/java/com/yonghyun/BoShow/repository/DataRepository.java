package com.yonghyun.BoShow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yonghyun.BoShow.model.Data;
import com.yonghyun.BoShow.model.User;

public interface DataRepository extends JpaRepository<Data, Long>{
	public List<Data> findAllByUser(User user);
}
