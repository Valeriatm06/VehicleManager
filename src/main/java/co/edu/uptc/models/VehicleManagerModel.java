package co.edu.uptc.models;

import co.edu.uptc.interfaces.VehicleManagerInterface;
import co.edu.uptc.pojos.VehicleRecord;
import co.edu.uptc.pojos.Vehicle;
import co.edu.uptc.utilities.MySort;
import co.edu.uptc.utilities.SimpleList;
import co.edu.uptc.utilities.VehicleComparator;
import co.edu.uptc.utilities.VehicleReader;
import lombok.Getter;

@Getter
public class VehicleManagerModel implements VehicleManagerInterface.Model {

    private VehicleManagerInterface.Presenter presenter;
    private SimpleList<Vehicle> dataList;
    private MySort<Integer> mySort;
    private MySort<String> countySort;
    private SimpleList<VehicleRecord> showStateInfo;
    private SimpleList<VehicleRecord> showCountyInfo;
    private SimpleList<VehicleRecord> showCityInfo;
    private SimpleList<VehicleRecord> showModelInfo;
    private SimpleList<VehicleRecord> showMakeInfo;
    private SimpleList<VehicleRecord> showRangeInfo;

    public VehicleManagerModel() {
        mySort = new MySort<Integer>();
        countySort = new MySort<String>();
    }

    @Override
    public void setPresenter(VehicleManagerInterface.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadData() {
        VehicleReader reader = new VehicleReader();
        dataList = reader.readData(); 
    }

    public SimpleList<Vehicle> getDataList() {
        if (dataList == null) {
            loadData();
        }
        return dataList;
    }

    @Override
    public SimpleList<VehicleRecord> organizeState() {
        showStateInfo = this.countInfo("state");
        mySort.sortData(showStateInfo, VehicleComparator.countComparator);
        return showStateInfo;
    }

    @Override
    public SimpleList<VehicleRecord> organizeCounty() {
        showCountyInfo = this.countInfo("county");
        mySort.sortData(showCountyInfo, VehicleComparator.stateComparator);
        return showCountyInfo;
    }

    @Override
    public SimpleList<VehicleRecord> organizeCity() {
        SimpleList<VehicleRecord> aux = this.countInfo("city");
        mySort.sortData(aux, VehicleComparator.countComparator);
        int count = 0;
        showCityInfo = new SimpleList<VehicleRecord>();
        int maxRecords = aux.get(0).getTotalRecord();
        while (count < aux.size() && aux.get(count).getTotalRecord() == maxRecords) {
            showCityInfo.add(aux.get(count));
            count++;
        }
        return showCityInfo;
    }

    @Override
    public SimpleList<VehicleRecord> organizeModel() {
        showModelInfo = this.countInfo("model");
        return showModelInfo;
    }

    @Override
    public SimpleList<VehicleRecord> organizeMake() {
        showMakeInfo = this.countInfo("make");
        return showMakeInfo;
    }

    @Override
    public SimpleList<VehicleRecord> organizeRange() {
        showRangeInfo = this.countInfo("range");
        return showRangeInfo;
    }

    public SimpleList<VehicleRecord> countInfo(String select){
        SimpleList<VehicleRecord> info = new SimpleList<VehicleRecord>();
        String place;
        for (int i = 0; i < getDataList().size; i++) {
            place = getDataList().get(i).getIf(select);
            boolean add =true;
            for (int j = 0; j < info.size(); j++) {
                if(info.get(j).getName().equals(place)){
                    info.get(j).addToTotalRecord();
                    add=false;
                }
            }
            if (add) {
                String extraInformation = null;
                if (select.equals("county")) {
                    extraInformation = getDataList().get(i).getState();
                }
                info.add(new VehicleRecord(place, 1, extraInformation));
            }
        }
        return info;
    }

    @Override
    public void resetData() {
        getDataList().clear();
    }

}
