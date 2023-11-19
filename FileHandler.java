import java.util.LinkedList;
import java.io.*;

public class FileHandler {

	public LinkedList<Member> readFile () {
		LinkedList<Member> memberList = new LinkedList<>();
		String lineRead;
		String[] splitLine;
		Member member;

		try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {
			lineRead = reader.readLine();

			while (lineRead != null) {
				splitLine = lineRead.split(", ");

				if (splitLine[0].equals("S")) {
					member = new SingleClubMember('S', Integer.parseInt(splitLine[1]), splitLine[2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));

				} else {
					member = new MultiClubMember('M', Integer.parseInt(splitLine[1]), splitLine[2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
				}

				memberList.add(member);

				lineRead = reader.readLine();
			}

		} catch (IOException e) {
			System.out.println(e);
		}

		return memberList;
	}

	public void appendFile (String newMember) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.csv", true))) {
			writer.write(newMember += "\n");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void overWriteFile (LinkedList<Member> moddedList) {
		String line; 

		try (BufferedWriter overWriter = new BufferedWriter(new FileWriter("members.temp", false))) {
			for (int i = 0; i < moddedList.size(); i++) {
				line = moddedList.get(i).toString();
				overWriter.write(line + "\n");
			} 
		} catch (IOException e) {
			System.out.println(e);
		}

		try {
			File oldFile = new File("members.csv");
			File newFile = new File("members.temp");

			oldFile.delete();
			newFile.renameTo(oldFile);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}