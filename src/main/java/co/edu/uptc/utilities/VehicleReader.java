package co.edu.uptc.utilities;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import co.edu.uptc.pojos.Vehicle;

public class VehicleReader{

    SimpleList<Vehicle> dataList;

    public SimpleList<Vehicle> readData(){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            URL url = new URL("https://data.wa.gov/api/views/f6w7-q2d2/rows.json");

            JsonNode rootNode = objectMapper.readTree(url);

            JsonNode dataNode = rootNode.get("data");

            dataList = new SimpleList<Vehicle>();

            if (dataNode.isArray()) {
                for (JsonNode arrayNode : dataNode) {
                    Iterator<JsonNode> elements = arrayNode.elements();
                    Vehicle data = new Vehicle();
                    for (int i = 0; i < 8; i++) {
                        elements.next();
                    }
                    data.setId(elements.next().asText());
                    data.setCounty(elements.next().asText());
                    data.setCity(elements.next().asText());
                    data.setState(elements.next().asText());
                    data.setPostalCode(elements.next().asText());
                    data.setModelYear(elements.next().asText());
                    data.setMake(elements.next().asText());
                    data.setModel(elements.next().asText());
                    data.setElectricType(elements.next().asText());
                    data.setCleanFuelVehicleEligibility(elements.next().asText());
                    data.setElectricRange(elements.next().asText());
                    data.setBaseMsrp(elements.next().asText());
                    data.setLegislativeDistrict(elements.next().asText());
                    data.setDolVehicleId(elements.next().asText());
                    data.setGeocodedLocation(elements.next().asText());
                    data.setElectricUtility(elements.next().asText());
                                    
                    dataList.add(data);
                }
            }

            return dataList;

        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }
    }
}