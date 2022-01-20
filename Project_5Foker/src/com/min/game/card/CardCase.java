package com.min.game.card;

import java.util.ArrayList;
import java.util.List;

/**
 * 카드 덱 하나를 만들어 내는 클래스 
 * @author JaeMan
 *
 */
public class CardCase {
	
	private List<CardOne> cardcase;
	
	public CardCase() {
		cardcase = new ArrayList<CardOne>();
		make();
	}
/**
 * List<CardOne>을 모두 비우고 다시 새롭게 채우는 메소드
 * @return
 */
	public List<CardOne> getCardcase() {
		cardcase.clear();
		make();
		return cardcase;
	}


	private void make() {
		int cnt = 0; //종료조건
		while (true) {
			CardOne num = new CardOne();
			if(!cardcase.contains(num)) {
				cardcase.add(num);
				cnt++;
			}
			if(cnt==CardOne.SHAPE.length*CardOne.NUMBER.length) {
				break;
			}
		}
	}

}
