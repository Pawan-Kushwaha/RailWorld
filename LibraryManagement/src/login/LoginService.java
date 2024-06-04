package login;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import Main.MainClass;
import dao.DatabaseService;
import dao.LoginDao;
import service.BookService;
import service.StudentService;

public class LoginService {
	Scanner sc = new Scanner(System.in);
	MainClass mainClass = new MainClass();
	public void doLoginAdmin() throws ClassNotFoundException, SQLException {

		System.out.println("\t\tPlease Enter The UserName Of Admin:");
		String userName = sc.nextLine();

		System.out.println("\t\tPlease Enter The Password Of Admin:");
		String password = sc.nextLine();

		try (Connection conn = DatabaseService.getConnection()) {
			LoginDao loginDao = new LoginDao();
			String userType = loginDao.doLogin(conn, userName, password);

			if (userType == null) {
				System.out.println("\t\tInvalid user!");
				System.out.println("\t\tPlease try Again.");

				mainClass.run();
			}

			System.out.println("\n\n\t\t----Login Success----\n\n\t\tYou logged in as a " + userType + "\n");

			if (userType.equals("admin")) {
				displayAdminMenu(conn);
			} else {
				System.out.println("\t\tInvalid ID Password :");
				System.out.println("\t\tPlease try Again.");
				doLoginAdmin();
			}
		}
	}
		public void doLoginUser() throws ClassNotFoundException, SQLException {
			System.out.println("\t\tPlease Enter  UserName Of Student :");
			String userName = sc.nextLine();

			System.out.println("\t\tPlease Enter  Password Of Student:");
			String password = sc.nextLine();

			try (Connection conn = DatabaseService.getConnection()) {
				LoginDao loginDao = new LoginDao();
				String userType = loginDao.doLogin(conn, userName, password);

				if (userType == null) {
					System.out.println("\t\tInvalid user!");
					System.out.println("\t\tPlease try Again.");
					mainClass.run();
				}

				System.out
						.println("\n\n\t\t----Login Success---- \n\nYou logged in as a" + userType + "\n");

				if (userType.equals("student")) {
					// display admin related menu
					displayStudentMenu(conn);
				} else {
					System.out.println("\t\tInvalid ID Password :");
					System.out.println("\t\tPlease Try Again.");
					doLoginUser();
						}
			}

	}

	public void displayAdminMenu(Connection conn) throws SQLException, ClassNotFoundException {
		LoginService loginService = new LoginService();
		int choice;
		BookService bookService = new BookService();
		StudentService studentService = new StudentService();

		do {
			System.out.println("========================================");
			System.out.println("\t\t 1. Search a Book.");
			System.out.println("\t\t 2. Add new Book.");
			System.out.println("\t\t 3. Upgrade Quantity of a Book.");
			System.out.println("\t\t 4. Show All Books.");
			System.out.println("\t\t 5. Register Student.");
			System.out.println("\t\t 6. Show All Registered Students.");
			System.out.println("\t\t 7. Booking Status.");
			System.out.println("\t\t 8. Back to Home.");
			System.out.println("\t\t 9. Log Out.");
			System.out.println("\t\t 10. Exit From Application.");
			System.out.println("========================================");

			System.out.println("\t\tPlease Enter your choice.");

			choice = sc.nextInt();

			switch (choice) {
			case 1:
				searchBook(conn);
				break;
			case 2:
				bookService.addBook(conn);
				break;
			case 3:
				bookService.updateBookQty(conn);
				break;
			case 4:
				bookService.getAllBooks(conn);
				break;
			case 5:
				studentService.addStudent(conn);
				break;
			case 6:
				studentService.getAllStudents(conn);
				break;
				case 7:
					bookService.getBbookingStatus(conn);
					break;
				case 8:
					loginService.doLoginAdmin();
					break;
				case 9:
					mainClass.run();
					break;
			case 10:
				System.out.println("\t\tThank You for using Library Management System.");
				System.exit(0);
				break;
			default:
				System.out.println("\t\tPlease select valid option.");
			}

		} while (choice != 7);
	}
	
	public void displayStudentMenu(Connection conn) throws SQLException, ClassNotFoundException {
		LoginService loginService = new LoginService();
		int choice;
		BookService bookService = new BookService();
		StudentService studentService = new StudentService();

		do {
			System.out.println("========================================");
			System.out.println("\t\t 1. Create Account.");
			System.out.println(" \t\t2. Search a Book.");
			System.out.println(" \t\t3. Check out Book.");
			System.out.println(" \t\t4. Check in Book.");
			System.out.println(" \t\t5. Back to Home.");
			System.out.println(" \t\t6. Log Out.");
			System.out.println(" \t\t7. Exit From Application.");
			System.out.println("========================================");

			System.out.println("\t\tPlease Enter your choice.");

			choice = sc.nextInt();

			switch (choice) {
				case 1:
					studentService.addStudent(conn);
					break;
			case 2:
				searchBook(conn);
				break;
			case 3:
				bookService.checkOutBook(conn);
				break;
			case 4:
				bookService.checkInBook(conn);
				break;
				case	5:
					loginService.doLoginUser();
					break;
				case 6:
					mainClass.run();
					break;
			case 7:
				System.out.println("\t\tThank You for using Library Management System.");
				System.exit(0);
				break;
			default:
				System.out.println("\t\tPlease select valid option.");
			}

		}
		while (choice != 6);
	}
	
	private void searchBook(Connection conn) throws SQLException {
		BookService bookService = new BookService();
		System.out.println("\t\t 1. Search with Book Serial No.");
		System.out.println("\t\t 2. Search with Book's Author Name.");
		
		System.out.println("\t\tPlease Enter your choice.");
		
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1: 
			bookService.searchBySrNo(conn);
			break;
		case 2:
			bookService.searchByAuthorName(conn);
		}
	}
}
