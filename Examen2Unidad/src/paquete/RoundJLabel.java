package paquete;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class RoundJLabel extends JLabel{

	  private Color backgroundColor;
	    private Color foregroundColor;
	    private int borderRadius;

	    public RoundJLabel() {
	        super();
	        this.backgroundColor = Color.WHITE;
	        this.foregroundColor = Color.BLACK;
	        this.borderRadius = 10;
	        setOpaque(false);
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        Graphics2D g2 = (Graphics2D) g.create();
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        g2.setColor(backgroundColor);
	        g2.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, borderRadius, borderRadius);
	        g2.setColor(foregroundColor);
	        super.paintComponent(g2);
	        g2.dispose();
	    }

	    @Override
	    public Dimension getPreferredSize() {
	        return new Dimension(super.getPreferredSize().width + borderRadius*2, super.getPreferredSize().height + borderRadius*2);
	    }

	    public void setBackgroundColor(Color backgroundColor) {
	        this.backgroundColor = backgroundColor;
	    }

	    public void setForegroundColor(Color foregroundColor) {
	        this.foregroundColor = foregroundColor;
	    }

	    public void setBorderRadius(int borderRadius) {
	        this.borderRadius = borderRadius;
	    }
}
