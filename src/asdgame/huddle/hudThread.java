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
		// ran에 랜덤숫자를 집어넣고, 숫자가 500보다 큰 경우에는 큰 장애물
		// 작을 경우에는 작은 장애물을 생성
		while (true) {
			ran = (int) (Math.random() * 1000);
			// System.out.println(ran);
			if (ran >= 500) {
				(new bigHuddle(e)).start();
			} else if (ran < 500) {
				(new Huddle(e)).start();
			}
			// ran값에 따라서 스피드가 결정되고, 그 스피드만큼 스레드를 활성화한다.
			int spd = 500 + ran;
			try {
				Thread.sleep(spd);

			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// 레이져를 쐈을 때, 허들을 4초동안 생성 못 하게 하는 코드
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