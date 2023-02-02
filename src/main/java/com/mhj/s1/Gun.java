package com.mhj.s1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class Gun {
	
	private Bullet bullet;
	
	private void gun() {
		// TODO Auto-generated method stub

	}
	
	@Autowired
	public Gun(Bullet bullet) {
		this.bullet = bullet;
	}

	public void trigger() {
		this.bullet.sound();
	}
	
}
