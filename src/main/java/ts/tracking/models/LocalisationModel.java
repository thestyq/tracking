package ts.tracking.models;

import org.bson.Document;

public class LocalisationModel implements Model {
    private String request;
    private String status;
    private String region;
    private String areaCode;
    private String dmaCode;
    private String countryCode;
    private String countryName;
    private String continentCode;
    private String latitude;
    private String longtitude;
    private String regionCode;
    private String regionName;
    private String currencyCode;
    private String currencySymbol;
    private String currencyConverter;

    public LocalisationModel() {
    }

    @Override
    public Document getAsDocument() {
        return new Document()
                .append("request", request)
                .append("status", status)
                .append("region", region)
                .append("areaCode", areaCode)
                .append("dmaCode", dmaCode)
                .append("countryCode", countryCode)
                .append("countryName", countryName)
                .append("latitude", latitude)
                .append("longtitude", longtitude)
                .append("regionCode", regionCode)
                .append("regionName", regionName)
                .append("currencyCode", currencyCode)
                .append("currencySymbol", currencySymbol)
                .append("currencyConverter", currencyConverter);
    }
}
