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
			Thread.sleep(700);// "press any key" 0.7�� ��ٷȴ� ���� �� �� while ���ѷ���
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while(chk){
			
			if(e.pakchk==false){
				e.pakf();//���ӽ��� �������� "press any key"�� �����Ѵ�.
			}
			else if(e.pakchk==true){
				e.pakt();// ������ ������ "press any key"�� �����Ѵ�. ���ѹݺ�
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