package asdgame.hp;


import java.awt.Color;

import javax.swing.ImageIcon;

import asdgame.game;

public class hiting extends Thread {
	game e;

	public hiting(game e) {
		this.e = e;
	}

	ImageIcon btnicon1 = new ImageIcon("img//dainobback1.png"); // ȭ�� ���� (����)
	ImageIcon btnicon2 = new ImageIcon("img//dainobback2.png");// ȭ�� ���� (����)
	ImageIcon btnicon3 = new ImageIcon("img//daino.png"); // ���� ����

	ImageIcon eggicon1 = new ImageIcon("jordi\\jordibback1.png");// �Ҹ��� ���� ����
	ImageIcon eggicon2 = new ImageIcon("jordi\\jordibback2.png");// �Ҹ��� ȭ�� (����Ʈ�� ŭ)
	ImageIcon eggicon3 = new ImageIcon("jordi\\jordibback3.png");// �Ҹ��� ȭ�� (����Ʈ�� ����)
	ImageIcon eggicon4 = new ImageIcon("jordi\\jordi.png"); // �Ҹ��� ���� ���¿� ����

	public void run() {
		// ���������� ������ ������ ��, ��ֹ��� �ε����ԵǸ� ����Ʈ�� ���ϴ� �ڵ�
		// ������ �ð��� �̿��Ͽ� ������ �����Ÿ��� �� ó�� ����
		if (e.eggstartchk == false) {
			for (int i = 0; i < 2; i++) {
				e.btn.setIcon(btnicon1);

				try {
					Thread.sleep(375);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					
				}
				e.btn.setIcon(btnicon2);
				try {
					Thread.sleep(375);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					
				}
				e.btn.setIcon(btnicon1);
			}
			try {
				Thread.sleep(375);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				
			}
			e.btn.setIcon(btnicon3);
		}
		// ġƮŰ�� ����Ͽ��� ��� �Ҹ���� ���Ӱ� ����Ǵ� �ڵ�
				// �����带 �̿��Ͽ� ������ �����Ÿ��� �� ó�� ����
		else if (e.eggstartchk == true) {
			for (int i = 0; i < 2; i++) {
				e.btn.setIcon(eggicon1);

				try {
					Thread.sleep(375);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
				
				}
				e.btn.setIcon(eggicon2);
				try {
					Thread.sleep(375);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
				
				}
				e.btn.setIcon(eggicon3);
			}
			try {
				Thread.sleep(375);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
			
			}
			e.btn.setIcon(eggicon4);
		}
	}

}