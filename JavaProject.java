import java.util.LinkedList;

public class JavaProject {
	public static void main (String[] args) {
		String memberString;

		MembershipManagement memberManage = new MembershipManagement();
		FileHandler fileHandler = new FileHandler();
		LinkedList<Member> memberList = fileHandler.readFile();
		int choice = memberManage.getChoice();

		while (choice != -1) {
			switch (choice) {
			case 1:
				memberString = memberManage.addMembers(memberList); 
				fileHandler.appendFile(memberString);
				break;

			case 2:
				memberManage.removeMember(memberList); 
				fileHandler.overWriteFile(memberList);
				break;

			case 3:
				memberManage.printMemberInfo(memberList); 
				break;

			default:
				System.out.println("Error: Invalid Option.");
			}
			choice = memberManage.getChoice();
		}
		System.out.println("Goodbye.");
		//
	}
}