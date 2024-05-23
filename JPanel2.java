import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class JPanel2 extends JPanel {
    private Image backgroundImage;
    private int arcWidth;
    private int arcHeight;

    public JPanel2(Image backgroundImage) {
        this(backgroundImage, 0, 0);
    }

    public JPanel2(Image backgroundImage, int arcWidth, int arcHeight) {
        this.backgroundImage = backgroundImage;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setOpaque(false); // Ensure the panel is non-opaque to support transparency
    }

    public void setArcSize(int arcWidth, int arcHeight) {
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        // Enable anti-aliasing for smoother corners
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Create a rounded rectangle clip
        g2d.setClip(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));

        // Draw the background image
        if (backgroundImage != null) {
            g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

        g2d.dispose();
    }
}
