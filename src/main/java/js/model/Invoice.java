package js.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
public class Invoice {

    private String id;

    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("pdf_url")
    private String pdfUrl;

    private Integer amount;

    public Invoice(String userId,  Integer amount,String pdfUrl){
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.amount = amount;
        this.pdfUrl = pdfUrl;

    }
}
