package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OverlappingOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("day4PartOneInput.txt"));
//		BufferedReader br = new BufferedReader(new FileReader("day4PartOneBsp.txt"));
		try {
			String line;
			int sum = 0;
			while ((line = br.readLine()) != null) {
				String[] buffer = line.split(",");
				String[] first = buffer[0].split("-");
				String[] second = buffer[1].split("-");
				int firstStart = Integer.parseInt(first[0]);
				int firstEnd = Integer.parseInt(first[1]);
				int secondStart = Integer.parseInt(second[0]);
				int secondEnd = Integer.parseInt(second[1]);
				if ((firstStart >= secondStart && firstStart <= secondEnd)) {
					sum++;
				} else if ((firstStart <= secondStart && firstEnd >= secondStart))
					sum++;
				System.out.println(sum);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		br.close();
	}
}
