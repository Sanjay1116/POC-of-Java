package poc2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class StudentInsert {
	public static void main(String[]args){
		
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/poc2", "root", "$anjay@161101");
			 Statement st=con.createStatement();
			
			FileInputStream fstream = new FileInputStream("C:\\Users\\sanjayraman.sriram\\Documents\\POC-Data\\input.txt");
			    DataInputStream in = new DataInputStream(fstream);
			    BufferedReader br = new BufferedReader(new InputStreamReader(in));
			    String strLine;
			    ArrayList list=new ArrayList();
			    while ((strLine = br.readLine()) != null){
			    list.add(strLine);
			    }
			  Iterator itr;
			    for (itr=list.iterator(); itr.hasNext(); ){
			  String str=itr.next().toString();  
			    String [] splitSt =str.split("	");
			    String studid="	",fname="	",lname="	",deptid=" ",jod=" ",dob=" ",mob=" ",email=" ";
			    
			      for (int i = 0 ; i < splitSt.length ; i++)
			    	  {
			         studid=splitSt[0];
			     fname=splitSt[1];
			     lname=splitSt[2];
			     deptid=splitSt[3];
			     jod=splitSt[4];
			     dob=splitSt[5];
			     mob=splitSt[6];
			     email=splitSt[7];
			    }
			
			int k=st.executeUpdate("insert into student(studentid,fullname,lastname,departmentid,joiningDate,studentDob,mobileNo,email) "
					+ "values('"+studid+"','"+fname+"','"+lname+"','"+deptid+"','"+jod+"','"+dob+"','"+mob+"','"+email+"')");
			    System.out.println("Insert Success");
			}
			}
			catch(Exception e){
				System.out.println(e);
			}
		}

}
