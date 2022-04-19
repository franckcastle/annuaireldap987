package pfe.annuaireldap.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"pfe.annuaireldap.*"})
@Profile("default")
@EnableLdapRepositories(basePackages = "pfe.annuaireldap.*")
public class Config {
    private static final Logger logger = LoggerFactory.getLogger(Config.class);
    @Bean
    LdapTemplate ldapTemplate(ContextSource contextSource){
        return new LdapTemplate(contextSource);
    }
}