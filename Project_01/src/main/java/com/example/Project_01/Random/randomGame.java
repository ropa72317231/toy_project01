package com.example.Project_01.Random;

import java.util.ArrayList;
import java.util.Scanner;

//Random 숫자 맞추기 게임

public class randomGame {
	public static void main(String[] args) {
		
		int num1, num2, total;
		// total 변수는 임의의 수를 받는 기능을 넣고 싶을 경우에 쓴다 (제한횟수 조절. 현재 default는 10으로 돼 있음)
		int count = 1;
		String s1 = ""; // 숫자를 문자열로 저장해서 변환해서 담음
		ArrayList list = new ArrayList<>();

		Scanner s = new Scanner(System.in);
		num1 = (int) ((Math.random()) * 100) + 1; // 1부터 100중에 아무 숫자가 튀어나옴.

		String sep = "";

		for (int i = 0; i < 10; i++) {
			System.out.println("숫자를 입력하세요 : ");
			num2 = s.nextInt();
			s1 = num2 + "";
			list.add(s1);
			sep = ", ";

			if (count < 10) {
				if (num1 < num2) {
					System.out.println("너무 크게 입력했네 ~? 줄여보지 그래 ㅋㅋㅋㅋ");

				}

				else if (num1 > num2) {
					System.out.println("너무 작게 입력했네 ~? 크게 입력해보지 그래 ㅋㅋㅋㅋ");

				} else {
					System.out.println(num2 + "가 정답입니다");
					System.out.print("지금까지 입력한 수 : ");
					for (Object a : list) {
						System.out.print(sep + a);
					}
					System.out.println();
					System.out.println("입력 횟수 : " + count + "/10");
					break;

				}
			} else {
				if (num1 != num2) {
					System.out.println("기회를 모두 소진하셨습니다");

				} else {
					System.out.println(num2 + "이 정답입니다");

				}

			}
			System.out.print("지금까지 입력한 수 : ");
			for (Object a : list) {
				System.out.print(sep + a);
			}
			System.out.println();
			System.out.println("입력 횟수 : " + count + "/10");
			
			count++;

		}
		
		
		
		
		
	}

}
