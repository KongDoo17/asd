package asdgame.util;

import asdgame.game;

public class spdth extends Thread {
	// �ӵ� ������. ������ �ӵ��� �������ִ� Ŭ�����̴�
	game e;

	public spdth(game e) {// game Ŭ�������� spdth�� ����� �� �ֵ��� ������ �����
		this.e = e;
	}

	public void run() {
		while (true) {
			if (e.spds > 1) {// ���� �ӵ��� 1~5���� ������, �⺻ �������� 5�̴�. spds�� 1�� �� ��� ����������.
				try {
					Thread.sleep(10000); //10��
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.spds--;// 30�ʸ��� ���Ӽӵ��� 1�� ��������. 1���� �Ʒ��δ� �������� �ʴ´�.
				
			}
		}
	}
}
