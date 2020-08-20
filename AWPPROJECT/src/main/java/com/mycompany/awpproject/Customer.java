/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.awpproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;  

public class Customer
{

	private String firstname,lastname,mobileno,gender,emailid,password,dob,address;
	private boolean Loginstatus=false;
	Scanner sc =new Scanner(System.in);
	
	private String mfgyear,capacity,fueltype,color;
	public String type,number;
	public boolean status;
	private int Rate;
	
	private String startdate,enddate;
	
	public String[] name;
	private final String[] Phoneno;
    	private final String[] Licenseno;
        
        
        int rand=-1;
	
	public Customer() 
	{
            this.name = new String[6];
            this.Phoneno = new String[6];
            this.Licenseno = new String[6];
		firstname="";
		lastname="";
		mobileno="";
		emailid="";
		password="";
		dob="";
		address="";
		
		type="";
		mfgyear="";
		capacity="";
		fueltype="";
		color="";
		number="";
		Rate=0;
		status=true;
		
		startdate="";
		enddate="";
		
		name[0]="Rahul Meet";
		name[1]="Kamal Dass";
		name[2]="Arjun Singh";
		name[3]="kamal Singh";
		name[4]="deep Singh";
		name[5]="kapeel Dev";
		
		
		Phoneno[0]="7011456987";
		Phoneno[1]="1478965230";
		Phoneno[2]="1254789630";
		Phoneno[3]="1254712547";
		Phoneno[4]="1254712542";
		Phoneno[5]="1254798999";
		
		Licenseno[0]="MC12547896";
		Licenseno[1]="NC12563478";
		Licenseno[2]="ABG5223698";
		Licenseno[3]="ASD4523698";
		Licenseno[4]="ND14523698";
		Licenseno[5]="MN11542980";
		
		
	
	}
	public boolean CheckData(String email,String password)
	{
            Loginstatus=false;
		
            //database se retreive kar ke check karega
            String msg="";
            String id;
            id = "";
            String pass;
            pass = "";
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/awp","root","root");
                PreparedStatement ps=conn.prepareStatement("SELECT * FROM customer;");
                ResultSet result=ps.executeQuery();
                while (result.next()) 
                {
                    this.firstname=result.getString(1);
                    this.lastname=result.getString(2);
                    this.mobileno=result.getString(3);
                    
                    id=result.getString(5);
                    this.emailid=id;
                    
                    pass=result.getString(6);
                    this.password=pass;
                    if(id.equals(email) && pass.equals(password))
                    {
                        Loginstatus=true;
                    }
                }
            }
            catch(SQLException | ClassNotFoundException err)
            {
                msg="INVALID ENTRY"+err.getMessage();
            }
            if(!msg.equals(""))
            {
                Loginstatus=false;
            }
                
