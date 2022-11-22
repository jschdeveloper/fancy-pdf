package js;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Invoice {

    private String id;
    private String userId;
    private String pdfUrl;

    private Integer amount;
}
