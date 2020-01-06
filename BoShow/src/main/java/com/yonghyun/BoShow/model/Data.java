package com.yonghyun.BoShow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
@lombok.Data
public class Data {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String thumb;
	private String desc;
	private String link;
	private String src;
	
	@ManyToOne
	private User user;
}
