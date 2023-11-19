public class SingleClubMember extends Member {
	private int memberClub;

	public SingleClubMember (char type, int id, String name, double fees, int club) {
		super(type, id, name, fees);
		memberClub = club;
	}

	public int getClub () {
		return memberClub;
	}

	public void setClub (int club) {
		memberClub = club;
	}

	@Override
	public String toString () {
		return super.toString() + ", " + memberClub;
	}
//
}