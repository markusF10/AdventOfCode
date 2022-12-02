package day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CaloriesMax {
	public static void main(String[] args) throws FileNotFoundException {
//		BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
		BufferedReader br = new BufferedReader(new FileReader("bsp.txt"));
		try {
			String line;
			int sum = 0;
			int max = 0;
			while ((line = br.readLine()) != null) {
				while (line != null && !line.isBlank()) {
					sum = sum + Integer.parseInt(line);
					line = br.readLine();
				}
				if (sum > max) {
					max = sum;
				}
				sum = 0;
			}
			System.out.println(max);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
