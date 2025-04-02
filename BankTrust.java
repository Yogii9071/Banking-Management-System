import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

class BankTrust extends JFrame{
    
    JLabel l1,l2,l3,l4,l5;
    JButton b1,b2,b3,b4,b5,b6,b7;
    JTextField t1,t2,t3;
    JPanel p1,p2,p3,p4,p5,p6,p7,p8;
    JTextPane textPane;
    Dimension d;
    Container con;
    double balance;
    List<String> transactions;
    BankTrust(String t,String uname,String acc){
        super(t);

        balance = 0.00;
        con = getContentPane();
        con.setLayout(null);
        
        

        transactions = new ArrayList<>();
        p1 = new JPanel();
        l1 = new JLabel("SACHIN BANK OF INDIA");
        l1.setFont(new Font("Eras Bold ITC", Font.BOLD, 40));
        d = l1.getPreferredSize();
        p1.add(l1);
        p1.setBounds(125, 2, d.width, d.height);
        p1.setOpaque(false);
        con.add(p1);

        p2 = new JPanel();
        l2 = new JLabel("Welcome: "+uname);
        l2.setFont(new Font("Constantia", Font.BOLD, 30));
        d = l2.getPreferredSize();
        p2.add(l2);
        p2.setBounds(40,100 , d.width, d.height);
        p2.setOpaque(false);
        con.add(p2);

        p3 = new JPanel();
        l3 = new JLabel("Account No.: "+acc);
        l3.setFont(new Font("Constantia", Font.BOLD, 30));
        d = l3.getPreferredSize();
        p3.add(l3);
        p3.setBounds(40,140 , d.width, d.height);
        p3.setOpaque(false);
        con.add(p3);

        b1 = new JButton("Check Balance");
        d = b1.getPreferredSize();
        b1.setBounds(580,135 ,d.width+30,40);
        con.add(b1);
        
        b1.addActionListener( e->{
            if(e.getSource()==b1){
                PINFrame p = new PINFrame("PIN VAlIDATOR",this);
                p.setVisible(true);
                p.setSize(260,150);
                p.setResizable(false);
                p.setLocationRelativeTo(b1);
                p.con.setBackground(new Color( 144,  238, 144));
                p.setDefaultCloseOperation(PINFrame.DISPOSE_ON_CLOSE);
        
            }
        });

        
        textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setOpaque(false);
        textPane.setContentType("text/html");
        textPane.getCaret().setVisible(false);

        String InfoText = "<html><body><h1 style=\"font-family: Eras Bold ITC, sans-serif; font-size: 24px;\">Bank Safety Tips:- </h1>" +
            "<ul style=\"font-family: 'Constantia', sans-serif; font-size: 15px;\">" +
            "<li>Do not share your pin, passwords and account number with anyone.</li>" +
            "<li>Beware of frauds, the bank will never ask for your pin, passwords, or account number.</li>" +
            "<li>Always change your pin and passwords frequently.</li>" +
            "<li>24x7 service available.</li>" +
            "<li>For any query, please visit your nearest bank branch.</li>" +
            "</ul></body></html>";

        textPane.setText(InfoText);
        textPane.setBounds(44, 430, 800, 300);
        con.add(textPane);

        b2 = new JButton("Deposit");
        d = b2.getPreferredSize();
        b2.setBounds(280,200 ,d.width+44, 40);
        con.add(b2);

        b3 = new JButton("Withdraw");
        d = b3.getPreferredSize();
        b3.setBounds(280,260 ,d.width+31,40 );
        con.add(b3);

        b4 = new JButton("Mini Statement");
        d = b4.getPreferredSize();
        b4.setBounds(280,320 ,d.width,40 );
        con.add(b4);

        b5 = new JButton("Cancel");
        d = b5.getPreferredSize();
        b5.setBounds(280,380 ,d.width+46,40 );
        con.add(b5);

        b2.addActionListener(e -> {
            if (e.getSource() == b2) {
                p4 = new JPanel();
                l4 = new JLabel("Enter Amount to Deposit ");
                t1 = new JTextField(10);
                b6 = new JButton("Ok");
                p4.add(l4);
                p4.add(t1);
                p4.add(b6);
                p4.setBounds(425, 200, 330, 40);
                p4.setOpaque(true);
                con.add(p4);
                this.revalidate();
                this.repaint();

                b6.addActionListener(depositEvent -> {
                    try {
                        double amount1 = Double.parseDouble(t1.getText());
                        if (amount1 <= 0) {
                            throw new NumberFormatException();
                        }
                        balance += amount1;
                        transactions.add("Deposited: Rs."+amount1);
                        JOptionPane.showMessageDialog(this, "Amount deposited successfully! ", "Deposit", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid amount entered. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        con.remove(p4);
                        this.revalidate();
                        this.repaint();
                    }
                });
            }
        });

        b3.addActionListener(e -> {
            if (e.getSource() == b3) {
                p5 = new JPanel();
                l5 = new JLabel("Enter Amount to Withdraw");
                t2 = new JTextField(10);
                b7 = new JButton("Ok");
                p5.add(l5);
                p5.add(t2);
                p5.add(b7);
                p5.setBounds(425, 260, 330, 40);
                p5.setOpaque(true);
                con.add(p5);
                this.revalidate();
                this.repaint();

                b7.addActionListener(withdrawEvent -> {
                    try {
                        double amount2 = Double.parseDouble(t2.getText());
                        if (amount2 <= 0 || amount2 > balance) {
                            throw new NumberFormatException();
                        }
                        balance -= amount2;
                        transactions.add("Withdrew: Rs."+amount2 );
                        JOptionPane.showMessageDialog(this, "Amount withdrawn successfully!", "Withdraw", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid amount entered or insufficient balance. Your balance is "+balance, "Error", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        con.remove(p5);
                        this.revalidate();
                        this.repaint();
                    }
                });
            }
        });

        b4.addActionListener(e->{
            MiniStatementFrame miniStatementFrame = new MiniStatementFrame(transactions);
            miniStatementFrame.setVisible(true);
            miniStatementFrame.setSize(400, 300);
            miniStatementFrame.setResizable(false);
            miniStatementFrame.setLocationRelativeTo(b4);
            miniStatementFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        });
        

        b5.addActionListener(e->{
            boolean panelRemoved = false;

            if (p4 != null) {
                con.remove(p4);
                p4 = null;
                panelRemoved = true;
            }
            if (p5 != null) {
                con.remove(p5);
                p5 = null;
                panelRemoved = true;
            }
            if (panelRemoved) {
                this.revalidate();
                this.repaint();
            } else {
            JOptionPane.showMessageDialog(this, "There are no panels to close.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    
    }

    public void showBalance() {
        JOptionPane.showMessageDialog(this, "Your available balance is Rs." + balance, "Balance", JOptionPane.INFORMATION_MESSAGE);
    }


}
                   

        
