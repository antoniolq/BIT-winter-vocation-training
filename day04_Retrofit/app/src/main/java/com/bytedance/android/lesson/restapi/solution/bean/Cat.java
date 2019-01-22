/**
 * Copyright 2019 bejson.com
 */
package com.bytedance.android.lesson.restapi.solution.bean;
import java.util.List;

/**
 * Auto-generated: 2019-01-22 15:14:15
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Cat {

    private List<String> breeds;
    private String id;
    private String url;
    public void setBreeds(List<String> breeds) {
        this.breeds = breeds;
    }
    public List<String> getBreeds() {
        return breeds;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

}