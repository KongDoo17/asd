package asdgame;

import java.awt.AlphaComposite;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import asdgame.energypa.coolth;
import asdgame.energypa.energy;
import asdgame.hp.hiting;
import asdgame.hp.hpchk;
import asdgame.hp.hpth;
import asdgame.huddle.hudThread;
import asdgame.start.startgame;
import asdgame.start.startth;
import asdgame.start.startth2;
import asdgame.util.jumps;
import asdgame.util.eggth;
import asdgame.util.mapTh;
import asdgame.util.scoreth;
import asdgame.util.spdth;


public class game extends JFrame implements KeyListener {

	//----------------쓰레드 생성
	
	public jumps th = new jumps(this);
	public hudThread hth = new hudThread(this);
	public hpchk hp = new hpchk(this);
	public hiting hit = new hiting(this);
	public mapTh map = new mapTh(this);
	public hpth pts = new hpth(this);
	public scoreth scr = new scoreth(this);
	public spdth sp = new spdth(this);
	public energy en = new energy(this);
	public eggth egg = new eggth(this);
	public startgame sg = new startgame(this);
	public startth st = new startth(this);
	public startth2 st2 = new startth2(this);
	public coolth cth = new coolth(this);

	//----------------쓰레드생성
	
	//----------------버튼 선언
	public JButton btn;
	public JButton enbtn;
	public JButton startbtn;
	public JButton coolbtn;
	public JButton yd;
	public JButton prr;
	
	//----------------버튼선언
	
	public JPanel pnl, pnl2, hppnl1, hppnl2, startpnl, diepnl;
	
	public JLabel score, rescore;
	
	public int gongx1, gongx2, gongy1, gongy2; // 공룡 xy 좌표�?
	public int bigx1, bigx2, bigy1, bigy2; // 큰선인장xy 좌표�?
	public int sx1, sx2, sy1, sy2; // 작은선인장xy 좌표�?
	public int z = 20; // 공룡 최초 크기
	public int a = 20;// 공룡 최초 x
	public int b = 111; // 공룡 최초y
	public int mapx = 0; // 맵x좌표
	public int ptong = 300; //피통
	public int spds = 5; // 게임속도
	public int tu = 0;// 처음 공룡 run! 밝기 0부터 255까지 초기값설정

	public String scorestr; // 최종스코어 저장 string

	public Clip clip; // bgm 재생 관련
	
	public boolean chk = true; //
	public boolean enchk = true; // 레이저 발사 중인지 참거짓
	public boolean enenable = false; // 레이저 발사 할 수  있는지 참거짓
	public boolean ensleep = false; // 레이저 sleep 참거짓
	public boolean eggchek1 = false;
	public boolean eggchek2 = false;
	public boolean eggchek3 = false;
	public boolean eggchek4 = false;
	public boolean eggstartchk = false; // egg... 은 죠르디 변환 커맨드 체크 참거짓 
	public boolean startchk = false; // 시작 했는지 참거짓
	public boolean restart = false; // 리스타튼지 참거짓
	public boolean spdchk = false;// 속도 참거짓
	public boolean pakchk = false;// 첫화면 "PRESS ANY KEY" 참거짓
	
	
	public ImageIcon btnicon = new ImageIcon("img\\daino.png"); //공룡 
	public ImageIcon enicon = new ImageIcon("energy\\en1.png");//에너지모우기1
	public ImageIcon starticon = new ImageIcon("img\\pnk.png");//press any key
	public ImageIcon coolicon = new ImageIcon("cool\\cool16.png"); // 쿨타임 꽉찬 그림
	public ImageIcon ydicon = new ImageIcon("die\\YD.png"); //사망시 유다이 그림
	public ImageIcon prricon = new ImageIcon("die\\PRR.png");// 사망시 press r restart 그림
	public Image background = new ImageIcon("img\\backk.png").getImage();// 배경그림
	public Image image = Toolkit.getDefaultToolkit().getImage("img\\run.png"); // 배경 그림

	AlphaComposite alphaComposite; //첫시작 투명도 알파값

	public game() {
		
		
		btn = new JButton(btnicon); // 공룡생성
		enbtn = new JButton(); //에너지파 생성버튼
		coolbtn = new JButton(coolicon); //쿨타임 버튼생
		startbtn = new JButton(starticon); // press any key 생성
		yd = new JButton(ydicon); // 유다이 생성
		prr = new JButton(prricon); // press r restart 생성
		score = new JLabel("0"); //스코어 생성
		hppnl1 = new JPanel(null); // hp 그림
		pnl = new JPanel(null) { // 땅 그림 그려주기
			public void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		startpnl = new JPanel(null) { //공룡 RUN! 밝기 변하기
			public void paint(Graphics g) {
				alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) tu / 255); // alpha�? = 밝기 �??��
				Graphics2D g2 = (Graphics2D) g;
				g2.setComposite(alphaComposite);
				g2.drawImage(image, 0, 0, this);
			}
		};
			
