package bLogic;

public class bookCheck {

	private int BID;
	private int FID;
	private int CID;
	
	public int getBID() {
		return BID;
	}
	public int getFID() {
		return FID;
	}
	public int getCID() {
		return CID;
	}
public void check(int BID,int FID, int CID) {
		
		this.BID = BID;
		this.FID = FID;
		this.CID = CID;
		
	}
}
