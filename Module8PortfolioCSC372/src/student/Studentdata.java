package student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Studentdata {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		LinkedList<Student> students = new LinkedList<Student>();
		while (true) {
			System.out.print("Enter student name: ");
			String name = in.nextLine();
			if (name.equalsIgnoreCase("done")) {
				break;
			}

			System.out.print("Enter student address: ");
			String address = in.nextLine();

			double gpa = 0;
			while (true) {
				System.out.print("Enter student GPA: ");
				try {
					gpa = Double.parseDouble(in.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("GPA needs to be a number! ");
					continue;
				}

				if (gpa < 0 || gpa > 4) {
					System.out.print("GPA needs to be between 0 and 4! ");
					continue;

				}

				break;
			}
			Student student = new Student(name, address, gpa);
			students.add(student);

			Collections.sort(students, Comparator.comparing(Student::getName));
		}

		try

		{
			BufferedWriter file = new BufferedWriter(new FileWriter("students9.txt"));
			for (Student student : students) {
				file.write(student + "");
				file.newLine();
				System.out.println(student.getName() + "," + student.getAddress() + "," + student.getGpa());

			}

			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Student data has been written to students9.txt");

		in.close();
	}

}
