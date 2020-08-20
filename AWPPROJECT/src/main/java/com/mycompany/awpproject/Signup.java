/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.awpproject;
import java.awt.*;
import javax.swing.*;

public class Signup
{ 

	private static final int WIDTH = 800;
	private static final int HEIGHT = 500;
	JFrame frame;
	JPanel panel;
	Image icon;
	
	JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JLabel jLabel7 = new JLabel();
    JLabel jLabel8 = new JLabel();
    JLabel jLabel9 = new JLabel();
    JRadioButton jRadioButton1 = new JRadioButton();
    JRadioButton jRadioButton2 = new JRadioButton();
    ButtonGroup buttongroup =new ButtonGroup();
    JPasswordField jPasswordField1 = new JPasswordField();
    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    JTextArea jTextArea1=new JTextArea();
	JTextField jTextField1=new JTextField();
	JTextField jTextField2=new JTextField();
	JTextField jTextField3=new JTextField();
	JTextField jTextField4=new JTextField();
	JTextField jTextField5=new JTextField();
    
    Boolean Loginstatus=false;

	
//////////////////////////////////////////////////////////CONSTRUCTER//////////////////////////////////////////
	Signup(Customer customer)
	{
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
		//panel.setBackground(Color.WHITE);
		
			
        
        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SIGN UP FORM");
        
		jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("FIRST NAME");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LAST NAME");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("MOBILE NUMBER");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ADDRESS");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("EMAIL-ID");


        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("D.O.B");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("GENDER");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("PASSWORD");

        jRadioButton1.setSelected(true);
        jRadioButton1.setText("MALE");
        
        jRadioButton2.setText("FEMALE");
        
		buttongroup.add(jRadioButton1);
		buttongroup.add(jRadioButton2);

		jTextField1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextField1.setText("FIRST NAME");
		jTextField1.addFocusListener(new java.awt.event.FocusListener ()
		{
                        @Override
			public void focusGained(java.awt.event.FocusEvent e) 
			{
				if(jTextField1.getText().equals("FIRST NAME"))
				{
					jTextField1.setText("");
				}
				

			}
                        @Override
			public void focusLost(java.awt.event.FocusEvent f)
			{
				if(jTextField1.getText().equals(""))
				{
					jTextField1.setText("FIRST NAME");
				}
			}
		});
		
		jTextField2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextField2.setText("LAST NAME");
		jTextField2.addFocusListener(new java.awt.event.FocusListener ()
		{
                        @Override
			public void focusGained(java.awt.event.FocusEvent e) 
			{
				if(jTextField2.getText().equals("LAST NAME"))
				{
					jTextField2.setText("");
				}
				

			}
                        @Override
			public void focusLost(java.awt.event.FocusEvent f)
			{
				if(jTextField2.getText().equals(""))
				{
					jTextField2.setText("LAST NAME");
				}
			}
		});


		jTextField3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextField3.setText("MOBILE NUMBER");
		jTextField3.addFocusListener(new java.awt.event.FocusListener ()
		{
                        @Override
			public void focusGained(java.awt.event.FocusEvent e) 
			{
				if(jTextField3.getText().equals("MOBILE NUMBER"))
				{
					jTextField3.setText("");
				}
				

			}
                        @Override
			public void focusLost(java.awt.event.FocusEvent f)
			{
				if(jTextField3.getText().equals(""))
				{
					jTextField3.setText("MOBILE NUMBER");
				}
			}
		});
		
		jTextField4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextField4.setText("EMAIL ID");
		jTextField4.addFocusListener(new java.awt.event.FocusListener ()
		{
                        @Override
			public void focusGained(java.awt.event.FocusEvent e) 
			{
				if(jTextField4.getText().equals("EMAIL ID"))
				{
					jTextField4.setText("");
				}
				

			}
                        @Override
			public void focusLost(java.awt.event.FocusEvent f)
			{
				if(jTextField4.getText().equals(""))
				{
					jTextField4.setText("EMAIL ID");
				}
			}
		});
		
		jPasswordField1.setFont(new java.awt.Font("Dialog", 1, 14));
		jPasswordField1.setText("PASSWORD");
		jPasswordField1.addFocusListener(new java.awt.event.FocusListener ()
		{
                        @Override
			public void focusGained(java.awt.event.FocusEvent e) 
			{
				if(jPasswordField1.getText().equals("PASSWORD"))
				{
					jPasswordField1.setText("");
				}
				

			}
                        @Override
			public void focusLost(java.awt.event.FocusEvent f)
			{
				if(jPasswordField1.getText().equals(""))
				{
					jPasswordField1.setText("PASSWORD");
				}
			}
		});
		
        
		
