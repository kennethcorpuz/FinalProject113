import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;


public class mainWindow implements ActionListener, FocusListener{

    JFrame frame = new JFrame();
    boolean isSearchFieldVisible = false;


    // Search
    JPanel searchButtonPanel = new JPanel();
    JPanel labelPanel = new JPanel();
    JLabel label2 = new JLabel("<html><div style = 'text-align: left; margin-left: 0px; margin-right: 80px;'>Let's <br>Discover</div><html>");
    ImageIcon searchIcon = new ImageIcon("images/icons8-search-20.png");
    JButton2 searchButton = new JButton2(searchIcon);
    JTextField searchField = new JTextField(20); // Set preferred width
    String placeholder = "Search";
    
    // Hotels
    JPanel hotelsPanel = new JPanel();
    JLabel hotelText = new JLabel("<html><div style = 'text-align: left; margin-left: 20px; margin-right: 30px;'>Hotels</div><html>");
    JPanel arrowsPanel = new JPanel();
    ImageIcon leftArrowIcon = new ImageIcon("images/icons8-left-arrow-30.png");
    JButton2 leftArrowButton = new JButton2(leftArrowIcon);
    ImageIcon rightArrowIcon = new ImageIcon("images/icons8-right-arrow-30.png");
    JButton2 rightArrowButton = new JButton2(rightArrowIcon);
    JButton2 bookNow = new JButton2("Book Now");
    ImageIcon hotel1Background = new ImageIcon("images/hotel1.jpg");
    Image hotel1Image = hotel1Background.getImage();
    JPanel2 hotel1 = new JPanel2(hotel1Image, 50, 50);

    // Bottom Navigation
    JPanel panel5 = new JPanel();
    ImageIcon homeIcon = new ImageIcon("images/icons8-home-30.png");
    JButton homeButton = new JButton(homeIcon);
    ImageIcon shareIcon = new ImageIcon("images/icons8-share-30.png");
    JButton shareButton = new JButton(shareIcon);
    ImageIcon bookmarkIcon = new ImageIcon("images/icons8-bookmark-30.png");
    JButton bookmarkButton = new JButton(bookmarkIcon);
    ImageIcon accountIcon = new ImageIcon("images/icons8-account-30.png");
    JButton accountButton = new JButton(accountIcon);


    mainWindow(){   

        bookNow.setHorizontalAlignment(JLabel.CENTER);
        bookNow.setForeground(Color.white);
        bookNow.setBackground(new Color(52, 186, 235));
        bookNow.setBorderPainted(false);
        bookNow.setArcSize(50, 50);
        bookNow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        hotel1.setLayout(new BorderLayout());
        hotel1.add(bookNow, BorderLayout.SOUTH);
        hotel1.setBounds(60, 340, 300, 350);
        
        leftArrowButton.setOpaque(true);
        leftArrowButton.setBackground(new Color(32, 32, 32));
        leftArrowButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        arrowsPanel.add(leftArrowButton);
        rightArrowButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rightArrowButton.setOpaque(true);
        rightArrowButton.setBackground(new Color(32, 32, 32));
        arrowsPanel.add(rightArrowButton);
        arrowsPanel.setOpaque(false);
        arrowsPanel.setLayout(new GridLayout(1, 2));
        arrowsPanel.setBounds(280, 260, 100, 50);

        hotelText.setFont(new Font("SansSerif", Font.PLAIN, 30).deriveFont(Font.BOLD,40));
        hotelText.setForeground(Color.white);
        hotelText.setBounds(200, 200, 100, 100);
        hotelsPanel.setBounds(20, 250, 170, 70);
        hotelsPanel.setOpaque(false);
        hotelsPanel.add(hotelText);
        
        homeButton.setPreferredSize(new Dimension(100, 60));
        homeButton.setBorderPainted(false);
        homeButton.setBackground(new Color(32, 32, 32));
        homeButton.setFocusPainted(false);
        panel5.add(homeButton);
        shareButton.setBorderPainted(false);
        shareButton.setPreferredSize(new Dimension(100, 60));
        shareButton.setBackground(new Color(32, 32, 32));
        shareButton.setFocusPainted(false);
        panel5.add(shareButton);
        bookmarkButton.setBorderPainted(false);
        bookmarkButton.setPreferredSize(new Dimension(100, 60));
        bookmarkButton.setBackground(new Color(32, 32, 32));
        bookmarkButton.setFocusPainted(false);
        panel5.add(bookmarkButton);
        accountButton.setBorderPainted(false);
        accountButton.setPreferredSize(new Dimension(100, 60));
        accountButton.setBackground(new Color(32, 32, 32));
        accountButton.setFocusPainted(false);
        panel5.add(accountButton);
        panel5.setLayout(new GridLayout(1, 5));
        panel5.setOpaque(false);
        panel5.setBounds(0, 730, 450, 60);
            
        
        label2.setFont(new Font("SansSerif", Font.PLAIN, 30).deriveFont(Font.BOLD,40));
        label2.setForeground(Color.white);
        label2.setBounds(200, 200, 100, 100);
        labelPanel.add(label2);
        labelPanel.setBounds(20, 20, 300, 200);
        labelPanel.setOpaque(false);

        searchButton.setOpaque(true);
        searchButton.setBorder(new LineBorder(Color.RED));
        searchButton.setBackground(new Color(32, 32, 32));
        searchButton.setPreferredSize(20, 30);
        searchButton.setHorizontalTextPosition(SwingConstants.CENTER);
        searchButton.setVerticalTextPosition(SwingConstants.CENTER);
        searchButton.setArcSize(50,50);
        searchButton.addActionListener(this);
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButtonPanel.setForeground(Color.WHITE);
        searchButtonPanel.add(searchButton);
        searchButtonPanel.setOpaque(false);
        // searchButtonPanel.setPreferredSize(new Dimension(450, 200)); 
        searchButtonPanel.setBounds(230, 20, 300, 200);

        searchField.setForeground(Color.LIGHT_GRAY);
        searchField.setText(placeholder);
        searchField.addFocusListener(this);

        frame.add(hotel1);
        frame.add(arrowsPanel);
        frame.add(hotelsPanel);
        frame.add(panel5);
        frame.add(searchButtonPanel);
        frame.add(labelPanel);
        frame.add(searchField);

        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(32, 32, 32));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(450, 830);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==searchButton) {
            if (!isSearchFieldVisible) {
                frame.add(searchField);
                labelPanel.setBounds(20, 50, 300, 200);
                searchField.setBounds(40, 20, 320, 30);
                searchField.setBackground(new Color(84, 84, 84));
                searchField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(0, 2, 0, 2), // Empty border for top, left, and right
                    BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE) // White bottom border
                ));
                frame.revalidate();
                isSearchFieldVisible = true; // Update flag variable
            } else {
                frame.remove(searchField);
                labelPanel.setBounds(20, 20, 300, 200); // Reset labelPanel bounds
                searchField.setForeground(Color.LIGHT_GRAY); // Reset text color
                searchField.setText(placeholder); // Reset text
                isSearchFieldVisible = false; // Update flag variable
            }
        }
    }


    @Override
    public void focusGained(FocusEvent e) {
        if (searchField.getText().equals(placeholder)) {
            searchField.setText("");
            searchField.setForeground(Color.BLACK);
        }
        searchField.setForeground(Color.WHITE);
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (searchField.getText().isEmpty()) {
            searchField.setForeground(Color.LIGHT_GRAY);
            searchField.setText(placeholder);
        }
    }
}
