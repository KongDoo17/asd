package asdgame.energypa;

import java.awt.Color;

import javax.swing.ImageIcon;

import asdgame.game;

public class energy extends Thread {
	game e;

	public energy(game e) {
		this.e = e;
	}

	ImageIcon lasericon1 = new ImageIcon("jordi\\jordilaser.png");//조르디 레이저 이미지파일
	ImageIcon lasericon2 = new ImageIcon("jordi\\jordi.png");// 조르디 캐릭터 이미지파일
	
	ImageIcon enicon1 = new ImageIcon("energy\\en1.png");
	ImageIcon enicon2 = new ImageIcon("energy\\en2.png");
	ImageIcon enicon3 = new ImageIcon("energy\\en3.png");
	ImageIcon enicon4 = new ImageIcon("energy\\en4.png");// en1~en4 레이저 에너지 모으기 이미지파일
	ImageIcon enicon5 = new ImageIcon("energy\\en5.png");// en5 레이저 발사 이미지파일
	public void run() {

		if (e.eggstartchk == false) {// 이스터 에그가 발동하지 않았을 때, 일반 공룡 상태일 때
			for (int i = 0; i < 3; i++) {
				
				//------------------------에너지 모으기 이미지파일 변경
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
				//------------------------에너지 모으기 이미지파일 변경
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block

			} 
			e.enchk = false; // 에너지 발사 체크값 false
			e.enbtn.setBounds(e.a + 20, e.b, 300, 10); // 레이저 발사 버튼 위치설정
			e.enbtn.setIcon(enicon5);  // 레이저 발사 버튼 이미지 설정
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block

			}
			e.enchk = true; // 에너지 발사 체크값 true

			e.enbtn.setBounds(e.a + 20, e.b, 10, 10);
			e.enbtn.setIcon(null); // 레이저 발사 버튼 이미지 제거
			e.ensleep = false; // 에너지 발사 상태값 false, 일정 시간동안은 발사하지 못하도록 함
		}
		else if (e.eggstartchk == true) {//이스터 에그가 발동했을 때, 죠르디 상태일 때
			e.btn.setIcon(lasericon1);  // 죠르디 레이저 발사하는 모션으로 캐릭터 이미지 변경
			for (int i = 0; i < 3; i++) {
				//------------------------에너지 모으기 이미지파일 변경
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
				//------------------------에너지 모으기 이미지파일 변경
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block

			}
			e.enchk = false;// 에너지 발사 체크값 false
			e.enbtn.setBounds(e.a + 32, e.b+5, 300, 10);// 레이저 발사 버튼 위치설정
			e.enbtn.setIcon(enicon5);// 레이저 발사 버튼 이미지 설정
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block

			}
			e.enchk = true;// 에너지 발사 체크값 true

			e.enbtn.setBounds(e.a + 32, e.b+5, 10, 10);
			e.enbtn.setIcon(null); // 레이저 발사 버튼 이미지 제거
			e.btn.setIcon(lasericon2); // 원래 죠르디 캐릭터로 이미지 변경
			e.ensleep = false; // 에너지 발사 상태값 false, 일정 시간동안은 발사하지 못하도록 함
		}
	}

}