package com.wrike.links;

public enum Links {
    HOMEPAGE_URL("https://www.wrike.com/"),
    RESEND_PAGE_URL("https://www.wrike.com/resend/"),
    EMAIL_POSTFIX("+wpt@wriketask.qaa"),
    TWITTER_WRIKE_LINK("https://twitter.com/wrike"),
    TWITTER_ICON_TEXT("/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v2#twitter");
    
    private String link;

    Links(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}
