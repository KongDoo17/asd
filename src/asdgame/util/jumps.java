package asdgame.util;

import asdgame.game;

public class jumps extends Thread {
	game e;

	public jumps(game e) {
		// TODO Auto-generated constructor stub
		this.e = e;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 111; i > 50; i--) {//����Ű�� �������ÿ� ������ 111���� �ö� 
			e.jum(i);

			e.gongy1 = e.btn.getY();
			e.gongy2 = e.btn.getY() + 20;
			try {
				Thread.sleep(2);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch sblock
				e1.printStackTrace();
			}
			
		}
		for (int i = 50; i <= 111; i++) {//������ 111���� �ö������� 50���� ����
			e.jum(i);
			e.gongy1 = e.btn.getY();
			e.gongy2 = e.btn.getY() + 20;
			try {
				Thread.sleep(4);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		e.chk = true;
	}
}