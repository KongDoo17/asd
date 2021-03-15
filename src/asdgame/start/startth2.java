package asdgame.start;

import java.awt.Color;

import javax.swing.ImageIcon;

import asdgame.game;

public class startth2 extends Thread {
	game e;
	public boolean chk=true;
	public startth2(game e) {
		this.e = e;
	}

	public void run() {
		try {
			Thread.sleep(700);// "press any key" 0.7초 기다렸다 실행 후 밑 while 무한루프
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while(chk){
			
			if(e.pakchk==false){
				e.pakf();//게임실행 시켰을때 "press any key"를 생성한다.
			}
			else if(e.pakchk==true){
				e.pakt();// 위에서 제거한 "press any key"를 제거한다. 무한반복
			}
			
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

}