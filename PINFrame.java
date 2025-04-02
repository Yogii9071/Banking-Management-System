import java.awt.*;
import javax.swing.*;
class PINFrame extends JFrame {

    JLabel l1;
    JPasswordField t1;
    JPanel p1;
    JButton b1;
    Container con;

    PINFrame(String t,BankTrust bank){
        super(t);
        con = getContentPane();
        con.setLayout(null);

        p1= new JPanel();
        l1= new JLabel("ENTER PIN ");
        t1 = new JPasswordField(4);
        p1.add(l1);
        p1.add(t1);
        p1.setBounds(50, 10, 150, 30);
        p1.setOpaque(true);
        con.add(p1);

        b1 = new JButton("Enter");
        Dimension d = b1.getPreferredSize();
        b1.setBounds(95,50,d.width,20);
        con.add(b1);

        b1.addActionListener(e->{
            if(e.getSource()==b1){
                
                String pinVal = new String(t1.getPassword());
                if(pinVal.equals("1234")){
                    this.dispose();
                    bank.showBalance();
                }else{
                    JOptionPane.showMessageDialog(this,"Invalid Pin Entered.","PinValidation",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
    }
    
}


