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


import ht.mbds.haiti.rase.job.JobDetection;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ComponentScan(basePackageClasses={AppConfig.class})
public class AppConfig {
    
    @Bean
    public JobDetection beanDectection() {
        return new JobDetection();
    }

}