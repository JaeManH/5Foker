package com.min.game.rule;

import com.min.game.card.CardOne;
import java.util.Arrays;

/**
 * user의 카드를 입력받아 족보를 계산하고 족보의 등급을 int형으로 반환해주는 클래스
 * int rank 가 높을수록 높은 족보다.
 * @author JaeMan
 *
 */
public class Jokbo {
	private int[] mCardNumber;
	private String[] mCardPattern;
	private CardOne[] mCard;

	public int[] getmCardNumber() {
		return mCardNumber;
	}
	public String[] getmCardPattern() {
		return mCardPattern;
	}
	public Jokbo() {
		this(5);
	}

	public Jokbo(int i) {
		mCardNumber = new int[5];
		mCardPattern = new String[5];
	}

	/**
	 * 족보계산을 위해 user가 가진 CardOne[]을 받아오는 메소드
	 * @param mCard
	 */
	public void setmCard(CardOne[] mCard) {
		this.mCard = mCard;
	}

	/**
	 * setmCard메소드로 족보를 검사할 카드 세팅 후  
	 * 족보를 모두 검사하는 메소드
	 * @return rank 족보의 랭킹을 int형으로 나타냄 숫자가 높을수록 높은 족보
	 */
	public int checkJokbo() {
		cardSorting(mCard);
		int rank = 0;
		int straightAndFlush = checkStraightAndFlush();
		int pair = checkPair();
		rank = (straightAndFlush > pair) ? straightAndFlush : pair;
		if(rank==0)
			System.out.println("TOP...");
		return rank;
	}

	/**
	 * 카드를 정렬하는 메소드
	 * String으로 받은 숫자는 Integer.valueOf메소드를 통해 숫자로 바꾸고
	 * 알파벳으로 된 J,Q,K,A는 switch-case를 통해 숫자로 변환한다.
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
//		for (int i : mCardNumber) {
//				System.out.printf("%d ", i);
//		}
//		System.out.println();
	}

	/**
	 * 멤버필드에 있는 mCardNumber과 mCardPattern로 스트레이트와 플러시류 족보를 검사하는 메소드
	 */
	private int checkStraightAndFlush() {

		
		int flush = 0;
		int straight = 0;

		for (int i = 0; i < mCardNumber.length - 1; i++) {
			if (mCardNumber[i] + 1 == mCardNumber[i + 1]) {
				straight++;
			}
			if (mCardPattern[i] == mCardPattern[i + 1]) {
				flush++;
			}
		}

		if (straight == 4 && flush == 4 && mCardNumber[4] == 14) {
			System.out.println("로얄스트레이트 플러시 입니다!");
			return 12;
		} else if (straight == 3 && mCardNumber[3] == 5 && mCardNumber[4] == 14 && flush == 4) {
			System.out.println("백 스트레이트 플러시 입니다!");
			return 11;
		} else if (straight == 4 && flush == 4) {
			System.out.println("스트레이트 플러시 입니다!");
			return 10;
		} else if (straight == 4 && mCardNumber[4] == 14) {
			System.out.println("마운틴 입니다!");
			return 6;
		} else if (straight == 3 && mCardNumber[3] == 5 && mCardNumber[4] == 14) {
			System.out.println("백 스트레이트 입니다!");
			return 5;
		} else if (straight == 4) {
			System.out.println("스트레이트 입니다!");
			return 4;
		} else if (flush == 4) {
			System.out.println("플러쉬 입니다!");
			return 7;
		}
		return 0;
	}
/**
 * 페어인지 아닌지 검사하는 메소드
 * @return
 */
	private int checkPair() {
		int grade = 0;
		switch (cardChk()) {
		case 2:

			System.out.println("원페어 입니다!");
			return 1;

		case 4:
			System.out.println("투페어 입니다!");
			return 2;
		case 6:

			System.out.println("트리플 입니다!");
			return 3;
		case 8:

			System.out.println("풀하우스 입니다!");
			return 8;
		case 12:

			System.out.println("포카드 입니다!");
			return 9;
		}
		return grade;

	}

	private int cardChk() {
		int cnt = 0;
		for (int i = 0; i < mCardNumber.length; i++) {
			for (int j = 0; j < mCardNumber.length; j++) {
				if (i != j && mCardNumber[i] == mCardNumber[j]) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
