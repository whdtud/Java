package com.poseidon.jini;

import java.util.Scanner;

public class JiniMain {

	public static void main(String[] args) {
		JINI jini = new JINI();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("지니 시작합니다.");
		System.out.println("명령어 : 안녕/이름/날짜/시간/나가기");
		
		while (jini.isQute) {
			System.out.println("질문 > ");
			String input = sc.next();
			jini.scheck(input);
		}
		
		sc.close();
	}
}
