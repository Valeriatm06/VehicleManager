package co.edu.uptc.utilities;

import java.util.Comparator;

import co.edu.uptc.pojos.VehicleRecord;

public class VehicleComparator {

    public static Comparator<VehicleRecord> stateComparator = new Comparator<VehicleRecord>() {
        @Override
        public int compare(VehicleRecord one, VehicleRecord two) {
        // TODO Auto-generated method stub
            int result = two.getExtraInfo().compareTo(one.getExtraInfo());
            if (result == 0) {
                result = Integer.compare(two.getTotalRecord(), one.getTotalRecord());
            }
            return result;
        }
    };

    public static Comparator<VehicleRecord> countComparator = new Comparator<VehicleRecord>() {

        @Override
        public int compare(VehicleRecord one, VehicleRecord two){

            return Integer.compare(one.getTotalRecord(), two.getTotalRecord());
        }
    };
}
