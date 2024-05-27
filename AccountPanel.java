import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountPanel extends JPanel implements ActionListener {

    JPanel bottomNavigation = new JPanel();
    ImageIcon homeIcon = new ImageIcon("images/icons8-home-30.png");
    JButton homeButton = new JButton(homeIcon);
    ImageIcon bookmarkIcon = new ImageIcon("images/icons8-bookmark-30.png");
    JButton bookmarkButton = new JButton(bookmarkIcon);
    ImageIcon accountIcon = new ImageIcon("images/icons8-account-30.png");
    JButton accountButton = new JButton(accountIcon);

    JLabel text = new JLabel("Accounts");


    CardLayout cardLayout;
    CardLayout cardsLayout;

    AccountPanel(CardLayout layout, CardLayout cardsLayout) {
        this.cardLayout = layout;
        this.cardsLayout = cardsLayout;

        text.setFont(new Font("SansSerif", Font.PLAIN, 30).deriveFont(Font.BOLD, 40));
        text.setForeground(Color.white);
        text.setBounds(50, 50, 100, 100);

 
        // Bottom Navigation design start
        homeButton.setPreferredSize(new Dimension(100, 60));
        homeButton.setBorderPainted(false);
        homeButton.setBackground(new Color(32, 32, 32));
        homeButton.setFocusPainted(false);
        homeButton.addActionListener(this);
        bottomNavigation.add(homeButton);

        bookmarkButton.setBorderPainted(false);
        bookmarkButton.setPreferredSize(new Dimension(100, 60));
        bookmarkButton.setBackground(new Color(32, 32, 32));
        bookmarkButton.setFocusPainted(false);
        bookmarkButton.addActionListener(this);
        bottomNavigation.add(bookmarkButton);

        accountButton.setBorderPainted(false);
        accountButton.setPreferredSize(new Dimension(100, 60));
        accountButton.setBackground(new Color(32, 32, 32));
        accountButton.setFocusPainted(false);
        accountButton.addActionListener(this);
        bottomNavigation.add(accountButton);

        bottomNavigation.setLayout(new GridLayout(1, 3));
        bottomNavigation.setOpaque(false);
        bottomNavigation.setBounds(0, 730, 450, 60);
        // Bottom navigation design end

        // Panel properties
        this.add(text);
        this.add(bottomNavigation);
        this.setOpaque(true);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(450, 830));
        this.setBackground(new Color(32, 32, 32));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Logic for Bottom navigation
        // Check if any of the buttons are pressed then go to the panel that is connected to the button
        if (e.getSource() == homeButton) {
            cardLayout.show(this.getParent(), "mainPanel");
        } else if (e.getSource() == bookmarkButton) {
            cardsLayout.show(this.getParent(), "bookmarkPanel");
        }
    }
}
