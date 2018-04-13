package com.patterns.bookstore.purchasingPrototype;



public class CloneFactory {

	public UserClone getClone(UserClone userClone) {
		// TODO Auto-generated constructor stub
		
		return  userClone.makeCopy();
	}

}
