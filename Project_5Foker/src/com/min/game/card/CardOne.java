package com.min.game.card;

/**
 * 모양과 숫자를 조합(concat)하여 카드한장을 만들어 냄  
 * @author JaeMan
 *
 */
public class CardOne {
	
	private String one;
	
	public static final String[] SHAPE = {"♣","♥","◆","♠"};
	public static final String[] NUMBER = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	public CardOne() {
		int a = (int)(Math.random()*SHAPE.length);
		int b = (int)(Math.random()*NUMBER.length);
		one = SHAPE[a]+" "+NUMBER[b];
	}

	@Override
	public int hashCode() {
		return one.hashCode()+137;
	}

	@Override
	public boolean equals(Object obj) {

		boolean isc = false;
		CardOne other = (CardOne)obj;
		if(one.equals(other.getOne())) {
			isc = true;
		}
		return isc;
	}

	public String getOne() {
		return one;
	}

	@Override
	public String toString() {
		return one ;
	}
	
	
	
	
}
