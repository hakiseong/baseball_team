package baseball;

public class BatterDto extends HumanDto {

	
	
	@Override
	public String toString() {
		return "BatterDto [batcount=" + batcount + ", hit=" + hit + ", hivAvg=" + hivAvg + "]";
	}
	
	private int batcount;
	private int hit;
	private double hivAvg;
	
	public BatterDto() {
		
	}
	public BatterDto(int batcount, int hit, double hivAvg) {
		super();
		this.batcount = batcount;
		this.hit = hit;
		this.hivAvg = hivAvg;
	}




	public int getBatcount() {
		return batcount;
	}
	public void setBatcount(int batcount) {
		this.batcount = batcount;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public double getHivAvg() {
		return hivAvg;
	}
	public void setHivAvg(double hivAvg) {
		this.hivAvg = hivAvg;
	}
	
	
	
	
	
}
