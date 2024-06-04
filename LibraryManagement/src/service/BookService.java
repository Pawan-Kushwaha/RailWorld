package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.BookDao;
import dao.StudentDao;
import dto.Book;
import dto.BookingDetails;
import login.LoginService;

public class BookService {
	Scanner sc = new Scanner(System.in);

	public void searchBySrNo(Connection conn) throws SQLException {
		System.out.println("\t\tEnter Serial No of Book:");
		int srNo = sc.nextInt();

		BookDao dao = new BookDao();
		Book book = dao.getBooksBySrno(conn, srNo);

		if (book != null) {
			System.out.println("======= Book Details ======");
			System.out.println("\t\t+----------------+----------------------+--------------------+--------------+");
			System.out.println("\t\t|   Book ID      |      Book Name       |    Author Name     |   Quantity   |");
			System.out.println("\t\t+----------------+----------------------+--------------------+--------------+");
			System.out.printf("\t\t|   %-10s   |   %-16s   |   %-14s   |   %-8s   | \n", book.getSrNo(), book.getBookName(),
					book.getAuthorName(), book.getBookQty());
			System.out.println("\t\t+----------------+----------------------+--------------------+--------------+");
		} else {
			System.out.println("\t\tNo Book for Serial No " + srNo + " Found.");
		}
	}

	public void searchByAuthorName(Connection conn) throws SQLException {
		System.out.println("\t\tEnter Author Name:");

		String authorName = sc.nextLine();

		BookDao dao = new BookDao();
		Book book = dao.getBooksByAuthorName(conn, authorName);

		if (book != null) {
			System.out.println("====== Book Details ======");
			System.out.println("\t\t+----------------+----------------------+--------------------+--------------+");
			System.out.println("\t\t|   Book ID      |      Book Name       |    Author Name     |   Quantity   |");
			System.out.println("\t\t+----------------+----------------------+--------------------+--------------+");
			System.out.printf("\t\t|   %-10s   |   %-16s   |   %-14s   |   %-8s   | \n", book.getSrNo(), book.getBookName(),
					book.getAuthorName(), book.getBookQty());
			System.out.println("\t\t+----------------+----------------------+--------------------+--------------+");
		} else {
			System.out.println("\t\tNo Book for Author Name " + authorName + " Found.");
		}
	}

	public void addBook(Connection conn) throws SQLException {
		System.out.println("\t\tEnter Serial No of Book:");
		int srNo = sc.nextInt();
		sc.nextLine();

		System.out.println("\t\tEnter Book Name:");
		String bookName = sc.nextLine();

		System.out.println("\t\tEnter Author Name:");
		String authorName = sc.nextLine();

		System.out.println("\t\tEnter Quantity of Books:");
		int qty = sc.nextInt();

		BookDao dao = new BookDao();
		Book book = dao.getBooksBySnoOrBookName(conn, authorName, srNo);

		if (book != null) {
			System.out.println("\t\tBook details exist into our system. Please save with other book.");
			return;
		}

		Book input = new Book();
		input.setAuthorName(authorName);
		input.setBookName(bookName);
		input.setBookQty(qty);
		input.setSrNo(srNo);

		dao.saveBook(conn, input);
	}

	public void getAllBooks(Connection conn) throws SQLException {
		BookDao dao = new BookDao();
		List<Book> books = dao.getAllBooks(conn);

		System.out.println("\t\t+----------------+----------------------+--------------------+--------------+");
		System.out.println("\t\t|   Book ID      |      Book Name       |    Author Name     |   Quantity   |");
		System.out.println("\t\t+----------------+----------------------+--------------------+--------------+");

		for (Book book : books) {
			System.out.printf("\t\t|   %-10s   |   %-16s   |   %-14s   |   %-8s   | \n", book.getSrNo(), book.getBookName(),
					book.getAuthorName(), book.getBookQty());
			System.out.println("\t\t+----------------+----------------------+--------------------+--------------+");
		}
	}

