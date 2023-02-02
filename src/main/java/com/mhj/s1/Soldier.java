package com.mhj.s1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class Soldier {
	
	private Gun gun;
	
	private String name;
	private int age;
	
	@Autowired
	public void setGun(Gun gun) {
		this.gun = gun;
	}

	public void useGun() {
		this.gun.trigger();
	}
	
}
