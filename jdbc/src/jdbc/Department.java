package jdbc;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Department{
	
public static void main(String[]args){
	
	try{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/poc", "root", "$anjay@161101");
		 Statement st=con.createStatement();
		
		FileInputStream fstream = new FileInputStream("C:\\Users\\sanjayraman.sriram\\Documents\\POC-DBData\\Department.txt");
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
		    String deptid="	",deptname="	";
		      for (int i = 0 ; i < splitSt.length ; i++)
		    	  {
		         deptid=splitSt[0];
		     deptname=splitSt[1];
		     
		    }
		      
		int k=st.executeUpdate("insert into department(departmentid,departmentname) values('"+deptid+"','"+deptname+"')");
		    System.out.println("Insert Success");
		}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}