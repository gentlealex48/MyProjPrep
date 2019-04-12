package com.kkaty.myprojprep.Model;

public class Business {
    private String id;
    private String alias;
    private String name;
    private String image_url;
    private String url;
    private String review_count;
    private String categories;

    public Business(String id, String alias, String name, String image_url, String is_closed, String url, String review_count, String categories) {
        this.id = id;
        this.alias = alias;
        this.name = name;
        this.image_url = image_url;
        this.is_closed = is_closed;
        this.url = url;
        this.review_count = review_count;
        this.categories = categories;
    }

    private String is_closed;

    public String getId() {
        return id;
    }

    public String getAlias() {
        return alias;
    }

    public String getName() {
        return name;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getIs_closed() {
        return is_closed;
    }

    public String getUrl() {
        return url;
    }

    public String getReview_count() {
        return review_count;
    }

    public String getCategories() {
        return categories;
    }

}
