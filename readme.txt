2020-12-09

기본키 
← → 좌우이동
  X   레이저 발사
  C   점프
  S   처음 시작시
  R   사망시 재시작

기능 
s 눌러서 스타트 전 레이저 쿨타임 없음
s 누르기 전에도 조작 가능
상 > 하 > 좌 > 우 > G 순서대로 누를시 이스터에그 발생
사망시 R 누르면 재시작
X 눌러서 레이저 발사할때 선인장 생성 안됨
C 눌러서 점프시 선인장 피해짐
우측상단 실시간 스코어 표시
좌측상단 레이저 쿨타임 표시 (쿨타임 10초)
사망시 사망 BGM 재생
매 10초 마다 속도 빨라짐 (5단계)
선인장 큰거 작은거 랜덤생성

폴더
asdgame 기본 폴더
  ┖game.java 게임 실행 및 쓰레드 관련 메인 부분

  ┖energypa 에너지파 관련
      ┖coolth.java 쿨타임 이미지 표시 관련 쓰레드
      ┖energy.java 쿨타임 이미지 표시 관련 쓰레드

  ┖hp 피통 관련
      ┖hiting.java 주인공 부딪히면 화난 그림 바꿔주는 쓰레드
      ┖hpchk.java 장애물 부딪힘 체크 및 피 감소 쓰레드
      ┖hpth.java 사망 체크 쓰레드

  ┖huddle 장애물 관련
      ┖bigHuddle.java 큰선인장 생성 쓰레드
      ┖Huddle.java 작은선인장 생성 쓰레드
      ┖hudThread 위 둘 생성 쓰레드를 랜덤으로 실행시켜주는 쓰레드

  ┖start 시작 관련
      ┖reprr.java 사망시 "PRESS 'R' RESTART" 깜빡거리는 쓰레드
      ┖startgame.java 사망시 재시작 관련 쓰레드
      ┖startth.java 시작시 공룡RUN! 밝아지는 쓰레드
      ┖startth2.java 시작시 "PRESS ANY KEY" 깜빡거리는 쓰레드

  ┖util 기타등등
      ┖eggth.java 이스터에그(죠르디) 관련 쓰레드
      ┖mapth.java 맵 이미지 무한반복 쓰레드
      ┖jumps.java 점프 하는 쓰레드
      ┖scoreth.java 점수 쓰레드
      ┖spdth.java 속도 점점 빨라지게 하는 쓰레드

