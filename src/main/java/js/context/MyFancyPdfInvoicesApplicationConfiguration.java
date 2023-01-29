package js.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import js.AppLauncher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AppLauncher.class)
public class MyFancyPdfInvoicesApplicationConfiguration {
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
