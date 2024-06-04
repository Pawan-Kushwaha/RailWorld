package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Book;
import dto.BookingDetails;

public class BookDao {


	public Book getBooksBySrno(Connection conn, int srNo) throws SQLException {
		String query = "select * from books where sr_no = ?";

		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, srNo);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Book book = new Book();
					book.setAuthorName(rs.getString("author_name"));
					book.setBookName(rs.getString("name"));
					book.setBookQty(rs.getInt("qty"));
					book.setId(rs.getInt("id"));
					book.setSrNo(rs.getInt("sr_no"));
					
					return book;
				}
			}
		}
		
		return null;
	}
	
	public Book getBooksByAuthorName(Connection conn, String authorName) throws SQLException {
		String query = "select * from books where author_name = ?";

		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, authorName);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Book book = new Book();
					book.setAuthorName(rs.getString("author_name"));
					book.setBookName(rs.getString("name"));
					book.setBookQty(rs.getInt("qty"));
					book.setId(rs.getInt("id"));
					book.setSrNo(rs.getInt("sr_no"));
					
					return book;
				}
			}
		}
		
		return null;
	}
	
	public Book getBooksBySnoOrBookName(Connection conn, String authorName, int srNo) throws SQLException {
		String query = "select * from books where author_name = ? or sr_no = ?";

		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, authorName);
			ps.setInt(2, srNo);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Book book = new Book();
					book.setAuthorName(rs.getString("author_name"));
					book.setBookName(rs.getString("name"));
					book.setBookQty(rs.getInt("qty"));
					book.setId(rs.getInt("id"));
					book.setSrNo(rs.getInt("sr_no"));
					return book;
				}
			}
		}
		
		return null;
	}
	
	public void saveBook(Connection conn, Book book) throws SQLException {
		String query = "insert into books (sr_no, name, author_name, qty) values (?, ?, ?, ?)";
		
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, book.getSrNo());
			ps.setString(2, book.getBookName());
			ps.setString(3, book.getAuthorName());
			ps.setInt(4, book.getBookQty());
			
			int rows = ps.executeUpdate();
			
			if (rows > 0) {
				System.out.println("Book added successfully.");
			} else {
				System.out.println("Failed to add book.");
			}
		}
	}
	
	public List<Book> getAllBooks(Connection conn) throws SQLException {
		String query = "select * from books";
		
		List<Book> books = new ArrayList<>();

		try (PreparedStatement ps = conn.prepareStatement(query)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Book book = new Book();
					book.setAuthorName(rs.getString("author_name"));
					book.setBookName(rs.getString("name"));
					book.setBookQty(rs.getInt("qty"));
					book.setId(rs.getInt("id"));
					book.setSrNo(rs.getInt("sr_no"));
					
					books.add(book);
				}
			}
		}
		
		return books;
	}

	public List<BookingDetails> getAllStatus(Connection connection) throws SQLException {
		String query = "select * from booking_details";

		List<BookingDetails> bookingDetails = new ArrayList<>();

		try (PreparedStatement ps = connection.prepareStatement(query)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					BookingDetails bookingDetail = new BookingDetails();
					bookingDetail.setId(rs.getInt("id"));
					bookingDetail.setStdId(rs.getInt("std_id"));
					bookingDetail.setBookId(rs.getInt("book_id"));
					bookingDetail.setQty(rs.getInt("qty"));
					bookingDetail.setDate(rs.getString("booking_date"));
					bookingDetail.setrDate(rs.getString("return_date"));

					bookingDetails.add(bookingDetail);
				}
			}
		}
        return bookingDetails;
    }

	public void updateBookQty(Connection conn, Book book) throws SQLException {
		String query = "update books set qty = ? where sr_no = ?";
		
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, book.getBookQty());
			ps.setInt(2, book.getSrNo());
			
			int rows = ps.executeUpdate();
			
			if (rows > 0) {
				System.out.println("Book updated successfully.");
			} else {
				System.out.println("Failed to update book.");
			}
		}
		
	}
	
}
