
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
public class datagenerator{
	
	public static void main( String args[] )
	{
		//*********SO IF ANY OF THESE FAILS, DATABASE FILE IS NOT UPDATED? OR CAN NEVER UPDATE DB FILE, ONLY CREATE?
	    Connection connection = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      //connection = DriverManager.getConnection("jdbc:sqlite:test.db");
	      connection = DriverManager.getConnection("jdbc:sqlite:carpoolingsampledatabase.db");   //REOPEN AFTER CLOSING IN EACH TRY STATEMENT?
	    } catch ( Exception e ) {
	    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    System.exit(0);
	    }
		System.out.println("Opened database successfully");
		
		
		try {
			stmt = connection.createStatement();
		      String sql = "BEGIN TRANSACTION;" +
				"CREATE TABLE 'usersWithCar' ( " +
					"`email`	TEXT NOT NULL UNIQUE," +
					"`numSeats`	INTEGER NOT NULL," +
					"PRIMARY KEY(email)," +
					"FOREIGN KEY(`email`) REFERENCES users ( email )" +
				");" +
				"INSERT INTO `usersWithCar` VALUES ('cool_cattie7@yahoo.com " +
				"',4); " +
				"INSERT INTO `usersWithCar` VALUES ('spartanvader93@gmail.com " +
				"',2);" +
				"CREATE TABLE 'users' (" +
					"`email`	TEXT NOT NULL UNIQUE," +
					"`name`	TEXT NOT NULL," +
					"`passwordHash`	TEXT NOT NULL," +
					"PRIMARY KEY(email)" +
				");" +
				"INSERT INTO `users` VALUES ('cool_cattie7@yahoo.com" +
				"','cattie" +
				"','password123" +
				"');" +
				"INSERT INTO `users` VALUES ('spartanvader93@gmail.com','Bruce','password234" +
				"');" +
				"INSERT INTO `users` VALUES ('horne@gmail.com" +
				"','Emily" +
				"','12345" +
				"');" +
				"INSERT INTO `users` VALUES ('katso@gmail.com','Katso" +
				"','3456" +
				"');" +
				"CREATE TABLE 'trips' (" +
					"`trip_id`	INTEGER NOT NULL UNIQUE," +
					"`current_location`	TEXT," +
					"`destination`	TEXT," +
					"`estimated_start_date_time`	NUMERIC," +
					"PRIMARY KEY(trip_id)" +
				");" +
				"INSERT INTO `trips` VALUES (1,'123 allavista way" +
				"','1975" +
				"','10/17/2016:10:25" +
				"');" +
				"INSERT INTO `trips` VALUES (2,'hotel california" +
				"','hotel california','11/11/2017:18:30');" +
				"CREATE TABLE 'passengers' (" +
					"`trip_id`	INTEGER NOT NULL," +
					"`email`	TEXT NOT NULL," +
					"PRIMARY KEY(trip_id,email)," +
					"FOREIGN KEY(`email`) REFERENCES users ( email )" +
				");" +
				"INSERT INTO `passengers` VALUES (1,'cool_cattie7@yahoo.com" +
				"');" +
				"CREATE TABLE 'isMemberOf' (" +
					"`email`	TEXT NOT NULL," +
					"`gid`	INTEGER NOT NULL," +
					"PRIMARY KEY(email,gid)," +
					"FOREIGN KEY(`email`) REFERENCES users(email)" +
				");" +
				"INSERT INTO `isMemberOf` VALUES ('horne@gmail.com',123);" +
				"CREATE TABLE 'isDrivenBy' (" +
					"`trip_id`	INTEGER NOT NULL UNIQUE," +
					"`email`	TEXT," +
					"PRIMARY KEY(trip_id)," +
					"FOREIGN KEY(`email`) REFERENCES users ( email )" +
				");" +
				"INSERT INTO `isDrivenBy` VALUES (1,'katso@gmail.com" +
				"');" +
				"INSERT INTO `isDrivenBy` VALUES (2,'spartanvader93@gmail.com" +
				"');" +
				"CREATE TABLE 'groups' (" +
					"`gid`	INTEGER NOT NULL," +
					"`nickname`	TEXT NOT NULL," +
					"PRIMARY KEY(gid)" +
				");" +
				"INSERT INTO `groups` VALUES (123,'dopesquad" +
				"');" +
				"INSERT INTO `groups` VALUES (345,'testing" +
				"');" +
				"INSERT INTO `groups` VALUES (456,'chillsquad');" +
				"COMMIT;";
		      System.out.println(sql);
		      stmt.executeUpdate(sql);
		      stmt.close();
		      //connection.close();
		      System.out.println("added all tables successfully");
			
		} catch (Exception e) {
			System.out.println("adding all the schema failed, probably already exists");
		}
		
		
		try {
			stmt = connection.createStatement();
		    ResultSet rs = null;
		    System.out.println("got to here0");
			rs = stmt.executeQuery( "SELECT * FROM users;" );
		    System.out.println("got here1");
		    while ( rs.next() ) {
		    	 String name = rs.getString("name");
		    	 System.out.println(name);
		    }
		    rs.close();
		    stmt.close();
		    //connection.close();
		    System.out.println("the select operation worked fuck yes");
			
		} catch (Exception e){
			System.out.println("error with statement and stuff");
		}
		
		
		datagenerator.usergenerator();
		datagenerator.userWithCarGenerator();
		datagenerator.groupsGenerator();
		datagenerator.tripsGenerator();
		datagenerator.isDrivenByGenerator();
		datagenerator.memberGenerator();
		
	}
	
	
	public static void usergenerator(){
		Connection connection = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      //connection = DriverManager.getConnection("jdbc:sqlite:test.db");
	      connection = DriverManager.getConnection("jdbc:sqlite:carpoolingsampledatabase.db");   //REOPEN AFTER CLOSING IN EACH TRY STATEMENT?
	    } catch ( Exception e ) {
	    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    System.exit(0);
	    }
		System.out.println("Opened database successfully");
		//*********now generate dynamic data to add to the database, format as sql statement
		
		//first create users
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> emails = new ArrayList<String>();
		ArrayList<String> passwords = new ArrayList<String>();
		for(int i = 0; i < 200; i++){
			String user = "user" + i;
			String email = "user" + i + "@gmail.com";
			String password = "password" + i;
			names.add(user);
			emails.add(email);
			passwords.add(password);
			
		}
		
		String sql_user_insert = ""; 
		String sql_users_to_insert = "";
		try{
		stmt = connection.createStatement();
		for( int i = 0; i < 200; i++){
			sql_user_insert = "";
			sql_user_insert = sql_user_insert + "INSERT INTO 'users' VALUES ('" + emails.get(i) + "', '" + names.get(i) + "', '" + passwords.get(i) + "');" ;
			sql_users_to_insert = sql_users_to_insert + sql_user_insert;
			
			try{
				stmt.executeUpdate(sql_user_insert);
				System.out.println("user added successfully: " + sql_user_insert);
			} catch (Exception e) {
				System.out.println("user insert failed: " + sql_user_insert);
			}
		}
		stmt.close();
		}catch (Exception e){
			
		}
		try{
		    connection.close();
			
			System.out.println("connection closed, all users added successfully");
		} catch (Exception e) {
			System.out.println("user data generation failed");
		}
	}
	
	
	public static void userWithCarGenerator(){
		Connection connection = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      //connection = DriverManager.getConnection("jdbc:sqlite:test.db");
	      connection = DriverManager.getConnection("jdbc:sqlite:carpoolingsampledatabase.db");   //REOPEN AFTER CLOSING IN EACH TRY STATEMENT?
	    } catch ( Exception e ) {
	    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    System.exit(0);
	    }
		System.out.println("Opened database successfully");
		
		//*****now generate values for the usersWithCar table
		
		//first need to get user info using query 
		ArrayList<String[]> users = new ArrayList<String[]>(); 
		try {
			stmt = connection.createStatement();
		    ResultSet rs = null;
			rs = stmt.executeQuery( "SELECT * FROM users;" );
			while ( rs.next() ) {
		    	 String name = rs.getString("name");
		    	 String email = rs.getString("email");
		    	 String password = rs.getString("passwordhash");
		    	 String[] user = {name, email, password};
		    	 users.add(user);
		    }
		    rs.close();
		    stmt.close();
		    //connection.close();
		    System.out.println("users grabbed using select query");
			
		} catch (Exception e){
			System.out.println("user selection failed");
		}
		
		//now pick random users to have cars
		//say first 30 have cars
		try{
			stmt = connection.createStatement();
			String sql_usercar_insert;
			for( int i = 0; i < 30; i++){
				//generate number of seats for car
				Random rand = new Random(); 
				int carseats = rand.nextInt(4) + 1;
				sql_usercar_insert = "";
				sql_usercar_insert = "INSERT INTO 'usersWithCar' VALUES ('" + users.get(i)[1] + "', '" + carseats +  "');" ;
				
				try{
					stmt.executeUpdate(sql_usercar_insert);
					System.out.println("usercar added successfully: " + sql_usercar_insert);
				} catch (Exception e) {
					System.out.println("usercar insert failed: " + sql_usercar_insert);
				}
			}
			stmt.close();
		}catch (Exception e){
			
		}
		try{
		    connection.close();
			System.out.println("connection closed, all usercars added successfully");
		} catch (Exception e) {
			System.out.println("usercar data generation failed");
		}
	}
		
	public static void groupsGenerator(){
		Connection connection = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      //connection = DriverManager.getConnection("jdbc:sqlite:test.db");
	      connection = DriverManager.getConnection("jdbc:sqlite:carpoolingsampledatabase.db");   //REOPEN AFTER CLOSING IN EACH TRY STATEMENT?
	    } catch ( Exception e ) {
	    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    System.exit(0);
	    }
		System.out.println("Opened database successfully");
		
		//****now generate groups
		
		int[] groupids = {1, 2, 3, 4, 5, 6, 7};
		String[] groupnames = {"group1", "group2", "group3", "group4", "group5", "group6", "group7"};
		
		try{
			stmt = connection.createStatement();
			String sql_group_insert;
			for( int i = 0; i < 7; i++){
				sql_group_insert = "";
				sql_group_insert = "INSERT INTO 'groups' VALUES ('" + groupids[i] + "', '" + groupnames[i] +  "');" ;
				
				try{
					stmt.executeUpdate(sql_group_insert);
					System.out.println("group added successfully: " + sql_group_insert);
				} catch (Exception e) {
					System.out.println("group insert failed: " + sql_group_insert);
				}
			}
			stmt.close();
		}catch (Exception e){
			
		}
		try{
		    connection.close();
			System.out.println("connection closed, all groups added successfully");
		} catch (Exception e) {
			System.out.println("group data generation failed");
		}
		
	}
	
	
	public static void tripsGenerator(){
		Connection connection = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      //connection = DriverManager.getConnection("jdbc:sqlite:test.db");
	      connection = DriverManager.getConnection("jdbc:sqlite:carpoolingsampledatabase.db");   //REOPEN AFTER CLOSING IN EACH TRY STATEMENT?
	    } catch ( Exception e ) {
	    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    System.exit(0);
	    }
		System.out.println("Opened database successfully");
		
		ArrayList<String[]> trips = new ArrayList<String[]>();
		for(int i = 0; i < 20; i++){
			Random rand = new Random();
			int month = rand.nextInt(11) +1;
			int day = rand.nextInt(28) +1;
			int hour = rand.nextInt(11) + 1;
			int minute = rand.nextInt(58) + 1;
			String[] trip = {Integer.toString(i), "origin"+i, "destination"+i, Integer.toString(month) + "/" + Integer.toString(day) + "/" + "2016:" + Integer.toString(hour) + ":" + Integer.toString(minute)};
			trips.add(trip);
		}
		
		try{
			stmt = connection.createStatement();
			String sql_trip_insert;
			for( int i = 0; i < 20; i++){
				sql_trip_insert = "";
				sql_trip_insert = "INSERT INTO 'trips' VALUES ('" + new Integer(trips.get(i)[0]) + "', '" + trips.get(i)[1] + "', '" + trips.get(i)[2] + "', '" + trips.get(i)[3] + "');" ;
				
				try{
					stmt.executeUpdate(sql_trip_insert);
					System.out.println("trip added successfully: " + sql_trip_insert);
				} catch (Exception e) {
					System.out.println("trip insert failed: " + sql_trip_insert);
				}
			}
			stmt.close();
		}catch (Exception e){
			
		}
		try{
		    connection.close();
			System.out.println("connection closed, all trips added successfully");
		} catch (Exception e) {
			System.out.println("trip data generation failed");
		}	
		
	}
	
	public static void isDrivenByGenerator(){
		Connection connection = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      //connection = DriverManager.getConnection("jdbc:sqlite:test.db");
	      connection = DriverManager.getConnection("jdbc:sqlite:carpoolingsampledatabase.db");   //REOPEN AFTER CLOSING IN EACH TRY STATEMENT?
	    } catch ( Exception e ) {
	    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    System.exit(0);
	    }
		System.out.println("Opened database successfully");
		
		//get number of trips and trip ids
		ArrayList<Integer> tripids = new ArrayList<Integer>();
		try {
			stmt = connection.createStatement();
		    ResultSet rs = null;
			rs = stmt.executeQuery( "SELECT * FROM trips;" );
			while ( rs.next() ) {
		    	 int tripid = rs.getInt("trip_id");
		    	 tripids.add(tripid);
		    }
		    rs.close();
		    stmt.close();
		    //connection.close();
		    System.out.println("tripids grabbed using select query");
			
		} catch (Exception e){
			System.out.println("trip id selection failed");
		}
		
		//get users with cars
		ArrayList<String> emails = new ArrayList<String>();
		try {
			stmt = connection.createStatement();
		    ResultSet rs = null;
			rs = stmt.executeQuery( "SELECT * FROM usersWithCar;" );
			while ( rs.next() ) {
		    	 String email = rs.getString("email");
		    	 emails.add(email);
		    }
		    rs.close();
		    stmt.close();
		    //connection.close();
		    System.out.println("user emails grabbed using select query");
			
		} catch (Exception e){
			System.out.println("user email selection failed");
		}
		
		
		//now need to assign a driver to each trip id
		ArrayList<String[]> isDrivenBy = new ArrayList<String[]>();
		for(int i = 0; i < tripids.size(); i++){
			String[] tripDriver = {Integer.toString(tripids.get(i)), emails.get(i)};
			isDrivenBy.add(tripDriver);
		}
		
		
		try{
			stmt = connection.createStatement();
			String sql_isDrivenBy_insert;
			for( int i = 0; i < 20; i++){
				sql_isDrivenBy_insert = "";
				sql_isDrivenBy_insert = "INSERT INTO 'isDrivenBy' VALUES ('" + new Integer(isDrivenBy.get(i)[0]) + "', '" + isDrivenBy.get(i)[1] + "');" ;
				
				try{
					stmt.executeUpdate(sql_isDrivenBy_insert);
					System.out.println("driver added successfully: " + sql_isDrivenBy_insert);
				} catch (Exception e) {
					System.out.println("driver insert failed: " + sql_isDrivenBy_insert);
				}
			}
			stmt.close();
		}catch (Exception e){
			
		}
		try{
		    connection.close();
			System.out.println("connection closed, all drivers added successfully");
		} catch (Exception e) {
			System.out.println("driver data generation failed");
		}	
		
		
	}
	
	public static void memberGenerator(){
		Connection connection = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      //connection = DriverManager.getConnection("jdbc:sqlite:test.db");
	      connection = DriverManager.getConnection("jdbc:sqlite:carpoolingsampledatabase.db");   //REOPEN AFTER CLOSING IN EACH TRY STATEMENT?
	    } catch ( Exception e ) {
	    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    System.exit(0);
	    }
		System.out.println("Opened database successfully");
		
		//now get list of user ids
		ArrayList<String> emails = new ArrayList<String>();
		try {
			stmt = connection.createStatement();
		    ResultSet rs = null;
			rs = stmt.executeQuery( "SELECT * FROM users;" );
			while ( rs.next() ) {
		    	 String email = rs.getString("email");
		    	 emails.add(email);
		    }
		    rs.close();
		    stmt.close();
		    //connection.close();
		    System.out.println("user emails grabbed using select query");
			
		} catch (Exception e){
			System.out.println("user email selection failed");
		}
		
		//now get list of group ids
		ArrayList<Integer> groupids = new ArrayList<Integer>();
		try {
			stmt = connection.createStatement();
		    ResultSet rs = null;
			rs = stmt.executeQuery( "SELECT * FROM groups;" );
			while ( rs.next() ) {
		    	 int gid = rs.getInt("gid");
		    	 groupids.add(gid);
		    }
		    rs.close();
		    stmt.close();
		    //connection.close();
		    System.out.println("groupids grabbed using select query");
			
		} catch (Exception e){
			System.out.println("groupid selection failed");
		}
		
		
		//now randomly select users for each group, and number of users for each group
		ArrayList<String[]> groupmembers = new ArrayList<String[]>();
		System.out.println("group ids" + groupids);
		for(int i = 0; i < groupids.size(); i++){
			Random rand = new Random();
			int num_members = rand.nextInt(10) +1;
			int total_users = emails.size();
			String[] group = new String[num_members+1];
			group[0] = Integer.toString(i);
			for(int j = 1; j <= num_members; j++){
				int user_index = (int) (Math.random() * total_users);
				group[j] = emails.get(user_index);
			}
			
			groupmembers.add(group);
		}
		System.out.println("group members" + groupmembers.get(0));
		try{
			stmt = connection.createStatement();
			String sql_members_insert;
			for( int i = 0; i < groupmembers.size(); i++){
				for(int j = 1; j < groupmembers.get(i).length; j++){
					sql_members_insert = "";
					sql_members_insert = "INSERT INTO 'isMemberOf' VALUES ('" + groupmembers.get(i)[j] + "', '" + new Integer(groupmembers.get(i)[0]) + "');" ;
					try{
						stmt.executeUpdate(sql_members_insert);
						System.out.println("groupmembers added successfully: " + sql_members_insert);
					} catch (Exception e) {
						System.out.println("groupmembers insert failed: " + sql_members_insert);
					}
				}
			}
			stmt.close();
		}catch (Exception e){
			
		}
		try{
		    connection.close();
			System.out.println("connection closed, all groupmembers added successfully");
		} catch (Exception e) {
			System.out.println("groupmember data generation failed");
		}	
		
		
	}
	
}
