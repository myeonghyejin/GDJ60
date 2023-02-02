package com.mhj.s1.army;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Soldier {
	
//	@Autowired
//	private Gun gun;
	
	@Autowired
	private Gun shotGun;
	@Autowired
	private Gun rifle;
	
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

//	public Gun getGun() {
//		return gun;
//	}
//
//	public void setGun(Gun gun) {
//		this.gun = gun;
//	}
//
//	public void useGun() {
//		this.gun.trigger();
//	}
	
}
