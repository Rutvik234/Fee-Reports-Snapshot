package FeeReports;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolManagementSystem extends Student {

	public SchoolManagementSystem(int id, String firstName, String lastName, String email, String course, double fee,
			double paid, double due, String address, String city, String state, String country, long contactNumber) {
		super(id, firstName, lastName, email, course, fee, paid, due, address, city, state, country, contactNumber);
	}

	private static List<Accountant> accountants = new ArrayList<>();
	private static List<Student> students = new ArrayList<>();
	private static int accountantIdCounter = 1; // To generate unique accountant IDs
	private static int studentIdCounter = 1; // To generate unique student IDs
	private static Accountant loggedInAccountant = null;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to School Management System!");

		feeReport(scanner);

	}

	private static void feeReport(Scanner scanner) {
		while (true) {

			System.out.println("\n1: Admin login");
			System.out.println("2: Accountant login");
			System.out.println("3: Exit");

			int key = scanner.nextInt();

			switch (key) {
			case 1: {
				adminLogin(scanner);
				break;
			}
			case 2: {
				accountantLogin(scanner);
				break;
			}
			case 3: {
				System.out.println("Thanks for visiting...");
				scanner.close();
				System.exit(0);
			}
			default:
				System.err.println("Nops... Enter invalid Credential!!");
			}
		}
	}

	private static void adminLogin(Scanner scanner) {
		System.out.println("Name is: admin");
		System.out.println("Password is: admin123");

		System.out.print("Enter Name: ");
		String name = scanner.next();

		System.out.print("Enter Password: ");
		String password = scanner.next();

		if (name.equals("admin") && password.equals("admin123")) {
			adminSection(scanner);
		} else {
			System.err.println("\n" + "Worng Admin Name or Password" + "\n" + "plz try again..." + "\n");
			adminLogin(scanner);
		}
	}

	private static void adminSection(Scanner scanner) {

		System.out.println("\n1: Add Accountant");
		System.out.println("2: View Accountant");
		System.out.println("3: Logout");

		int key = scanner.nextInt();
		switch (key) {

		case 1: {
			addAccountant(scanner);
			break;
		}
		case 2: {
			viewAccountants();
			adminSection(scanner);
			break;
		}
		case 3: {
			System.out.println("Logout Successfull...\n");
			feeReport(scanner);
		}
		default:
			System.err.println("\n" + "Invalid Choice !!! " + key + "\n");
			break;
		}

	}

	private static void addAccountant(Scanner scanner) {
		System.out.println("\nAdding Accountant...");
		System.out.print("Enter first name: ");
		String firstName = scanner.next();

		System.out.print("Enter last name: ");
		String lastName = scanner.next();

		System.out.print("Enter password: ");
		String password = scanner.next();

		System.out.print("Enter email: ");
		String email = scanner.next();

		System.out.print("Enter contact number: ");
		long contactNumber = scanner.nextLong();

		// Generate unique ID for the accountant
		int id = accountantIdCounter++;

		Accountant newAccountant = new Accountant(id, firstName, lastName, password, email, contactNumber);
		accountants.add(newAccountant);

		System.out.println("Accountant added successfully!");
		System.out.println("Generated Accountant ID: " + id);

		adminSection(scanner);
	}

	private static void viewAccountants() {
		System.out.println("\nViewing Accountants...");
		if (accountants.isEmpty()) {
			System.err.println("No accountants in the system.");
		} else {
			System.out.println("Accountants:");
			for (Accountant accountant : accountants) {
				System.out.println(accountant);
			}
		}
	}

	private static void addStudent(Scanner scanner) {
		System.out.println("\nAdding Student...");
		System.out.print("Enter first name: ");
		String firstName = scanner.next();

		System.out.print("Enter last name: ");
		String lastName = scanner.next();

		System.out.print("Enter email: ");
		String email = scanner.next();

		System.out.print("Enter course: ");
		String course = scanner.next();

		System.out.print("Enter fee: ");
		double fee = scanner.nextDouble();

		System.out.print("Enter amount paid: ");
		double paid = scanner.nextDouble();

		double due = fee - paid;

		scanner.nextLine(); // Consume newline

		System.out.print("Enter address: ");
		String address = scanner.nextLine();

		System.out.print("Enter city: ");
		String city = scanner.nextLine();

		System.out.print("Enter state: ");
		String state = scanner.nextLine();

		System.out.print("Enter country: ");
		String country = scanner.nextLine();

		System.out.print("Enter contact number: ");
		long contactNumber = scanner.nextLong();

		// Generate unique ID for the student
		int id = studentIdCounter++;

		Student newStudent = new Student(id, firstName, lastName, email, course, fee, paid, due, address, city, state,
				country, contactNumber);
		students.add(newStudent);

		System.out.println("Student added successfully!");
		System.out.println("Generated Student ID: " + id);
	}

	private static void viewStudents() {
		System.out.println("\nViewing Students...");
		if (students.isEmpty()) {
			System.err.println("No students in the system.");
		} else {
			System.out.println("Students:");
			for (Student student : students) {
				System.out.println(student);
			}
		}
	}

	private static void editStudent(Scanner scanner) {
		System.out.println("\nUpdate Student...");
		System.out.print("Enter student ID to edit: ");
		int idToEdit = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		boolean found = false;
		for (Student student : students) {
			if (student.getId() == idToEdit) {
				found = true;
				System.out.println("Enter new details for student ID " + idToEdit + ":");

				System.out.print("Enter first name: ");
				String firstName = scanner.next();

				System.out.print("Enter last name: ");
				String lastName = scanner.next();

				System.out.print("Enter email: ");
				String email = scanner.next();

				System.out.print("Enter course: ");
				String course = scanner.next();

				System.out.print("Enter fee: ");
				double fee = scanner.nextDouble();

				System.out.print("Enter amount paid: ");
				double paid = scanner.nextDouble();

				double due = fee - paid;

				scanner.nextLine(); // Consume newline

				System.out.print("Enter address: ");
				String address = scanner.nextLine();

				System.out.print("Enter city: ");
				String city = scanner.nextLine();

				System.out.print("Enter state: ");
				String state = scanner.nextLine();

				System.out.print("Enter country: ");
				String country = scanner.nextLine();

				System.out.print("Enter contact number: ");
				long contactNumber = scanner.nextLong();

				// Update student details
				student.setFirstName(firstName);
				student.setLastName(lastName);
				student.setEmail(email);
				student.setCourse(course);
				student.setFee(fee);
				student.setPaid(paid);
				student.setDue(due);
				student.setAddress(address);
				student.setCity(city);
				student.setState(state);
				student.setCountry(country);
				student.setContactNumber(contactNumber);

				System.out.println("Student details updated successfully!");
				break;
			}
		}

		if (!found) {
			System.err.println("Student with ID " + idToEdit + " not found.");
		}
	}

	private static void viewStudentsWithDue() {
		System.out.println("\nViewing Students with Due Fees...");
		boolean found = false;
		for (Student student : students) {
			if (student.getDue() > 0) {
				found = true;
				System.out.println(student);
			}
		}
		if (!found) {
			System.out.println("No students with due fees.");
		}
	}

	private static void accountantLogin(Scanner scanner) {
		System.out.println("\nAccountant Login...");

		System.out.print("Enter email: ");
		String email = scanner.next();

		System.out.print("Enter password: ");
		String password = scanner.next();

		System.out.println(accountants);

		if (accountants.isEmpty()) {
			System.err.println("Enter email or password is not present... try again");
		} else {
			for (Accountant accountant : accountants) {
				if ((accountant.getEmail()).equals(email) && (accountant.getPassword()).equals(password)) {
					loggedInAccountant = accountant;
					System.out.println("Login successful! Welcome, " + loggedInAccountant.getFiestName() + ".");
					listForAllStudent(scanner);
				} else {
					System.err.println("Invalid email or password. Please try again.");
				}
			}
		}

	}

	private static void listForAllStudent(Scanner scanner) {

		System.out.println("\n1. Add Student");
		System.out.println("2. View Student");
		System.out.println("3. Update Student");
		System.out.println("4. Due Fee");
		System.out.println("5. Logout");

		int key = scanner.nextInt();

		switch (key) {

		case 1: {
			addStudent(scanner);
			listForAllStudent(scanner);
		}

		case 2: {
			viewStudents();
			listForAllStudent(scanner);
		}
		case 3: {
			editStudent(scanner);
			listForAllStudent(scanner);
		}
		case 4: {
			viewStudentsWithDue();
			listForAllStudent(scanner);
		}
		case 5: {
			System.out.println("Logout Successfull...");
			feeReport(scanner);
		}
		default:
			System.err.println("Nops... Enter Valid Number");
			accountantLogin(scanner);
		}

	}

// Accountant class

// Student class

}