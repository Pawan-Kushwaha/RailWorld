package Main;

import java.sql.SQLException;
import java.util.Scanner;

import login.LoginService;

public class MainClass {


	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MainClass mainClass = new MainClass();
		mainClass.run();
	}

	public void run() throws SQLException, ClassNotFoundException {
		System.out.println("\n******************* Welcome to the College Library! *******************");

		Scanner scanner = new Scanner(System.in);

		System.out.println("\n\t\t\t\t\t\t------ HOME PAGE ------ \n \n...................Please Chose The User Option No. ................... ");
		System.out.println("\n\t\t 1. Admin\t\t\t2. Student\t\t\t3. Exit" );

		int uNo = scanner.nextInt();
		LoginService loginService = new LoginService();

		switch (uNo) {
			case 1:
				loginService.doLoginAdmin();
				break;
			case 2:
				loginService.doLoginUser();
				break;
			case 3:
				System.out.println("\t\tThank You for using Library Management System.");
				System.exit(0);
			default:
				System.out.println("\t\tInvalid Choice Please Try Again.");
		}
	}
}