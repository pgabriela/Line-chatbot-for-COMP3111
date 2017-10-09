package com.example.bot.spring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dictionary {

	//@Id
	//private int id;
	private String keyword;
	private String response;

	public Dictionary(String k, String r){
		keyword = k;
		response = r;
	}

	public void setKeyword(String k){
		keyword = k;
	}
	public void setResponse(String r){
		response= r;
	}
	//public void setId(int i){
	//	this.id = i;
	//}
	public String getKeyword(){
		return keyword;
	}
	public String getResponse(){
		return response;
	}
	//public int getId(){
	//	return id;
	//}

}
