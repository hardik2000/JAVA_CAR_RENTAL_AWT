/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.awpproject;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.JScrollPane;

public class Car
{ 

    private static final int WIDTH = 800;
    private static final int HEIGHT = 500;
    JFrame frame;
    JPanel panel;
    Image icon;
    
    static String type,mfgyear,capacity,fueltype,color,no;
     
    String msg;    
        
        
    JButton jButton1=new JButton();
    JLabel jLabel5=new JLabel();
    JLabel jLabel1=new JLabel();
    JLabel jLabel2=new JLabel();
    JLabel jLabel3=new JLabel();
    JLabel jLabel4=new JLabel();
    JTextArea jTextArea=new JTextArea();
    JScrollPane scroll;
	
//////////////////////////////////////////////////////////CONSTRUCTER//////////////////////////////////////////
	Car(Customer customer)
	{
            type="";
            mfgyear="";
            capacity="";
            fueltype="";
            color="";
            no="";
            
		JFrame frame = new JFrame();
		icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\HARDIK\\Documents\\NetBeansProjects\\AWPPROJECT\\src\\main\\java\\com\\mycompany\\awpproject\\Images/logo.jfif");  
		frame.setIconImage(icon);  
		frame.setTitle("CAR RENTAL SYSTEM");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		//frame.setLocation(500,300);
		panel =new JPanel();
		//panel.setLayout(new FlowLayout());
		panel.setLayout(null);
                panel.setBackground(Color.WHITE);
		
                jLabel5.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
                jLabel5.setText("CHOOSE A CAR FROM BELOW BY CLICKING ON THE IMAGE");

		jLabel1 = new JLabel(new ImageIcon("C:\\Users\\HARDIK\\Documents\\NetBeansProjects\\AWPPROJECT\\src\\main\\java\\com\\mycompany\\awpproject\\Images/pickup.gif"));
		jLabel1.addMouseListener(new java.awt.event.MouseAdapter() 
		{
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) 
                    {
                        jTextArea.setText("MINI CAR :\n");
                        type="MINI";
                        Boolean found=false;
                        try
                        {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/awp","root","root");
                            PreparedStatement ps;
                            ps = conn.prepareStatement("SELECT * FROM car WHERE type='MINI';");
                            ResultSet result=ps.executeQuery();
                            while (result.next() && found==false) 
                            {
                                if(result.getString(7).equals("true"))
                                {
                                    mfgyear=result.getString(2);
                                    capacity=result.getString(3);
                                    fueltype=result.getString(4);
                                    color=result.getString(5);
                                    no=result.getString(6);
                                    jTextArea.setText("MINI CAR :\n"
                                            + "TYPE : "+type+"\n"
                                            + "MFG YEAR :"+mfgyear+"\n"
                                            + "CAPACITY :"+capacity+"\n"
                                            + "FUEL TYPE :"+fueltype+"\n"
                                            + "COLOR :"+color+"\n"
                                            + "NUBER :"+no+"\n"
                                            );
                                    

                                    found=true;
                                }
                              
                            }
                            if(found==false)
                            {
                                jTextArea.setText("MINI CAR :\nNO CAR AVAILABLE \nCHOOSE SOME OTHER TYPE\n");
                            }
                            
                        }
                        catch(SQLException | ClassNotFoundException err)
                        {
                            msg="INVALID ENTRY"+err.getMessage();
                        }
                        
                        
                        customer.InsertData(type,mfgyear,capacity,fueltype,color,no);
                        customer.puttype("MINI");
                    }
                });
		
