package asdgame.start;

import asdgame.game;

public class startgame extends Thread {
	
	game e;
	reprr reprr;
	
	public startgame(game e) {
		this.e = e;
	}
	
	public void run() {
		e.ptong = 300;
		while(true) {
			reprr = new reprr(e);
			try {
				Thread.sleep(10);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			if(e.ptong <= 0) {// ���� ü�°������� 0�� �Ǹ� �Ʒ� ���� ����
				e.clip.stop(); // bgm ����
				e.Play("bgm\\die.wav");//���  bgm ���
				
				e.spdchk= false; // �ӵ� üũ false
				// ---------------------------------������ ����
				if(e.sp.isAlive()) {
					e.sp.stop();
					
				}
				if(e.th.isAlive()) {
					e.th.interrupt();
				}
				if(e.hth.isAlive()) {
					e.hth.interrupt();
				}
				if(e.hp.isAlive()) {
					e.hp.interrupt();
				}
				if(e.hit.isAlive()) {
					e.hit.interrupt();
				}
				if(e.map.isAlive()) {
					e.map.interrupt();
				}
				if(e.pts.isAlive()) {
					e.pts.interrupt();
				}
				if(e.scr.isAlive()) {
					e.scr.interrupt();
				}
				if(e.en.isAlive()) {
					e.en.interrupt();
				}
				if(e.egg.isAlive()) {
					e.egg.interrupt();
				}
				// --------------------------------- ������ ����
				
				e.restart = true;// ����� ���� boolean �� true�� ����
				
				//--------���������
				  e.youdied();
				 
				
				if(reprr.isAlive()){
					reprr.interrupt();
				}
				reprr.start();
				//--------���������
				
				break;
				
			}
		}
	}
}
