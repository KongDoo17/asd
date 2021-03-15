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
			if(e.ptong <= 0) {// 위의 체력게이지가 0이 되면 아래 문구 실행
				e.clip.stop(); // bgm 종료
				e.Play("bgm\\die.wav");//사망  bgm 재생
				
				e.spdchk= false; // 속도 체크 false
				// ---------------------------------스레드 종료
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
				// --------------------------------- 스레드 종료
				
				e.restart = true;// 재시작 가능 boolean 값 true로 변경
				
				//--------사망페이지
				  e.youdied();
				 
				
				if(reprr.isAlive()){
					reprr.interrupt();
				}
				reprr.start();
				//--------사망페이지
				
				break;
				
			}
		}
	}
}
