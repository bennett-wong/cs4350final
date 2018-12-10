import java.sql.*;
import java.util.Scanner;
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s1 = new Scanner(System.in);
		boolean done = false;
		System.out.println("Welcome to the Pomona Transit System, please select an option below");
		while(!done) {
			menu();
			int choice = s1.nextInt();
			switch(choice) {
			 case 1:
				 System.out.println("Please enter in StartLocationName, Destination Name, and Date: ");
				 String StartLocationName = s1.next();
				 String DestinationName = s1.next();
				 String Date = s1.next();
				 displayScheduledTrips(StartLocationName, DestinationName, Date);
			 	break;
			 case 2: 
				 System.out.println("Please enter your option");
				 menu2();
				 int choice1 = s1.nextInt();
				 switch(choice1) {
				 case 1:
					 System.out.print("Enter in TripNumber: ");
					 int TripNumber1 = s1.nextInt();
					 System.out.print("\n");
					 System.out.print("Enter in Date: ");
					 String Date1 = s1.next();
					 System.out.print("\n");
					 System.out.print("Enter in Schedule Start Time: ");
					 String ScheduledStartTime1 = s1.next();
					 System.out.print("\n");
					 try {
							
							Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3380/data", user, password);
							Statement myStmt = myConn.createStatement();
							String sql = ("DELETE FROM tripoffering WHERE (TripNumber = " + TripNumber1 + ") and (Date = " + 
							Date1 + ") and (ScheduledStartTime = " + ScheduledStartTime1 + ")");
							myStmt.executeUpdate(sql);
						}
						catch(Exception exc) {
							exc.printStackTrace();
						}
					 break;
				 case 2:
					 System.out.println("Please enter in all attributes for trip offering");
					 System.out.println("Trip Number");
					 int TripNumber2 = s1.nextInt();
					 System.out.println("Date");
					 String Date2 = s1.next();
					 System.out.print("Scheduled Start Time: ");
					 String ScheduledStartTime2 = s1.next();
					 System.out.print("Scheduled Arrival Time: ");
					 String ScheduledArrivalTime2 = s1.next();
					 System.out.print("DriverName: ");
					 String DriverName2 = s1.next();
					 System.out.println("BusID: ");
					 int BusID2 = s1.nextInt();
					 try {
							
							Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3380/data", user, password);
							
							Statement myStatement = myConn.createStatement();
							
							ResultSet myRs = myStatement.executeQuery("INSERT INTO tripoffering (TripNumber, Date, ScheduledStartTime, ScheduledArrivalTime, DriverName, BusID)"
									+ "VALUES(" + TripNumber2 + ", " + Date2 + ", " + ScheduledStartTime2 + ", " + ScheduledArrivalTime2 + ", " + DriverName2 + ", " 
											+ BusID2 + ")");
						}
						catch(Exception exc) {
							exc.printStackTrace();
						}
					 break;
				 case 3:
					 System.out.println("Please enter in all attributes to change driver");
					 System.out.print("Trip Number: ");
					 int TripNumber3 = s1.nextInt();
					 System.out.print("Date: ");
					 String Date3 = s1.next();
					 System.out.print("Scheduled Start Time: ");
					 String ScheduledStartTime3 = s1.next();
					 System.out.print("Enter in name to change to: ");
					 String name = s1.next();
					 try {
							
							Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3380/data", user, password);
							
							Statement myStmt = myConn.createStatement();
							
							String sql = ("UPDATE tripoffering SET DriverName = " + name + "WHERE (TripNumber = " + 
							TripNumber3 + ") AND (Date = " + Date3 + ") AND (ScheduledStartTime" + ScheduledStartTime3 + ")");
							myStmt.executeUpdate(sql);
							
						}
						catch(Exception exc) {
							exc.printStackTrace();
						}
					 break;
				 case 4:
					 System.out.println("Enter in Trip Offering info to change bus");
					 System.out.print("Trip Number: ");
					 int TripNumber4 = s1.nextInt();
					 System.out.print("Date: ");
					 String Date4 = s1.next();
					 System.out.print("Scheduled Start Time: ");
					 String ScheduledStartTime4 = s1.next();
					 System.out.print("New Bus ID: ");
					 int BusID4 = s1.nextInt();
					 try {
							
							Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3380/data", user, password);
							
							Statement myStmt = myConn.createStatement();
							
							String sql = ("UPDATE tripoffering SET BusID = " + BusID4 + "WHERE (TripNumber = " + 
							TripNumber4 + ") AND (Date = " + Date4 + ") AND (ScheduledStartTime" + ScheduledStartTime4 + ")");
							myStmt.executeUpdate(sql);
						}
						catch(Exception exc) {
							exc.printStackTrace();
						}
					 break;
				 default: System.out.println("Invalid input");
				 	break;
				 }
				 break;
			 case 3:
				 System.out.println("Enter in TripNumber");
				 int TripNumber = s1.nextInt();
				 displayTripStops(TripNumber);
             	break;
			 case 4:  
				 System.out.println("Please enter in driver and date for weekly schedule");
				 System.out.print("Driver: ");
				 String DriverName4 = s1.next();
				 System.out.print("\n");
				 System.out.print("Date: ");
				 String Date4 = s1.next();
				 System.out.print("\n");
				 displaySchedule(DriverName4, Date4);
				 break;
			 case 5:
				 System.out.println("Please enter in the driver name and Driver Telephone Number");
				 System.out.print("Driver Name: ");
				 String DriverName5 = s1.next();
				 System.out.print("\n");
				 System.out.print("Driver's Telephone Number: ");
				 int DriverTelephoneNumber5 = s1.nextInt();
				 addDriver(DriverName5, DriverTelephoneNumber5);
             	break;
			 case 6:
				 System.out.println("Please enter in the BusID, Model, and Year");
				 System.out.print("BusID: ");
				 int BusID6 = s1.nextInt();
				 System.out.print("\n");
				 System.out.print("Model: ");
				 String Model = s1.next();
				 System.out.print("\n");
				 System.out.print("Year: ");
				 int Year = s1.nextInt();
				 System.out.print("\n");
				 addBus(BusID6, Model, Year);
			 	break;
			 case 7:
				 System.out.print("Please enter in BusID to delete: ");
				 int BusID7 = s1.nextInt();
				 System.out.print("\n");
				 deleteBus(BusID7);
			 	break;
			 case 8:  
				System.out.print("Please enter in the required information to record the data");
				System.out.print("TripNumber: ");
				int TripNumber8 = s1.nextInt();
				System.out.print("\n");
				System.out.print("Date: ");
				String Date8 = s1.next();
				System.out.print("\n");
				System.out.print("ScheduledStartTime: ");
				String ScheduledStartTime8 = s1.next();
				System.out.print("\n");
				System.out.print("StopNumber: ");
				int StopNumber8 = s1.nextInt();
				System.out.print("\n");
				System.out.print("ActualStartTime: ");
				String ActualStartTime8 = s1.next();
				System.out.print("\n");
				System.out.print("ActualArrivalTime: ");
				String ActualArrivalTime8 = s1.next();
				System.out.print("\n");
				System.out.print("NumberOfPassengersIn: ");
				int NumberOfPassengersIn8 = s1.nextInt();
				System.out.print("\n");
				System.out.print("NumberOfPassengersOut: ");
				int NumberOfPassengersOut8 = s1.nextInt();
				System.out.print("\n");
			 	break;
			 case 9:
				 done = true;
				 break;
			 default: System.out.println("Invalid input");
             break;
			}
		}
		
	}
	
	public static void menu() {
		System.out.println("1. Display schedule of trips");
		System.out.println("2. Edit schedule");
		System.out.println("3. Display the stops of a given trip");
		System.out.println("4. Display weekly schedule of a given driver and date");
		System.out.println("5. Add a driver");
		System.out.println("6. Add a bus");
		System.out.println("7. Delete a bus");
		System.out.println("8. Record actual data of a given trip");
		System.out.println("9. Exit");
	}
	
	public static void menu2() {
		System.out.println("1. Delete a trip offering specified by Trip#, Date, and ScheduledStartTime");
		System.out.println("2. Add a set of trip offerings assuming the values of all attributes are given");
		System.out.println("3. Change the driver for a given Trip offering (i.e given TripNumber, Date, ScheduledStartTime)");
		System.out.println("4. Change the bus for a given Trip offering.");
	}
	
	/*
	 * #1
	 */
	
	public static void displayScheduledTrips(String StartLocationName, String DestinationName, String Date) {
		try {
			//Edit to fit your database
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			Statement myStatement = myConn.createStatement();
			
			ResultSet myRs = myStatement.executeQuery("select TOF.ScheduledStartTime, TOF.ScheduledArrivalTime, "
					+ "TOF.DriverName, TOF.BusID FROM TripOffering TOF, Trip T WHERE TOF.TripNumber = T.TripNumber AND T.StartLocationName = " + 
					StartLocationName + " AND T.DestinationName = " + DestinationName + " AND TOF.Date = " + Date);
			while(myRs.next()) {
				System.out.print(myRs.getString("ScheduledStartTime") + ", " + myRs.getString("ScheduledArrivalTime") + ", " 
				+ myRs.getString("DriverName") + ", " + myRs.getString("BusID"));
				}
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	

	//======================================================================//
	
	
	
	
	/*
	 * #3
	 */
	
	public static void displayTripStops(int TripNumber) {
		try {
			//Edit to fit your database
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			Statement myStatement = myConn.createStatement();
			
			ResultSet myRs = myStatement.executeQuery("SELECT TS.TripNumber, TS.StopNumber, TS.SequenceNumber, TS.DrivingTime FROM TripStopInfo TS "
					+ "WHERE TS.TripNumber = " + TripNumber);
			while(myRs.next()) {
				System.out.print(myRs.getString("TripNumber") + ", " + myRs.getString("StopNumber") + ", " 
				+ myRs.getString("SequenceNumber") + ", " + myRs.getString("DrivingTime"));
				}
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	/*
	 * #4
	 */
	
	public static void displaySchedule(String DriverName, String Date) {
		try {
			//Edit to fit your database
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			Statement myStatement = myConn.createStatement();
			
			ResultSet myRs = myStatement.executeQuery("SELECT T.TripNumber, T.StartLocationName, T.DestinationName, "
					+ "TOF.ScheduledStartTime, TOF.ScheduledArrivalTime FROM Trip T, TripOffering TOF WHERE T.TripNumber = TOF.TripNumber AND TOF.DriverName = " 
					+ DriverName + " AND TOF.Date = " + Date);
			while(myRs.next()) {
				System.out.print(myRs.getString("TripNumber") + ", " + myRs.getString("StartLocationName") + ", " 
				+ myRs.getString("DestinationName") + ", " + myRs.getString("ScheduledStartTime") + ", " + myRs.getString("ScheduledArrivalTime"));
				}
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	/*
	 * #5
	 */
	
	public static void addDriver(String DriverName, int DriverTelephoneNumber) {
		try {
			//Edit to fit your database
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			Statement myStatement = myConn.createStatement();
			
			String sql = "INSERT INTO driver (DriverName, DriverTelephoneNumber) VALUES (" + DriverName + ", " + DriverTelephoneNumber + ")";
			myStatement.executeUpdate(sql);
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	/*
	 * #6
	 */
	
	public static void addBus(int BusID, String Model, int Year) {
		try {
			//Edit to fit your database
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			Statement myStatement = myConn.createStatement();
			
			String sql = "INSERT INTO bus (BusID, Model, Year) VALUES (" + BusID + ", " + Model + ", " + Year + ")";
			myStatement.executeUpdate(sql);		
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	/*
	 * #7
	 */
	
	public static void deleteBus(int BusID) {
		try {
			//Edit to fit your database
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			Statement myStatement = myConn.createStatement();
			
			String sql = "DELETE FROM bus WHERE BusID = " + BusID;
			myStatement.executeUpdate(sql);		
			System.out.println("Bus with ID " + BusID + " has been deleted.");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	
	/*
	 * #8
	 */
	
	public static void insertData(int TripNumber, String Date, String ScheduledStartTime, int StopNumber, String ActualStartTime, String ActualArrivalTime, int PassengersIn, int PassengersOut) {
		try {
			//Edit to fit your database
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			Statement myStatement = myConn.createStatement();
			
			String sql = "INSERT INTO actualtripstopinfo(TripNumbner, Date, ScheduledStartTime) VALUES( " + TripNumber + ", " + Date + ", " + ScheduledStartTime + ")";
			myStatement.executeUpdate(sql);		
			String sql2 = "UPDATE actualtripstopinfo SET StopNumber = " + StopNumber + " WHERE (TripNumber " + TripNumber + " AND Date = " + Date + " AND ScheduledStartTime = " + ScheduledStartTime + ")";
			myStatement.executeUpdate(sql2);
			String sql3 = "UPDATE actualtripstopinfo SET ActualStartTime = " + ActualStartTime + ", ActualArrivalTime = " + ActualArrivalTime + ", NumberOfPassengersIn = " + PassengersIn + ", NumberOfPassengersOut = " + PassengersOut + 
					" WHERE (TripNumber " + TripNumber + " AND Date = " + Date + " AND ScheduledStartTime = " + ScheduledStartTime + "AND StopNumber = " + StopNumber + ")";
			myStatement.executeUpdate(sql3);
			System.out.println("Recording Complete.");
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}