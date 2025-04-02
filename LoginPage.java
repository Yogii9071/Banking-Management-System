import java.awt.*;
import javax.swing.*;

class Login extends JFrame {
    JLabel l0,l1,l2;
    JPasswordField f1;
    JTextField t0,t1;
    JButton b1,b2;

    JPanel p0,p1,p2;
    Container con;
    String uname,acc;
    private String pass;

    Login(String t){
        super(t);

        con = getContentPane();
        con.setLayout(null);

        uname = "Sachin";
        acc = "12345678";
        pass = "1234";

        
        p0 = new JPanel();
        l0 = new JLabel("User Name");
        t0 = new JTextField(12);
        p0.add(l0);
        p0.add(t0);
        p0.setBounds(80,20,230,30);
        p0.setOpaque(true);
        con.add(p0);

        p1 = new JPanel();
        l1 = new JLabel("Account No.");
        t1 = new JTextField(12);
        p1.add(l1);
        p1.add(t1);
        p1.setBounds(80,60,230,30);
        p1.setOpaque(true);
        con.add(p1);

        p2 = new JPanel();
        l2 = new JLabel("Password ");
        f1 = new JPasswordField(12);
        p2.add(l2);
        p2.add(f1);
        p2.setBounds(80,100,231,30);
        p2.setOpaque(true);
        con.add(p2);

        b1 = new JButton("Login");
        b1.setBounds(160, 140, 80,30);
        con.add(b1);

        b1.addActionListener(e ->{
            if(e.getSource()==b1){
                String unameVal = t0.getText();
                String accValues = t1.getText();
                String passValues = new String(f1.getPassword());
                if(unameVal.equals(uname) && accValues.equals(acc) && passValues.equals(pass)){
                    JOptionPane.showMessageDialog(this,"Login successfull","Login",JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    BankTrust b = new BankTrust("Bank Management System",unameVal,accValues);
                    b.setVisible(true);
                    b.setSize(800,730);
                    b.setResizable(false);
                    b.con.setBackground(new Color(255, 182, 193));
                    b.setLocationRelativeTo(b1);
                    b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    
            

                }else{
                    JOptionPane.showMessageDialog(this, "Invalid Credentials, Please Re-enter account no. and password ","Login Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        

    }

}
class LoginPage {
    public static void main(String[] args) {
        Login log = new Login("Tanisha Bank of India Login Page");
        log.setVisible(true);
        log.setSize(400, 300);
        log.con.setBackground(new Color(255, 127, 127));
        log.setResizable(false);
        log.setLocationRelativeTo(null); 
        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
