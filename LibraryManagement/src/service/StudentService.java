package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import dao.BookDao;
import dao.StudentDao;
import dto.Book;

public class StudentService {
	Scanner sc = new Scanner(System.in);

	public void addStudent(Connection conn) throws SQLException {
		System.out.println("\t\tEnter Student Name:");
		String studentName = sc.nextLine();

		System.out.println("\t\tEnter Registration No:");
		String regNo = sc.nextLine();

		StudentDao dao = new StudentDao();
		boolean isStdExist = dao.getStudentByRegno(conn, regNo);

		if (isStdExist) {
			System.out.println("\t\tStudents details exist into our system.");
			return;
		}

		dao.saveStudent(conn, studentName, regNo);
	}

	public void getAllStudents(Connection conn) throws SQLException {
		StudentDao dao = new StudentDao();
		dao.getAllStudents(conn);
	}

}
