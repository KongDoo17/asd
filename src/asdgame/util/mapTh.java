package asdgame.util;

import asdgame.game;

public class mapTh extends Thread {
	game e;

	public mapTh(game e) { // game 클래스에서 mapTh를 사용할 수 있도록 생성자 만들기
		this.e = e;
	}

	public void run() {
		while (true) {
			if (e.mapx > -600) {//mapx는 map 이미지의 x좌표 
				e.mapx--;
				e.pnl.setBounds(e.mapx, 128, 900, 200);
				//e.pnl2.setBounds(e.mapx+300, 128, 900, 200);
				try {
					Thread.sleep(e.spds); //spds는 맵이 지나가는 속도. 1~5까지 있는데 낮은 값일수록 속도가 빠르고, 높은 값일수록 속도가 느리다.
                    //일정 시간마다 값이 줄어들며, 1이하로는 내려가지 않는다.
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else{
				e.mapx=0;
			} // mapx가 -600 이하로 내려갔을 경우 다시 0으로 만들어서 맵이 무한으로 지나갈 수 있도록 한다.
		}
	}

}

