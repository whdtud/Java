package com.poseidon.dto;

//데이터 전송때 사용하는 객체입니다.
//ArrayList<BoardDTO>로 담겠습니다.
public class BoardDTO {
	private int bno, bcount;
	private String btitle, bdate, name, id;
	private String bcontent;//detail에서 사용할 본문 내용입니다.
	
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public int getBcount() {
		return bcount;
	}

	public void setBcount(int bcount) {
		this.bcount = bcount;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

}
/*
	오늘 할 일
	서버 프로그램 구현
	detail완성하기
	login완성하기
	
	clean - 이미 만들어진 class파일 정리하기 
			.java파일을 수정했다? 서버 다시 시작하기
			
	html과 jsp와 java코드 설명하기 - 생성시점
	


*/