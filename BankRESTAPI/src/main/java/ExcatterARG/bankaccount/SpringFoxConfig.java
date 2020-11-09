package ExcatterARG.bankaccount;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(createAPIInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo createAPIInfo(){
        Contact creator = new Contact("Juan Ignacio Beloqui", "https://github.com/ExcatterARG", "excatter@gmail.com");
        return new ApiInfo("Bank Demo Application", "This is a demo showing an example of a REST API built using Spring boot",
                "1.0.0", "", creator, null, null, Collections.emptyList());
    }
}