package de.spqrinfo.assetmanagement.web.rest.dto;

import de.spqrinfo.assetmanagement.persistence.Asset;

import java.util.List;

/**
 * Created by Felix on 03.03.2015.
 */
public class AssetPaginatedDto {

    private final long total;
    private final List<AssetDto> assets;

    public AssetPaginatedDto(final long total, final List<AssetDto> assets) {
        this.total=total;
        this.assets=assets;
    }

    public  long getTotal(){ return this.total; }

    private List<AssetDto> getAssets() { return this.assets; }
}
