/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.awpproject;
import java.awt.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import static javax.xml.ws.Service.Mode.MESSAGE;
import javax.swing.table.*;

public class Admin
{ 

	private static final int WIDTH = 800;
	private static final int HEIGHT = 500;
	JFrame frame;
	JPanel panel;
	Image icon;
	
        JTextArea jTextArea1=new JTextArea();
        JLabel jLabel1=new JLabel();
        JScrollPane scroll;
        JTable j;
        DefaultTableModel dtm;
                
        Connection conn;
        PreparedStatement ps;
        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();
        public Object GetData(JTable table, int row_index, int col_index)
        {
            return table.getModel().getValueAt(row_index, col_index);
        } 

	
//////////////////////////////////////////////////////////CONSTRUCTER//////////////////////////////////////////
	Admin()
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
                panel.setBackground(Color.WHITE);
		
                jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
                jLabel1.setText("WELCOME ADMIN");

        	jTextArea1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		jTextArea1.setText("");
                
                
                //jButton1.setBackground(Color.BLACK);
		
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
                jButton2.setText("DELETE");
		jButton2.addMouseListener(new java.awt.event.MouseAdapter() 
		{
                    Boolean flag=false;
                    String obj1;
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) 
                    {
                        int rowIndex=j.getSelectedRow();
                        if(rowIndex !=-1)
                        {
                            obj1 = (String) GetData(j,rowIndex, 0);
                            //JOptionPane.showMessageDialog(frame,obj1);
                            flag=true;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(frame,"PLEASE CHOOSE A ROW TO PERFORM DELETION");
                        }
                        if(flag)
                        {
                            int option;
                            option = JOptionPane.showConfirmDialog(frame,"ARE YOU SURE YOU WANT TO DELETE SELECTED ROW?\nTHIS OPERATION CAN'T BE UNDONE","ARE YOU SURE?",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE );
                            if(option==0)
                            {
                               try
                                {
                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                    Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/awp","root","root");
                                    PreparedStatement ps1;
                                    ps1 = conn1.prepareStatement("delete from record where id=?;");
                                    ps1.setInt(1,Integer.parseInt(obj1));
                                    ps1.executeUpdate();
                                    frame.setVisible(false);
                                    new Admin();
                                    
                                }catch(SQLException | ClassNotFoundException err)
                                {
                                    JOptionPane.showMessageDialog(frame,"INVALID ENTRY"+err.getMessage());
                                }  


                            }

                        }
                    }

                });
                
                String[] columnNames = {"ID","Name", "Mobile_No", "Email","Password","Type","Car NO","Start Date","End Date"}; 
                dtm = new DefaultTableModel(columnNames,0);
                j=new JTable(dtm);
                scroll = new JScrollPane(j);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
	

        	
                
                
                try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/awp","root","root");
                    PreparedStatement ps;
                    ps = conn.prepareStatement("SELECT * FROM record;");
                    ResultSet result=ps.executeQuery();
                    int i=1;
                    while (result.next() ) 
                    {
                        String[] item={result.getString(1),result.getString(2)+" "+result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getString(9),result.getString(10)};
                        dtm.addRow(item);
                        i++;
                    }
                    
                }catch(SQLException | ClassNotFoundException err)
                {
                    JOptionPane.showMessageDialog(frame,"INVALID ENTRY"+err.getMessage());
                }
                
               
	
		jLabel1.setBounds(300,10,240,30);
		scroll.setBounds(0,50,800,350);
                jButton1.setBounds(600,410,150,50);
                jButton2.setBounds(100,410,150,50);

                
		panel.add(jLabel1);
		panel.add(scroll);
		panel.add(jButton1);
		panel.add(jButton2);
		
                frame.add(panel);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
                
                
                
                
                
                
              
		
	
	}
        
        public static void main(String args[])
        {
            new Admin();
        }
       
}
