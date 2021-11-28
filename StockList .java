import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

/*import Login.ButtonListener;
import Login.RadioListener;*/

public class StockList extends JFrame {

	private JPanel contentPane;
    private JButton add, modify, generate;
    private JButton btnNewButton;
    /*private ButtonGroup buttonGroup;
    private JButton btnNewButton;*/

	/**
	 * Launch the application.
	 */
    

	/**
	 * Create the frame.
	 */
	public StockList() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0,1));
        
        JLabel message = new JLabel("Select appropriate option:");

        inputPanel.add(message);
        
        inputPanel.setPreferredSize(new Dimension(349,120));

        

        JPanel radioPanel = new JPanel();


        JPanel btnPanel = new JPanel();
        add = new JButton("Add Item");
        modify = new JButton("Modify Item");
        generate = new JButton("Generate Stock List");
        ButtonListener buttonListener = new ButtonListener();
        add.addActionListener(buttonListener);
        modify.addActionListener(buttonListener);
        generate.addActionListener(buttonListener);

        btnPanel.add(add);
        btnPanel.add(modify);
        btnPanel.add(generate);
        btnPanel.setPreferredSize(new Dimension(349,40));
        

        getContentPane().add(inputPanel);
        getContentPane().add(radioPanel);
        getContentPane().add(btnPanel);
        
        btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Menu m = new Menu();
        		m.setVisible(true);
        	}
        });
        btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
        btnPanel.add(btnNewButton);

        
        setPreferredSize(new Dimension(400, 350));
        
        
    }

    private class ButtonListener implements ActionListener
    {
    
        public void actionPerformed(ActionEvent event)
        {
        	if(event.getSource() == add){
        		AddItem at = new AddItem();
        		at.setVisible(true);
            }else{
            	if(event.getSource() == modify) {
            		ModifyList ml = new ModifyList();
            		ml.setVisible(true);
            }else {
            	if(event.getSource() == generate) {
            		 File file = new File("Stock List.txt");
            		 try {
						file.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} // if file already exists will do nothing 
            		 try {
            			 BufferedWriter out = new BufferedWriter( new FileWriter("Stock List.txt", true));
            		     for (String i[] : UserLogin.products) {
            		    	 out.write("Product ID: " + i[0]);
            		    	 out.write(" | Product quantity: " + i[1]);
            		    	 out.write(" | Product price: $" + i[2]);
            		         System.out.println("");
            		         out.write("\n");
            		     }
            		     out.close();
            		 }
            		 // Catch block to handle the exceptions
            		 catch (IOException e) {
            			 // Display message when exception occurs
            		     System.out.println("exception occoured" + e);
            		 }
            	}
            }
            }
          }
        }
    }











