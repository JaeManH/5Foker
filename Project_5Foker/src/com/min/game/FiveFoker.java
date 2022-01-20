package com.min.game;

import java.util.List;
import java.util.Scanner;

import com.min.game.card.CardCase;
import com.min.game.card.CardOne;
import com.min.game.money.Batting;
import com.min.game.rule.Jokbo;

/**
 * 포커안에 있는 모든 룰이 정의 되어 있는 클래스 
 * @author JaeMan
 *
 */
public class FiveFoker {
	
	Jokbo jokbo = new Jokbo();
	CardCase make = new CardCase();
	List<CardOne> allCard= make.getCardcase();
	CardOne[] user = new CardOne[5];
	Scanner scan = new Scanner(System.in);
	Batting bet = new Batting();
	int rank = 0;
	/**
	 * 카드 덱을 초기화한 뒤
	 * 첫 카드 5장을 받고 출력해주는 메소드
	 */
	public void getCard() {
		allCard = make.getCardcase(); 
		for (int i = 0; i < user.length; i++) {
			user[i] = allCard.get(0);
			allCard.remove(0);
//			System.out.printf("\t[%d]",i);
			System.out.printf("%d.[%s]\t",i+1,user[i].toString());
		}
		System.out.println();
	}
	
	//TODO 예외처리 만들기 
	/**
	 * 원하는 카드를 1~5번까지 한장 교체 할 수 있는 메소드
	 * 5번 반복 
	 */
	public void changeCard() {
		for (int i = 0; i < user.length; i++) {
			System.out.printf("바꾸고 싶은 카드를 선택해주세요(1번~5번)\n 안바꾼다:0번 (남은기회: %d번) ",5-i);
			int c = scan.nextInt();
			if(c==0) {
				break;
			}else {
				user[c-1] = allCard.get(0);
				allCard.remove(0);
				print();
			}
		}
		endGame();
	}
	private void endGame() {
		jokbo.setmCard(user);
		rank =jokbo.checkJokbo(); 
		bet.betResult(rank);
		System.out.println("게임 종료... 남은 돈:"+bet.getSidMoney());	
	}
	/**
	 * 현재 가지고 있는 카드 5장을 출력해주는 메소드 
	 */
	public void print() {
		for (int i = 0; i<user.length;i++) {
			System.out.printf("%d.[%s]\t",i+1,user[i].toString());
		}
		System.out.println();
	}
	/**
	 *  sidMoney보다 작은 정수를 입력받아 배팅을 하는 메소드 
	 */
	public void betting()
	{
		System.out.printf("배팅금을 입력해주세요.(1000원이상) \n(남은돈:"+bet.getSidMoney()+")");
		try {
			bet.bet(scan.nextInt());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
