package asdgame.util;

import asdgame.game;

public class spdth extends Thread {
	// 속도 스레드. 게임의 속도를 결정해주는 클래스이다
	game e;

	public spdth(game e) {// game 클래스에서 spdth를 사용할 수 있도록 생성자 만들기
		this.e = e;
	}

	public void run() {
		while (true) {
			if (e.spds > 1) {// 게임 속도는 1~5까지 있으며, 기본 설정값은 5이다. spds가 1이 될 경우 빠져나간다.
				try {
					Thread.sleep(10000); //10초
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.spds--;// 30초마다 게임속도가 1씩 빨라진다. 1보다 아래로는 떨어지지 않는다.
				
			}
		}
	}
}
