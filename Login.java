/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline.management.system;

import java.awt.*;  //it include classes
import java.awt.event.*; // subpackage
import javax.swing.*; // display function 
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    TextField t1,t2;
    Label l1,l2;
    Button b2,b3,b4;
    GridBagLayout gbl;  
    GridBagConstraints gbc; 
    Font f1,f2;
    
    public Login(){
        super("Login");
                
        setBackground(Color.WHITE); // frame background colour
        f1 = new Font("TimesRoman",Font.BOLD,20); // text font
        f2 = new Font("TimesRoman",Font.BOLD,15);
		
        gbl=new GridBagLayout();  // pre-defined layout
	gbc=new GridBagConstraints();
        setLayout(gbl); 
	
        l1 = new Label("Username");
        l1.setFont(f1);
	
        l2 = new Label("Password");
        l2.setFont(f1);

	
        t1 = new TextField(15); // size
	t2 = new TextField(15); 
        t2.setEchoChar('*'); // password invisible to user
	
	b2 = new Button("Reset");
        b2.setFont(f2);
		
        b3 = new Button("Submit");
        b3.setFont(f2);
		
        b4 = new Button("Close");
	b4.setFont(f2);
		
        gbc.gridx=0; // username label
	gbc.gridy=0; 
        gbl.setConstraints(l1,gbc);
	add(l1);
        
	gbc.gridx=2;
        gbc.gridy=0;  
	gbl.setConstraints(t1,gbc);
        add(t1);
		
	gbc.gridx=0;
        gbc.gridy=2;
	gbl.setConstraints(l2,gbc);
        add(l2);

	gbc.gridx=2;
        gbc.gridy=2;
        gbl.setConstraints(t2,gbc);
	add(t2);
				
	// 3 buttons
	gbc.gridx=0;
        gbc.gridy=8;
	gbl.setConstraints(b2,gbc);
        add(b2);

        gbc.gridx=2;
	gbc.gridy=8;
        gbl.setConstraints(b3,gbc);
	add(b3);
	
        gbc.gridx=4;
	gbc.gridy=8;
        gbl.setConstraints(b4,gbc);
	add(b4);
        

        b2.addActionListener(this);
        b3.addActionListener(this);
	b4.addActionListener(this);
                
        setVisible(true);   //bydefault false
        setSize(400,250); // frame size
        setLocation(400,200);   
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
          
            t1.setText("");  
            t2.setText("");  // reset button
	}
        if(ae.getSource()==b4){
            System.exit(0);  // terminate program // close button
	}
        if(ae.getSource()==b3){
            try{                 // submit button
                conn c1 = new conn(); // mysql connection class which help to execute query
                
                String s1 = t1.getText(); // get value from username
                String s2 = t2.getText(); // password
            
                String str = "select * from login where username = '"+s1+"' and password = '"+s2+"'";
                ResultSet rs = c1.s.executeQuery(str);   // s= statement in conn class
                
                if(rs.next()){
                    new Mainframe();
                    setVisible(false); // to close current login frame
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Login"); // if does not execute query
                    setVisible(false);  // close frame
                }
            
            }catch(Exception e){
                System.out.println(e);}
            
	}
    }        
   
    public static void main(String[] args){
            (new Login()).setVisible(true);
    }
}
