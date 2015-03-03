package de.spqrinfo.assetmanagement.web.rest.dto;

import java.util.Date;

/**
 * Created by Felix on 03.03.2015.
 */
public class AssetDto {

    private Long asset_id;
    private Long location_id;
    private Long type_id;
    private Long logoId;
    private String name;
    private String version;
    private String comment;
    private Date construction_date;
    private int opening_value;
    private String currency;

    public Long getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(Long asset_id) {
        this.asset_id = asset_id;
    }

    public Long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Long location_id) {
        this.location_id = location_id;
    }

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }

    public Long getLogoId() {
        return logoId;
    }

    public void setLogoId(Long logoId) {
        this.logoId = logoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getConstruction_date() {
        return construction_date;
    }

    public void setConstruction_date(Date construction_date) {
        this.construction_date = construction_date;
    }

    public int getOpening_value() {
        return opening_value;
    }

    public void setOpening_value(int opening_value) {
        this.opening_value = opening_value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
