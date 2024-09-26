package co.edu.uptc.pojos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VehicleRecord {
    String name;
    int totalRecord;
    String extraInfo;

    public void Record(){
        totalRecord = 0;
    }

    public void addToTotalRecord(){
        totalRecord++;
    }
}
