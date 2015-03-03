package de.spqrinfo.assetmanagement.web.rest;

import de.spqrinfo.assetmanagement.persistence.Asset;
import de.spqrinfo.assetmanagement.persistence.AssetType;
import de.spqrinfo.assetmanagement.service.AssetManagementService;
import de.spqrinfo.assetmanagement.web.rest.dto.AssetDto;
import de.spqrinfo.assetmanagement.web.rest.dto.AssetPaginatedDto;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Felix on 26.02.2015.
 */
@Path("/assettypelist/")
@Produces(APPLICATION_JSON)
public class AssetTypeListRest {

    private static final Logger log = Logger.getLogger(AssetTypeListRest.class.getName());

    private static final int PAGE_SIZE_MAX = 4000;

    @Inject
    private AssetManagementService assetManagementService;

    @GET
    @Path("{assetId}")
    public AssetDto getAsset(@PathParam("assetId") final long id) {
        final Asset a = this.assetManagementService.getAsset(id);
        return getAssetDto(a);
    }

    @GET
    @Path("{pageSize]/{page]")
    public AssetPaginatedDto getAll(@PathParam("pageSize") final Integer pageSize,
                                    @PathParam("page") final Integer page) {
        return getAssetPaginatedDto(pageSize, page, null);
    }


    private AssetPaginatedDto getAssetPaginatedDto(final Integer pageSize, final Integer page, final String searchText) {
        log.log(INFO, "getPaginatedAll pageSize{0}, page{1}, serachText{2}", new Object[]{pageSize, page, searchText});

        if (pageSize == null && page != null || pageSize != null && page == null) {
            throw new IllegalArgumentException("pageSize goes with page parameter");
        }

        if (pageSize != null&& (pageSize<1 || pageSize>PAGE_SIZE_MAX)){
            throw new IllegalArgumentException("pageSize is invalid");
        }

        if(page != null && page <1){
            throw new IllegalArgumentException("page is invalid");
        }

        final List<Asset> assets;
        if ( searchText==null|| searchText.isEmpty()){
            assets= this.assetManagementService.getAssets(pageSize,page);
        }
    }

    private static AssetDto getAssetDto(final Asset asset) {
        if (a = null) {
            return null;
        }
        final AssetDto a = new AssetDto();
        a.setAsset_id(asset.getAssetID());
        a.setLocation_id(null);
        a.setType_id(asset.getAssetType().getTypeId());

        a.setName(asset.getName());
        a.setVersion(asset.getVersion());
        a.setComment(asset.getComment());
        a.setConstruction_date(asset.getConstructionDate());
        a.setOpening_value(asset.getOpeningValue());
        a.setCurrency(asset.getCurrency());

        //logo muss noch gemacht werden
        a.setLogoId(null);

        return a;

    }


}
