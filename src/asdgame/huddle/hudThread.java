package asdgame.huddle;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import asdgame.game;

public class hudThread extends Thread {
	game e;
	int ran;
	public boolean isfull = false;
	//ImageIcon img = new ImageIcon("fire.png");

	public hudThread(game e) {
		this.e = e;
	}

	public void run() {
		// ran�� �������ڸ� ����ְ�, ���ڰ� 500���� ū ��쿡�� ū ��ֹ�
		// ���� ��쿡�� ���� ��ֹ��� ����
		while (true) {
			ran = (int) (Math.random() * 1000);
			// System.out.println(ran);
			if (ran >= 500) {
				(new bigHuddle(e)).start();
			} else if (ran < 500) {
				(new Huddle(e)).start();
			}
			// ran���� ���� ���ǵ尡 �����ǰ�, �� ���ǵ常ŭ �����带 Ȱ��ȭ�Ѵ�.
			int spd = 500 + ran;
			try {
				Thread.sleep(spd);

			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// �������� ���� ��, ����� 4�ʵ��� ���� �� �ϰ� �ϴ� �ڵ�
			if (isfull) {

				try {
	
					e.repaint();
					e.revalidate();
					this.sleep(4000);
					isfull = false;
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
	}
}

class Full extends Thread {
	game e;
	hudThread hdt = new hudThread(e);
	boolean isfull;

	public Full(game e) {
		this.e = e;
	}

	public void run() {

	}
}