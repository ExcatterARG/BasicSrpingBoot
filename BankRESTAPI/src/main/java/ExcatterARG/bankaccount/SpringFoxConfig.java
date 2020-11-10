package ExcatterARG.bankaccount;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${swagger.apiinfo.contact.name}")
    private String contactName;

    @Value("${swagger.apiinfo.contact.email}")
    private String contactEmail;

    @Value("${swagger.apiinfo.contact.url}")
    private String contactURL;

    @Value("${swagger.apiinfo.title}")
    private String apiTitle;

    @Value("${swagger.apiinfo.description}")
    private String apiDescription;

    @Value("${swagger.apiinfo.version}")
    private String apiVersion;

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
        Contact creator = new Contact(this.contactName,this.contactURL, this.contactEmail);
        return new ApiInfo(this.apiTitle, this.apiDescription, this.apiVersion,
                null, creator, null, null, Collections.emptyList());
    }
}