package br.com.webscrap.model;

import java.io.Serializable;

/**
 * Created by Gustavo on 26/08/2016.
 */

public class Casa implements Serializable{

    private String name;
    private String url;
    private String logo;

    public Casa(String name, String url, String logo) {
        this.name = name;
        this.url = url;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
