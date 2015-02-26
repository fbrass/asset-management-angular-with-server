package de.spqrinfo.assetmanagement.web.rest;

import de.spqrinfo.assetmanagement.persistence.AssetType;
import de.spqrinfo.assetmanagement.service.AssetManagementService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by Felix on 26.02.2015.
 */
@Path("/assettypelist/")
@Produces(APPLICATION_JSON)
public class AssetTypeListRest {

    @Inject
    private AssetManagementService assetManagementService;

    @GET
    publicn AssetTypeList getAll() {
        final List<AssetType> assetTypeList = this.assetManagementService.getAssetTypes();
        return assetTypeList;
    }
}
