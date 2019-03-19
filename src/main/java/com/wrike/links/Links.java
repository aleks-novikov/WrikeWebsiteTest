package com.wrike.links;

public enum Links {

    HOMEPAGE_URL("https://www.wrike.com/"),
    RESEND_PAGE_URL("https://www.wrike.com/resend/"),
    USER_EMAIL_MASK("+wpt@wriketask.qaa");
    
    private String content;

    Links(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
