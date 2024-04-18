import java.time.*;
import java.time.format.DateTimeFormatter;

public  record  Divisa(
        String base_code,
        String target_code,
        double conversion_rate
){

    @Override
    public String toString() {

        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime today = LocalDateTime.now();
        String formattedDate = today.format(formatDate);

        return "1 "+base_code()+" es igual a "+conversion_rate()+" "+target_code()+" con fecha: "+formattedDate+"\n";
    }

}
