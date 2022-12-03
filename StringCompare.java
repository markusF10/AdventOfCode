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
				sum = getEqual(line, sum);
			}
			System.out.println(sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int getEqual(String line, int sum) {
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
		int s;
		if (Character.isLowerCase(c1[counter - 1])) {
			s = c1[counter - 1] % 96;
		} else {
			s = c1[counter - 1] % 64 + 26;
		}
		sum += s;
		return sum;
	}
}
