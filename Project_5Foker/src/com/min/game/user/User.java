package com.min.game.user;

import com.min.game.card.CardCase;
import com.min.game.card.CardOne;

/**
 * 게임플레이어 한명을 가진 클래스 
 * 게임 플레이어가 가지고 있어야 하는 카드와 기능들을 모아 놓은 클래스
 * @author JaeMan
 *
 */
public class User {

	private int mMoney = 0;
	private CardOne[] mCard;
	public void getCard(CardCase cc,int n) {
		
	}
	public void setmMoney(int mMoney) {
		this.mMoney = mMoney;
	}
	public void setmCard(CardOne[] mCard) {
		this.mCard = mCard;
	}
	
}
