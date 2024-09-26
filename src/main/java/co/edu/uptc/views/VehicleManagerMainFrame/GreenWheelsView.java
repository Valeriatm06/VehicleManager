package co.edu.uptc.views.VehicleManagerMainFrame;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import co.edu.uptc.interfaces.VehicleManagerInterface;
import co.edu.uptc.utilities.DesignButton;
import co.edu.uptc.views.GlobalView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GreenWheelsView extends JFrame implements VehicleManagerInterface.View {

    private VehicleManagerInterface.Presenter presenter;
    private GridBagConstraints gbc;
    private JPanel buttonsPanel;
    private Container contentJPanel;
    private InitialPanel menuJPanel;
    private VehiclePanel vehicJPanel;
    private GeographicPanel geographicJPanel;
    private DesignButton loadDataButton;
    private DesignButton toMenu;
    private DesignButton toVehicle;
    private DesignButton toGeo;

    public GreenWheelsView() {
        initFrame();
        createButtonsPanel();
        createContentJPanel();
        createMenuPanel();
        createVehicJPanel();
        createButtons();
        createVehicJPanel();
        createGeographicJPanel();
    }

    @Override
    public void begin() {
        this.setVisible(true);
    }

    private void initFrame() {
        this.setTitle("GreenWheels Manager");
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        gbc = new GridBagConstraints();
    }

    public void createButtonsPanel() {
        buttonsPanel = new ButtonsPanel();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.25;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(buttonsPanel, gbc);
        buttonsPanel.setVisible(false);
    }

    public void createContentJPanel() {
        contentJPanel = new JPanel(new CardLayout());
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.75;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(contentJPanel, gbc);
    }

    public void createMenuPanel() {
        menuJPanel = new InitialPanel(this);
        contentJPanel.add(menuJPanel, "Menu");
    }

    public void createVehicJPanel() {
        vehicJPanel = new VehiclePanel(this);
        contentJPanel.add(vehicJPanel, "Vehicle");
    }

    public void createGeographicJPanel() {
        geographicJPanel = new GeographicPanel(this);
        contentJPanel.add(geographicJPanel, "geo");
    }

    public void createButtons() {
        loadDataButton = new DesignButton("Load Data", true);
        loadDataButton.setForeground(GlobalView.PRIMARY_BTN_TEXT);
        loadDataButton.setBounds(60, 430, 350, 50);
        loadDataButton.addActionListener(e -> loadData());
        loadDataButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loadDataButton.setBackground(GlobalView.PRIMARY_BTN_BACKGROUND);
        menuJPanel.addToAside(loadDataButton);

        toMenu = new DesignButton("Log Out",false);
        toMenu.setForeground(GlobalView.PRIMARY_BTN_TEXT);
        toMenu.setBounds(15, 600, 200, 50);
        toMenu.addActionListener((e -> {
            resetAllData(); 
            showPanel("Menu");
        }));
        buttonsPanel.add(toMenu);

        toVehicle = new DesignButton("Vehicle Data Analisis",true);
        toVehicle.setForeground(GlobalView.PRIMARY_BTN_TEXT);
        toVehicle.setBackground(GlobalView.PRIMARY_BTN_BACKGROUND);
        toVehicle.setBounds(56, 260, 200, 50);
        toVehicle.addActionListener(e -> showPanel("Vehicle"));
        buttonsPanel.add(toVehicle);

        toGeo = new DesignButton("Geographic Analisis",true);
        toGeo.setForeground(GlobalView.PRIMARY_BTN_TEXT);
        toGeo.setBackground(GlobalView.PRIMARY_BTN_BACKGROUND);
        toGeo.setBounds(55, 330, 200, 50);
        toGeo.addActionListener(e -> showPanel("geo"));
        buttonsPanel.add(toGeo);
        contentJPanel.setVisible(true);
    }
    
    private void loadData() {
        if(this.continueDialog()){
            LoadingDialog loadingDialog = new LoadingDialog(this);
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                presenter.loadData(); 
                // geographicJPanel.loadStateData(); 
                // geographicJPanel.loadCountyData();
                // geographicJPanel.loadCityData(); 
                // vehicJPanel.loadModelData(); 
                vehicJPanel.loadManufacturerData(); 
                // vehicJPanel.loadRangeData(); 
                return null;
            }

            @Override
            protected void done() {
                loadingDialog.hideLoading(); 
                showPanel("Vehicle"); 
            }
        };

        worker.execute();
        loadingDialog.showLoading();
        }
}

    public boolean continueDialog(){
        int respons = JOptionPane.showConfirmDialog(null,"Would you like to continue?", "Continue",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return respons == JOptionPane.YES_OPTION;
    }


    private void showPanel(String panelName) {
        CardLayout cardLayout = (CardLayout) contentJPanel.getLayout();
        cardLayout.show(contentJPanel, panelName);
        buttonsPanel.setVisible(!panelName.equals("Menu"));
    }

    private void resetAllData() {
        vehicJPanel.clearData(); 
        geographicJPanel.clearData(); 
        if (presenter != null) {
            presenter.resetData(); 
        }
    }

    @Override
    public void setPresenter(VehicleManagerInterface.Presenter presenter) {
        this.presenter = presenter;
    }

    public VehicleManagerInterface.Presenter getPresenter(){
        return this.presenter;
    }
}
