import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountPanel extends JPanel implements ActionListener {

    JPanel bottomNavigation = new JPanel();
    ImageIcon homeIcon = new ImageIcon("images/icons8-home-30.png");
    JButton homeButton = new JButton(homeIcon);
    ImageIcon accountIcon = new ImageIcon("images/icons8-account-30.png");
    JButton accountButton = new JButton(accountIcon);
    
    ImageIcon panelbackground = new ImageIcon("images/background.jpg");
    Image panelImage = panelbackground.getImage();
    JPanel2 imagePanel = new JPanel2(panelImage);

    ImageIcon userPicture = new ImageIcon("images/github2.png");
    Image userImage = userPicture.getImage();
    JPanel2 userPanel = new JPanel2(userImage, 150, 150);
    JPanel usernamePanel = new JPanel();
    JLabel username = new JLabel("<html><div style = 'text-align: left; margin-left: 0px;'>Username</div><html>");

    JPanel accountSettings = new JPanel();
    JButton Exit = new JButton("Exit");

    JLabel text = new JLabel("Accounts");

    CardLayout cardLayout;
    CardLayout cardsLayout;

    AccountPanel(CardLayout layout, CardLayout cardsLayout) {
        this.cardLayout = layout;
        this.cardsLayout = cardsLayout;

        Exit.setBackground(new Color(32, 32, 32));
        Exit.setFont(new Font("SansSerif", Font.PLAIN, 30).deriveFont(Font.BOLD, 20));
        Exit.setForeground(Color.WHITE);
        Exit.setBorderPainted(false); // Remove the border of the Exit button
        Exit.addActionListener(this); // Add action listener for the Exit button
        accountSettings.add(Exit);
        accountSettings.setLayout(new GridLayout(1, 1));
        accountSettings.setBounds(0, 415, 430, 40);
        accountSettings.setBorder(null); // Ensure no border is set for the panel

        username.setFont(new Font("SansSerif", Font.PLAIN, 30).deriveFont(Font.BOLD, 30));
        username.setForeground(Color.WHITE);
        usernamePanel.add(username);
        usernamePanel.setBackground(new Color(32, 32, 32));
        usernamePanel.setBounds(130, 210, 200, 100);
        userPanel.setBounds(30, 180, 100, 100);
        
        imagePanel.setBounds(0, 0, 434, 200);
        imagePanel.setBorder(BorderFactory.createLineBorder(new Color(150, 147, 147), 2));

        // Bottom Navigation design start
        homeButton.setPreferredSize(new Dimension(100, 60));
        homeButton.setBorderPainted(false);
        homeButton.setBackground(new Color(32, 32, 32));
        homeButton.setFocusPainted(false);
        homeButton.addActionListener(this);
        bottomNavigation.add(homeButton);

        accountButton.setBorderPainted(false);
        accountButton.setPreferredSize(new Dimension(100, 60));
        accountButton.setBackground(new Color(32, 32, 32));
        accountButton.setFocusPainted(false);
        accountButton.addActionListener(this);
        bottomNavigation.add(accountButton);

        bottomNavigation.setLayout(new GridLayout(1, 2));
        bottomNavigation.setOpaque(false);
        bottomNavigation.setBounds(0, 730, 450, 60);
        // Bottom navigation design end

        // Panel properties
        this.add(accountSettings);
        this.add(usernamePanel);
        this.add(userPanel);
        this.add(imagePanel);
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
        }

        // Exit button logic
        if (e.getSource() == Exit) {
            System.exit(0); // Exit the program
        }
    }
}
