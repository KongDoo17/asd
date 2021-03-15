package asdgame.util;

import asdgame.game;

public class scoreth extends Thread {
	int a=0; // 점수
	public int b=0; // 레이저 발사값, 30이 넘을 경우 레이저 발사 가능
	game e; // game 클래스 호출
	public scoreth(game e){ // game 클래스에서 scoreth를 사용할 수 있도록 생성자 만들기
		this.e=e;
	}
	
	
	public void run(){
		b++; // 게임시작 전에 레이저를 사용할 수 있도록 while문 전에 b를 ++함
		while(true){
			
			e.score.setText(a+"");// 오른쪽 상단 점수에 a값을 설정
			
			e.scorestr=e.score.getText();//숨질시 최종스코어 설정
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				
			}
			a++; // 점수를 1씩 올림
			b++; // 레이저 발사값을 1씩 올림
			if(b>=10){
				e.enenable=true;

				
			} // 레이저 발사값이 10이상이면 레이저를 발사할 수 있도록 en enable을 true로 변경
			else {
				e.enenable=false;
			}
			if(e.restart) {

				a = 0;
				b = 0;
				break;
			}// 게임이 재시작되면 a와 b의 값을 0으로 초기화시켜줌. 
			

		}
	}
}
