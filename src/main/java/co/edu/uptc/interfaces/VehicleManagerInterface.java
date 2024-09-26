package co.edu.uptc.interfaces;

import co.edu.uptc.utilities.SimpleList;
import co.edu.uptc.pojos.VehicleRecord;

public interface VehicleManagerInterface {

    public interface Model {
        public void setPresenter(Presenter presenter);

        public void loadData();

        public SimpleList<VehicleRecord> organizeState();

        public SimpleList<VehicleRecord> organizeCounty();

        public SimpleList<VehicleRecord> organizeCity();

        public SimpleList<VehicleRecord> organizeModel();

        public SimpleList<VehicleRecord> organizeMake();

        public SimpleList<VehicleRecord> organizeRange();

        public void resetData();
    }

    public interface View {
        public void setPresenter(Presenter presenter);

        public void begin();
    }

    public interface Presenter {
        public void setView(View view);

        public void setModel(Model model);

        public void loadData();
        
        public SimpleList<VehicleRecord> organizeState();

        public SimpleList<VehicleRecord> organizeCounty();

        public SimpleList<VehicleRecord> organizeCity();

        public SimpleList<VehicleRecord> organizeModel();

        public SimpleList<VehicleRecord> organizeMake();

        public SimpleList<VehicleRecord> organizeRange();

        public void resetData();
        
    }

}
