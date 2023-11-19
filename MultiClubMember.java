public class MultiClubMember extends Member {
	private int membershipPoints;

	public MultiClubMember (char type, int id, String name, double fees, int points) {
		super(type, id, name, fees);
		membershipPoints = points;
	}

	public int getPoints () {
		return membershipPoints;
	}

	public void setPoints (int points) {
		membershipPoints = points;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + membershipPoints;
	}
}