		jTextField5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextField5.setText("DD/MM/YY");
		jTextField5.addFocusListener(new java.awt.event.FocusListener ()
		{
                        @Override
			public void focusGained(java.awt.event.FocusEvent e) 
			{
				if(jTextField5.getText().equals("DD/MM/YY"))
				{
					jTextField5.setText("");
				}
				

			}
                        @Override
			public void focusLost(java.awt.event.FocusEvent f)
			{
				if(jTextField5.getText().equals(""))
				{
					jTextField5.setText("DD/MM/YY");
				}
			}
		});
		
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        
        jButton2.setText("SUBMIT");
		jButton2.addMouseListener(new java.awt.event.MouseAdapter() 
		{
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) 
            {
		String message="";
                if(jTextField1.getText().equals("FIRST NAME"))
                {
			message+="PLEASE ENTER A VALID FIRST NAME\n";
		}
		if(jTextField2.getText().equals("LAST NAME"))
		{
			message+="PLEASE ENTER A VALID LAST NAME\n";
		}
		if(jTextField3.getText().equals("MOBILE NUMBER"))
		{
			message+="PLEASE ENTER A VALID MOBILE NUMBER\n";
		}
		if(jTextField4.getText().equals("EMAIL ID"))
		{
			message+="PLEASE ENTER A VALID EMAIL ID\n";
		}
		if(jTextField5.getText().equals("DD/MM/YY"))
		{
			message+="PLEASE ENTER A VALID D.O.B. \n";
		}
		if(jTextArea1.getText().equals(""))
		{
			message+="PLEASE ENTER A VALID ADDRES\n";
		}
		if(jPasswordField1.getText().equals("PASSWORD"))
		{
			message+="PLEASE ENTER A VALID PASSWORD";
		}
		if(!message.equals(""))
		{
				
			JTextArea jtp=new JTextArea();
			jtp.setText(message);
			JOptionPane.showMessageDialog(frame, jtp);
		}
		else
		{
			customer.putfirstname(jTextField1.getText());
		
                        customer.putlastname(jTextField2.getText());
					
			customer.putmobileno(jTextField3.getText());
			
                        String gender;
                        if(jRadioButton1.isSelected())
                        {
                            gender=jRadioButton1.getText();
                        }
                        else
                        {
                            gender=jRadioButton2.getText();
                        }
                                        
                        customer.putgender(gender);
					
			customer.putemailid(jTextField4.getText());
									
			customer.putpassword(jPasswordField1.getText());
				 
			customer.putaddress(jTextArea1.getText());
					
			customer.putdob(jTextField5.getText()); 
			Loginstatus=true;
			String msg=customer.InsertData();
                        if(!msg.equals(""))
                        {
                            JOptionPane.showMessageDialog(frame,msg);
                            Loginstatus=false;
                        }
                        if(Loginstatus)
                        {
                            frame.setVisible(false);
                            Car car = new Car(customer);
                        }
                        
                }	
            }
        });
		
		
        jButton1.setText("CLEAR");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() 
		{
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) 
			{
                jTextArea1.setText("");
				jTextField1.setText("FIRST NAME");
				jTextField2.setText("LAST NAME");
				jTextField3.setText("MOBILE NUMBER");
				jTextField4.setText("EMAIL ID");
				jTextField5.setText("DD/MM/YY");
				jPasswordField1.setText("PASSWORD");
				jRadioButton1.setSelected(true);
			
            }
        });

      
   





		panel.add(jLabel1);
		panel.add(jLabel2);
		panel.add(jLabel3);
		panel.add(jLabel4);
		panel.add(jLabel5);
		panel.add(jLabel6);
		panel.add(jLabel7);
		panel.add(jLabel8);
		panel.add(jLabel9);
		panel.add(jRadioButton1);
		panel.add(jRadioButton2);
		panel.add(jPasswordField1);
		panel.add(jButton1);
		panel.add(jButton2);
		panel.add(jTextField1);
		panel.add(jTextField2);
		panel.add(jTextField3);
		panel.add(jTextField4);
		panel.add(jTextField5);
		panel.add(jTextArea1);
		
	
		
		jLabel1.setBounds(300,30,200,30);

		jLabel2.setBounds(60,100,150,30);
		jLabel3.setBounds(420,100,150,30);
		
		jLabel4.setBounds(60,160,150,30);
		jLabel8.setBounds(420,160,150,30);
		
		jLabel6.setBounds(60,220,150,30);
		jLabel9.setBounds(420,220,150,30);
		
		jLabel5.setBounds(60,280,150,30);
		jLabel7.setBounds(420,280,150,30);
		
		
		jTextField1.setBounds(230,100,180,30);
		jTextField2.setBounds(590,100,180,30);
		jTextField3.setBounds(230,160,180,30);
		jTextField4.setBounds(230,220,180,30);
		jTextField5.setBounds(590,280,180,30);
		
		jPasswordField1.setBounds(590,220,180,30);
		
		jTextArea1.setBounds(230,280,180,100);
		
		jButton1.setBounds(200,400,100,30);
		jButton2.setBounds(500,400,100,30);
	
		jRadioButton1.setBounds(590,160,80,30);
		jRadioButton2.setBounds(680,160,100,30);
	
		frame.add(panel);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
	}



}
