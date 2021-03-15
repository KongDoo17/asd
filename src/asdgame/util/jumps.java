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
		for (int i = 111; i > 50; i--) {//점프키를 눌렀을시에 공룡이 111까지 올라감 
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
		for (int i = 50; i <= 111; i++) {//공룡이 111까지 올라가있으면 50까지 감소
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