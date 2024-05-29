import javax.swing.*;
import java.awt.*;

public class formPanel extends JPanel {
    JLabel firstnameLabel = new JLabel("First Name:");
    JTextField firstnameField = new JTextField(20);
    JLabel lastnameLabel = new JLabel("Last Name:");
    JTextField lastnameField = new JTextField(20);
    JLabel emailLabel = new JLabel("Email:");
    JTextField emailField = new JTextField(20);
    JLabel roomTypeLabel = new JLabel("Room Type:");
    JComboBox<String> roomTypeCombo = new JComboBox<>(new String[]{"Single", "Double", "Suite"});
    JLabel numGuestsLabel = new JLabel("Number of Guests:");
    JSpinner numGuestsSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
    JLabel arrivalDateLabel = new JLabel("Arrival Date and Time:");
    JTextField arrivalDateField = new JTextField(20);
    JLabel departureDateLabel = new JLabel("Departure Date (MM-DD-YY):");
    JTextField departureDateField = new JTextField(20);
    JCheckBox freePickupCheckBox = new JCheckBox("Free Pick Up");
    JLabel hotelNameLabel = new JLabel();
    JPanel hotelnamePanel = new JPanel();
    JLabel hotelImageLabel = new JLabel();
    JPanel infoPanel = new JPanel(new BorderLayout());
    JPanel formPanel = new JPanel();

    formPanel() {
        // Set layout and add components
        setLayout(new BorderLayout());

        hotelNameLabel.setFont(new Font("SansSerif", Font.PLAIN, 30).deriveFont(Font.BOLD, 40));
        hotelNameLabel.setForeground(Color.white);
        hotelnamePanel.add(hotelNameLabel);
        hotelnamePanel.setBackground(new Color(32, 32, 32));
        infoPanel.setOpaque(false);
        infoPanel.setBackground(new Color(32, 32, 32));
        infoPanel.setBounds(-20, 10, 450, 250);
        infoPanel.add(hotelImageLabel, BorderLayout.CENTER);
        infoPanel.add(hotelnamePanel, BorderLayout.SOUTH);

        this.setBackground(new Color(32, 32, 32));
        add(infoPanel, BorderLayout.NORTH);

        formPanel.setLayout(new GridLayout(8, 2, 10, 10));
        formPanel.setOpaque(false);

        formPanel.add(firstnameLabel);
        formPanel.add(firstnameField);
        formPanel.add(lastnameLabel);
        formPanel.add(lastnameField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(roomTypeLabel);
        formPanel.add(roomTypeCombo);
        formPanel.add(numGuestsLabel);
        formPanel.add(numGuestsSpinner);
        formPanel.add(arrivalDateLabel);
        formPanel.add(arrivalDateField);
        formPanel.add(departureDateLabel);
        formPanel.add(departureDateField);
        formPanel.add(new JLabel("")); // Filler
        formPanel.add(freePickupCheckBox);

        add(formPanel, BorderLayout.CENTER);
    }

    // Method to set hotel information
    public void setHotelInfo(String hotelName, String imagePath) {
        hotelNameLabel.setText(hotelName);
        // Assuming imagePath is the path to the hotel image
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage().getScaledInstance(infoPanel.getWidth(), 200, Image.SCALE_SMOOTH);
        hotelImageLabel.setIcon(new ImageIcon(image));
    }

    @Override
    public void doLayout() {
        super.doLayout();
        if (hotelImageLabel.getIcon() != null) {
            // Adjust the hotel image size dynamically
            ImageIcon icon = (ImageIcon) hotelImageLabel.getIcon();
            Image image = icon.getImage().getScaledInstance(infoPanel.getWidth(), 200, Image.SCALE_SMOOTH);
            hotelImageLabel.setIcon(new ImageIcon(image));
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(450, 500); // Adjusted height for the form
    }
}
