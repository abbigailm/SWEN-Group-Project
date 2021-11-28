import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/*import Login.ButtonListener;
import Login.RadioListener;*/

public class Menu extends JFrame {

	private JPanel contentPane;
	
    private JButton stockList, salesReport, cashier, suppManagement;
    private int radioSelect = 0;
    private int isChecked = 0;
    private ButtonGroup buttonGroup;
    private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0,1));
        

        JPanel radioPanel = new JPanel();

        RadioListener radioListener = new RadioListener();

        JPanel btnPanel = new JPanel();
        stockList = new JButton("View and Modify List");
        salesReport = new JButton("View and Export Report");
        cashier = new JButton("Conduct Sales Transaction");
        suppManagement = new JButton("View and Modify Suppliers");
        ButtonListener buttonListener = new ButtonListener();
        stockList.addActionListener(buttonListener);
        salesReport.addActionListener(buttonListener);
        cashier.addActionListener(buttonListener);
        suppManagement.addActionListener(buttonListener);

        btnPanel.add(stockList);
        btnPanel.add(salesReport);
        btnPanel.add(cashier);
        btnPanel.add(suppManagement);
        btnPanel.setPreferredSize(new Dimension(349,40));

        add(inputPanel);
        add(radioPanel);
        add(btnPanel);

       
        setPreferredSize(new Dimension(400, 350));
	}
	private class ButtonListener implements ActionListener
    {
    
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == stockList) {
            	StockList st = new StockList();
            	st.setVisible(true);
        }
               
        }
    }
	private class RadioListener implements ActionListener
    {
        
        public void actionPerformed(ActionEvent event)
        {
            radioSelect = 1;
        }
    }

    private class AcceptListener implements ItemListener
    {

        public void itemStateChanged(ItemEvent event)
        {
            if(isChecked == 0)
                isChecked = 1;
            else
                isChecked = 0;
        }
    }

}

