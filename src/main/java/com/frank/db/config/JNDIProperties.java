package com.frank.db.config;

import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
public class JNDIProperties {

    private String jndiName;
    private String auth;
    private String type;
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private String maxActive;
    private String maxIdle;
    private String maxWait;

    public String getJndiName() {
        return jndiName;
    }

    public void setJndiName(String jndiName) {
        this.jndiName = jndiName;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(String maxActive) {
        this.maxActive = maxActive;
    }

    public String getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(String maxIdle) {
        this.maxIdle = maxIdle;
    }

    public String getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(String maxWait) {
        this.maxWait = maxWait;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JNDIProperties that = (JNDIProperties) o;
        return Objects.equals(jndiName, that.jndiName) &&
                Objects.equals(auth, that.auth) &&
                Objects.equals(type, that.type) &&
                Objects.equals(driverClassName, that.driverClassName) &&
                Objects.equals(url, that.url) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(maxActive, that.maxActive) &&
                Objects.equals(maxIdle, that.maxIdle) &&
                Objects.equals(maxWait, that.maxWait);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jndiName, auth, type, driverClassName, url, username, password, maxActive, maxIdle, maxWait);
    }

    @Override
    public String toString() {
        return "JNDIProperties{" +
                "jndiName='" + jndiName + '\'' +
                ", auth='" + auth + '\'' +
                ", type='" + type + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", maxActive='" + maxActive + '\'' +
                ", maxIdle='" + maxIdle + '\'' +
                ", maxWait='" + maxWait + '\'' +
                '}';
    }
}
