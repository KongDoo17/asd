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
		// �������ڸ��� ū ���� �׸��� RUN! �������� ������� ������ �ڵ�
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