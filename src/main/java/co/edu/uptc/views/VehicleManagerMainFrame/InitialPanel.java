package co.edu.uptc.views.VehicleManagerMainFrame;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.GlobalView;
import lombok.Getter;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

@Getter
public class InitialPanel extends JPanel{

    private GreenWheelsView greenWheelsView;
    private GridBagConstraints gbc;
    private JLabel logo;
    private JLabel title;
    private JLabel subTitle;
    private JPanel asidePanel;
    private JPanel imagePanel;
    private PropertiesService propertiesService;

    public InitialPanel(GreenWheelsView greenWheelsView){
        this.greenWheelsView = greenWheelsView;
        propertiesService = new PropertiesService();
        initPanel();
        createAsidePanel();
        createImagePanel();
        initLabels();
        
    }

    public void initPanel(){
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
    }

    public void createAsidePanel(){
        asidePanel = new JPanel();
        asidePanel.setLayout(new BoxLayout(asidePanel, BoxLayout.Y_AXIS));
        asidePanel.setBackground(GlobalView.ASIDE_BACKGROUND);
        asidePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1; 
        gbc.weighty = 1.0; 
        gbc.fill = GridBagConstraints.BOTH;
        this.add(asidePanel,gbc);

        asidePanel.add(Box.createVerticalStrut(20));
    }

    public void createImagePanel(){
        imagePanel = new ImagePanel(propertiesService.getKeyValue("principalImagePath"));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.85; 
        gbc.fill = GridBagConstraints.BOTH;
        this.add(imagePanel, gbc);
    }

    public void initLabels(){
        logo = new JLabel(); 
        logo.setIcon(new javax.swing.ImageIcon(propertiesService.getKeyValue("logoPath")));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        asidePanel.add(logo);
        asidePanel.add(Box.createVerticalStrut(80));

        title = new JLabel("<html><div style='text-align: center;'>WELCOME TO<br>GREENWHEELS<br> DATA</div></html>");
        title.setFont(GlobalView.TITLE_ASIDE);
        title.setForeground(GlobalView.ASIDE_TEXT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        asidePanel.add(title);
        asidePanel.add(Box.createVerticalStrut(100));

        subTitle = new JLabel("<html><div style='text-align: center;'>Optimize your analysis<br>with ease and precision!</div></html>");
        subTitle.setFont(GlobalView.ALL_TEXT_FONT);
        subTitle.setForeground(GlobalView.ASIDE_TEXT);
        subTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        subTitle.setHorizontalAlignment(SwingConstants.CENTER);
        asidePanel.add(subTitle);
        asidePanel.add(Box.createVerticalStrut(70));
    }

    public void addToAside(Component element){
        this.asidePanel.add(element);
        asidePanel.add(Box.createVerticalGlue());
    }
}