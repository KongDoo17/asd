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
			//큰 허들을 math.random 함수를 이용하여 랜덤한 시간마다 랜덤한 갯수를 출력
			e.bighud(50 + ((int) (Math.random() * 100)));
			try {
				Thread.sleep((int) (Math.random() * 10));
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}
		}
	}