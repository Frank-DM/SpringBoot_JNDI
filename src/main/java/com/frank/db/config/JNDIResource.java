package com.frank.db.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@ConfigurationProperties(prefix = "jndiConfig")
public class JNDIResource {

    private List<JNDIProperties> jndiList = new ArrayList<>();

    public List<JNDIProperties> getJndiList() {
        return jndiList;
    }

    public void setJndiList(List<JNDIProperties> jndiList) {
        this.jndiList = jndiList;
    }
}
