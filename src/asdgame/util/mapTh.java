package asdgame.util;

import asdgame.game;

public class mapTh extends Thread {
	game e;

	public mapTh(game e) { // game Ŭ�������� mapTh�� ����� �� �ֵ��� ������ �����
		this.e = e;
	}

	public void run() {
		while (true) {
			if (e.mapx > -600) {//mapx�� map �̹����� x��ǥ 
				e.mapx--;
				e.pnl.setBounds(e.mapx, 128, 900, 200);
				//e.pnl2.setBounds(e.mapx+300, 128, 900, 200);
				try {
					Thread.sleep(e.spds); //spds�� ���� �������� �ӵ�. 1~5���� �ִµ� ���� ���ϼ��� �ӵ��� ������, ���� ���ϼ��� �ӵ��� ������.
                    //���� �ð����� ���� �پ���, 1���Ϸδ� �������� �ʴ´�.
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else{
				e.mapx=0;
			} // mapx�� -600 ���Ϸ� �������� ��� �ٽ� 0���� ���� ���� �������� ������ �� �ֵ��� �Ѵ�.
		}
	}

}