		// 버튼 위치 조정
		startbtn.setBounds(90, 80, 100, 20);
		coolbtn.setBounds(10, 20, 20, 20);
		yd.setBounds(37, 10, 200, 50);
		prr.setBounds(47, 80, 200, 50);
		hppnl1.setBounds(0, 0, 300, 10);
		score.setBounds(260, 10, 30, 15);
		startpnl.setBounds(60, 20, 150, 50);
		pnl.setBounds(0, 128, 900, 40);
		
		enbtn.setBounds(a + 20, b, 10, 10);// 레이저버튼 공룡 x+20 좌표만큼 앞에 생성
		btn.setBounds(a, b, z, 20);
		hppnl1.setBackground(Color.RED);
		// 버튼 위치 조정

		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		enbtn.setBorderPainted(false);
		enbtn.setContentAreaFilled(false);
		coolbtn.setBorderPainted(false);
		coolbtn.setContentAreaFilled(false);
		startbtn.setBorderPainted(false);
		startbtn.setContentAreaFilled(false);
		yd.setBorderPainted(false);
		yd.setContentAreaFilled(false);
		prr.setBorderPainted(false);
		prr.setContentAreaFilled(false);
		startbtn.setSelected(false);

		

		this.setSize(300, 200);
		this.setDefaultCloseOperation(3);
		this.setLayout(null);
		this.requestFocus();
		this.setFocusable(true);
		this.setLocationRelativeTo(null); // ?��면중?��
		this.setResizable(false);
		
		this.addKeyListener(this);
		this.add(startpnl);
		this.add(score);
		this.add(pnl);
		this.add(hppnl1);
		this.add(coolbtn);
		this.add(btn);
		this.add(enbtn);
		
		st.start();
		st2.start();			
		
		setVisible(true);
		
