import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JPanel
{
    private JTextField uname, pwd;
    private JRadioButton owner, employee;
    private JButton submit, clear;
    private JLabel confirmMsg;
    private int radioSelect = 0;
    private int isChecked = 0;
    private ButtonGroup buttonGroup;
    private JButton btnNewButton;

    public Login()
    {

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0,1));
        
        uname = new JTextField(30);
        pwd = new JTextField(30);
        JLabel uLabel = new JLabel("Username:");
        JLabel pLabel = new JLabel("Password:");

        inputPanel.add(uLabel);
        inputPanel.add(uname);
        inputPanel.add(pLabel);
        inputPanel.add(pwd);
        inputPanel.setPreferredSize(new Dimension(349,120));

        

        JPanel radioPanel = new JPanel();

        JLabel acctypeLabel = new JLabel("Account Type:");
        owner = new JRadioButton("Owner");
        employee = new JRadioButton("Employee");

        RadioListener radioListener = new RadioListener();

        owner.addActionListener(radioListener);
        employee.addActionListener(radioListener);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(owner);
        buttonGroup.add(employee);

        radioPanel.add(acctypeLabel);
        radioPanel.add(owner);
        radioPanel.add(employee);


        JPanel btnPanel = new JPanel();
        submit = new JButton("Submit");
        clear = new JButton("Clear");
        ButtonListener buttonListener = new ButtonListener();
        submit.addActionListener(buttonListener);
        clear.addActionListener(buttonListener);

        btnPanel.add(submit);
        btnPanel.add(clear);
        btnPanel.setPreferredSize(new Dimension(349,40));

        JPanel confirmPanel = new JPanel();
        confirmMsg = new JLabel("<<MSG>>");
        confirmPanel.add(confirmMsg);
        confirmPanel.setPreferredSize(new Dimension(349,40));


        

        add(inputPanel);
        add(radioPanel);
        add(btnPanel);
        add(confirmPanel);


       
        setPreferredSize(new Dimension(400, 350));
        
        
    }

    private class ButtonListener implements ActionListener
    {
    
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == submit)
            {
                if(uname.getText().length() > 0 && pwd.getText().length() > 0 && 
                    radioSelect==1)
                {
                    confirmMsg.setText("New user succesfully added");
                    btnNewButton = new JButton("Next");
                    btnNewButton.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		//Login.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    		Menu m = new Menu();
                    		m.setVisible(true);
                    	}

						/*private void close() {
							WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
                    		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
						}*/
                    });
                    add(btnNewButton);
                    
                } else {
                    confirmMsg.setText("Fields missing");
                }
            } else {
                uname.setText("");
                pwd.setText("");
                buttonGroup.clearSelection();
                radioSelect = 0;
                confirmMsg.setText("<<MSG>>>");
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