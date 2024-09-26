package co.edu.uptc.utilities;

import java.util.Comparator;
import java.util.List;

import co.edu.uptc.pojos.VehicleRecord;

public class MySort<T> {

    public void sortData(List<VehicleRecord> data, Comparator<VehicleRecord> comparator) {
        quickSort(data, comparator, 0, data.size() - 1);
    }

    private void quickSort(List<VehicleRecord> list, Comparator<VehicleRecord> comparator, int low, int high) {
        if (low < high) {
            int pi = partition(list, comparator, low, high);

            quickSort(list, comparator, low, pi - 1);
            quickSort(list, comparator, pi + 1, high);
        }
    }

    private int partition(List<VehicleRecord> list, Comparator<VehicleRecord> comparator, int low, int high) {
        VehicleRecord pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(list.get(j), pivot) >= 1) {
                i++;

                VehicleRecord temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        VehicleRecord temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }
}