	public void updateBookQty(Connection conn) throws SQLException {
		System.out.println("\t\tEnter Serial No of Book:");
		int srNo = sc.nextInt();

		BookDao dao = new BookDao();
		Book book = dao.getBooksBySrno(conn, srNo);

		if (book == null) {
			System.out.println("\t\tBook not available.");
			return;
		}

		System.out.println("\t\tEnter No of Books to be Added:");
		int qty = sc.nextInt();

		Book input = new Book();
		input.setBookQty(book.getBookQty() + qty);
		input.setSrNo(srNo);

		dao.updateBookQty(conn, input);
	}

	public void checkOutBook(Connection conn) throws SQLException {
		StudentDao dao = new StudentDao();

		System.out.println("\t\tEnter Reg Number:");
		String regNum = sc.nextLine();

		boolean isExist = dao.getStudentByRegno(conn, regNum);



		if (!isExist) {
			System.out.println("\t\nStudent is not Registered. Please Registered Your ID.\n\n");
			return;
		}

		getAllBooks(conn);

		System.out.println("\t\tEnter Serial No of Book to be Checked Out.");
		int sNo = sc.nextInt();

		BookDao bookDao = new BookDao();
		Book book = bookDao.getBooksBySrno(conn, sNo);

		if (book == null) {
			System.out.println("\t\tBook is not available.");
			return;
		}

		book.setBookQty(book.getBookQty() - 1);

		int id = dao.getStudentByRegno_(conn, regNum);

		dao.saveBookingDetails(conn, id, book.getId(), 1);
		bookDao.updateBookQty(conn, book);
	}

	public  void getBbookingStatus(Connection conn) throws SQLException, ClassNotFoundException {
		BookingDetails bookingDetails = new BookingDetails();
		BookDao book = new BookDao();
		List<BookingDetails> bookArray = book.getAllStatus(conn);

		System.out.println("\t\t+----------------+--------------+---------------+----------------------+----------------+");
		System.out.println("\t\t|   Student ID   |    Book ID   |    Quantity   |     Rec. Date        |   Return Date  |");
		System.out.println("\t\t+----------------+--------------+---------------+----------------------+----------------+");

		for (BookingDetails bookingDetails1 : bookArray) {
			System.out.printf("\t\t|   %-10s   |   %-8s   |   %-9s   |   %-16s   |   %-7s   |\n", bookingDetails1.getStdId(),
					bookingDetails1.getBookId(),bookingDetails1.getQty(),bookingDetails1.getDate(), bookingDetails1.getrDate());
			System.out.println("\t\t+----------------+--------------+---------------+----------------------+----------------+");
		}
		LoginService loginService = new LoginService();
		loginService.displayAdminMenu(conn);
	}
	public void checkInBook(Connection conn) throws SQLException {
		StudentDao dao = new StudentDao();

		System.out.println("\t\tEnter Reg Number:");
		String regNum = sc.nextLine();

		boolean isExist = dao.getStudentByRegno(conn, regNum);

		if (!isExist) {
			System.out.println("\t\tStudent is not Registered. Get Registered First.");
			return;
		}
		
		int id = dao.getStudentByRegno_(conn, regNum);
		List<BookingDetails> bookingDetails = dao.getBookDetailsId(conn, id);
		System.out.println("\t\t+----------------+-------------------+------------+--------------------+-----------------+");
		System.out.println("\t\t|   Book ID      |      Book Name    |    Name    |     Rec. Date      |   Return Date   |");
		System.out.println("\t\t+----------------+-------------------+------------+--------------------+-----------------+");

		bookingDetails.stream().forEach(b -> System.out.println("|\t" +b.srNo + "\t\t\t\t" + b.bookName + "\t\t\t\t" + b.authorName+ "\t\t\t"
				+b.date+ "\t\t\t" +b.rDate+ "\t |\n+----------------+-------------------+------------+--------------------+-----------------+"));
		
		System.out.println("\t\tEnter Serial Number of Book to be Checked In:");
		int sNo = sc.nextInt();
		
		BookingDetails filterDetails = bookingDetails.stream().filter(b -> b.getSrNo() == sNo).findAny().orElse(null);
		
		BookDao bookDao = new BookDao();
		Book book = bookDao.getBooksBySrno(conn, sNo);
		book.setBookQty(book.getBookQty() + 1);
		
		bookDao.updateBookQty(conn, book);;
		dao.deleteBookingDetails(conn, filterDetails.getId());
		
	}
}
