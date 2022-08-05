import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class GUI implements ActionListener {
    private static JFrame frame;
    private static JPanel panel;
    private static JLabel userLabel;
    private static JLabel userRegisLabel;
    private static JTextField userText;
    private static JTextField userRegisText;
    private static JLabel passwordLabel;
    private static JLabel passwordRegisLabel;
    private static JTextField passwordText;
    private static JTextField passwordRegisText;
    private static JButton loginButton;
    private static JButton registerButton;
    private static JLabel result;
    private static HashMap<String, String> userInfo = new HashMap<String, String>();
    

    public static void main(String[] args) {
        // Initialize the frame and panel 
        frame = new JFrame("GUI");
        panel = new JPanel();

        // Sets dimensions of the frame, makes it visible, and adds the panel to the frame
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        
        // Blank layout for the panel
        panel.setLayout(null);

        // Creates a user label and text field
        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        userLabel.setVisible(false);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 162, 25);
        userText.setVisible(false);
        panel.add(userText);

         // Creates a password label and text field
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        passwordLabel.setVisible(false);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 162, 25);
        passwordText.setVisible(false);
        panel.add(passwordText);

        // Creates a login button
        loginButton = new JButton("LOGIN");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addActionListener(new GUI());
        loginButton.setVisible(false);
        panel.add(loginButton);

        // Creates an empty label to display the login status
        result = new JLabel("");
        result.setBounds(10, 110, 300, 25);
        panel.add(result);

        //Register half of the program

        // Creates a login button
        registerButton = new JButton("Register");
        registerButton.setBounds(10, 105, 100, 25);
        registerButton.addActionListener(new GUI());
        panel.add(registerButton);
        

        // Creates a registration user label and text field
        userRegisLabel = new JLabel("Enter a username");
        userRegisLabel.setBounds(10, 20, 110, 25);
        panel.add(userRegisLabel);

        userRegisText = new JTextField(20);
        userRegisText.setBounds(130, 20, 150, 25);
        panel.add(userRegisText);

         // Creates a registration password label and text field
        passwordRegisLabel = new JLabel("Enter a password");
        passwordRegisLabel.setBounds(10, 50, 110, 25);
        panel.add(passwordRegisLabel);

        passwordRegisText = new JTextField(20);
        passwordRegisText.setBounds(130, 50, 150, 25);
        panel.add(passwordRegisText);

        //Repaints the elements on the panel
        panel.repaint();
        
        
    
    }

     @Override
    public void actionPerformed(ActionEvent e) {
        Object whichButton = e.getSource();
        String user = userText.getText();
        String password = passwordText.getText();
        String registeredUser = userRegisText.getText();
        String registeredPassword = passwordRegisText.getText();
        
        if(whichButton == loginButton) { // If the login button is clicked
            if(userInfo.containsKey(user) && password.equals(userInfo.get(user))) {
                result.setText("Login successful");
            } else {
                result.setText("Login failed");
            }
        }
        else { // If the register button is clicked
            loginVisible();
            registerInvisible();
            userInfo.put("blankUser", "blankPassword");
            userInfo.put(registeredUser, registeredPassword);
            
        
        }


        }

    //Makes the login portion of the program visible
    public void loginVisible() {
        userLabel.setVisible(true);
        userText.setVisible(true);
        passwordLabel.setVisible(true);
        passwordText.setVisible(true);
        loginButton.setVisible(true);
    }

    //Makes the registration portion of the program invisible
    public void registerInvisible() {
        registerButton.setVisible(false);
        userRegisLabel.setVisible(false);
        userRegisText.setVisible(false);
        passwordRegisLabel.setVisible(false);
        passwordRegisText.setVisible(false);
    }
 
    /* public void setUpButtonListeners() {
        ActionListener buttonListener = new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String password = passwordText.getText();

                if(user.equals("user") && password.equals("password")) {
                    result.setText("Login successful");
                } else {
                    result.setText("Login failed");
                }
            }
        };

        
    } */


        
    }

