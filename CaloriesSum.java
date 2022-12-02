package day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CaloriesSum {
	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
//		BufferedReader br = new BufferedReader(new FileReader("bsp.txt"));
		try {
			String line;
			int sum = 0;
			int max = 0;
			int max2 = 0;
			int max3 = 0;
			int result = 0;

			while ((line = br.readLine()) != null) {
				while (line != null && !line.isBlank()) {
					sum = sum + Integer.parseInt(line);
					line = br.readLine();
				}
				if (sum > max3) {
					max = max2;
					max2 = max3;
					max3 = sum;
				} else if (sum > max2 && sum < max3) {
					max = max2;
					max2 = sum;
				} else if (sum > max && sum < max2 && sum < max3)
					max = sum;
				sum = 0;
			}
			result = max + max2 + max3;
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
