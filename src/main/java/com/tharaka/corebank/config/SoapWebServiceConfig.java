package com.tharaka.corebank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return  new ServletRegistrationBean(servlet, "/soapWS/*");
    }

    @Bean
    public XsdSchema accountSchema(){
        return new SimpleXsdSchema(new ClassPathResource("accounts.xsd"));
    }

    @Bean(name = "bankAccountDetailsWsdl")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema accountSchema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(accountSchema);
        definition.setLocationUri("/soapWS");
        definition.setPortTypeName("AccountServicePort");
        definition.setTargetNamespace("http://tharaka.com/corebank/model");
        return definition;
    }
}