		Play("bgm\\start.wav"); // bgm 시작

	}	
	
	public void startbgm(){//시작 bgm
		
		Play("bgm\\die.wav");
	}

	public void youdied(){ //사망화면생성
		this.add(yd);
		rescore=new JLabel(scorestr);
		Font font = new Font(null,Font.BOLD,30);
		rescore.setFont(font);
		rescore.setBounds(125, 17, 100, 100);
		this.add(rescore);
		this.add(prr);
		repaint();
	}

	public void pakt() { //시작시 press any key 생성
		
		this.add(startbtn);
		this.repaint();
		pakchk = false;
	}

	public void pakf() {//시작시 press any key 삭제
		this.remove(startbtn);
		this.repaint();
		pakchk = true;
	}

	public void jum(int x) { //공룡 점프 그리기

		btn.setBounds(a, x, z, 20);
		if (enchk == true) {
			if (eggstartchk == false) {
				enbtn.setBounds(a + 20, b, 10, 10);
			} else if (eggstartchk == true) {
				enbtn.setBounds(a + 32, b + 5, 10, 10);
			}
		} else if (enchk == false) {
			if (eggstartchk == false) {
				enbtn.setBounds(a + 20, b, 300, 10);
			} else if (eggstartchk == true) {
				enbtn.setBounds(a + 32, b + 5, 300, 10);
			}
		}
		b = x;
		this.repaint();
		this.revalidate();
	}
	
	public void Play(String fileName) // bgm 재생 관련
    {
        try
        {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName)); // bgm 파일 가져오기
            clip = AudioSystem.getClip();
            clip.stop();
            clip.open(ais);
            clip.start(); // 가져온 음악 재생
        }
        catch (Exception ex)
        {
        }
    }
	
	

	@Override
	public void keyPressed(KeyEvent e) {

		
		this.remove(startpnl); 
		this.remove(startbtn);
		this.repaint();   // 아무키를 누를시 공룡RUN!,Press any key 삭제
		st2.chk = false; // press any key 깜빡거리는 쓰레드 멈추기
		

		
		// 이스터에그(죠르디) 커맨드 입력 확인 부분 아래 설명있음
		if (e.getKeyCode() == KeyEvent.VK_UP && startchk == false) {
			if (eggchek1 == false) {
				eggchek1 = true;
			} else {
				eggchek1 = false;
				eggchek2 = false;
				eggchek3 = false;
				eggchek4 = false;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN && eggchek1 == true && startchk == false) {
			if (eggchek2 == false) {
				eggchek2 = true;
			} else {
				eggchek1 = false;
				eggchek2 = false;
				eggchek3 = false;
				eggchek4 = false;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT && eggchek2 == true && startchk == false) {
			if (eggchek3 == false) {
				eggchek3 = true;
			} else {
				eggchek1 = false;
				eggchek2 = false;
				eggchek3 = false;
				eggchek4 = false;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && eggchek3 == true && startchk == false) {
			if (eggchek4 == false) {
				eggchek4 = true;
			} else {
				eggchek1 = false;
				eggchek2 = false;
				eggchek3 = false;
				eggchek4 = false;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_G && eggchek4 == true && eggstartchk == false && startchk == false) {

			eggstartchk = true;
			egg.start();
			z = 30;
		}
		
		

		
		
		if (e.getKeyCode() == KeyEvent.VK_F5) {

			eggchek1 = false;
			eggchek2 = false;
			eggchek3 = false;
			eggchek4 = false;
		}
		
		//첫 시작 화면에서 상 하 좌 우 G 를 순서대로 누를시 eggchk1,2,3,4가 차례대로 true 값으로 바고
		//G 를 누를시 이스터에그 안되고 시작 안됬을때만 먹을수 있게 바뀜
		//상 하 좌 우 G 를 순서대로 안누를시 무조건 false로 바꾸기 떄문에 꼬일 수 있음 그럴떈 F5를 눌러 모두 False로 바꿔주고 다시 커맨드를 입력하면
		//처음부터 커맨드를 다시 입력할 수 있음

		if (e.getKeyCode() == KeyEvent.VK_LEFT) { //좌측이동

			if (a > 10) {
				a -= 10;
				btn.setBounds(a, b, z, 20);
				if (enchk == true) {
					if (eggstartchk == false) {
						enbtn.setBounds(a + 20, b, 10, 10);
					} else if (eggstartchk == true) {
						enbtn.setBounds(a + 32, b + 5, 10, 10);
					}

				} else if (enchk == false) {
					if (eggstartchk == false) {
						enbtn.setBounds(a + 20, b, 300, 10);
					} else if (eggstartchk == true) {
						enbtn.setBounds(a + 32, b + 5, 300, 10);
					}
				}
				gongx1 = btn.getX();
				gongx2 = btn.getX() + 20;
				repaint();
				
				revalidate();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // 우측이동
			if (a < 90) {
				a += 10;
				btn.setBounds(a, b, z, 20);
				if (enchk == true) {
					if (eggstartchk == false) {
						enbtn.setBounds(a + 20, b, 10, 10);
					} else if (eggstartchk == true) {
						enbtn.setBounds(a + 32, b + 5, 10, 10);
					}

				} else if (enchk == false) {
					if (eggstartchk == false) {
						enbtn.setBounds(a + 20, b, 300, 10);
					} else if (eggstartchk == true) {
						enbtn.setBounds(a + 32, b + 5, 300, 10);
					}
				}

				gongx1 = btn.getX();
				gongx2 = btn.getX() + 20;
				repaint();
				revalidate();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_C) { // 점프
			if (chk == true) {
				chk = false;

				if (th.isAlive()) {
					th.interrupt();
				}
				th = new jumps(this);
				th.start();
			}

		}
		if (e.getKeyCode() == KeyEvent.VK_S && startchk == false && !restart) { // S 키를 눌러 스타트

			spdchk = true; //게임 속도 쓰레드 시작
			startchk = true; // 게임 시작 참 전환
			
			gongx1 = btn.getX();      //시작시 바로 공룡 xy 좌표 주인공 int변수에 저장?
			gongx2 = btn.getX() + 20; 
			gongy1 = btn.getY();	  
			gongy2 = btn.getY() + 20; 

			// 쓰레드 일단 죽이기
			if (sg.isAlive()) {
				sg.interrupt();
			}
			if (hth.isAlive()) {
				hth.interrupt();
			}
			if (hp.isAlive()) {
				hp.interrupt();
			}
			if (map.isAlive()) {
				map.interrupt();
			}
			if (pts.isAlive()) {
				pts.interrupt();
			}
			if (scr.isAlive()) {
				scr.interrupt();
			}
			if (sp.isAlive()) {
				sp.interrupt();
			}
			// 쓰레드 일단 죽이기
			
			// 쓰레드 살리기
			sg.start();
			hth.start();
			hp.start();
			map.start();
			pts.start();
			scr.start();
			sp.start();
			// 쓰레드 살리기
			
			//쿨타임 사진 관련 쓰레드
			if (cth.isAlive()) {
				cth.interrupt();
				
			}
			//쿨타임 사진 관련 쓰레드 다시 만들기
			cth = new coolth(this);
			cth.start();

		}

		if (e.getKeyCode() == KeyEvent.VK_R && restart && startchk == false) { //?��?��?���?�?
			
			this.remove(yd); // 유다이 삭제
			this.remove(prr); // press r restart 삭제
			this.remove(rescore); // 최종 스코어 삭제
			
			clip.stop(); //사망 시 bgm 종료
			Play("bgm\\start.wav"); // 스타트 bgm 스타트
			
			spds = 5;
			spdchk = true;
			restart = false;
			startchk = true;
			gongx1 = btn.getX();
			gongx2 = btn.getX() + 20;
			gongy1 = btn.getY();
			gongy2 = btn.getY() + 20;

			if (sp.isAlive())
				sg.interrupt();
			sg = new startgame(this);
			sg.start();
			hth = new hudThread(this);
			hth.start();
			hp = new hpchk(this);
			hp.start();
			map = new mapTh(this);
			map.start();
			pts = new hpth(this);
			pts.start();
			scr = new scoreth(this);
			scr.start();
			sp = new spdth(this);
			sp.start();
			if (cth.isAlive()) {
				cth.interrupt();
				;
			}
			cth = new coolth(this);
			cth.start();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_X) { //에너지 발사
			if (enenable == true) { //에너지파 준비됐을때
				scr.b = 0; // 쿨타임 초기화
				if (eggstartchk == false) { //공룡일때 에너지파
					enbtn.setBounds(a + 20, b, 10, 10);
				} else if (eggstartchk == true) {//죠르디 일떄 에너지파
					enbtn.setBounds(a + 32, b + 5, 10, 10);
				}
				hth.isfull = true;//에너지파 쏠때 선인장 안나오게
				if (en.isAlive()) {
					en.interrupt();
				}

				if (cth.isAlive()) {
					cth.interrupt();
					;
				}
				cth = new coolth(this);
				cth.start();

				en = new energy(this);

				en.start(); // 에너지파 발사

				enenable = false;

			}
			if (scr.b == 0) { // 0이면 시작신데 시작할때 무한 레이저포 발사 하기위함

				if (ensleep == false) {
					scr.b = 0;
					if (eggstartchk == false) {
						enbtn.setBounds(a + 20, b, 10, 10);
					} else if (eggstartchk == true) {
						enbtn.setBounds(a + 32, b + 5, 10, 10);
					}
					hth.isfull = true;
					ensleep = true;
					if (en.isAlive()) {
						en.interrupt();
					}
					en = new energy(this);

					en.start();
					enenable = false;
				}
			}

		}

	}

	public void bighud(int spd) {// 큰선인장생성
		int x;
		int chkx1 = 0;
		int chkx2 = 0;
		ImageIcon bigicon = new ImageIcon("img//bigsun.png");

		JButton btn_bighuddle = new JButton(bigicon);
		btn_bighuddle.setBorderPainted(false);
		btn_bighuddle.setContentAreaFilled(false);
		add(btn_bighuddle);

		for (x = 300; x > -100; x -= 1) {

			btn_bighuddle.setBounds(x, 116, 15, 15);
			btn_bighuddle.setBackground(Color.blue);

			chkx1 = btn_bighuddle.getX();
			chkx2 = btn_bighuddle.getX() + 15;

			if (chkx1 > 0 && chkx2 > 0) {
				bigx1 = btn_bighuddle.getX();
				bigx2 = btn_bighuddle.getX() + 15;
				bigy1 = btn_bighuddle.getY();
				bigy2 = btn_bighuddle.getY() + 15;
			}
			try {
				Thread.sleep(spds);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public void hud(int spd) { // 작은선인장 생성
		int x = 300;
		int chkx1 = 1;
		int chkx2 = 1;
		ImageIcon sicon = new ImageIcon("img//smallsun.png");
		JButton btn_huddle = new JButton(sicon);
		btn_huddle.setBorderPainted(false);
		btn_huddle.setContentAreaFilled(false);
		add(btn_huddle);
		btn_huddle.setBounds(x, 121, 10, 10);
		while (x > -20) {

			chkx1 = btn_huddle.getX();
			chkx2 = btn_huddle.getX() + 10;

			if (chkx1 > 0 && chkx2 > 0) {

				sx1 = btn_huddle.getX();
				sx2 = btn_huddle.getX() + 10;
				sy1 = btn_huddle.getY();
				sy2 = btn_huddle.getY() + 10;
			}

			try {
				Thread.sleep(spds);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			x -= 1;
			btn_huddle.setBounds(x, 121, 10, 10);

		}

	}
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent e) {}
	public static void main(String[] args) {new game();}
}
