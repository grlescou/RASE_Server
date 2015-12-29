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

import ht.mbds.haiti.rase.config.app.AppConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;




public class RaseWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        super.onStartup(container);
    }
    
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { MvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/api/*" };
    }
    
}
