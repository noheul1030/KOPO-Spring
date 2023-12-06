package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test1 {
	public static void main(String[] args) {
		int num = 100;

		for (int i = 1; i <= num; i++) {
			writeCSV(i);
		}
		System.out.println("- Test Complete -");
	}

	public static void writeCSV(int create) {
		File csv = new File("C:\\Users\\USER\\Desktop\\Test\\BackupTest " + create + ".txt");
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(csv, true));

			String data = "test" + create + " File.";
			
			bw.write(data);
			bw.newLine();
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("File create success " + create);
		}
	}
}
