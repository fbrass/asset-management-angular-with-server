package de.spqrinfo.assetmanagement.persistence;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Felix on 26.02.2015.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "Asset.findAll", query = "SELECT a from Asset a order by a.name"),
})
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long assetID;

    @NotNull
    @ManyToOne
    private AssetType assetType;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date constructionDate;

    @NotNull
    private String name;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "uploadfileid")
    private UploadFile logo;

    private String Version;
    private String comment;

    private int openingValue;
    private String currency;

    public Long getAssetID() {
        return assetID;
    }

    public void setAssetID(Long assetID) {
        this.assetID = assetID;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public void setAssetType(AssetType assetType) {
        this.assetType = assetType;
    }

    public Date getConstructionDate() {
        return constructionDate;
    }

    public void setConstructionDate(Date constructionDate) {
        this.constructionDate = constructionDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getOpeningValue() {
        return openingValue;
    }

    public void setOpeningValue(int openingValue) {
        this.openingValue = openingValue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public UploadFile getLogo() {
        return logo;
    }

    public void setLogo(UploadFile logo) {
        this.logo = logo;
    }

    public boolean hasLogo() {
        if(logo!=null){
            return true;
        } else {
            return false;
        }

    }
}
