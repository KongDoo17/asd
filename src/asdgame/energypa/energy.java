package asdgame.energypa;

import java.awt.Color;

import javax.swing.ImageIcon;

import asdgame.game;

public class energy extends Thread {
	game e;

	public energy(game e) {
		this.e = e;
	}

	ImageIcon lasericon1 = new ImageIcon("jordi\\jordilaser.png");//������ ������ �̹�������
	ImageIcon lasericon2 = new ImageIcon("jordi\\jordi.png");// ������ ĳ���� �̹�������
	
	ImageIcon enicon1 = new ImageIcon("energy\\en1.png");
	ImageIcon enicon2 = new ImageIcon("energy\\en2.png");
	ImageIcon enicon3 = new ImageIcon("energy\\en3.png");
	ImageIcon enicon4 = new ImageIcon("energy\\en4.png");// en1~en4 ������ ������ ������ �̹�������
	ImageIcon enicon5 = new ImageIcon("energy\\en5.png");// en5 ������ �߻� �̹�������
	public void run() {

		if (e.eggstartchk == false) {// �̽��� ���װ� �ߵ����� �ʾ��� ��, �Ϲ� ���� ������ ��
			for (int i = 0; i < 3; i++) {
				
				//------------------------������ ������ �̹������� ����
				e.enbtn.setIcon(enicon1);

				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block

				}
				e.enbtn.setIcon(enicon2);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block

				}
				e.enbtn.setIcon(enicon3);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block

				}
				e.enbtn.setIcon(enicon4);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block

				}
				e.enbtn.setIcon(enicon1);
				//------------------------������ ������ �̹������� ����
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block

			} 
			e.enchk = false; // ������ �߻� üũ�� false
			e.enbtn.setBounds(e.a + 20, e.b, 300, 10); // ������ �߻� ��ư ��ġ����
			e.enbtn.setIcon(enicon5);  // ������ �߻� ��ư �̹��� ����
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block

			}
			e.enchk = true; // ������ �߻� üũ�� true

			e.enbtn.setBounds(e.a + 20, e.b, 10, 10);
			e.enbtn.setIcon(null); // ������ �߻� ��ư �̹��� ����
			e.ensleep = false; // ������ �߻� ���°� false, ���� �ð������� �߻����� ���ϵ��� ��
		}
		else if (e.eggstartchk == true) {//�̽��� ���װ� �ߵ����� ��, �Ҹ��� ������ ��
			e.btn.setIcon(lasericon1);  // �Ҹ��� ������ �߻��ϴ� ������� ĳ���� �̹��� ����
			for (int i = 0; i < 3; i++) {
				//------------------------������ ������ �̹������� ����
				e.enbtn.setIcon(enicon1);

				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block

				}
				e.enbtn.setIcon(enicon2);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block

				}
				e.enbtn.setIcon(enicon3);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block

				}
				e.enbtn.setIcon(enicon4);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block

				}
				e.enbtn.setIcon(enicon1);
				//------------------------������ ������ �̹������� ����
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block

			}
			e.enchk = false;// ������ �߻� üũ�� false
			e.enbtn.setBounds(e.a + 32, e.b+5, 300, 10);// ������ �߻� ��ư ��ġ����
			e.enbtn.setIcon(enicon5);// ������ �߻� ��ư �̹��� ����
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block

			}
			e.enchk = true;// ������ �߻� üũ�� true

			e.enbtn.setBounds(e.a + 32, e.b+5, 10, 10);
			e.enbtn.setIcon(null); // ������ �߻� ��ư �̹��� ����
			e.btn.setIcon(lasericon2); // ���� �Ҹ��� ĳ���ͷ� �̹��� ����
			e.ensleep = false; // ������ �߻� ���°� false, ���� �ð������� �߻����� ���ϵ��� ��
		}
	}

}