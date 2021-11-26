import javax.swing.*;
import java.awt.*;

public class UserLogin
{
    public static void main(String[] args)
    {

        JFrame loginPage = new JFrame("User Login"); //create window

        Login panel = new Login();

        loginPage.getContentPane().add(panel);

        loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginPage.pack();
        loginPage.setVisible(true);


    }
}