package serverComponents;

/**
 * Configuration Parameters
 * 
 * @author ken
 *
 */
public class Configuration {
	
	// Connection configuration
	public static final int PORT = 8000;
	public static final String MYSQL_JDBC_URL = "jdbc:mysql://localhost:3306/%s?serverTimezone=UTC&useSSL=false";
	public static final String MYSQL_DB = "test";
	public static final String MYSQL_USER = "root";
	public static final String MYSQL_PWD = "Wang971001";
	
	// Connection pool configuration
	
	// Pool size management
	public static final String PR_ACQUIRE_INCREMENT = "acquireIncrement";
	public static final int ACQUIRE_INCREMENT = 1; // Number of connections to acquire when needed
	public static final String PR_INITIAL_POOL_SIZE = "initialPoolSize";
	public static final int INITIAL_POOL_SIZE = 10;
	public static final String PR_MAX_POOL_SIZE = "maxPoolSize";
	public static final int MAX_POOL_SIZE = 20;
	public static final String PR_MIN_POOL_SIZE = "minPoolSize";
	public static final int MIN_POOL_SIZE = 5;
	
	// Connection Testing
	public static final String PR_IDLE_CONNECTION_TEST_PERIOD = "idleConnectionTestPeriod";
	public static final int IDLE_CONNECTION_TEST_PERIOD = 180; // Period of time per which a idle connection will be tested
	
	// Statement pooling
	public static final String PR_MAX_STATEMENTS_PER_CONNECTION = "maxStatementsPerConnection";
	public static final int MAX_STATEMENTS_PER_CONNECTION = 12;
	
	// Database structure: TBL_* are table names; COL_* are column names
	public static final String TBL_USER = "USER";
	public static final String COL_USER_USER_ID = "UserID"; // primary key
	public static final String COL_USER_USER_NAME = "UserName";
	public static final String COL_USER_USER_PWD = "Password";
	public static final String COL_USER_WECHAT_INFO = "WeChatInfo";
	public static final String COL_USER_PHONE_NUMBER = "PhoneNumber";
	public static final String COL_USER_EMAIL = "Email";
	public static final String COL_USER_PROGRAM = "Program";
	
	public static final String TBL_POST = "POST";
	public static final String COL_POST_POST_ID = "PostID"; // primary key
	public static final String COL_POST_OWNER_ID = "OwnerID"; // foreign key references USER.UserID
	public static final String COL_POST_BOOK_TITLE = "BookTitle";
	public static final String COL_POST_BOOK_PHOTO = "BookPhoto";
	public static final String COL_POST_COURSE_ID = "CourseID";
	public static final String COL_POST_INSTRUCTOR = "Instructor";
	public static final String COL_POST_TAKE_YEAR = "TakeYear";
	public static final String COL_POST_DESCRIPTION = "Description";
	public static final String COL_POST_PRICE = "Price";
	public static final String COL_POST_STATUS = "Status";
	
	// PreparedStatements
	public static final String QRY_CREATE_USER = String.format("INSERT INTO %s ( %s, %s, %s, %s, %s, %s, %s )"
			+ " VALUES ( ?, ?, ?, ?, ?, ?, ? )", TBL_USER, COL_USER_USER_ID, COL_USER_USER_NAME, COL_USER_USER_PWD,
			COL_USER_WECHAT_INFO, COL_USER_PHONE_NUMBER, COL_USER_EMAIL, COL_USER_PROGRAM);
			// INSERT INTO USER ( UserID, UserName, Password, WeChatInfo, PhoneNumber, Email, Program ) VALUES ( ?, ?, ?, ?, ?, ?, ? )
	
	public static final String QRY_UPDATE_USER = String.format("UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=?, %s=? "
			+ "WHERE %s=?", TBL_USER, COL_USER_USER_NAME, COL_USER_USER_PWD,
			COL_USER_WECHAT_INFO, COL_USER_PHONE_NUMBER, COL_USER_EMAIL, COL_USER_PROGRAM, COL_USER_USER_ID);
			// UPDATE USER SET UserName=?, Password=?, WeChatInfo=?, PhoneNumber=?, Email=?, Program=? WHERE UserID=?
	
