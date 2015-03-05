package de.spqrinfo.assetmanagement.web.rest;

import de.spqrinfo.assetmanagement.service.AssetManagementService;

import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * Created by said on 04.03.2015.
 */
public class AssetListRest {

    private static final Logger log = Logger.getLogger(AssetListRest.class.getName());

    private static final int PAGE_SIZE_MAX=4000;

    @Inject
    private AssetManagementService assetManagementService;


}