            return Loginstatus;
	}	
	
	public String InsertData()
	{
            String msg="";
		//database main insert karna
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/awp","root","root");
                PreparedStatement ps=conn.prepareStatement("INSERT INTO customer(firstname,lastname,mobileno,gender,email,password,address,dob) VALUES(?,?,?,?,?,?,?,?);");
                ps.setString(1,firstname);
		ps.setString(2,lastname);
		ps.setString(3,mobileno);
		ps.setString(4,gender);
		ps.setString(5,emailid);
		ps.setString(6,password);
		ps.setString(7, address);
		ps.setString(8, dob);
                ps.executeUpdate();
                
            }
            catch(SQLException | ClassNotFoundException err)
            {
                msg="INVALID ENTRY"+err.getMessage();
            }
            return msg;
	}
	
	public void putfirstname(String firstname)
	{
		this.firstname=firstname;
        } 
	public void putlastname(String lastname)
	{
		this.lastname=lastname;
        } 
	public void putmobileno(String mobileno)
	{
		this.mobileno=mobileno;
        }
        public void putgender(String gender)
	{
		this.gender=gender;
        } 
	public void putemailid(String emailid)
	{
		this.emailid=emailid;
        } 
	public void putpassword(String password)
	{
		this.password=password;
        } 
	public void putaddress(String address)
	{
		this.address=address;
        } 
	public void putdob(String dob) 
	{
		this.dob=dob;
        } 
	public void puttype(String type)
	{
		this.type=type;
	}
	public void putstartdate(String type)
	{
		this.startdate=type;
	}
	public void putenddate(String type)
	{
		this.enddate=type;
	}
	public String getname()
	{
		return (firstname+" "+lastname);
	}
	public String mobileno()
	{
		return (mobileno);
	}
	
	public void InsertData(String type,String mfgyear,String capacity,String fueltype,String color,String number)
	{
            this.type=type;
            this.mfgyear=mfgyear;
            this.capacity=capacity;
            this.fueltype=fueltype;
            this.color=color;
            this.number=number;
            	
	}	
	public int ShowRate()
	{
		if(this.type.equals("MICRO"))
		{
			Rate=50;
		}
		else if(this.type.equals("MINI"))
		{
			Rate=25;
		}
		else if(this.type.equals("SEDAN"))
		{
			Rate=75;
		}
		else if(this.type.equals("PRIME"))
		{
			Rate=100;
		}
		return Rate;
	}
        public String ShowDetails()
	{
		String outMe="";
		outMe += String.format("----------------------------------------------------------------\n");
		outMe += String.format("THE DETAILS OF THE CAR ARE AS FOLLOWS	: \n\n");
		outMe += String.format("TYPE				: %s\n",type);
		outMe += String.format("MFG YEAR				: %s\n",mfgyear);
		outMe += String.format("NO OF PERSONS ALLOWED			: %s\n",capacity);
		outMe += String.format("FUEL TYPE				: %s\n",fueltype);
		outMe += String.format("COLOR OF THE BODY			: %s\n",color);
		outMe += String.format("PLATE NUMBER			: %s\n",number);
		return (outMe);
	}	
	public String toStringReceipt() {
                
                this.Rate=ShowRate();
		String outMe = "";
		
		outMe += String.format("               	             MADHAN's CAR RENTAL SERVICE\n");
		outMe += String.format("                              Owned & Operated By:\n");
		outMe += String.format("                                      G MADHAN REDDY\n");
		outMe += String.format("                             RENTAL TRANSACTION\n");
		outMe += String.format("-----------------------------------------------------------------------------------------------------\n");
		outMe += String.format("Car			%s\n", type);
		outMe += String.format("StartDate		%s\n", startdate);
		outMe += String.format("EndDate                 	%s\n", enddate);
		outMe += String.format("Rental Price            	%d\n", Rate);
		outMe += String.format("            --------------\n");
		outMe += String.format("Total Payment           	%d\n",Rate);
		outMe += String.format("TO :"+ getname());
		return outMe;
	}
	public String ShowDriverDetails(int k)
	{   
            int max = 6; 
            int min = 1; 
            int range = max - min + 1; 
            this.rand = (int)(Math.random() * range) + min; 	
					
             
            
		String outMe="";
		outMe += String.format("----------------------------------------------\n");
		outMe += String.format("THE DETAILS OF THE DRIVER ARE AS FOLLOWS	: \n\n");
		outMe += String.format("NAME				:%s\n",name[rand]);
		outMe += String.format("PHONENO				:%s\n",Phoneno[rand]);
		outMe += String.format("LICENSENO				:%s\n",Licenseno[rand]);
		return (outMe);
                
	}
        public String transaction()
        {
            String firstname,lastname,mobileno,email,password,type,carno,startdate,enddate,rate;
            firstname=this.firstname;
            lastname=this.lastname;
            mobileno=this.mobileno;
            email=this.emailid;
            password=this.password;
            type=this.type;
            carno=this.number;
            startdate=this.startdate;
            enddate=this.enddate;
             
            String msg="";
		//database main insert karna
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn2=DriverManager.getConnection("jdbc:mysql://localhost:3306/awp","root","root");
                PreparedStatement ps2=conn2.prepareStatement("INSERT INTO record(firstname,lastname,mobileno,email,passsword,type,carno,startdate,enddate) VALUES(?,?,?,?,?,?,?,?,?);");
                ps2.setString(1,firstname);
		ps2.setString(2,lastname);
		ps2.setString(3,mobileno);
		ps2.setString(4,email);
		ps2.setString(5,password);
		ps2.setString(6,type);
		ps2.setString(7,carno);
		ps2.setString(8,startdate);
                ps2.setString(9,enddate);
               
                
                ps2.executeUpdate();
                
            }
            catch(SQLException | ClassNotFoundException err)
            {
                msg="INVALID ENTRY"+err.getMessage();
            }
           
            
            return msg;
         
        }
        
        
	
	
}
