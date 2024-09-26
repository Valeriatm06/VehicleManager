package co.edu.uptc.pojos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Vehicle {

    private String id;
    private String state;
    private String county;
    private String city;
    private String postalCode;
    private String modelYear;
    private String model;
    private String electricType;
    private String make;
    private String electricRange;
    private String cleanFuelVehicleEligibility;
    private String baseMsrp;
    private String legislativeDistrict;
    private String dolVehicleId;
    private String geocodedLocation;
    private String electricUtility;

    public String getIf(String data){
        String dataReturn ="";
        switch (data) {
            case "state":
                dataReturn= this.state;
                break;
            case "county":
                dataReturn= this.county;
                break;
            case "city":
                dataReturn= this.city;
                break;
            case "model":
                dataReturn= this.model;
                break;
            case "make":
                dataReturn= this.make;
                break;
            case "id":
                dataReturn= this.id;
                break;
            case "postalCode":
                dataReturn= this.postalCode;
                break;
            case "modelYear":
                dataReturn= this.modelYear;
                break;
            case "electricRange":
                dataReturn= this.electricRange;
                break;
            case "electricType":
                dataReturn= this.electricType;
                break;
            case "clean":
                dataReturn= this.cleanFuelVehicleEligibility;
                break;
            case "baseMrsp":
                dataReturn= this.baseMsrp;
                break;
            case "legislative":
                dataReturn= this.legislativeDistrict;
                break;
            case "dol":
                dataReturn= this.dolVehicleId;
                break;
            case "geo":
                dataReturn= this.geocodedLocation;
                break;
            case "electricUtility":
                dataReturn= this.electricUtility;
                break;
            default:
                break;
        }
        return dataReturn;
    }
}


