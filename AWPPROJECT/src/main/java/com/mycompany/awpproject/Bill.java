/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.awpproject;
import java.awt.*;
import javax.swing.*;

public class Bill
{ 

	private static final int WIDTH = 1000;
	private static final int HEIGHT = 1000;
	JFrame frame;
	JPanel panel;
	Image icon;
	
	JLabel jLabel1 = new JLabel();
    JTextArea jLabel2 = new JTextArea();
    JTextArea jLabel3 = new JTextArea();
    JTextArea jLabel4 = new JTextArea();
    JScrollPane scrollbill;
    JScrollPane cardetails;
    JScrollPane driverdetails;
	
   
    JButton jButton1 = new JButton();
   
    

	
//////////////////////////////////////////////////////////CONSTRUCTER//////////////////////////////////////////
	Bill(Customer customer)
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
		
                String msg=customer.transaction();	
                if(!msg.equals(""))
                {
                    JOptionPane.showMessageDialog(frame,msg);
                }
        
        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BILLING DETAILS");
        
		jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("RECEIPT DETAILS ARE:\n"+customer.toStringReceipt());
		jLabel2.setEditable(false);
		scrollbill = new JScrollPane(jLabel2);
		scrollbill.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("CAR DETAILS ARE :\n"+customer.ShowDetails());
		jLabel3.setEditable(false);
		cardetails=new JScrollPane(jLabel3);
		cardetails.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		


        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("DRIVERS DETAILS ARE :\n"+customer.ShowDriverDetails(1));
		jLabel4.setEditable(false);
		driverdetails=new JScrollPane(jLabel4);
		driverdetails.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
        	jButton1.setBackground(Color.WHITE);
		
                jButton1.setText("CLOSE/LOGIN AGAIN");
		jButton1.addMouseListener(new java.awt.event.MouseAdapter() 
		{
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) 
                    {
                        frame.setVisible(false);
                        Loginform loginform = new Loginform();
                    }
                 });
		
		
		
		jLabel1.setBounds(100,10,750,30);
		
		scrollbill.setBounds(10,50,980,300);
		cardetails.setBounds(10,360,980,300);
		driverdetails.setBounds(10,670,980,200);
		jButton1.setBounds(800,880,150,50);

		panel.add(jLabel1);
		panel.add(scrollbill);
		panel.add(cardetails);
		panel.add(driverdetails);
		
		panel.add(jButton1);
	
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
	}
	
	
	
	

}

