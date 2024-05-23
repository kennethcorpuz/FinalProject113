import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class WelcomePage implements ActionListener{
    
    JFrame frame = new JFrame();

    
    JPanel buttonPanel = new JPanel();
    ImageIcon arrowIcon = new ImageIcon("images/icons8-arrow-30.png");
    JButton2 getStarted = new JButton2("Get Started", arrowIcon);

    JLabel welcome = new JLabel("<html><div style='text-align: center;'>Easy Way to<br>book your hotel<br>with us!</div></html>");
    JLabel welcome2 = new JLabel("<html><div style='text-align: center;'>Also book flight ticket,<br> places, food and many more.</div><html>");

    WelcomePage(){ 

        
        // getStarted.setSize(200, 200);
        // getStarted.setIcon(arrowIcon);
        getStarted.setBackground(new Color(27, 207, 162));
        getStarted.setArcSize(20, 20);
        getStarted.setForeground(new Color(227, 230, 229));
        getStarted.setBounds(125,15 ,200 , 50);
        getStarted.setEnabled(true);
        getStarted.addActionListener(this);
        getStarted.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // buttonPanel.setBackground(new Color(43, 221, 233));
        buttonPanel.setPreferredSize(new Dimension(10, 10));
        buttonPanel.setBounds(0, 630, 450, 100);
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(null);

        welcome.setFont(new Font("SansSerif", Font.PLAIN, 30).deriveFont(Font.BOLD,28));
        welcome.setForeground(Color.WHITE); 
        welcome.setHorizontalAlignment(SwingConstants.CENTER); 
        welcome.setBounds(0, 450, 450, 110); 

        welcome2.setFont(new Font("SansSerif", Font.PLAIN, 15).deriveFont(Font.BOLD, 15));
        welcome2.setForeground(new Color(192, 192, 192));
        welcome2.setHorizontalAlignment((SwingConstants.CENTER));
        welcome2.setBounds(0, 570, 450, 50); 
        
        buttonPanel.add(getStarted);
        frame.add(welcome);
        frame.add(welcome2);
        frame.add(buttonPanel);

        frame.getContentPane().setBackground(new Color(32, 32, 32));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Hotel Booking");
        frame.setLayout(null);
        
        frame.setSize(450, 830);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if(e.getSource() == getStarted){
            
            frame.dispose();
            mainWindow window= new mainWindow();
        }
        
    }

}
    
