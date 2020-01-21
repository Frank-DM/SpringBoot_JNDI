package com.frank.db.config;

import com.frank.db.common.CommonConstant;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;


@Configuration
public class JDNIConfig{

   @Resource
   private JNDIResource jNDIResource;

    @ConditionalOnProperty(name = "spring.profiles.active", havingValue = "dev")
    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatFactory() {
        return new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(
                    Tomcat tomcat) {
                tomcat.enableNaming();
                return super.getTomcatEmbeddedServletContainer(tomcat);
            }
            @Override
            protected void postProcessContext(Context context) {

                if(jNDIResource.getJndiList().isEmpty()){
                    return;
                }

                for (JNDIProperties jNDIProperties :jNDIResource.getJndiList()){
                    ContextResource resource = new ContextResource();
                    resource.setName(jNDIProperties.getJndiName());
                    resource.setType(jNDIProperties.getType());
                    resource.setProperty(CommonConstant.DATA_FACTORY, "org.apache.tomcat.jdbc.pool.DataSourceFactory");
                    resource.setProperty(CommonConstant.DATA_DRIVER_CLASS_NAME, jNDIProperties.getDriverClassName());
                    resource.setProperty(CommonConstant.DATA_URL, jNDIProperties.getUrl());
                    resource.setProperty(CommonConstant.DATA_USER_NAME, jNDIProperties.getUsername());
                    resource.setProperty(CommonConstant.DATA_PASSWORD,jNDIProperties.getPassword());
                    context.getNamingResources().addResource(resource);
                }

            }
        };
    }

}
