package asdgame.hp;

import java.awt.Rectangle;

import asdgame.game;

public class hpchk extends Thread {

	game e;
	

	Rectangle r1, r2;

	public hpchk(game e) {
		this.e = e;
	}

	public void run() {
		while (true) {

			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (e.bigx1 > 0 && e.bigy1 > 0 && e.gongx2 <= e.bigx1 + 3) { 
			
																		// start
				if (e.gongx2 > e.bigx1 && e.gongy2 > e.bigy1) {// 공룡과 큰장애물의 위치를 비교후 해당 조건이 맞을시 아래 문장실행

					if (e.hit.isAlive() == false) {  //스레드가 false값이면 스레드 종료
						e.hit.interrupt();
					}
					e.hit = new hiting(e); //재정의
					e.hit.start();         //시작
					e.ptong-=20*3;   //맞으면 피 -60감소
					
					

					try {
						synchronized (e.th) {
							e.th.wait(1125);//e.th를 1.125초 동안 중지
						}

						Thread.sleep(1125); //Thread 1.125초 동안 중지
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
			if (e.sx1 > 0 && e.sy1 > 0 && e.gongx2 <= e.sx1 + 3) { 
				// start
				
				if (e.gongx2 > e.sx1 && e.gongy2 > e.sy1) { // 공룡과 작은 장애물의 위치를 비교후 해당 조건이 맞을시 아래문장실행
					if (e.hit.isAlive() == false) { //스레드가 false값으면 스래드 종료
						e.hit.interrupt();
					}
					e.hit = new hiting(e); //재정의
					e.hit.start(); //시작
					e.ptong-=10*3; //맞으면 피 -30감소
					
					

					try {
						synchronized (e.th) {
							e.th.wait(1125);//e.th를 1.125동안 중지
						}

						Thread.sleep(1125);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		}
	}
}