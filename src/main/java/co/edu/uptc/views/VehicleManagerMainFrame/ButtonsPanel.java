package co.edu.uptc.views.VehicleManagerMainFrame;

import javax.swing.JPanel;

import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.GlobalView;

import javax.swing.JLabel;
import java.awt.Graphics;

public class ButtonsPanel extends JPanel{

    private JLabel logo;
    private JLabel geoLogo;
    private JLabel vehicleLogo;
    private JLabel logOutLogo;
    PropertiesService propertiesService;

    public ButtonsPanel(){
        propertiesService = new PropertiesService();
        initPanel();
        initializeComponents();
    }

    public void initPanel(){
        setLayout(null);
        setBackground(GlobalView.ASIDE_BACKGROUND);
    }

    public void initializeComponents() {
        
        logo = new JLabel(); 
        logo.setIcon(new javax.swing.ImageIcon(propertiesService.getKeyValue("logoPath")));
        logo.setBounds(50, 100, 200, 80);
        add(logo);

        geoLogo = new JLabel();
        geoLogo.setIcon(new javax.swing.ImageIcon(propertiesService.getKeyValue("geographicPath")));
        geoLogo.setBounds(20, 330, 30, 50);
        add(geoLogo);

        vehicleLogo = new JLabel();
        vehicleLogo.setIcon(new javax.swing.ImageIcon(propertiesService.getKeyValue("vehiclePath")));
        vehicleLogo.setBounds(20, 260, 40, 50);
        add(vehicleLogo);

        logOutLogo = new JLabel();
        logOutLogo.setIcon(new javax.swing.ImageIcon(propertiesService.getKeyValue("logOutPath")));
        logOutLogo.setBounds(23, 600, 30, 50);
        add(logOutLogo);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int lineYPosition = 580;
        g.drawLine(10, lineYPosition, getWidth() - 10, lineYPosition);
    }
}