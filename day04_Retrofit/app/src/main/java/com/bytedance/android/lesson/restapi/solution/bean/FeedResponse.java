/**
 * Copyright 2019 bejson.com
 */
package com.bytedance.android.lesson.restapi.solution.bean;;
import java.util.List;

/**
 * Auto-generated: 2019-01-22 16:43:13
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class FeedResponse {

    private List<Feed> feeds;
    private boolean success;
    public void setFeeds(List<Feed> feeds) {
        this.feeds = feeds;
    }
    public List<Feed> getFeeds() {
        return feeds;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    public boolean getSuccess() {
        return success;
    }

}