package collectn;

import java.sql.*;
import java.util.*;
import oracle.jdbc.driver.OracleDriver;

import java.text.ParseException;
import java.util.Date;

public class assignment {

public static void main(String args[]) throws ParseException {
Driver d;
Connection conn = null;

try {
// -------------------load and register the driver----------------------

System.out.println("Loading the driver");
d = new OracleDriver();
DriverManager.registerDriver(d);

System.out.println("Registering driver complete");
// establish connection with the database

String userName = "hr";
String password = "hr";
String url = "jdbc:oracle:thin:@192.168.1.59:1521:xe";

System.out.println("Creating a connection");
conn = DriverManager.getConnection(url, userName, password);
System.out.println("Connection created");

conn.setAutoCommit(false);

// ------------------switch case-----------------------------

int choice;

System.out.print("Enter a choice\n1.Insert\n2.Read\n3.Delete\n4.Update\n");
Scanner in = new Scanner(System.in);

choice = in.nextInt();

do {

switch (choice) {
case 1: // INSERT......................................................

String query = "insert into patients values(?,?,?,?)";

PreparedStatement pstmt = conn.prepareStatement(query);

int patientId, presId;
String name, email, medName;

System.out.println("Enter patient id");
patientId = in.nextInt();
System.out.println("Enter patient name");
name = in.next();
System.out.println("Enter email");
email = in.next();

Date date = new Date();

java.sql.Date registeredDate = new java.sql.Date(date.getTime());

pstmt.setInt(1, patientId);
pstmt.setString(2, name);
pstmt.setString(3, email);
pstmt.setDate(4, registeredDate);

int res = pstmt.executeUpdate();

System.out.println(res + "row(s) inserted");

String query1 = "insert into prescriptions values(?,?,?,?)";

System.out.println(" Enter prescription details:\nPrescription Id");
presId = in.nextInt();

System.out.println("Enter medicine name");
medName = in.next();

PreparedStatement pstmt1 = conn.prepareStatement(query1);

pstmt1.setInt(1, presId);
pstmt1.setDate(2, registeredDate);
pstmt1.setInt(3, patientId);
pstmt1.setString(4, medName);

res = pstmt1.executeUpdate();

System.out.println(res + "row(s) inserted");

conn.commit();

break;
case 2: //display....................................................



query = "Select * from patients";

Statement stmt= conn.createStatement();

ResultSet rs=stmt.executeQuery(query);

conn.commit();
while (rs.next()) {
System.out.println("\nPatient id: " + rs.getInt("patient_id") + "\nName : "
+ rs.getString("patient_name") + "\n Email" + rs.getString("email")
+ "\n Registered Date: " + rs.getDate("registered_date"));

}

break;
case 3:// DELETE .....................................................

query = "delete from patients where patient_id=?";
String query2 = "delete from prescriptions where patient_id=?";
pstmt1 = conn.prepareStatement(query2);

int id;

System.out.println("Enter patient id to delete");

id = in.nextInt();

pstmt1.setInt(1, id);

res = pstmt1.executeUpdate();

pstmt1 = conn.prepareStatement(query);
pstmt1.setInt(1, id);

res = pstmt1.executeUpdate();

System.out.println(res + "row(s) deleted from prescriptions");
System.out.println(res + "row(s) deleted from patients");

conn.commit();

break;

case 4: //update details..........................................
	
query = "update patients set patient_name= ? where patient_id=?";
query1 = "update patients set email= ? where patient_id=?";

PreparedStatement pstmt2 = conn.prepareStatement(query);
PreparedStatement pstmt3 = conn.prepareStatement(query1);

conn.prepareStatement(query);
conn.prepareStatement(query1);

System.out.println("Enter patirnt id whose details to update");

id=in.nextInt();

System.out.println("Enter new name");

                    name= in.next();

pstmt2.setString(1,name );

pstmt2.setInt(2,id);

res = pstmt2.executeUpdate();

System.out.println("Enter new email");

                    String em= in.next();

pstmt3.setString(1,em );

pstmt3.setInt(2,id);

res = pstmt3.executeUpdate();

System.out.println(res + "row(s) updated");

conn.commit();
break;


}

System.out.print("Enter a choice\n1.Insert\n2.Read\n3.Delete\n4.Update\n");

choice = in.nextInt();

} while (choice < 5);

} catch (SQLException e) {
try {
System.out.println("Error occured..rolling back transaction");
conn.rollback();
} catch (SQLException x) {
x.printStackTrace();
}

e.printStackTrace();
} finally {
try {
conn.close();
System.out.println("Closing the connection");

} catch (SQLException e) {

System.err.println("Error while closing connection");
e.printStackTrace();
}

}
}
}
