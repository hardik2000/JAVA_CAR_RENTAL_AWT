/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.awpproject;
import com.mycompany.awpproject.Signup;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Loginform
{ 

	private static final int WIDTH = 800;
	private static final int HEIGHT = 500;
	JFrame frame;
	JPanel panel;
	Image icon;
	//JLabel imglabel,imglabel1;
	
	JButton jButton1=new JButton();
    JButton jButton2=new JButton();
    JButton jButton3=new JButton();
    JComboBox<String> jComboBox1=new JComboBox<String>();
    JLabel jLabel1=new JLabel();
    JLabel jLabel2=new JLabel();
    JLabel jLabel3=new JLabel();
    JLabel jLabel4=new JLabel();
    JTextField jTextField1;
    JPasswordField jTextField2=new JPasswordField();
	
	Customer customer;
        Connection conn;
        PreparedStatement ps;

	
//////////////////////////////////////////////////////////CONSTRUCTER//////////////////////////////////////////
	Loginform()
	{
		JFrame frame = new JFrame();
		customer=new Customer();
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
		
        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        jLabel1.setText("LOGIN FORM");

        jLabel2.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel2.setText("TYPE");

        jComboBox1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"select", "ADMIN", "USER"}));
        
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("LOGIN ID");

        
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("PASSWORD");

		jTextField1=new JTextField();
		jTextField1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
                jTextField1.setText("LOGIN ID");
		jTextField1.addFocusListener(new java.awt.event.FocusListener ()
		{
                        @Override
			public void focusGained(java.awt.event.FocusEvent e) 
			{
				if(jTextField1.getText().equals("LOGIN ID"))
				{
					jTextField1.setText("");
				}
				

			}
                        @Override
			public void focusLost(java.awt.event.FocusEvent f)
			{
				if(jTextField1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(frame,"PLEASE ENTER A VALID LOGIN ID");
					jTextField1.requestFocus();
					
				}
			}
		});
		
		
        jTextField2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextField2.setText("PASSWORD");
        jTextField2.addFocusListener(new java.awt.event.FocusListener ()
		{
                        @Override
			public void focusGained(java.awt.event.FocusEvent e) 
			{
				if(!jTextField1.getText().equals(""))
				{
					if(jTextField2.getText().equals("PASSWORD"))
					{
						jTextField2.setText("");
					}
				}

			}
                        @Override
			public void focusLost(java.awt.event.FocusEvent f)
			{
				if(!jTextField1.getText().equals(""))
				{
					if(jTextField2.getText().equals(""))
					{
						JOptionPane.showMessageDialog(frame,"PLEASE ENTER A VALID PASSWORD");
						jTextField2.requestFocus();
					}
				}
			}
		});
		

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                if(jComboBox1.getSelectedItem().toString().equals("ADMIN"))
                {
                        //database se retreive kar ke check karega
                        Boolean Loginstatus=false;
                        String msg="";
                        String id;
                        String pass;
                        try
                        {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/awp","root","root");
                            PreparedStatement ps=conn.prepareStatement("SELECT * FROM admin;");
                            ResultSet result=ps.executeQuery();
                            while (result.next()) 
                            {
                                id=result.getString(1);
                                pass=result.getString(2);
                                

                                if(id.equals(jTextField1.getText()) && pass.equals(jTextField2.getText()))
                                {
                                    Loginstatus=true;
                                }
                            }
                        }
                        catch(SQLException | ClassNotFoundException err)
                        {
                            JOptionPane.showMessageDialog(frame,"INVALID ENTRY"+err.getMessage());
                            Loginstatus=false;
                        }
                            
                        if(Loginstatus)
                        {
                            frame.setVisible(false);
                            new Admin();
                            
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(frame,"INVALID ENTRY ENTER AGAIN");
                        }
                 
                }
                else if(jComboBox1.getSelectedItem().toString().equals("USER"))
                {
                    if(customer.CheckData(jTextField1.getText(),jTextField2.getText()))
                    {
			
                        frame.setVisible(false);
			Car car=new Car(customer);
                    }
                    else
                    {
			JOptionPane.showMessageDialog(frame,"INVALID ENTRY ENTER AGAIN");
			jTextField1.setText("LOGIN ID");
			jTextField2.setText("PASSWORD");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(frame,"PLEASE CHOOSE ANY ONE FROM COMBOBOX");
                    jTextField1.setText("LOGIN ID");
                    jTextField2.setText("PASSWORD");
                    
                }
            }
            });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setText("CLEAR");
        jButton2.addActionListener((java.awt.event.ActionEvent evt) -> 
        {
            // jButton2ActionPerformed(evt);
            jComboBox1.setSelectedIndex(0);
            jTextField1.setText("LOGIN ID");
            jTextField2.setText("PASSWORD");
        });

        
	jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setText("SIGN UP");
	jButton3.addMouseListener(new java.awt.event.MouseAdapter() 
	{
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) 
            {
		frame.setVisible(false);
                Signup signform=new Signup(customer);
            }
        });

		
	

                panel.add(jButton1);
		panel.add(jButton2);
		panel.add(jButton3);
		panel.add(jComboBox1);
		panel.add(jLabel1);
		panel.add(jLabel2);
		panel.add(jLabel3);
		panel.add(jLabel4);
		panel.add(jTextField1);
		panel.add(jTextField2);
		
	
		jLabel1.setBounds(320,30,200,30);
		jLabel2.setBounds(100,100,100,30);
		jLabel3.setBounds(100,180,100,30);
		jLabel4.setBounds(100,260,100,30);
		jTextField1.setBounds(450,180,250,30);
		jTextField2.setBounds(450,260,250,30);
		jComboBox1.setBounds(450,100,250,30);


		jButton1.setBounds(100,340,100,50);
		jButton2.setBounds(350,340,100,50);
		jButton3.setBounds(600,340,100,50);
		
		
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
	}


}
