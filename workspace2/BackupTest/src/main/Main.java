package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Integer> list_x = new ArrayList<>();
		List<Integer> list_y = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			if (list_x.contains(x))
				list_x.remove(Integer.valueOf(x));
			else
				list_x.add(x);

			if (list_y.contains(y))
				list_y.remove(Integer.valueOf(y));
			else
				list_y.add(y);
		}
		sc.close();

		System.out.println(list_x.get(0) + " " + list_y.get(0));
	}
}
