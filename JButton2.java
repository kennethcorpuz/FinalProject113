import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class JButton2 extends JButton {
    private int arcWidth;
    private int arcHeight;
    private Color bgColor;

    // Constructor with text and icon
    public JButton2(String text, ImageIcon icon) {
        this(text, icon, 200, 50, new Color(32, 205, 182), 0, 0);
    }

    // Constructor with only text
    public JButton2(String text) {
        this(text, null, 200, 50, new Color(32, 205, 182), 0, 0);
    }

    // Constructor with text, icon, and custom size
    public JButton2(String text, ImageIcon icon, int width, int height) {
        this(text, icon, width, height, new Color(32, 205, 182), 0, 0);
    }

    // Constructor with only icon
    public JButton2(ImageIcon icon) {
        this("", icon, 200, 50, new Color(32, 205, 182), 0, 0);
    }

    
    // Full constructor
    public JButton2(String text, ImageIcon icon, int width, int height, Color bgColor, int arcWidth, int arcHeight) {
        super(text);
        setOpaque(false); // Make the button transparent
        setContentAreaFilled(false); // Don't paint the content area
        setBorderPainted(false); // Don't paint the border
        setFocusPainted(false); // Don't paint the focus indication
        setForeground(new Color(236, 236, 236)); // Set text color
        setFont(new Font("SansSerif", Font.BOLD, 14)); // Set font
        setPreferredSize(new Dimension(width, height)); // Set preferred size
        setArcSize(arcWidth, arcHeight); // Set default arc size
        setIcon(icon);
        setIconTextGap(30);
        setHorizontalAlignment(SwingConstants.LEFT);
        setHorizontalTextPosition(SwingConstants.LEADING);
        this.bgColor = bgColor;
    }

    public void setArcSize(int arcWidth, int arcHeight) {
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        repaint();
    }

    public void setBackgroundColor(Color color) {
        this.bgColor = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(bgColor);
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));
        super.paintComponent(g2d);
        g2d.dispose();
    }

    public void setPreferredSize(int width, int height) {
        Dimension size = new Dimension(width, height);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
    }

}
