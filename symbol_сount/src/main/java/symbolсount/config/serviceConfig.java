package symbolсount.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import symbolсount.service.SymbolСountService;
import symbolсount.utils.SymbolСountImpl;

@Configuration
public class serviceConfig {

    @Bean("SymbolCountService")
    public SymbolСountService symbolСountService(){
        return new SymbolСountImpl();
    }
}
