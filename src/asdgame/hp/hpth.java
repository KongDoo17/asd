package asdgame.hp;

import asdgame.game;

public class hpth extends Thread{
	game e;
	int a=0;
	public hpth(game e){
		this.e = e;
	}
	
	public void run(){
		while(true){
			a= 300-e.ptong; //��ֹ��� ������ �� e.ptong��ŭ ����
			e.hppnl1.setBounds(a,0,300,10);
			if(a>=300){
				e.startchk=false;
				if(e.hth.isAlive()){
					e.hth.stop();
				}
				if(e.hp.isAlive()){
					e.hp.stop();
				}
				if(e.map.isAlive()){
					e.map.stop();
				}
				if(e.pts.isAlive()){
					e.pts.stop();
				}
				if(e.scr.isAlive()){
					e.scr.stop();
				}
				if(e.sp.isAlive()){
					e.sp.stop();
				}
				
				break;
			}
		}


	}

}
