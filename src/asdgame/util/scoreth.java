package asdgame.util;

import asdgame.game;

public class scoreth extends Thread {
	int a=0; // ����
	public int b=0; // ������ �߻簪, 30�� ���� ��� ������ �߻� ����
	game e; // game Ŭ���� ȣ��
	public scoreth(game e){ // game Ŭ�������� scoreth�� ����� �� �ֵ��� ������ �����
		this.e=e;
	}
	
	
	public void run(){
		b++; // ���ӽ��� ���� �������� ����� �� �ֵ��� while�� ���� b�� ++��
		while(true){
			
			e.score.setText(a+"");// ������ ��� ������ a���� ����
			
			e.scorestr=e.score.getText();//������ �������ھ� ����
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				
			}
			a++; // ������ 1�� �ø�
			b++; // ������ �߻簪�� 1�� �ø�
			if(b>=10){
				e.enenable=true;

				
			} // ������ �߻簪�� 10�̻��̸� �������� �߻��� �� �ֵ��� en enable�� true�� ����
			else {
				e.enenable=false;
			}
			if(e.restart) {

				a = 0;
				b = 0;
				break;
			}// ������ ����۵Ǹ� a�� b�� ���� 0���� �ʱ�ȭ������. 
			

		}
	}
}
