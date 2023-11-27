package Baseball_dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import baseball.BatterDto;
import baseball.HumanDto;
import baseball.PitcherDto;

public class HumanDao {
    private int count;
    private HumanDto[] players;

    public HumanDao() {
        count = 0;
        players = new HumanDto[50];
    }

    public void addPlayer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.타자  2. 투수");
        int playerType = sc.nextInt();

        if (playerType == 1) {
            BatterDto batter = new BatterDto();
            playerImpo(batter);
            System.out.print("타점 : ");
            batter.setBatcount(sc.nextInt());
            System.out.print("안타수 : ");
            batter.setHit(sc.nextInt());
            System.out.print("타율 : ");
            batter.setHivAvg(sc.nextDouble());

            players[count] = batter;
            count++;
            System.out.println("선수가 추가되었습니다.");
        } else if (playerType == 2) {
            PitcherDto pitcher = new PitcherDto();
            playerImpo(pitcher);
            System.out.print("승 : ");
            pitcher.setWin(sc.nextInt());
            System.out.print("패 : ");
            pitcher.setLose(sc.nextInt());
            System.out.print("방어율 : ");
            pitcher.setDefence(sc.nextDouble());

            players[count] = pitcher;
            count++;
            System.out.println("선수가 추가되었습니다.");
        } else {
            System.out.println("잘못입력하셨습니다. 다시 입력해 주세요!!");
        }
    }

   

    public void deletePlayer() {
    	boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while (flag) {
            System.out.print("삭제하고 싶은 선수의 이름 >> ");
            String name = sc.next();

            // 검색
            int findIndex = -1;
            for (int i = 0; i < count; i++) {
                if (players[i].getName().equals(name)) { // 찾았다
                    findIndex = i;
                    flag = false;
                    break;
                }
            }

            if (findIndex != -1) {
                if (players[findIndex] instanceof BatterDto) {
                    BatterDto batter = (BatterDto) players[findIndex];
                    playerimpdel(batter);
                    batter.setBatcount(0);
                    batter.setHit(0);
                    batter.setHivAvg(0.0);
                    System.out.println("선수 데이터를 삭제하였습니다.");
                } else if (players[findIndex] instanceof PitcherDto) {
                    PitcherDto pitcher = (PitcherDto) players[findIndex];
                    playerimpdel(pitcher);
                    pitcher.setWin(0);
                    pitcher.setLose(0);
                    pitcher.setDefence(0.0);
                    System.out.println("선수 데이터를 삭제하였습니다.");
                }
            } else {
                System.out.println("해당하는 선수가 존재하지 않습니다. 다시 입력해주세요");
            }
        }
    }

   
    public void allData() {
        for (int i = 0; i < count; i++) {
           
            if(players[i] != null && !players[i].getName().equals("")) {
            	System.out.println("===============");
            	if (players[i] instanceof BatterDto) {
                    printBatter((BatterDto) players[i]);
                } else if (players[i] instanceof PitcherDto) {
                    printPitcher((PitcherDto) players[i]);
                }
            } 
        }
    }

    
    
    public void selectPlayer() {
    	boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while (flag) {
            System.out.print("검색하고 싶은 선수의 이름 >> ");
            String name = sc.next();

            // 검색
          
            int findIndex = -1;
            for (int i = 0; i < count; i++) {
                if (players[i].getName().equals(name)) { // 찾았다
               
                    findIndex = i;
                    flag = false;
                    break;
                }
            }

            if (findIndex != -1) {
            	if (players[findIndex] instanceof BatterDto) {
                    printBatter((BatterDto) players[findIndex]);
                } else if (players[findIndex] instanceof PitcherDto) {
                    printPitcher((PitcherDto) players[findIndex]);
                }
            } else {
                System.out.println("해당하는 선수가 존재하지 않습니다. 다시 입력해주세요");
            }
        }
    }
    public void updatePlayer() {
    	boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while (flag) {
            System.out.print("수정하고 싶은 선수의 이름 >> ");
            String name = sc.next();

            // 검색
            int findIndex = -1;
            for (int i = 0; i < count; i++) {
                if (players[i].getName().equals(name)) { // 찾았다
                    findIndex = i;
                    flag = false;
                    break;
                }
            }

            if (findIndex != -1) {
            	if (players[findIndex] instanceof BatterDto) {
            		BatterDto batter = (BatterDto) players[findIndex];
            		System.out.print("타점 : ");
                    batter.setBatcount(sc.nextInt());
                    System.out.print("안타수 : ");
                    batter.setHit(sc.nextInt());
                    System.out.print("타율 : ");
                    batter.setHivAvg(sc.nextDouble());
                } else if (players[findIndex] instanceof PitcherDto) {
                	PitcherDto pitcher = (PitcherDto) players[findIndex];
            		System.out.print("승 : ");
            		pitcher.setWin(sc.nextInt());
                    System.out.print("패 : ");
                    pitcher.setLose(sc.nextInt());
                    System.out.print("방어율 : ");
                    pitcher.setDefence(sc.nextDouble());
                }
            } else {
                System.out.println("해당하는 선수가 존재하지 않습니다. 다시 입력해주세요");
            }
        }
    }
    
    public void batterLank() {
    	
    	BatterDto[] batters = new BatterDto[count];
        int batterCount = 0;

        for (int i = 0; i < count; i++) {
            if (players[i] instanceof BatterDto) {
            	BatterDto batter = (BatterDto) players[i];
            	if(batter.getHivAvg() != 0.0) { 
                batters[batterCount++] = batter;
            	}
            }
        }

        for (int i = 0; i < batterCount - 1; i++) {
            for (int j = 0; j < batterCount - 1 - i; j++) {
                if (batters[j].getHivAvg() < batters[j + 1].getHivAvg()) {
                    BatterDto temp = batters[j];
                    batters[j] = batters[j + 1];
                    batters[j + 1] = temp;
                }
            }
        }

        System.out.println("==== 타율 순위 ====");
        for (int i = 0; i < batterCount; i++) {
            System.out.println((i + 1) + ". " + batters[i].getName() + " - 타율: " + batters[i].getHivAvg());
        }
    }
    public void pitcherLank() {
    	
    	PitcherDto[] pitchers = new PitcherDto[count];
        int PitcherCount = 0;

        for (int i = 0; i < count; i++) {
            if (players[i] instanceof PitcherDto) {
            	PitcherDto pitcher = (PitcherDto) players[i];
            	if(pitcher.getDefence() != 0.0) {
            	pitchers[PitcherCount++] = pitcher;
            	}
            }
        }

        for (int i = 0; i < PitcherCount - 1; i++) {
            for (int j = 0; j < PitcherCount - 1 - i; j++) {
                if (pitchers[j].getDefence() > pitchers[j + 1].getDefence()) {
                    PitcherDto temp = pitchers[j];
                    pitchers[j] = pitchers[j + 1];
                    pitchers[j + 1] = temp;
                }
            }
        }

        System.out.println("==== 방어율 순위 ====");
        for (int i = 0; i < PitcherCount; i++) {
            System.out.println((i + 1) + ". " + pitchers[i].getName() + " - 타율: " + pitchers[i].getDefence());
        }
    }
    public void save() {
		File f = new File("d:\\tmp\\baseball_team.txt");
		
		String strLine[] = new String[players.length];
		
		for (int i = 0; i < players.length; i++) {
			if(players[i] != null && !players[i].getName().equals("")) {
				if(players[i] instanceof BatterDto) {
					BatterDto batter = (BatterDto) players[i];
					strLine[i] = batter.getName() + "-" + batter.getPosition() + "-" + batter.getAge() + "-" + batter.getHeight()+"-"
							+batter.getNumber() + "-" + batter.getBatcount()+ "-" + batter.getHit() + "-" + batter.getHivAvg();
				}
				else if (players[i] instanceof PitcherDto) {
					PitcherDto pitcher = (PitcherDto) players[i];
					strLine[i] = pitcher.getName() + "-" + pitcher.getPosition() + "-" + pitcher.getAge() + "-" +pitcher.getHeight()+"-"
							+pitcher.getNumber() + "-" + pitcher.getWin()+ "-" + pitcher.getLose() + "-" + pitcher.getDefence();
				}
							
			}else {
				strLine[i] = "";
			}
		}		
		
//		for (String s : strLine) {
//			System.out.println(s);
//		}
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			
			for (String s : strLine) {
				if(s != null && !s.equals("")) {
					pw.println(s);
				}
			}
			
			pw.close();			
		} catch (IOException e) {			
			System.out.println("파일에 저장되지 않았습니다");
			return;
		}		
		
		System.out.println("정상적으로 저장되었습니다");
	}
    public void load() {
        File f = new File("d:\\tmp\\baseball_team.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));

            String str;
            count = 0;
            while ((str = br.readLine()) != null) {
                String data[] = str.split("-");

                if (data.length == 8) { 
                    if (data[1].equals("타자")) {
                        BatterDto dto = new BatterDto();
                        dto.setName(data[0]);
                        dto.setPosition(data[1]);
                        dto.setAge(Integer.parseInt(data[2]));
                        dto.setHeight(Double.parseDouble(data[3]));
                        dto.setNumber(Integer.parseInt(data[4]));
                        dto.setBatcount(Integer.parseInt(data[5]));
                        dto.setHit(Integer.parseInt(data[6]));
                        dto.setHivAvg(Double.parseDouble(data[7]));

                        players[count] = dto;
                        count++;
                    } else if (data[1].equals("투수")) {
                        PitcherDto dto = new PitcherDto();
                        dto.setName(data[0]);
                        dto.setPosition(data[1]);
                        dto.setAge(Integer.parseInt(data[2]));
                        dto.setHeight(Double.parseDouble(data[3]));
                        dto.setNumber(Integer.parseInt(data[4]));
                        dto.setWin(Integer.parseInt(data[5]));
                        dto.setLose(Integer.parseInt(data[6]));
                        dto.setDefence(Double.parseDouble(data[7]));

                        players[count] = dto;
                        count++;
                    }
                }
            }

            br.close();
            System.out.println("파일을 불러왔습니다!!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("숫자 변환 오류 발생");
            e.printStackTrace();
        }

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void playerImpo(HumanDto human) {
        Scanner sc = new Scanner(System.in);
        System.out.print("선수 번호 : ");
        human.setNumber(sc.nextInt());
        System.out.print("선수 이름 : ");
        human.setName(sc.next());
        System.out.print("선수 나이 : ");
        human.setAge(sc.nextInt());
        System.out.print("선수 키 : ");
        human.setHeight(sc.nextDouble());
        System.out.print("선수 포지션 : ");
        human.setPosition(sc.next());
    }
    private void playerimpdel(HumanDto human) {
        human.setName("");
        human.setAge(0);
        human.setHeight(0.0);
        human.setNumber(0);
        human.setPosition("");
    }
    private void printBatter(BatterDto batter) {
    	
        System.out.print("이름: " + batter.getName() + " ");
        System.out.print("나이: " + batter.getAge()+ " ");
        System.out.print("키: " + batter.getHeight()+ " ");
        System.out.print("번호: " + batter.getNumber()+ " ");
        System.out.print("포지션: " + batter.getPosition()+ " ");
        System.out.print("타점: " + batter.getBatcount()+ " ");
        System.out.print("안타수: " + batter.getHit()+ " ");
        System.out.println("타율: " + batter.getHivAvg());
    }

    private void printPitcher(PitcherDto pitcher) {
        
        System.out.print("이름: " + pitcher.getName()+ " ");
        System.out.print("나이: " + pitcher.getAge()+ " ");
        System.out.print("키: " + pitcher.getHeight()+ " ");
        System.out.print("번호: " + pitcher.getNumber()+ " ");
        System.out.print("포지션: " + pitcher.getPosition()+ " ");
        System.out.print("승: " + pitcher.getWin()+ " ");
        System.out.print("패: " + pitcher.getLose()+ " ");
        System.out.println("방어율: " + pitcher.getDefence());
    }
}