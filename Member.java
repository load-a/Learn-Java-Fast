public class Member {

	private char memberType;
	private int memberID;
	private String memberName;
	private double membershipFees;

	public Member (char type, int id, String name, Double fees) {
		memberType = type;
		memberID = id;
		memberName = name; 
		membershipFees = fees;
	}

	public char getType () {
		return memberType;
	}
	public int getID () {
		return memberID;
	}
	public String getName () {
		return memberName;
	}
	public double getFees () {
		return membershipFees;
	}

	public void setType (char type) {
		memberType = type;
	}
	public void setID (int id) {
		memberID = id;
	}
	public void setName (String name) {
		memberName = name;
	}
	public void setFees (double fees) {
		membershipFees = fees;
	}

	@Override
	public String toString () {
		return memberType + ", " + memberID + ", " + memberName + ", " + membershipFees;
	}
//
}