	public static final String QRY_CREAT_POST = String.format("INSERT INTO %s ( %s, %s, %s, %s, %s, %s, %s, %s, %s, %s )"
			+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )", TBL_POST, COL_POST_POST_ID, COL_POST_OWNER_ID, COL_POST_BOOK_TITLE, COL_POST_BOOK_PHOTO,
			COL_POST_COURSE_ID, COL_POST_INSTRUCTOR, COL_POST_TAKE_YEAR, COL_POST_DESCRIPTION, COL_POST_PRICE, COL_POST_STATUS);
			// INSERT INTO POST ( PostID, OwnerID, BookTitle, BookPhoto, CourseID, Instructor, TakeYear, Description, Price, Status ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )
	
	public static final String QRY_UPDATE_POST = String.format("UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=?, %s=? "
			+ "WHERE %s=?", TBL_POST, COL_POST_OWNER_ID, COL_POST_BOOK_TITLE, COL_POST_BOOK_PHOTO,
			COL_POST_COURSE_ID, COL_POST_INSTRUCTOR, COL_POST_TAKE_YEAR, COL_POST_DESCRIPTION, COL_POST_PRICE, COL_POST_STATUS, COL_POST_POST_ID);
			// UPDATE POST SET OwnerID=?, BookTitle=?, BookPhoto=?, CourseID=?, Instructor=?, TakeYear=?, Description=?, Price=?, Status=? WHERE PostID=?
	
	public static final String QRY_DELETE_POST = String.format("DELETE FROM %s WHERE %s=?", TBL_POST, COL_POST_POST_ID);
	// DELETE FROM POST WHERE PostID=?
	
	public static final String QRY_GET_USER_INFO_BY_CREDENTIALS = String.format("SELECT %s, %s, %s, %s, %s, %s, %s FROM %s WHERE %s=? AND %s=?",
			COL_USER_USER_ID, COL_USER_USER_NAME, COL_USER_USER_PWD, COL_USER_WECHAT_INFO, COL_USER_PHONE_NUMBER, COL_USER_EMAIL, COL_USER_PROGRAM,
			TBL_USER, COL_USER_USER_NAME, COL_USER_USER_PWD);
			// SELECT UserID, UserName, Password, WeChatInfo, PhoneNumber, Email, Program FROM USER WHERE UserName=? AND Password=?
	
	public static final String QRY_GET_USER_INFO_BY_WECHAT_INFO = String.format("SELECT %s, %s, %s, %s, %s, %s, %s FROM %s WHERE %s=?",
			COL_USER_USER_ID, COL_USER_USER_NAME, COL_USER_USER_PWD, COL_USER_WECHAT_INFO, COL_USER_PHONE_NUMBER, COL_USER_EMAIL, COL_USER_PROGRAM,
			TBL_USER, COL_USER_WECHAT_INFO);
			// SELECT UserID, UserName, Password, WeChatInfo, PhoneNumber, Email, Program FROM USER WHERE WeChatInfo=?
	
	public static final String QRY_SEARCH_POST_BY_COURSE_ID = String.format("SELECT %s, %s, %s, %s, %s, %s, %s, %s, %s, %s FROM %s WHERE %s LIKE ?",
			COL_POST_POST_ID, COL_POST_OWNER_ID, COL_POST_BOOK_TITLE, COL_POST_BOOK_PHOTO, COL_POST_COURSE_ID, COL_POST_INSTRUCTOR, COL_POST_TAKE_YEAR,
			COL_POST_DESCRIPTION, COL_POST_PRICE, COL_POST_STATUS, TBL_POST, COL_POST_COURSE_ID);
			// SELECT PostID, OwnerID, BookTitle, BookPhoto, CourseID, Instructor, TakeYear, Description, Price, Status FROM POST WHERE CourseID LIKE ?
	
	public static final String QRY_SEARCH_POST_BY_OWNER_ID = String.format("SELECT %s, %s, %s, %s, %s, %s, %s, %s, %s, %s FROM %s WHERE %s=?",
			COL_POST_POST_ID, COL_POST_OWNER_ID, COL_POST_BOOK_TITLE, COL_POST_BOOK_PHOTO, COL_POST_COURSE_ID, COL_POST_INSTRUCTOR, COL_POST_TAKE_YEAR,
			COL_POST_DESCRIPTION, COL_POST_PRICE, COL_POST_STATUS, TBL_POST, COL_POST_OWNER_ID);
			// SELECT PostID, OwnerID, BookTitle, BookPhoto, CourseID, Instructor, TakeYear, Description, Price, Status FROM POST WHERE OwnerID=?
	
	public static final String QRY_SEARCH_POST_BY_BOOK_TITLE = String.format("SELECT %s, %s, %s, %s, %s, %s, %s, %s, %s, %s FROM %s WHERE %s LIKE ?",
			COL_POST_POST_ID, COL_POST_OWNER_ID, COL_POST_BOOK_TITLE, COL_POST_BOOK_PHOTO, COL_POST_COURSE_ID, COL_POST_INSTRUCTOR, COL_POST_TAKE_YEAR,
			COL_POST_DESCRIPTION, COL_POST_PRICE, COL_POST_STATUS, TBL_POST, COL_POST_BOOK_TITLE);
			// SELECT PostID, OwnerID, BookTitle, BookPhoto, CourseID, Instructor, TakeYear, Description, Price, Status FROM POST WHERE BookTitle LIKE ?
	
	public static final String QRY_GET_ALL_POST_INFO_BY_POST_ID = String.format("SELECT %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s"
			+ " FROM %s JOIN %s on %s.%s=%s.%s WHERE %s.%s=?",
			COL_POST_POST_ID, COL_POST_OWNER_ID, COL_POST_BOOK_TITLE, COL_POST_BOOK_PHOTO, COL_POST_COURSE_ID, COL_POST_INSTRUCTOR, COL_POST_TAKE_YEAR,
			COL_POST_DESCRIPTION, COL_POST_PRICE, COL_POST_STATUS, COL_USER_USER_NAME, COL_USER_USER_PWD, COL_USER_WECHAT_INFO, COL_USER_PHONE_NUMBER,
			COL_USER_EMAIL, COL_USER_PROGRAM, TBL_POST, TBL_USER, TBL_POST, COL_POST_OWNER_ID, TBL_USER, COL_USER_USER_ID, TBL_POST, COL_POST_POST_ID);
			// SELECT PostID, OwnerID, BookTitle, BookPhoto, CourseID, Instructor, TakeYear, Description, Price, Status, UserName, Password, WeChatInfo,
			//PhoneNumber, Email, Program FROM POST JOIN USER ON POST.OwnerID=USER.UserID WHERE POST.PostID=?
}
