package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@AllArgsConstructor
@Data
public class Message {

    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;


}
