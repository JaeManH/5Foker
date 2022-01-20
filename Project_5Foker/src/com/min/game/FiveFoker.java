package com.min.game;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.min.game.card.CardCase;
import com.min.game.card.CardOne;
import com.min.game.rule.Jokbo;

public class FiveFoker {
	Jokbo jokbo = new Jokbo();
	CardCase make = new CardCase();
	List<CardOne> allCard = make.getCardcase();
	CardOne[] user = new CardOne[5];
	int rank = 0;
	Scanner scan = new Scanner(System.in);
	public FiveFoker() {

		for (int i = 0; i < user.length; i++) {
			user[i] = allCard.get(0);
			allCard.remove(0);
		}
		System.out.println(Arrays.toString(user));
	}
	
	//TODO 예외처리 만들기 
	public void changeCard() {
		int c = scan.nextInt();
		if(c==0) {
			endGame();
		}else {
			user[c-1] = allCard.get(0);
			allCard.remove(0);
		}
	}
	private void endGame() {
		jokbo.setmCard(user);
		rank =jokbo.checkJokbo(); 
	}
}
