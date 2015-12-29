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

import ht.mbds.haiti.rase.service.ServicePackage;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackageClasses=ServicePackage.class)
public class ServiceConfig {

}