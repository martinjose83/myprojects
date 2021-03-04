import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Read {
	private ArrayList<String> words = new ArrayList<>();
	private ArrayList<String> words1 = new ArrayList<>();
	private Set<String> words2 = new HashSet<>();
	String fileName;
	int count = 0, count1 = 0;
File file;
	public Read(File file) {
		this.file = file;
		//this.fileName = fileName;
		// ChooseFile();
		Long time1 = System.currentTimeMillis();
		ReadFile();
		SortUnique();
		Long time2 = System.currentTimeMillis();
		System.out.println("Time Using ArrayList " + (time2 - time1));
		Long time3 = System.currentTimeMillis();
		ReadFile1();
		SortUnique1();
		Long time4 = System.currentTimeMillis();
		System.out.println("Time Using HashSet " + (time4 - time3));
		Calculate();
	}

	public void ReadFile() {

		try {
			// System.out.println(fileName);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {

				String str1 = scanner.next().trim();

				words.add(str1);
				count++;
				// System.out.println(str1);

			}

			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.printf("Error loading file: %s%n", e);
		}
		System.out.println("Count " + count + " words using ArrayList");
	}

	public void SortUnique() {
		for (String str : words) {
			if (!words1.contains(str)) {
				words1.add(str);
				count1++;
				// System.out.println(str);
			}

		}
		System.out.println("Unique Words Using ArrayList :" + count1);
	}

	public void ReadFile1() {
		int count2 = 0;
		try {
			// System.out.println(fileName);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {

				String str1 = scanner.next().trim();

				words2.add(str1);
				count2++;
				// System.out.println(str1);

			}
			System.out.println("Count " + count2 + " words using ArrayList");
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.printf("Error loading file: %s%n", e);
		}

	}

	public void SortUnique1() {

		System.out.println("read using set " + words2.size());

	}

	public void Calculate() {
		long x = 3;
		System.out.println(x);
		long x1 = 12 * (100000 / 1000);
		System.out.println(x1);
		double x2 = 58 * ((100000*Math.log(100000) )/ (12000*(Math.log(12000))));
		System.out.println(x2);
	}

//	public static void main(String[] args) {
//		new Read();
//
//	}

}
