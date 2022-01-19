package com.min.game.rule;

import com.min.game.card.CardOne;
import java.util.Arrays;

public class Jokbo {
	private int[] mCardNumber;
	private String[] mCardPattern;
	private CardOne[] mCard;
	private final static int EMPTY_CARD = 100;

	public Jokbo() {
		mCardNumber = new int[5];
		Arrays.fill(mCardNumber, EMPTY_CARD);
		mCardPattern = new String[5];
	}

	public void setmCard(CardOne[] mCard) {
		this.mCard = mCard;
	}

	/**
	 * setmCard로 세팅 후 카드 족보를 모두 검사하는 메소드 
	 * @return
	 */
	public int checkJokbo() {
		cardSorting(mCard);
		int rank = 0;
		int straightAndFlush = checkStraightAndFlush();
		int pair = checkPair();
		rank = (straightAndFlush > pair) ? straightAndFlush : pair;

		return rank;
	}

	/**
	 * 카드를 정렬하는 메소드
	 * 
	 * @param card 내가 들고있는 카드
	 */
	private void cardSorting(CardOne[] card) {
		for (int i = 0; i < mCardPattern.length; i++) {
			String tmp = card[i].getOne();
			String[] split = tmp.split(" ");
			if (split[1].equals("J")) {
				mCardNumber[i] = 11;
			} else if (split[1].equals("Q")) {
				mCardNumber[i] = 12;
			} else if (split[1].equals("K")) {
				mCardNumber[i] = 13;
			} else if (split[1].equals("A")) {
				mCardNumber[i] = 14;
			} else {
				mCardNumber[i] = Integer.valueOf(split[1]);
			}

			mCardPattern[i] = split[0].toString();
		}
		Arrays.sort(mCardNumber);
		for (int i : mCardNumber) {
			System.out.printf("%d ", i);
		}
		System.out.println();
	}

	/**
	 * 멤버필드에 있는 mCardNumber과 mCardPattern로 스트레이트와 플러시류 족보를 검사하는 메소드
	 */
	private int checkStraightAndFlush() {

		CardOne highCard;
		int flush = 0;
		int straight = 0;

		for (int i = 0; i < mCardNumber.length - 1; i++) {
			if (mCardNumber[i] + 1 == mCardNumber[i + 1]) {
				straight++;
				highCard = mCard[i + 1];
			}
			if (mCardPattern[i] == mCardPattern[i + 1]) {
				flush++;
			}
		}

		if (straight == 4 && flush == 4 && mCardNumber[4] == 14) {
			System.out.println("로얄스트레이트 플러시 입니다");
			return 12;
		} else if (straight == 3 && mCardNumber[3] == 5 && mCardNumber[4] == 14 && flush == 4) {
			System.out.println("백 스트레이트 플러시 입니다");
			return 11;
		} else if (straight == 4 && flush == 4) {
			System.out.println("스트레이트 플러시입니다");
			return 10;
		} else if (straight == 4 && mCardNumber[4] == 14) {
			System.out.println("마운틴 입니다");
			return 6;
		} else if (straight == 3 && mCardNumber[3] == 5 && mCardNumber[4] == 14) {
			System.out.println("백 스트레이트 입니다");
			return 5;
		} else if (straight == 4) {
			System.out.println("스트레이트 입니다");
			return 4;
		} else if (flush == 4) {
			System.out.println("플러쉬 입니다");
			return 7;
		}
		return 0;
	}

	private int checkPair() {
		  int grade = 0;
	      switch (cardChk()) {
	      case 2:
	         grade = 2;
	         System.out.println("원페어");
	         break;

	      case 4:
	         grade = 4;
	         System.out.println("투페어");
	         break;
	      case 6:
	         grade = 6;
	         System.out.println("트리플");
	         break;
	      case 8:
	         grade = 8;
	         System.out.println("풀하우스");
	         break;
	      case 12:
	         grade = 12;
	         System.out.println("포카드");
	         break;
	      }
	      return grade;

	}
	public int cardChk() {
	      int cnt = 0;
	      for (int i = 0; i < mCardNumber.length; i++) {
	         for (int j = 0; j < mCardNumber.length; j++) {
	            if(i!=j && mCardNumber[i]==mCardNumber[j]) {
	               cnt++;
	            }
	         }
	      }
	      return cnt;
	   }

}
