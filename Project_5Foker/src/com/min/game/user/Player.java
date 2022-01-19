package com.min.game.user;

public class Player {

	/**
	 * 포커 인원 전체를 가르키는 클래스
	 */
	private User[] user ;
	public Player() {
		this(5);
	}
	public Player(int i) {
		user = new User[i];
	}
	
}
