/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.awpproject;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Rental
{ 

	private static final int WIDTH = 800;
	private static final int HEIGHT = 500;
	JFrame frame;
	JPanel panel;
	Image icon;
	JLabel imglabel;
	JButton next;
//////////////////////////////////////////////////////////ACTION EVENTS//////////////////////////////////////////
	


	
//////////////////////////////////////////////////////////CONSTRUCTER//////////////////////////////////////////
	Rental()
	{
		JFrame frame = new JFrame();
		icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\HARDIK\\Documents\\NetBeansProjects\\AWPPROJECT\\src\\main\\java\\com\\mycompany\\awpproject\\Images/logo.jfif");  
		frame.setIconImage(icon);  
		frame.setTitle("CAR RENTAL SYSTEM");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		//frame.setLocation(500,300);
		panel =new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		imglabel = new JLabel(new ImageIcon("C:\\Users\\HARDIK\\Documents\\NetBeansProjects\\AWPPROJECT\\src\\main\\java\\com\\mycompany\\awpproject\\Images/brand.gif"));
		next = new JButton(new ImageIcon("C:\\Users\\HARDIK\\Documents\\NetBeansProjects\\AWPPROJECT\\src\\main\\java\\com\\mycompany\\awpproject\\Images/next.GIF"));
		next.setBackground(Color.WHITE);
		panel.add(imglabel);
		panel.add(next);
	
		imglabel.setBounds(10,10,600,450);
		next.setBounds(680,380,50,50);
		
		 next.addMouseListener(new MouseAdapter() 
		 {
                @Override
                public void mouseClicked(MouseEvent e) 
                {
			frame.setVisible(false);  
			Loginform loginform=new Loginform();
								
                }

                });
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


//////////////////////////////////////////////////////////MAIN//////////////////////////////////////////
	public static void main(String[] args) 
	{
		new Rental();
		
	}
}
