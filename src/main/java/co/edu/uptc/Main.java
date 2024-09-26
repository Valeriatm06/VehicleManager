package co.edu.uptc;

import co.edu.uptc.interfaces.VehicleManagerInterface;
import co.edu.uptc.models.VehicleManagerModel;
import co.edu.uptc.presenters.Presenter;
import co.edu.uptc.views.VehicleManagerMainFrame.GreenWheelsView;

public class Main {
    public static void main(String[] args) {

        VehicleManagerInterface.Model model = new VehicleManagerModel();
        VehicleManagerInterface.Presenter presenter = new Presenter();
        VehicleManagerInterface.View view = new GreenWheelsView();
        model.setPresenter(presenter);
        view.setPresenter(presenter);
        presenter.setModel(model);
        presenter.setView(view);
        view.begin();
    }
}