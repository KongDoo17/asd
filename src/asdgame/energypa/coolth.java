package asdgame.energypa;

import java.awt.Color;

import javax.swing.ImageIcon;

import asdgame.game;

public class coolth extends Thread {
	game e;

	public coolth(game e) {
		this.e = e;
	}

	public void run() {
		// 쿨타임차는 이미지 표현 쓰래드

		for(int i=2; i<=16; i++){
			String str ="cool\\cool"+i+".png";
			ImageIcon coolicon = new ImageIcon(str);
			//System.out.println(str);
			e.coolbtn.setIcon(coolicon);
			try {
				Thread.sleep(625);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			e.repaint();
		}

	}

}