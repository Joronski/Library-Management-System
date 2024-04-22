/* Project Made by Recio's Group for MIDTERM GROUP RESEARCH PROJECT CCS103 COMPUTER PROGRAMMING 2

Group Members:

Joaquin Aaron P. Recio - Lead Programmer
Anne Galzeleigh L. Eliang - Co-Lead Programmer
Kirsten Joi A. Lazarte - Member 
Jaymart G. Impas - Member
John Henrics L. Mateo - Member
Brenda Lazado - Member
Jennelyn N. Magtibay - Member
Marc Alvin P. Quitorio - Member
Kim Francis O. Dela Cruz - Member
Julius L. Natividad - Member

Recio's Group Library Management System (© 2024 RECIO) */

// This Java program is a library management system that allows users to manage their books, borrowers, and loans. Indicating the number of books, borrowers, and loans.
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Recio_Group_Library_Management_System extends JFrame {
	// Declares various components like text fields, check boxes, buttons, lists, and variables for managing books.
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBookTitleField;
	private JTextField txtAuthorField;
	private JTextField txtGenreField;
	private JTextField txtIsbnField;
	private JCheckBox chkAvailabilityCheckBox;
	private JTextField txtMemberNameField;
	private JTextField txtMemberIdField;
	private JTextField txtContactDetailsField;
	private JCheckBox chkMemberStatusCheckBox;
	private JTextArea txtADisplay;
	
	private List<Book> books;
	private List<Member> members;
	private List<String> transactionLog;
	
	private Frame book;
	private Component member;

	/**
	 * Launch the application.
	 */
	
	// Initialized the components and variables for the GUI. like labels, text fields, check boxes, buttons, lists, and variables. and sets up the layout using absolute positioning.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recio_Group_Library_Management_System frame = new Recio_Group_Library_Management_System();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Recio_Group_Library_Management_System() {
		// Set the icon for the frame using an image from the specified path.
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Windows 10\\eclipse-workspace\\Recio's Group Library Management System Project\\images\\Recio LMS Logo.png")); 
		
		// Sets the title of the frame.
		setTitle("Recio's Group Library Management System");
		// Sets the default close operation to exit the application when the close button is clicked.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Sets the size and position of the frame on the screen. This also sets the background color and border for the content pane.
		setBounds(100, 100, 700, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// Sets the Layout of the content pane to null, which allows for manual positioning of components.
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Adds a label logo and sets its position and size using setBounds.
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\Windows 10\\eclipse-workspace\\Recio's Group Library Management System Project\\images\\recio_logo.png")); // Image of my logo
		lblLogo.setBounds(120, 12, 39, 38);
		contentPane.add(lblLogo);
		
		// Adds a title label for the system title, sets its properties, and positions it using setBounds.
		JLabel lblTitleFrame = new JLabel("Recio's Group Library Management System (© 2024 RECIO)");
		lblTitleFrame.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleFrame.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblTitleFrame.setBounds(160, 18, 392, 27);
		contentPane.add(lblTitleFrame);
		
		// Adds text fields for book title, author, genre, and ISBN, sets their properties, and positions them using setBounds.
		JLabel lblBookTitle = new JLabel("Book Title: ");
		lblBookTitle.setBounds(20, 60, 80, 20);
		contentPane.add(lblBookTitle);
		
		txtBookTitleField = new JTextField();
		txtBookTitleField.setBounds(110, 60, 200, 20);
		contentPane.add(txtBookTitleField);
		txtBookTitleField.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author: ");
		lblAuthor.setBounds(20, 90, 80, 20);
		contentPane.add(lblAuthor);
		
		txtAuthorField = new JTextField();
		txtAuthorField.setBounds(110, 90, 200, 20);
		contentPane.add(txtAuthorField);
		txtAuthorField.setColumns(10);
		
		JLabel lblGenre = new JLabel("Genre: ");
		lblGenre.setBounds(20, 120, 80, 20);
		contentPane.add(lblGenre);
		
		txtGenreField = new JTextField();
		txtGenreField.setBounds(110, 120, 200, 20);
		contentPane.add(txtGenreField);
		txtGenreField.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN: ");
		lblIsbn.setBounds(20, 150, 80, 20);
		contentPane.add(lblIsbn);
		
		txtIsbnField = new JTextField();
		txtIsbnField.setBounds(110, 150, 200, 20);
		contentPane.add(txtIsbnField);
		txtIsbnField.setColumns(10);
		
		JLabel lblAvailability = new JLabel("Availability: ");
		lblAvailability.setBounds(20, 180, 80, 20);
		contentPane.add(lblAvailability);
		
		chkAvailabilityCheckBox = new JCheckBox("Available");
		chkAvailabilityCheckBox.setBackground(new Color(255, 128, 64));
		chkAvailabilityCheckBox.setBounds(110, 180, 100, 20);
		contentPane.add(chkAvailabilityCheckBox);
		
		JLabel lblMemberName = new JLabel("Member Name: ");
		lblMemberName.setBounds(350, 60, 100, 20);
		contentPane.add(lblMemberName);
		
		txtMemberNameField = new JTextField();
		txtMemberNameField.setBounds(450, 60, 200, 20);
		contentPane.add(txtMemberNameField);
		txtMemberNameField.setColumns(10);
		
		JLabel lblMemberId = new JLabel("Member ID: ");
		lblMemberId.setBounds(350, 90, 100, 20);
		contentPane.add(lblMemberId);
		
		txtMemberIdField = new JTextField();
		txtMemberIdField.setBounds(450, 90, 200, 20);
		contentPane.add(txtMemberIdField);
		txtMemberIdField.setColumns(10);
		
		JLabel lblContactDetails = new JLabel("Contact Details: ");
		lblContactDetails.setBounds(350, 120, 100, 20);
		contentPane.add(lblContactDetails);
		
		txtContactDetailsField = new JTextField();
		txtContactDetailsField.setBounds(450, 120, 200, 20);
		contentPane.add(txtContactDetailsField);
		txtContactDetailsField.setColumns(10);
		
		JLabel lblMemberStatus = new JLabel("Member Status: ");
		lblMemberStatus.setBounds(350, 150, 100, 20);
		contentPane.add(lblMemberStatus);
		
		chkMemberStatusCheckBox = new JCheckBox("Active");
		chkMemberStatusCheckBox.setBackground(new Color(255, 128, 64));
		chkMemberStatusCheckBox.setBounds(450, 150, 100, 20);
		contentPane.add(chkMemberStatusCheckBox);
		
		// Adds button with corresponding action listeners for performing actions.
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBook();
				
				txtBookTitleField.setText(null);
				txtBookTitleField.requestFocus();
				
				txtAuthorField.setText(null);
				txtAuthorField.requestFocus();
				
				txtGenreField.setText(null);
				txtGenreField.requestFocus();
				
				txtIsbnField.setText(null);
				txtIsbnField.requestFocus();
				
				chkAvailabilityCheckBox.setSelected(false);
				chkAvailabilityCheckBox.requestFocus();
			}
		});
		btnAddBook.setBounds(20, 220, 120, 30);
		contentPane.add(btnAddBook);
		
		JButton btnAddMember = new JButton("Add Member");
		btnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMember();
				
				txtMemberNameField.setText(null);
				txtMemberNameField.requestFocus();
				
				txtMemberIdField.setText(null);
				txtMemberIdField.requestFocus();
				
				txtContactDetailsField.setText(null);
				txtContactDetailsField.requestFocus();
				
				chkMemberStatusCheckBox.setSelected(false);
				chkMemberStatusCheckBox.requestFocus();
			}
		});
		btnAddMember.setBounds(150, 220, 120, 30);
		contentPane.add(btnAddMember);
		
		JButton btnBorrowBook = new JButton("Borrow Book");
		btnBorrowBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrowBook();
			}
		});
		btnBorrowBook.setBounds(280, 220, 120, 30);
		contentPane.add(btnBorrowBook);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnBook();
			}
		});
		btnReturnBook.setBounds(410, 220, 120, 30);
		contentPane.add(btnReturnBook);
		
		JButton btnSearchBook = new JButton("Search Book");
		btnSearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchBook();
			}
		});
		btnSearchBook.setBounds(540, 180, 120, 30);
		contentPane.add(btnSearchBook);
		
		JButton btnSearchMember = new JButton("Find Member");
		btnSearchMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchMember();
			}
		});
		btnSearchMember.setBounds(540, 220, 120, 30);
		contentPane.add(btnSearchMember);
		
		// For Displaying transaction log purposes
		JButton btnDisplayLog = new JButton("Display Log");
		btnDisplayLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTransactionLog();
			}
		});
		btnDisplayLog.setBounds(410, 180, 120, 30);
		contentPane.add(btnDisplayLog);
		
		// Adds a scrollable text area to display message and search result.
		txtADisplay = new JTextArea();
		txtADisplay.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(txtADisplay);
		scrollPane.setBounds(20, 260, 640, 250);
		contentPane.add(scrollPane);
		
		// Initializes books, members, and transaction log lists using ArrayList for storing book object, member object, and transaction log strings, respectively. 
		books = new ArrayList<Book>();
		members = new ArrayList<Member>();
		transactionLog = new ArrayList<String>();
		
		// Center the frame on the screen when it is displayed.
		setLocationRelativeTo(null);
	}
	
	// Retrieve input values for a new book title, author, genre, and ISBN from the text fields and create a new book object using the input values. Display a message indicating the book has been added to the system.
	private void addBook() {
		String title = txtBookTitleField.getText();
		String author = txtAuthorField.getText();
		String genre = txtGenreField.getText();
		String isbn = txtIsbnField.getText();
		boolean available = chkAvailabilityCheckBox.isSelected();
		
		Book book = new Book(title, author, genre, isbn, available);
		books.add(book);
		
		displayMessage("Book added: " + book);
		
		// Log the transaction
		logTransaction("Book added: " + book);
	}
	
	// Retrieves input values for a new member name, ID, Contact, and Status, and creates a new Member object with those values. Display a message indicating that the member was added.
	private void addMember() {
	    // Retrieve values from UI components
	    String name = txtMemberNameField.getText();
	    String id = txtMemberIdField.getText();
	    String contactDetails = txtContactDetailsField.getText();
	    boolean active = chkMemberStatusCheckBox.isSelected();
	    
	    // Create a new Member object
	    Member member = new Member(name, id, contactDetails, active);
	    
	    // Add the member to the list of members
	    members.add(member);
	    
	    displayMessage("\nMember added: " + member);
	    
	    // Log the transaction
	    logTransaction("Member added: " + member);
	 }
	
	// Prompts the user to enter the book title to borrow, checks if the book is available, and updates the availability status. if the book is found and available, prompts for the member ID and updates the books availability. logs the transaction and display a message confirming the borrowing.
	private void borrowBook() {
	    String titleToBorrow = JOptionPane.showInputDialog(null, "Enter the title of the book to borrow: ");

	    // Search for the book in the list of available books
	    for (Book book : books) {
	        if (book.getTitle().equalsIgnoreCase(titleToBorrow) && book.isAvailable()) {
	            String memberId = JOptionPane.showInputDialog(null, "Enter the ID of the member borrowing the book:");
	            
	            // Search for the member in the list of members
	            for (Member member : members) {
	                if (member.getId().equals(memberId)) {
	                    // Book is borrowed by the member
	                    book.setAvailable(false);
	                    displayMessage("\nBook \"" + book.getTitle() + "\" has been borrowed by " + member.getName());
	                    transactionLog.add("\nBook \"" + book.getTitle() + "\" has been borrowed by " + member.getName()); // Logging Transaction
	                    return;
	                }
	            }
	            // If member ID does not match
	            displayMessage("\nMember ID not found.");
	            return;
	        }
	    }
	    // If book not found or already borrowed
	    displayMessage("\nBook \"" + titleToBorrow + "\" not found or already borrowed.");
	    
	    // Log the transaction
	    logTransaction("Book \"" + book.getTitle() + "\" has been borrowed by " + member.getName());
	}
	
	// Prompts the user to enter the title of the book to return. Search for the book in the book list based on the title and availability. If the book is found and available, prompts for the member ID and updates the books availability and logs the return transaction.
	private void returnBook() {
		String titleToReturn = JOptionPane.showInputDialog(null, "Enter the title of the book to return: ");
		
		// Searching for the book in the list of borrowed books
		for (Book book : books) {
			if (book.getTitle().equalsIgnoreCase(titleToReturn) && !book.isAvailable()) {
				book.setAvailable(true);
				displayMessage("\nBook \"" + book.getTitle() + "\" has been returned.");
				transactionLog.add("\nBook \"" + book.getTitle() + "\" has been returned.");
				return;
			}
		}
		
		// If the book is not found or already returned
		displayMessage("\nBook \"" + titleToReturn + "\" not found or already returned.");
		
		// Log the transaction
		logTransaction("Book \"" + book.getTitle() + "\" has been borrowed by " + member.getName());
	}
	
	// Prompts the user to enter a search term title, author, genre, or ISBN, and displays the matching books in the display area.
	private void searchBook() {
		String searchTerm = JOptionPane.showInputDialog(null, "Enter the search term (Title, Author, Genre, or ISBN): ");
		
		// Search for the book by title, author, genre, or ISBN
		StringBuilder searchResults = new StringBuilder();
		for (Book book : books) {
			if (book.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) || book.getAuthor().toLowerCase().contains(searchTerm.toLowerCase()) || book.getGenre().toLowerCase().contains(searchTerm.toLowerCase()) || book.getIsbn().equalsIgnoreCase(searchTerm)) {
				searchResults.append(book).append("\n");
			}
		}
		
		// Search book results shown in the textArea
		if (searchResults.length() == 0) {
			displayMessage("\nNo books found matching the search term.");
		} else {
			displayMessage("\nSearch results for \"" + searchTerm + "\":\n" + searchResults);
		}
	}
	
	// Prompts the user to enter a search term and searches for a member with the given ID. 
	private void searchMember() {
		String searchTerm = JOptionPane.showInputDialog(null, "Enter the Search Term (Name or ID): ");
		
		// Finding for the member by name or ID
		StringBuilder searchResults = new StringBuilder();
		for (Member member : members) {
			if (member.getName().toLowerCase().contains(searchTerm.toLowerCase()) || member.getId().equals(searchTerm) || member.getContactDetails().contains(searchResults) || member.isActive()) {
				searchResults.append(member).append("\n");
			}
		}
		
		// Search member results shown in the textArea
		if (searchResults.length() == 0) {
			displayMessage("\nNo members found matching the search term.");
		} else {
			displayMessage("\nSearch results for \"" + searchTerm + "\":\n" + searchResults);
		}
	}
	
	// Appends a message to the display area. text area for displaying information and messages to the user.
	private void displayMessage(String message) {
		txtADisplay.append(message + "\n");
	}
	
	// Method to display the transaction log
	private void displayTransactionLog() {
		StringBuilder log = new StringBuilder("Transaction Log:\n");
		for (String entry : transactionLog) {
			log.append(entry).append("\n");
		}
		JOptionPane.showMessageDialog(null, log.toString(), "Transaction Log", JOptionPane.PLAIN_MESSAGE);
	}
	
	// Method for log transaction text file
	private void logTransaction(String message) {
		// Adding the message to the transaction log list
		transactionLog.add(message);
		
		// Writing a transaction log to its file/database
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("transaction_log.txt", true))) {
			// Writing the message to the file
			writer.write(message);
			// Adding a newLine after the message
			writer.newLine();
		} catch (IOException e) {
			// Handling IOException by printing the stack trace
			e.printStackTrace();
		}
	}
	
	// Represents a book with properties such as title, author, genre, ISBN, and availability. and it will provides methods to check availability, get details, and update availability status.
	class Book {
		private String title;
		private String author;
		private String genre;
		private String isbn;
		private boolean available;
		
		public Book(String title, String author, String genre, String isbn, boolean available) {
			this.title = title;
			this.author = author;
			this.genre = genre;
			this.isbn = isbn;
			this.available = available;
		}

		public boolean isAvailable() {
			// this returns the availability status of the book.
			return available;
		}

		public String getTitle() {
			// this returns the title of the book.
			return title;
		}
		
		public String getAuthor() {
			// this returns the value of the author attribute, which represents the author of the book.
			return author;
		}
		
		public String getGenre() {
			// this returns the value of the genre attribute, which represents the genre of the book.
			return genre;
		}
		
		public String getIsbn() {
			// this returns the value of the isbn attribute, which represents the ISBN (International Standard Book Number) of the book.
			return isbn;
		}

		public void setAvailable(boolean available) {
			// sets the availability status of the book.
			this.available = available;
		}

		// Overriding the string method to provide a formatted string representation of the book.
		@Override
		public String toString() {
			return "Title: " + title + " | Author: " + author + " | Genre: " + genre + " | ISBN: " + isbn + " | Available: " + available;
		}
	}
	
	// Represents a library member with properties such as name, ID, contact details, and status. and it will Provides to get member details and check if the member is active. 
	class Member {
	    private String name;
	    private String id;
	    private String contactDetails;
	    private boolean active;
	    
	    public Member(String name, String id, String contactDetails, boolean active) {
	        this.name = name;
	        this.id = id;
	        this.contactDetails = contactDetails;
	        this.active = active;
	    }

	    public String getName() {
	        return name;
	    }
	    
	    public String getId() {
	        return id;
	    }
	    
	    public String getContactDetails() {
	        return contactDetails;
	    }
	    
	    public boolean isActive() {
	        return active;
	    }

	    // Overriding the string method to provide a formatted string representation of the member.
	    @Override
	    public String toString() {
	        return "Name: " + name + " | ID: " + id + " | Contact Details: " + contactDetails + " | Active: " + active;
	    }
	}
}
