/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.awpproject;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Date
{ 

	private static final int WIDTH = 800;
	private static final int HEIGHT = 500;
	JFrame frame;
	JPanel panel;
	Image icon;
	
	private JLabel dayL, pickupDateL, returnDateL;
	private JComboBox pUMCB, pUDCB, pUYCB, rMCB, rDCB, rYCB;
	private JLabel dateChecker;
	private JButton reserveNextB, reserveBackB;  
	
	private JButton next;
	
	
//////////////////////////////////////////////////////////CONSTRUCTER//////////////////////////////////////////
	Date(Customer custumer)
	{
		JFrame frame = new JFrame();
		icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\HARDIK\\Documents\\NetBeansProjects\\AWPPROJECT\\src\\main\\java\\com\\mycompany\\awpproject\\Images/logo.jfif");  
		frame.setIconImage(icon);  
		frame.setTitle("CAR RENTAL SYSTEM");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		//frame.setLocation(500,300);
		panel =new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		dayL = new JLabel("DATES OF BOOKING :");
		dayL.setFont(new Font("Verdana", Font.PLAIN, 20));
		dayL.setForeground(Color.BLACK);
		
		pickupDateL = new JLabel("PICK_UP DATE:");
		pickupDateL.setFont(new Font("Serif", Font.BOLD, 18));
		pickupDateL.setForeground(Color.BLUE);
		
		
		returnDateL = new JLabel("RETURN DATE:");
		returnDateL.setFont(new Font("Serif", Font.BOLD, 18));
		returnDateL.setForeground(Color.BLUE);
	
		String[] pickUpMonthCB = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		pUMCB = new JComboBox(pickUpMonthCB);
		
		Integer[] pickUpDateCB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
		pUDCB = new JComboBox(pickUpDateCB);
		
		Integer[] pickUpYearCB = { 2018, 2019, 2020, 2021, 2022, 2023, 2024};
		pUYCB = new JComboBox(pickUpYearCB);
		
		String[] returnMonthCB = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		rMCB = new JComboBox(returnMonthCB);
		
		Integer[] returnDateCB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
		rDCB = new JComboBox(returnDateCB);
		
		Integer[] returnYearCB = {2018, 2019, 2020, 2021, 2022, 2023, 2024};
		rYCB = new JComboBox(returnYearCB);
		
		
		next = new JButton(new ImageIcon("C:\\Users\\HARDIK\\Documents\\NetBeansProjects\\AWPPROJECT\\src\\main\\java\\com\\mycompany\\awpproject\\Images/next.GIF"));
		next.setBackground(Color.WHITE);
		
		next.addMouseListener(new MouseAdapter() 
		{
            @Override
            public void mouseClicked(MouseEvent e) 
            {
				String startdate,enddate;
				startdate=pUDCB.getSelectedItem().toString()+"/"+pUMCB.getSelectedItem().toString()+"/"+pUYCB.getSelectedItem().toString();
				enddate=rDCB.getSelectedItem().toString()+"/"+rMCB.getSelectedItem().toString()+"/"+rYCB.getSelectedItem().toString();
				
				custumer.putstartdate(startdate);
				custumer.putenddate(enddate);
				frame.setVisible(false);  
				new Bill(custumer);
            }

        });
		
		
		
		
		
		
		
		
		
		
		
		
		
		pUDCB.setBounds(320, 90, 100, 25);
		pUMCB.setBounds(430, 90, 100, 25);
		pUYCB.setBounds(540, 90, 100, 25);
		
		rDCB.setBounds(320, 240, 100, 25);
		rMCB.setBounds(430, 240, 100, 25);
		rYCB.setBounds(540, 240, 100, 25);
		
		dayL.setBounds(200, 10, 400, 100);
		pickupDateL.setBounds(100, 50, 200, 100);
		returnDateL.setBounds(100, 200, 200, 100);
		
		next.setBounds(680,380,50,50);
		
		panel.add(rDCB);
		panel.add(rMCB);
		panel.add(rYCB);
		panel.add(pUDCB);
		panel.add(pUMCB);
		panel.add(pUYCB);
		panel.add(next);
	
		panel.add(dayL);
		panel.add(pickupDateL);
		panel.add(returnDateL);
	
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
	}
	

}
