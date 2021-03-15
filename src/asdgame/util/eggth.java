package asdgame.util;

import java.awt.Color;

import javax.swing.ImageIcon;

import asdgame.game;

public class eggth extends Thread {
	game e;

	public eggth(game e) {
		this.e = e;
	}

	ImageIcon btnicon1 = new ImageIcon("jordi\\jordi.png");

	public void run() {
		e.btn.setIcon(btnicon1);//e.btn버튼에 이미지 붙이기
		e.btn.setBounds(e.a,e.b,30,20);//a와 b는 enbtn 버튼의 위치 설정 해줄때의 x값, y값과 btn 버튼의 위치 설정 해줄때의 x값, y값

	}

}