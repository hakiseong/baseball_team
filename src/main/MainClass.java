package main;

import java.util.Scanner;

import Baseball_dao.HumanDao;
import baseball.HumanDto;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String menu;
		HumanDao humanDao = new HumanDao();
		
		System.out.println("========== 야구팀 관리 프로그램 ==========");
		while(true) {
			
			System.out.println("----------메뉴 ----------");
			System.out.println("1. 선수추가");
			System.out.println("2. 선수삭제");
			System.out.println("3. 선수검색");
			System.out.println("4. 선수수정");
			System.out.println("5. 타율순위");
			System.out.println("6. 방어율순위");
			System.out.println("7. 선수정보모두보기");
			System.out.println("8. 파일저장");
			System.out.println("9. 파일불러오기");
			
			System.out.print("메뉴 번호 > ");
			menu = sc.next();
			
			switch(menu) {
			case "1":
				humanDao.addPlayer();
				break;
			case "2":
				humanDao.deletePlayer();
				break;
			case "3":
				humanDao.selectPlayer();
				break;
			case "4":
				humanDao.updatePlayer();
				break;
			case "5":
				humanDao.batterLank();
				break;
			case "6":
				humanDao.pitcherLank();
				break;
			case "7":
				humanDao.allData();
				break;
			case "8":
				humanDao.save();
				break;
			case "9":
				humanDao.load();
				break;
			default:
				System.out.println("잘못된 번호입니다! 다시 입력해주세요");
				continue;
			}
			
		}

	}

}
