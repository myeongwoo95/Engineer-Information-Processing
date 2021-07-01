package VO;

public class Tbl_rankVO {
	private String artist_id;
	private String artist_name;
	private String artist_gender;
	private int sum;
	private double avg;
	private int rank;
	
	
	public String getArtist_id() {
		return artist_id;
	}
	public void setArtist_id(String artist_id) {
		this.artist_id = artist_id;
	}
	public String getArtist_name() {
		return artist_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	public String getArtist_gender() {
		return artist_gender;
	}
	public void setArtist_gender(String artist_gender) {
		this.artist_gender = artist_gender;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
}
