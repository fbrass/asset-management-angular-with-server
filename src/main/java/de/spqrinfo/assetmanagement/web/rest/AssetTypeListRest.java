package de.spqrinfo.assetmanagement.web.rest;

import de.spqrinfo.assetmanagement.persistence.AssetType;
import de.spqrinfo.assetmanagement.service.AssetManagementService;
import de.spqrinfo.assetmanagement.web.rest.dto.AssetTypeListDto;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.stream.Collectors;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by Felix on 26.02.2015.
 */
@Path("/assettypelist/")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class AssetTypeListRest {

    @Inject
    private AssetManagementService assetManagementService;

    @GET
    public AssetTypeListDto[] getAll() {
        final List<AssetType> assetTypes = this.assetManagementService.getAssetTypes();
        final List<AssetTypeListDto> result = assetTypes.stream().map(AssetTypeListRest::to).collect(Collectors.toList());
        return result.toArray(new AssetTypeListDto[result.size()]);
    }

    private static AssetTypeListDto to(final AssetType a){
        if(a==null){
            return null;
        }

        final AssetTypeListDto ad=new AssetTypeListDto();
        ad.setAssetTypeName(a.getTypeName());
        ad.setDescription(a.getDescription());
        ad.setFunction(a.getFunction());
        ad.setMake(a.getMake());
        ad.setTypeID(a.getTypeId());
        return  ad;
    }


}


/*
    private long typeID;
    private String assetTypeName;
    private String function;
    private String description;
    private String make;
    */