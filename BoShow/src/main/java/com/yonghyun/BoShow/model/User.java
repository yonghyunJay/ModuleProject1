package com.yonghyun.BoShow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String email;
	private String pwd;
	private String name;
	private String keyword1;
	private String keyword2;
	private String keyword3;
	private String keyword4;
	private String keyword5;
	private boolean typeGoogleNewsEn;
	private boolean typeYoutubeEn;
	private boolean typeNaverNewsEn;
	private boolean typeNaverBlogEn;
	private boolean typeKakaoNewsEn;
	private boolean typeKakaoBlogEn;
	private boolean typeKakaoVideoEn;
}
