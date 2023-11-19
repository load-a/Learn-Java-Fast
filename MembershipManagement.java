import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {
	final private Scanner reader = new Scanner(System.in);

	private int getIntInput() {
		int choice = 0;

		System.out.print("Enter an integer: ");
		while (choice == 0) {
			try {
				choice = reader.nextInt();

				if (choice == 0) {
					throw new InputMismatchException();
				}
				reader.nextLine();

			} catch (InputMismatchException e) {
				reader.nextLine();
				System.out.print("\nError: Invalid input. \nPlease enter an integer: ");
			}
		}
		return choice;
	}

	private void printClubOptions () {
		System.out.print("\n1) Club Mercury \n2) Club Neptune \n3) Club Jupiter \n4) Multi Clubs\n");
	}

	public int getChoice () {
		int choice;

		System.out.println("\nWELCOME TO OZONE FITNESS CENTER");
		System.out.println("===============================");
		System.out.println("1) Add Member");
		System.out.println("2) Remove Member");
		System.out.println("3) Display Member Information\n");
		System.out.print("Please select an option (or enter -1 to quit): ");

		choice = getIntInput();
		return choice;
	}

	public String addMembers (LinkedList<Member> list) {
		String name;
		int club;
		String memberString;
		double fees;
		int memberID;
		Member member;
		Calculator<Integer> cal;

		System.out.println("\nNew Member name: ");
		name = reader.nextLine();

		printClubOptions();
		club = getIntInput();

		while (club < 1 || club > 4) {
			System.out.println("Club value is invalid. \nPlease enter a club code: ");
			club = getIntInput();
		}

		if (list.size() > 0) {
			memberID = list.getLast().getID() + 1;
		} else {
			memberID = 1; 
		}

		if (club != 4) {
			cal = (clubNum) -> {
				return switch (clubNum) {
				case 1 -> 900;
				case 2 -> 950;
				case 3 -> 1000; 
				default -> -1;
				};
			};
			fees = cal.calculateFees(club);
			member = new SingleClubMember('S', memberID, name, fees, club);
			list.add(member);
			memberString = member.toString();
			System.out.println("\nStatus: Single Club Member added.");
		} else {
			cal = (clubNum) -> {
				if (clubNum == 4) {
					return 1200;
				} else {
					return -1;
				}
			};
			fees = cal.calculateFees(club);
			member = new MultiClubMember('M', memberID, name, fees, 100);
			list.add(member);
			memberString = member.toString();
			System.out.println("\nStatus: Multi Club Member added.");
		}
		return memberString;
	}

	public void removeMember(LinkedList<Member> list) {
		int memberID;

		System.out.print("Please enter member ID: ");
		memberID = getIntInput();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getID() == memberID) {
				list.remove(i);
				System.out.println("\nMember has been removed.");
				return;
			} else {
			System.out.println("\nMember ID not found.");
			}
		}
	}

	public void printMemberInfo (LinkedList<Member> list) {
		int memberID; 
		String memberString;
		String[] memberInfo;

		System.out.print("Please enter member ID: ");
		memberID = getIntInput();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getID() == memberID) {

				memberString = list.get(i).toString();
				memberInfo = memberString.split(", ");

				if (memberInfo[0] == "S") {
					System.out.println("\nMember Type: " + memberInfo[0] + "\nMember ID: " + memberInfo[1] + "\nMember Name: " + memberInfo[2] + "\nMembership Fees: " + memberInfo[3] + "\nClub ID: " + memberInfo[4]);
				} else {
					System.out.println("\nMember Type: " + memberInfo[0] + "\nMember ID: " + memberInfo[1] + "\nMember Name: " + memberInfo[2] + "\nMembership Fees: " + memberInfo[3] + "\nMembership Points: " + memberInfo[4]);
				}
				return;
			} else {
				System.out.println("\nMember ID not found.");
			}
		}
	}
}
