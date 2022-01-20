package com.min.game;

import java.util.List;
import java.util.Scanner;

import com.min.game.card.CardCase;
import com.min.game.card.CardOne;
import com.min.game.rule.Jokbo;

public class Test_Main {

	public static void main(String[] args) {

		Jokbo jokbo = new Jokbo();
		CardCase make = new CardCase();
		List<CardOne> allCard = make.getCardcase();
		CardOne card = new CardOne();
		CardOne[] user = new CardOne[5];

		int rank = 0;
		for (int i = 0; i < user.length; i++) {
			user[i] = allCard.get(0);
			allCard.remove(0);
			jokbo.setmCard(user);
		}
		rank = jokbo.checkJokbo();
		System.out.println(rank);
	}
}
