package ts.tracking;

public enum Header {
    USER_AGENT("User-Agent"),
    ACCEPT("Accept"),
    ACCEPT_LANGUAGE("Accept-Language"),
    ACCEPT_ENCODING("Accept-Encoding");

    private String header;
    Header(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }
}
