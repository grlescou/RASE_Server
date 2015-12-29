/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.config.mvc;

/**
 *
 * @author MyPC
 */


import ht.mbds.haiti.rase.rest.ControllerPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses={ControllerPackage.class} )
//@Import(ConverterConfig.class)
public class MvcConfig extends WebMvcConfigurerAdapter {
    
    //@Autowired private ContinentConverter continentConverter;


    // ---------------------------------------------------- Converters
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //registry.addConverter(continentConverter);
       
    } 
    
    // ---------------------------------------------------- Content Negotiation
    
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(true) 
                  .favorParameter(true).parameterName("media-type")
                  .ignoreAcceptHeader(false)
                  .useJaf(false)
                  .mediaType("json", MediaType.APPLICATION_JSON)
                  .defaultContentType(MediaType.APPLICATION_JSON);
    }
    
    // ---------------------------------------------------- Messages
    
    /* From the Spring documentation..
     * 
     * "Since application servers typically cache all files loaded from the 
     * classpath, it is necessary to store resources somewhere else (for example, 
     * in the "WEB-INF" directory of a web app). Otherwise changes of files
     * in the classpath will not be reflected in the application."
     */
//    @Bean
//    public ReloadableResourceBundleMessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messages = new ReloadableResourceBundleMessageSource();
//        messages.setBasename("WEB-INF/messages/messages");
//        return messages;
//    }

//    @Bean
//    public MessageSourceAccessor messageAccessor() {
//        MessageSourceAccessor messageAccessor = new MessageSourceAccessor(messageSource());
//        return messageAccessor;
//    }

}