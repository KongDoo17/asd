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
		e.btn.setIcon(btnicon1);//e.btn��ư�� �̹��� ���̱�
		e.btn.setBounds(e.a,e.b,30,20);//a�� b�� enbtn ��ư�� ��ġ ���� ���ٶ��� x��, y���� btn ��ư�� ��ġ ���� ���ٶ��� x��, y��

	}

}