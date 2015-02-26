package de.spqrinfo.assetmanagement.web.rest.dto;

/**
 * Created by Felix on 26.02.2015.
 */
public class AssetTypeListDto {

    private long typeID;
    private String typeName;
    private String description;
    private String series;

    private String make;
    private String function;
    private String comment;

    public long getTypeID() {
        return typeID;
    }

    public void setTypeID(long typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
