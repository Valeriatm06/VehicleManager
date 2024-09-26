package co.edu.uptc.presenters;

import co.edu.uptc.interfaces.VehicleManagerInterface;
import co.edu.uptc.pojos.VehicleRecord;
import co.edu.uptc.utilities.SimpleList;
import lombok.Getter;

@Getter
public class Presenter implements VehicleManagerInterface.Presenter{

    private VehicleManagerInterface.View view;
    private VehicleManagerInterface.Model model;

    @Override
    public void setView(VehicleManagerInterface.View view) {
        this.view = view;
    }

    @Override
    public void setModel(VehicleManagerInterface.Model model) {
      this.model = model;
    }

    @Override
    public void loadData() {
      model.loadData();
    }

    @Override
    public SimpleList<VehicleRecord> organizeState() {
      return model.organizeState();
    }

    @Override
    public SimpleList<VehicleRecord> organizeCounty() {
      return model.organizeCounty();
    }

    @Override
    public SimpleList<VehicleRecord> organizeCity() {
      return model.organizeCity();
    }

    @Override
    public SimpleList<VehicleRecord> organizeModel() {
      return model.organizeModel();
    }

    @Override
    public SimpleList<VehicleRecord> organizeMake() {
      return model.organizeMake();
    }

    @Override
    public SimpleList<VehicleRecord> organizeRange() {
      return model.organizeRange();
    }

    @Override
    public void resetData() {
      model.resetData();
    }
    
}
