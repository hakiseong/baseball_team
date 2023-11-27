package baseball;

public class PitcherDto extends HumanDto {
	
	@Override
	public String toString() {
		return "PitcherDto [win=" + win + ", lose=" + lose + ", defence=" + defence + "]";
	}
	
	private int win;
	private int lose;
	private double defence;
	
	
	public PitcherDto() {
		
	}
	
	public PitcherDto(int win, int lose, double defence) {
		super();
		this.win = win;
		this.lose = lose;
		this.defence = defence;
	}



	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public double getDefence() {
		return defence;
	}
	public void setDefence(double defence) {
		this.defence = defence;
	}
	
	

	
}
