package asdgame.hp;


import java.awt.Color;

import javax.swing.ImageIcon;

import asdgame.game;

public class hiting extends Thread {
	game e;

	public hiting(game e) {
		this.e = e;
	}

	ImageIcon btnicon1 = new ImageIcon("img//dainobback1.png"); // 화난 공룡 (진함)
	ImageIcon btnicon2 = new ImageIcon("img//dainobback2.png");// 화난 공룡 (연함)
	ImageIcon btnicon3 = new ImageIcon("img//daino.png"); // 평상시 공룡

	ImageIcon eggicon1 = new ImageIcon("jordi\\jordibback1.png");// 죠르디 평상시 상태
	ImageIcon eggicon2 = new ImageIcon("jordi\\jordibback2.png");// 죠르디 화남 (이펙트가 큼)
	ImageIcon eggicon3 = new ImageIcon("jordi\\jordibback3.png");// 죠르디 화남 (이펙트가 작음)
	ImageIcon eggicon4 = new ImageIcon("jordi\\jordi.png"); // 죠르디 평상시 상태와 동일

	public void run() {
		// 공룡모양으로 게임을 시작할 시, 장애물에 부딪히게되면 이펙트가 변하는 코드
		// 스레드 시간을 이용하여 사진이 깜빡거리는 것 처럼 구현
		if (e.eggstartchk == false) {
			for (int i = 0; i < 2; i++) {
				e.btn.setIcon(btnicon1);

				try {
					Thread.sleep(375);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					
				}
				e.btn.setIcon(btnicon2);
				try {
					Thread.sleep(375);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					
				}
				e.btn.setIcon(btnicon1);
			}
			try {
				Thread.sleep(375);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				
			}
			e.btn.setIcon(btnicon3);
		}
		// 치트키를 사용하였을 경우 죠르디로 새롭게 적용되는 코드
				// 스레드를 이용하여 사진이 깜빡거리는 것 처럼 구현
		else if (e.eggstartchk == true) {
			for (int i = 0; i < 2; i++) {
				e.btn.setIcon(eggicon1);

				try {
					Thread.sleep(375);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
				
				}
				e.btn.setIcon(eggicon2);
				try {
					Thread.sleep(375);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
				
				}
				e.btn.setIcon(eggicon3);
			}
			try {
				Thread.sleep(375);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
			
			}
			e.btn.setIcon(eggicon4);
		}
	}

}