/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.config.app;

/**
 *
 * @author MyPC
 */


import ht.mbds.haiti.rase.model.repository.RepositoryPackage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;


@Configuration
@EnableMongoRepositories(basePackageClasses=RepositoryPackage.class)
public class MongoConfig extends AbstractMongoConfiguration{

    // ---------------------------------------------------- mongodb config

    @Override
    protected String getDatabaseName() {
       // return "raseht";
        return "api";
    }

    @Override
    @Bean
    public MongoClient mongo() throws Exception {
        MongoClient client = new MongoClient("localhost");
        client.setWriteConcern(WriteConcern.SAFE);
        
        return client;
    }

    @Override
    protected String getMappingBasePackage() {
        return "ht.mbds.haiti.rase.model";
    }
    
    // ---------------------------------------------------- MongoTemplate
    
    
    @Override
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), getDatabaseName());
    }
    
}
