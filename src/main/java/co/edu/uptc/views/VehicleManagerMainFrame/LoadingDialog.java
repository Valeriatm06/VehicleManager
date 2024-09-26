package co.edu.uptc.views.VehicleManagerMainFrame;

import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.GlobalView;
import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.*;

public class LoadingDialog extends JDialog {

    PropertiesService propertiesService;

    public LoadingDialog(Frame parent) {
        super(parent, "Loading", true);
        propertiesService = new PropertiesService();
        initDialog();
        initLabels();
    }

    private void initDialog() {
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(getParent());
        setBackground(GlobalView.DIALOG_BACKGROUND);
        setUndecorated(true);
    }

    public void initLabels(){
        ImageIcon loadingGif = new ImageIcon(propertiesService.getKeyValue("gifPath"));

        JLabel loadingLabel = new JLabel(loadingGif);
        loadingLabel.setFont(GlobalView.ALL_TEXT_FONT);
        loadingLabel.setForeground(GlobalView.ASIDE_TEXT);
        loadingLabel.setHorizontalAlignment(JLabel.CENTER);

        add(loadingLabel, BorderLayout.NORTH);

        JLabel loadingInfoLabel = new JLabel("shh, please wait...");
        loadingInfoLabel.setFont(GlobalView.ALL_TEXT_FONT);
        loadingInfoLabel.setForeground(GlobalView.ASIDE_TEXT);
        loadingInfoLabel.setHorizontalAlignment(JLabel.CENTER);
        add(loadingInfoLabel, BorderLayout.SOUTH);
    }

    
    public void showLoading() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }

    
    public void hideLoading() {
        SwingUtilities.invokeLater(() -> dispose());
    }
}
