package asdgame.huddle;

import asdgame.game;

public class bigHuddle extends Thread {
		game e;

		public bigHuddle(game e) {
			// TODO Auto-generated constructor stub
			this.e = e;
		}

		@Override
		public void run() {
			//ū ����� math.random �Լ��� �̿��Ͽ� ������ �ð����� ������ ������ ���
			e.bighud(50 + ((int) (Math.random() * 100)));
			try {
				Thread.sleep((int) (Math.random() * 10));
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}
		}
	}