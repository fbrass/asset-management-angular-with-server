package de.spqrinfo.assetmanagement.persistence;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Felix on 26.02.2015.
 */


@Entity
@NamedQueries({
        @NamedQuery(name="AssetType.findAll", query="SELECT a from AssetType a ORDER BY a.typeName"),
        @NamedQuery(name="AssetType.findALLMatching",
                    query="select a from AssetType a where lower(a.typeName) LIKE :typeName order by a.typeName"),
        @NamedQuery(name="AssetType.count",query = "select count(a) from AssetType a")
})
public class AssetType implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long typeId;

    @NotNull
    private String typeName;

    private String description;

    private String series;

    private String make;
    private String function;
    private String comment;

    @OneToMany(mappedBy = "assetType", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("due DESC")
    private final List<Asset> assets = new ArrayList<>();

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
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

    public List<Asset> getAssets() {
        return assets;
    }
}
