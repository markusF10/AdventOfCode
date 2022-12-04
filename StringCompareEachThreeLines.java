package day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class StringCompareEachThreeLines {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("day3Input.txt"));
//		BufferedReader br = new BufferedReader(new FileReader("day3Bsp.txt"));
		try {
			String line;
			int sum = 0;
			while ((line = br.readLine()) != null) {

				char[] c1 = line.toCharArray();
				line = br.readLine();
				char[] c2 = line.toCharArray();
				line = br.readLine();
				char[] c3 = line.toCharArray();
				char equal = getEqualChar(c1, c2, c3);
				int s = charToPuzzleNumber(equal);
				sum += s;
			}
			System.out.println(sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
		br.close();
	}

	public static int charToPuzzleNumber(char equal) {
		int s;
		if (Character.isLowerCase(equal)) {
			s = equal % 96;
		} else {
			s = equal % 64 + 26;
		}
		return s;
	}

	public static char getEqualChar(char[] c1, char[] c2, char[] c3) {
		int counter = 0;
		int i = 0;
		boolean notFound = true;
		char[] buffer = new char[1000];
		while (counter < c1.length) {
			int j = 0;

			while (j < c2.length) {
				if (c1[counter] == c2[j]) {
					buffer[i] = c1[counter];
					i++;
				}
				j++;
			}
			counter++;
		}
		counter = 0;
		while (notFound) {
			int j = 0;
			while (j < c3.length) {
				if (buffer[counter] == c3[j]) {
					notFound = false;
				}
				j++;
			}
			counter++;
		}
		char equal = buffer[counter - 1];
		return equal;
	}
}
