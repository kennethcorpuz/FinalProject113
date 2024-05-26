import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class mainWindow implements ActionListener, FocusListener {

    JFrame frame = new JFrame();
    boolean isSearchFieldVisible = false;
    boolean isAccountPanelVisible = false;

    // Main panel to hold all components
    JPanel cards = new JPanel(new CardLayout());
    JPanel mainPanel = new JPanel();
    JPanel accountPanel = new JPanel();

    // Search
    JPanel searchButtonPanel = new JPanel();
    JPanel labelPanel = new JPanel();
    JLabel label2 = new JLabel("<html><div style = 'text-align: left; margin-left: 0px; margin-right: 80px;'>Let's <br>Discover</div><html>");
    ImageIcon searchIcon = new ImageIcon("images/icons8-search-20.png");
    JButton2 searchButton = new JButton2(searchIcon);
    JTextField searchField = new JTextField(20); // Set preferred width
    String placeholder = "Search";

    // Hotel left and right arrow
    JPanel arrowsPanel = new JPanel();
    ImageIcon leftArrowIcon = new ImageIcon("images/icons8-left-arrow-30.png");
    JButton2 leftArrowButton = new JButton2(leftArrowIcon);
    ImageIcon rightArrowIcon = new ImageIcon("images/icons8-right-arrow-30.png");
    JButton2 rightArrowButton = new JButton2(rightArrowIcon);
    JPanel hotelsTextPanel = new JPanel();
    JLabel hotelText = new JLabel("<html><div style = 'text-align: left; margin-left: 20px; margin-right: 30px;'>Hotels</div><html>");

    String[] hotelNames = {"<html><div style= 'text-align: Left; margin-left: 15px;'>Sola Hotel</div><html>", 
                            "<html><div style= 'text-align: Left; margin-left: 15px;'>West Gate Hotel</div><html>",
                            "<html><div style= 'text-align: Left; margin-left: 15px;'>Hotel Lourdes</div><html>",
                            "<html><div style= 'text-align: Left; margin-left: 15px;'>La Elliana Hotel</div><html>",
                            "<html><div style= 'text-align: Left; margin-left: 15px;'>Sabel Travelers Inn</div><html>"
                                };
    String[] hotelDescriptions = {"<html><div style= 'text-align: Left; margin-left: 15px;'>Set in Laoag, 13 km from Paoay Sand Dunes, Sola Hotel offers accommodation with a restaurant, free private parking, a garden and a bar.</div><html>",
                                    "<html><div style= 'text-align: Left; margin-left: 15px;'>Westgate Hotel Hotel has air-conditioned rooms with a private bathroom in Laoag. Free WiFi is available in the hotel’s common areas. There is also a 24-hour front desk and on-site minimart.</div><html>",
                                    "<html><div style= 'text-align: Left; margin-left: 15px;'>Set in Laoag, Luzon region, Hotel Lourdes is situated 14 km from Paoay Sand Dunes.</div><html>",
                                    "<html><div style= 'text-align: Left; margin-left: 15px;'>Set in Laoag, 14 km from Paoay Sand Dunes, La Elliana Hotel & Restaurant, Inc. Offers accommodation with a restaurant and free private parking.</div><html>",
                                    "<html><div style= 'text-align: Left; margin-left: 15px;'>Situated in Laoag, 14 km from Paoay Sand Dunes, Sabel Travelers Inn features accommodation with free WiFi and free private parking. The hostel has family rooms.</div><html>"
                                    };

    String[] hotelImages = {"images/hotel1.jpg", "images/wesGate.jpg", "images/hotelLourdes.jpg", "images/laElliana.jpg", "images/sabelInn.jpg"};

    String[] prices = { "<html><div style= 'text-align: Left; margin-left: 15px; font-size: 20px; color: rgb(3, 252, 40);'>Php 4,500<br><div style = 'text-align: left; margin-left: 4px; font-size: 10px; color: rgb(215, 219, 216)'>per night</div></div><html>",
                        "<html><div style= 'text-align: Left; margin-left: 15px; font-size: 20px; color: rgb(3, 252, 40);'>Php 1,080<br><div style = 'text-align: left; margin-left: 4px; font-size: 10px; color: rgb(215, 219, 216)'>per night</div></div><html>",
                        "<html><div style= 'text-align: Left; margin-left: 15px; font-size: 20px; color: rgb(3, 252, 40);'>Php 1,790<br><div style = 'text-align: left; margin-left: 4px; font-size: 10px; color: rgb(215, 219, 216)'>per night</div></div><html>",
                        "<html><div style= 'text-align: Left; margin-left: 15px; font-size: 20px; color: rgb(3, 252, 40);'>Php 1,512<br><div style = 'text-align: left; margin-left: 4px; font-size: 10px; color: rgb(215, 219, 216)'>per night</div></div><html>",
                        "<html><div style= 'text-align: Left; margin-left: 15px; font-size: 20px; color: rgb(3, 252, 40);'>Php 1,194<br><div style = 'text-align: left; margin-left: 4px; font-size: 10px; color: rgb(215, 219, 216)'>per night</div></div><html>",
                        };
    
    JPanel[] hotelsPanels; // Array to store hotel panels
    int currentHotelIndex = 0;

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

    mainWindow() {

        accountPanel.setLayout(new BorderLayout());
        accountPanel.setBackground(new Color(32, 32, 32));
        accountPanel.setBounds(0, 0, 450, 830);
        accountPanel.setVisible(false);


        hotelsPanels = new JPanel[hotelNames.length];
        for (int i = 0; i < hotelNames.length; i++) {
            // Create components for each hotel
            JLabel hotelNameLabel = new JLabel(hotelNames[i]);
            JLabel hotelDescriptionLabel = new JLabel(hotelDescriptions[i]);
            JLabel hotelPrices = new JLabel(prices[i]);
            JButton2 bookNowButton = new JButton2("Book Now");
            ImageIcon hotelBackground = new ImageIcon(hotelImages[i]);
            Image hotelImage = hotelBackground.getImage();
            JPanel2 hotelPanel = new JPanel2(hotelImage, 15, 15);
    
            // Set properties for book now button
            bookNowButton.setHorizontalAlignment(JLabel.CENTER);
            bookNowButton.setForeground(Color.white);
            bookNowButton.setBackground(new Color(52, 186, 235));
            bookNowButton.setBorderPainted(false);
            bookNowButton.setPreferredSize(new Dimension(150, 40));
            bookNowButton.setArcSize(50, 50);
            bookNowButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    
            // Create panel for book now button
            JPanel bookNowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            bookNowPanel.setBackground(new Color(32, 32, 32));
            bookNowPanel.setOpaque(false); // Make the panel background transparent
            bookNowPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
            bookNowPanel.add(bookNowButton);
    
            // Set properties for hotel name label
            hotelNameLabel.setFont(new Font("SansSerif", Font.PLAIN, 30).deriveFont(Font.BOLD, 30));
            hotelNameLabel.setForeground(Color.white);
            hotelPrices.setForeground(Color.white);
    
            // Set properties for hotel description label
            hotelDescriptionLabel.setForeground(Color.white);
    
            // Create panel for hotel information
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new GridLayout(4, 1));
            infoPanel.setBackground(new Color(40, 40, 40));
            infoPanel.add(hotelNameLabel);
            infoPanel.add(hotelDescriptionLabel);
            infoPanel.add(hotelPrices);
            infoPanel.add(bookNowPanel);
    
            // Create panel for each hotel
            hotelsPanels[i] = new JPanel();
            hotelsPanels[i].setBackground(new Color(32, 32, 32));
            hotelsPanels[i].setLayout(new GridLayout(2, 1));
            hotelsPanels[i].add(hotelPanel);
            hotelsPanels[i].add(infoPanel);
            hotelsPanels[i].setBounds(40, 260, 350, 460);
        }
    
        // Initialize the first hotel panel to be visible
        mainPanel.setLayout(null);
        mainPanel.setPreferredSize(new Dimension(450, 830));
        mainPanel.setBackground(new Color(32, 32, 32));
        mainPanel.add(hotelsPanels[currentHotelIndex]);
        
        
        leftArrowButton.setOpaque(true);
        leftArrowButton.setBackground(new Color(32, 32, 32));
        leftArrowButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        leftArrowButton.addActionListener(this);
        arrowsPanel.add(leftArrowButton);
    
        rightArrowButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rightArrowButton.setOpaque(true);
        rightArrowButton.setBackground(new Color(32, 32, 32));
        rightArrowButton.addActionListener(this);
        arrowsPanel.add(rightArrowButton);
    
        arrowsPanel.setOpaque(false);
        arrowsPanel.setLayout(new GridLayout(1, 2));
        arrowsPanel.setBounds(280, 205, 100, 50);
    
        hotelText.setFont(new Font("SansSerif", Font.PLAIN, 30).deriveFont(Font.BOLD, 40));
        hotelText.setForeground(Color.white);
        hotelText.setBounds(200, 200, 100, 100);
        hotelsTextPanel.setBounds(20, 200, 170, 70);
        hotelsTextPanel.setOpaque(false);
        hotelsTextPanel.add(hotelText);
    
        homeButton.setPreferredSize(new Dimension(100, 60));
        homeButton.setBorderPainted(false);
        homeButton.setBackground(new Color(32, 32, 32));
        homeButton.setFocusPainted(false);
        homeButton.addActionListener(this);
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
        accountButton.addActionListener(this);
        panel5.add(accountButton);
        
        panel5.setLayout(new GridLayout(1, 5));
        panel5.setOpaque(false);
        panel5.setBounds(0, 730, 450, 60);
    
        label2.setFont(new Font("SansSerif", Font.PLAIN, 30).deriveFont(Font.BOLD, 40));
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
        searchButton.setArcSize(50, 50);
        searchButton.addActionListener(this);
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButtonPanel.setForeground(Color.WHITE);
        searchButtonPanel.add(searchButton);
        searchButtonPanel.setOpaque(false);
        searchButtonPanel.setBounds(230, 20, 300, 200);
    
        searchField.setForeground(Color.LIGHT_GRAY);
        searchField.setText(placeholder);
        searchField.addFocusListener(this);
        
        panel5.setBounds(0, 730, 450, 60);
        accountPanel.add(panel5, BorderLayout.SOUTH);


        // Add components to mainPanel
        mainPanel.add(arrowsPanel);
        mainPanel.add(hotelsTextPanel);
        mainPanel.add(panel5);
        mainPanel.add(searchButtonPanel);
        mainPanel.add(labelPanel);

        
    
        cards.add(mainPanel, "mainPanel");
        cards.add(accountPanel, "accountPanel");
    
        frame.add(cards);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(450, 830);
        frame.setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            if (!isSearchFieldVisible) {
                mainPanel.add(searchField);
                labelPanel.setBounds(20, 50, 300, 200);
                searchField.setBounds(40, 20, 320, 30);
                searchField.setBackground(new Color(84, 84, 84));
                searchField.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(0, 2, 0, 2), // Empty border for top, left, and right
                        BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE) // White bottom border
                ));
                mainPanel.revalidate();
                isSearchFieldVisible = true; // Update flag variable
            } else {
                mainPanel.remove(searchField);
                labelPanel.setBounds(20, 20, 300, 200); // Reset labelPanel bounds
                searchField.setForeground(Color.LIGHT_GRAY); // Reset text color
                searchField.setText(placeholder); // Reset text
                isSearchFieldVisible = false; // Update flag variable
            }
            mainPanel.repaint();
        }

        if (e.getSource() == leftArrowButton) {
            currentHotelIndex--;
            if (currentHotelIndex < 0) {
                currentHotelIndex = hotelsPanels.length - 1; // Wrap around to the last panel
            }
            showCurrentHotelPanel();
        } else if (e.getSource() == rightArrowButton) {
            currentHotelIndex++;
            if (currentHotelIndex >= hotelsPanels.length) {
                currentHotelIndex = 0; // Wrap around to the first panel
            }
            showCurrentHotelPanel();
        }

        CardLayout cardLayout = (CardLayout) cards.getLayout();
        if (e.getSource() == accountButton) {
            cardLayout.show(cards, "accountPanel");
            
        } else if (e.getSource() == homeButton) {
            cardLayout.show(cards, "mainPanel");
            
        }
    }

    private void showCurrentHotelPanel() {
        // Remove all hotel panels
        for (JPanel panel : hotelsPanels) {
            mainPanel.remove(panel);
        }
        // Add the current hotel panel
        mainPanel.add(hotelsPanels[currentHotelIndex]);
        mainPanel.revalidate();
        mainPanel.repaint();
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
