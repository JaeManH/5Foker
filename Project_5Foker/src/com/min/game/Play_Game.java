package com.min.game;

import java.util.Scanner;


/**
 * 게임이 실행되는 메인 클래스
 * @author JaeMan
 *
 */
public class Play_Game {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		FiveFoker foker = new FiveFoker();
		
		String answer = "Y";
		do {
			foker.getCard();
			foker.betting();
			foker.changeCard();
			System.out.println("한번 더 하시겠습니까? (Retry \"Y\"/press any key to exit)");
			answer = scan.next();
		}while(answer.trim().toUpperCase().equals("Y"));
	}
}
