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
			Thread.sleep(500); //	����� 0.5�� ��� �� �� while �� ���� ���ѷ���
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (true) {

			e.prr.setVisible(false);//����� "PRESS 'R' RESTART �����
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.prr.setVisible(true); //����� "PRESS 'R' RESTART ǥ��

			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

}