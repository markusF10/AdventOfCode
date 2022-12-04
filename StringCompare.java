package day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class StringCompare {
	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader("day3Input.txt"));
//		BufferedReader br = new BufferedReader(new FileReader("day3Bsp.txt"));
		try {
			String line;
			int sum = 0;
			while ((line = br.readLine()) != null) {
				char equal = getEqualChar(line);
				int s = charToPuzzleNumber(equal);
				sum += s;
			}
			System.out.println(sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public static char getEqualChar(String line) {
		boolean notFound = true;
		int counter = 0;
		char[] c1 = new char[line.length() / 2];
		char[] c2 = new char[line.length() / 2];
		while (counter < line.length() / 2) {
			c1[counter] = line.charAt(counter);
			counter++;
		}
		counter = 0;
		while (counter < line.length() / 2) {
			c2[counter] = line.charAt(counter + line.length() / 2);
			counter++;
		}
		counter = 0;
		while (notFound == true) {
			int j = 0;
			while (j < c2.length) {
				if (c1[counter] == c2[j])
					notFound = false;
				j++;
			}
			counter++;
		}
		char equal = c1[counter - 1];
		return equal;
	}
}
