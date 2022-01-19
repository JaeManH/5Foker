package com.min.game;

import java.util.Arrays;
import java.util.List;

import com.min.game.card.CardCase;
import com.min.game.card.CardOne;
import com.min.game.rule.Jokbo;

public class Test_Main {

	public static void main(String[] args) {
		int cnt=0;
		int rank = 0;
		while(true) {
			Jokbo j = new Jokbo();
//			j.drawCard();
			CardCase make = new CardCase();
			CardOne[] user1 = new CardOne[5]; 
			
//			System.out.println(make.getCardcase());
			List<CardOne> allCard = make.getCardcase();
			
			for (int i = 0; i < user1.length; i++) {
				user1[i] = allCard.get(0);
				allCard.remove(0);
			}
			System.out.println(Arrays.toString(user1));
			j.setmCard(user1);
			rank = j.checkJokbo();
			if(cnt==100) break;
			cnt++;
		}
//		System.out.println(allCard.size());		
//		String card0 = user1[0].toString();		
//		String[] cardSplit = card0.split("");
//		System.out.println(cardSplit[0]);
		
	}
}
