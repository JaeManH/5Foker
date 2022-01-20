package com.min.game.money;

public class Batting {

	private int sidMoney = 10000;
	private int betMoney;
	
	
	public int getSidMoney() {
		return sidMoney;
	}
	public void bet(int batMoney) {
		this.betMoney = batMoney;
	}
	/**
	 * 
	 * @param rank 족보를 int값으로 표현 숫자가 높을수록 높은족보
	 * @return 배율에 따른 베팅금과 시드머니를 더한 lastMoney
	 */
	public void betResult(int rank) {
		sidMoney = sidMoney - betMoney;
		int lastMoney = 0;
		switch (rank) {
		case 0:
			lastMoney = sidMoney+(int)(0.4*betMoney);
			break;
		case 1:
			lastMoney = sidMoney+(int)(0.6*betMoney);
			break;
		case 2:
			lastMoney = sidMoney+(int)(0.7*betMoney);
			break;
		case 3:
			lastMoney = sidMoney+(int)(1.1*betMoney);
			break;
		case 4:
			lastMoney = sidMoney+(int)(1.3*betMoney);
			break;
		case 5:
			lastMoney = sidMoney+(int)(1.5*betMoney);
			break;
		case 6:
			lastMoney = sidMoney+(int)(1.7*betMoney);
			break;
		case 7:
			lastMoney = sidMoney+(int)(2.0*betMoney);
			break;
		case 8:
			lastMoney = sidMoney+(int)(2.5*betMoney);
			break;
		case 9:
			lastMoney = sidMoney+(int)(3.0*betMoney);
			break;
		case 10:
			lastMoney = sidMoney+(int)(10.0*betMoney);
			break;
		case 11:
			lastMoney = sidMoney+(int)(50.0*betMoney);
			break;
		case 12:
			lastMoney = sidMoney+(int)(100.0*betMoney);
			break;
		}
		sidMoney =  lastMoney;
	}

}
