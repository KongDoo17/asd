package asdgame.start;

import java.awt.Color;

import javax.swing.ImageIcon;

import asdgame.game;

public class startth extends Thread {
	game e;

	public startth(game e) {
		this.e = e;
	}

	public void run() {
		// 시작하자마자 큰 공룡 그림과 RUN! 아이콘이 밝아지게 나오는 코드
		for(int i=0; i<255; i++){
			e.tu=i;
			e.repaint();
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}