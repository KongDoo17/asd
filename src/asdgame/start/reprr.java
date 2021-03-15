package asdgame.start;

import java.awt.Color;

import javax.swing.ImageIcon;

import asdgame.game;

public class reprr extends Thread {
	game e;
	boolean chk = true;

	public reprr(game e) {
		this.e = e;
	}

	public void run() {
		
	
		
		try {
			Thread.sleep(500); //	사망시 0.5초 대기 후 밑 while 문 진입 무한루프
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (true) {

			e.prr.setVisible(false);//사망시 "PRESS 'R' RESTART 지우기
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.prr.setVisible(true); //사망시 "PRESS 'R' RESTART 표시

			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

}