		jLabel2 = new JLabel(new ImageIcon("C:\\Users\\HARDIK\\Documents\\NetBeansProjects\\AWPPROJECT\\src\\main\\java\\com\\mycompany\\awpproject\\Images/van.gif"));
		jLabel2.addMouseListener(new java.awt.event.MouseAdapter() 
		{
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) 
                    {
                         jTextArea.setText("MICRO CAR :\n");
                        type="MICRO";
                        Boolean found=false;
                        try
                        {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/awp","root","root");
                            PreparedStatement ps;
                            ps = conn.prepareStatement("SELECT * FROM car WHERE type='MICRO';");
                            ResultSet result=ps.executeQuery();
                            while (result.next() && found==false) 
                            {
                                if(result.getString(7).equals("true"))
                                {
                                    mfgyear=result.getString(2);
                                    capacity=result.getString(3);
                                    fueltype=result.getString(4);
                                    color=result.getString(5);
                                    no=result.getString(6);
                                    jTextArea.setText("MICRO CAR :\n"
                                            + "TYPE : "+type+"\n"
                                            + "MFG YEAR :"+mfgyear+"\n"
                                            + "CAPACITY :"+capacity+"\n"
                                            + "FUEL TYPE :"+fueltype+"\n"
                                            + "COLOR :"+color+"\n"
                                            + "NUBER :"+no+"\n"
                                            );
                                    

                                    found=true;
                                }
                              
                            }
                            if(found==false)
                            {
                                jTextArea.setText("MICRO CAR :\nNO CAR AVAILABLE \nCHOOSE SOME OTHER TYPE\n");
                            }
                            
                        }
                        catch(SQLException | ClassNotFoundException err)
                        {
                            msg="INVALID ENTRY"+err.getMessage();
                        }
                        
                        
                        customer.InsertData(type,mfgyear,capacity,fueltype,color,no);
                        customer.puttype("MICRO");
                    }
                    
                });
		
		jLabel3 = new JLabel(new ImageIcon("C:\\Users\\HARDIK\\Documents\\NetBeansProjects\\AWPPROJECT\\src\\main\\java\\com\\mycompany\\awpproject\\Images/jeepney.gif"));
		jLabel3.addMouseListener(new java.awt.event.MouseAdapter() 
		{
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) 
                    {
                         jTextArea.setText("PRIME CAR :\n");
                        type="PRIME";
                        Boolean found=false;
                        try
                        {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/awp","root","root");
                            PreparedStatement ps;
                            ps = conn.prepareStatement("SELECT * FROM car WHERE type='PRIME';");
                            ResultSet result=ps.executeQuery();
                            while (result.next() && found==false) 
                            {
                                if(result.getString(7).equals("true"))
                                {
                                    mfgyear=result.getString(2);
                                    capacity=result.getString(3);
                                    fueltype=result.getString(4);
                                    color=result.getString(5);
                                    no=result.getString(6);
                                    jTextArea.setText("PRIME CAR :\n"
                                            + "TYPE : "+type+"\n"
                                            + "MFG YEAR :"+mfgyear+"\n"
                                            + "CAPACITY :"+capacity+"\n"
                                            + "FUEL TYPE :"+fueltype+"\n"
                                            + "COLOR :"+color+"\n"
                                            + "NUBER :"+no+"\n"
                                            );
                                    

                                    found=true;
                                }
                              
                            }
                            if(found==false)
                            {
                                jTextArea.setText("PRIME CAR :\nNO CAR AVAILABLE \nCHOOSE SOME OTHER TYPE\n");
                            }
                            
                        }
                        catch(SQLException | ClassNotFoundException err)
                        {
                            msg="INVALID ENTRY"+err.getMessage();
                        }
                        
                        
                        customer.InsertData(type,mfgyear,capacity,fueltype,color,no);
                        customer.puttype("PRIME");
                    }
                    
                });
		
		jLabel4 = new JLabel(new ImageIcon("C:\\Users\\HARDIK\\Documents\\NetBeansProjects\\AWPPROJECT\\src\\main\\java\\com\\mycompany\\awpproject\\Images/limousine.gif"));
		jLabel4.addMouseListener(new java.awt.event.MouseAdapter() 
		{
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) 
                    {
                         jTextArea.setText("SEDAN CAR :\n");
                        type="SEDAN";
                        Boolean found=false;
                        try
                        {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/awp","root","root");
                            PreparedStatement ps;
                            ps = conn.prepareStatement("SELECT * FROM car WHERE type='SEDAN';");
                            ResultSet result=ps.executeQuery();
                            while (result.next() && found==false) 
                            {
                                if(result.getString(7).equals("true"))
                                {
                                    mfgyear=result.getString(2);
                                    capacity=result.getString(3);
                                    fueltype=result.getString(4);
                                    color=result.getString(5);
                                    no=result.getString(6);
                                    jTextArea.setText("SEDAN CAR :\n"
                                            + "TYPE : "+type+"\n"
                                            + "MFG YEAR :"+mfgyear+"\n"
                                            + "CAPACITY :"+capacity+"\n"
                                            + "FUEL TYPE :"+fueltype+"\n"
                                            + "COLOR :"+color+"\n"
                                            + "NUBER :"+no+"\n"
                                            );
                                    

                                    found=true;
                                }
                              
                            }
                            if(found==false)
                            {
                                jTextArea.setText("SEDAN CAR :\nNO CAR AVAILABLE \nCHOOSE SOME OTHER TYPE\n");
                            }
                            
                        }
                        catch(SQLException | ClassNotFoundException err)
                        {
                            msg="INVALID ENTRY"+err.getMessage();
                        }
                        
                        
                        customer.InsertData(type,mfgyear,capacity,fueltype,color,no);
                        customer.puttype("SEDAN");
                    }
                });
		
		
		jTextArea.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		jTextArea.setText("");
                jTextArea.setEditable(false);
		scroll = new JScrollPane(jTextArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		
		
		jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
                jButton1.setText("CONFIRM");
		jButton1.addMouseListener(new java.awt.event.MouseAdapter() 
		{
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) 
                    {
                            try
                            {
                                 Connection conn1;
                                 conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/awp","root","root");
                                 PreparedStatement ps1;
                                 ps1 = conn1.prepareStatement("UPDATE car SET status='false' WHERE no=?;");
                                 ps1.setString(1,no);
                                 ps1.executeUpdate();

                            }
                            catch(SQLException err)
                            {
                                JOptionPane.showMessageDialog(frame,"INVALID ENTRY"+err.getMessage());

                            }


                             frame.setVisible(false);
                             Date date = new Date(customer);
                    }
                
                });

		
	

                panel.add(jButton1);
		panel.add(jLabel5);
		panel.add(jLabel1);
		panel.add(jLabel2);
		panel.add(jLabel3);
		panel.add(jLabel4);
		panel.add(scroll);
		
	
		jLabel5.setBounds(20,20,750,50);
		jLabel1.setBounds(20,100,200,100);
		jLabel2.setBounds(250,100,200,100);
		jLabel3.setBounds(20,250,200,100);
		jLabel4.setBounds(250,250,200,100);
		scroll.setBounds(480,100,270,250);
	

		jButton1.setBounds(630,400,120,50);
		
		
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
	}

}
