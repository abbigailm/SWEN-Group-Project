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

public class StockList extends JFrame {

	private JPanel contentPane;
    private JButton add, modify, generate;
    private int radioSelect = 0;
    private int isChecked = 0;
    private ButtonGroup buttonGroup;
    private JButton btnNewButton;

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


        RadioListener radioListener = new RadioListener();


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

        add(inputPanel);
        add(radioPanel);
        add(btnPanel);

        
        setPreferredSize(new Dimension(400, 350));
        
        
    }

    private class ButtonListener implements ActionListener
    {
    
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == submit)
            {
             
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

}




/*START HERE
 * 
 * import java.util.*;
import java.io.*;

class StockListManagement {
  public static ArrayList<String[]> products = new ArrayList<String[]>();

  public static void addItem(){
    boolean exists = false;
    Scanner input = new Scanner(System.in);
    System.out.println("Enter product name:");
    String name =  input.nextLine(); 
    if (name.isEmpty()){
      while (name.isEmpty()){
        System.out.println("Enter product name:");
        name =  input.nextLine();
      }
    }
    for (String i[] : products){
      String[] namePart = i[0].split("(?<=\\D)(?=\\d)");
      while (namePart[0].equals(name)){
        System.out.println("Product name already exists");
        System.out.println("Enter product name:");
        name =  input.nextLine(); 
      }
    }   
    Random random = new Random();
    String ID = name + random.nextInt(999 - 100);
    if (products.contains(ID) == true){
      ID = name +  random.nextInt(999 - 100);
    }
    System.out.println("Enter product quantity:");
    Integer quantity =  input.nextInt();
    if (quantity <= 0){
      while (quantity <= 0){
        System.out.println("Invalid quantity. Enter an integer greater than 0");
        quantity =  input.nextInt();
      }
    }
    System.out.println("Enter product price:");
    Integer price =  input.nextInt();
    if (price <= 0){
      while (price <= 0){
        System.out.println("Invalid price. Enter an integer greater than 0");
        price =  input.nextInt();
      }
    }
    String[] item = {ID, quantity.toString(), "$"+price.toString()};
    products.add(item);
    System.out.println("___________________");
    System.out.println("ID|Quantity|Price");      
    System.out.println("___________________");
    for (String i[] : products){
      System.out.println(Arrays.toString(i));
    }
  }

  public static void genStockList() throws IOException{
    FileWriter writer = new FileWriter("Stock List.txt");
    for (String i[] : products) {
      writer.write(Arrays.toString(i) + "\n");
    }
    writer.close();
  }

  public static void modifyProducts(){
    Scanner response = new Scanner(System.in);
    System.out.println("Would you like to:\n1.Add a new product\n2.Delete a product\n3.Edit a product's information");
    int answer = response.nextInt();
    switch(answer){
      case 1:
        addItem();
        break;
      case 2:
        System.out.println("___________________");
        System.out.println("ID      |  Quantity");      System.out.println("___________________");
        for (String i[] : products){
          System.out.println(Arrays.toString(i));
          System.out.println("___________________");
        }
        System.out.println("Enter product ID for item you wish to delete");
        response.nextLine();
        String toDelete = response.nextLine();
        for (String i[] : products){
          if (i[0].equals(toDelete)){
            int index = products.indexOf(i);
            products.remove(index);
            break;
          }
        }
        break;
      case 3:
        boolean inList = false;
        System.out.println("Enter product ID for item you wish to modify");
        response.nextLine();
        String toModify = response.nextLine();
        for (String i[] : products){
          if (i[0].equals(toModify)){
            inList = true;
            int item = products.indexOf(i);
            break;
          }
        }
        if (inList == true){
          System.out.println("Would you like to edit:\n1.Product name\n2.Product quantity\n3.Product price");
          int choice = response.nextInt();
          switch(choice){
            case 1:
              System.out.println("Enter new product name:");
              response.nextLine();
              String newName = response.nextLine();
              if (newName.isEmpty()){
                while (newName.isEmpty()){
                  System.out.println("Enter product name:");
                  newName =  response.nextLine();
                }
              }
              for (String i[] : products){
                String[] namePart = i[0].split("(?<=\\D)(?=\\d)");
                while (namePart[0].equals(newName)){
                  System.out.println("Product name already exists");
                  System.out.println("Enter product name:");
                  newName =  response.nextLine(); 
                }
              }  
              for (String i[] : products){
                if (i[0].equals(toModify)){
                  Random random = new Random();
                  i[0] = newName + random.nextInt(999 - 100);
                }
              }
              break;
            case 2:
              System.out.println("Enter new product quantity:");
              response.nextLine();
              Integer newQuantity = response.nextInt();
              if (newQuantity <= 0){
                while (newQuantity <= 0){
                  System.out.println("Invalid quantity. Enter an integer greater than 0");
                  newQuantity =  response.nextInt();
                }
              }
              for (String i[] : products){
                if (i[0].equals(toModify)){
                  i[1] = newQuantity.toString();
                }
              }
              break;
              case 3:
                System.out.println("Enter new product price:");
                response.nextLine();
                Integer newPrice = response.nextInt();
                if (newPrice <= 0){
                  while (newPrice <= 0){
                    System.out.println("Invalid price. Enter an integer greater than 0");
                    newPrice =  response.nextInt();
                  }
                }
                for (String i[] : products){
                  if (i[0].equals(toModify)){
                    i[2] = newPrice.toString();
                  }
                }
                break;
            default:
              System.out.println("Invalid input");
          }
        }else{
          System.out.println("Item not in Stock List");
        }
        break;
      default:
        System.out.println("Invalid input");
    }
  }
}*/



