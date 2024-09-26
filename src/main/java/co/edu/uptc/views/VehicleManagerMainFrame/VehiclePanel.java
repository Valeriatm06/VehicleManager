package co.edu.uptc.views.VehicleManagerMainFrame;

import javax.swing.JTable;
import javax.swing.JPanel;

import co.edu.uptc.pojos.VehicleRecord;
import co.edu.uptc.utilities.DesignButton;
import co.edu.uptc.utilities.SimpleList;
import co.edu.uptc.views.GlobalView;
import lombok.Getter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

@Getter
public class VehiclePanel extends JPanel{
    
    private GreenWheelsView greenWheelsView;
    private DesignButton byModel;
    private DesignButton byManufacturer;
    private DesignButton byRange;
    private JTable modelTable;
    private JTable manufacturerTable;
    private JTable rangeTable;
    private DefaultTableModel modelTableModel;
    private DefaultTableModel manufacturerTableModel;
    private DefaultTableModel rangeTableModel;
    private JScrollPane modelScrollPane;
    private JScrollPane manufacturerScrollPane;
    private JScrollPane rangeScrollPane;

    
    public VehiclePanel(GreenWheelsView greenWheelsView){
        this.greenWheelsView = greenWheelsView;
        setBackground(GlobalView.BODY_BACKGROUND);
        setLayout(null);
        initializeButtons();
        initModelTable();
        initManufacterTable();
        initRangeTable();
        showModelTable();
    }

    private void initializeButtons() {
        byModel = new DesignButton("Vehicles by model", true);
        byModel.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        byModel.setForeground(GlobalView.SECUNDARY_BTN_TEXT);
        byModel.setBounds(50, 60, 300, 35);
        byModel.addActionListener(e -> showModelTable());
        add(byModel);

        byManufacturer = new DesignButton("Vehicles by manufacturer", true);
        byManufacturer.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        byManufacturer.setForeground(GlobalView.SECUNDARY_BTN_TEXT);
        byManufacturer.setBounds(395, 60, 300, 35);
        byManufacturer.addActionListener(e -> showManufacturerTable());
        add(byManufacturer);

        byRange = new DesignButton("Vehicles by electric Range", true);
        byRange.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        byRange.setForeground(GlobalView.SECUNDARY_BTN_TEXT);
        byRange.setBounds(735, 60, 300, 35);
        byRange.addActionListener(e -> showRangeTable());
        add(byRange);
    }

    public void initModelTable(){
        String[] modelColumnNames = {"Model", "Number of Vehicles"};
        modelTableModel = new DefaultTableModel(modelColumnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelTable = new JTable(modelTableModel);
        modelScrollPane = new JScrollPane(modelTable);
        modelScrollPane.setBounds(50, 110, 990, 500);
        add(modelScrollPane);
        modelScrollPane.setVisible(false); 
    }

    public void initManufacterTable(){
        String[] manufacturerColumnNames = {"Manufacter", "Number of Vehicles"};
        manufacturerTableModel = new DefaultTableModel(manufacturerColumnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        manufacturerTable = new JTable(manufacturerTableModel);
        manufacturerScrollPane = new JScrollPane(manufacturerTable);
        manufacturerScrollPane.setBounds(50, 110, 990, 500);
        add(manufacturerScrollPane);
        manufacturerScrollPane.setVisible(false); 
    }

    public void initRangeTable(){
        String[] rangeColumnNames = {"Electric Range", "Number of Vehicles"};
        rangeTableModel = new DefaultTableModel(rangeColumnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        rangeTable = new JTable(rangeTableModel);
        rangeScrollPane = new JScrollPane(rangeTable);
        rangeScrollPane.setBounds(50, 110, 990, 500);
        add(rangeScrollPane);
        rangeScrollPane.setVisible(false); 
    }

     public void loadModelData() {
        
        SimpleList<VehicleRecord> modelData = greenWheelsView.getPresenter().organizeModel();
        modelTableModel.setRowCount(0);  

        for (int i = 0; i < modelData.size; i++) {
        VehicleRecord record = modelData.get(i);  

        Object[] rowData = {record.getName(), record.getTotalRecord()};
        
        modelTableModel.addRow(rowData);
        } 
     }

    public void loadManufacturerData() {
        
        SimpleList<VehicleRecord> manufacturerData = greenWheelsView.getPresenter().organizeMake();
        manufacturerTableModel.setRowCount(0);  

        for (int i = 0; i < manufacturerData.size; i++) {
        VehicleRecord record = manufacturerData.get(i);  

        Object[] rowData = {record.getName(), record.getTotalRecord()};
        
        manufacturerTableModel.addRow(rowData);
        }
    }

    public void loadRangeData() {
        
        SimpleList<VehicleRecord> rangeData = greenWheelsView.getPresenter().organizeRange();
        rangeTableModel.setRowCount(0);  

        for (int i = 0; i < rangeData.size; i++) {
        VehicleRecord record = rangeData.get(i);  

        Object[] rowData = {record.getName(), record.getTotalRecord()};
        
        rangeTableModel.addRow(rowData);
    }
    }

    private void showModelTable() {
        modelScrollPane.setVisible(true);
        manufacturerScrollPane.setVisible(false);
        rangeScrollPane.setVisible(false);
        revalidate();
        repaint();
    }

    private void showManufacturerTable() {
        modelScrollPane.setVisible(false);
        manufacturerScrollPane.setVisible(true);
        rangeScrollPane.setVisible(false);
        revalidate();
        repaint();
    }

    private void showRangeTable() {
        modelScrollPane.setVisible(false);
        manufacturerScrollPane.setVisible(false);
        rangeScrollPane.setVisible(true);
        revalidate();
        repaint();
    }

    public void clearData() {
        modelTableModel.setRowCount(0);;
        manufacturerTableModel.setRowCount(0);
        rangeTableModel.setRowCount(0);
    }

}