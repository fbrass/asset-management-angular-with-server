package de.spqrinfo.assetmanagement.web;

import de.spqrinfo.assetmanagement.persistence.Asset;
import de.spqrinfo.assetmanagement.persistence.UploadFile;
import de.spqrinfo.assetmanagement.service.AssetManagementService;
import de.spqrinfo.assetmanagement.service.UploadFileService;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Felix on 03.03.2015.
 */
@WebServlet(urlPatterns = "/file")
@MultipartConfig(fileSizeThreshold = 1024*1024*10,
                 maxFileSize = 1024*1024*50,
                 maxRequestSize = 1024*1024*100)
public class FileServlet extends HttpServlet {

    private static final String KIND_ASSET_LOGO = "assetLogo";
    private static final String KIND_ASSET_TEMP_LOGO = "assetLogoTemp";

    @Inject
    UploadFileService uploadFileService;

    @Inject
    private AssetManagementService assetManagementService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final List<UploadFile> uploads = new ArrayList<>();

        for (final Part part: request.getParts()){
            final String submittedFileName = part.getSubmittedFileName();
            if(submittedFileName==null){
                continue;
            }

            final String contentType = part.getContentType();
            final long size=part.getSize();

            try (InputStream inputStream = part.getInputStream()) {
                final byte[] data = new byte[(int) part.getSize()];
                final int nb = inputStream.read(data);
                inputStream.close();

                if(nb != part.getSize()){
                    throw new RuntimeException("I/O error invariant failed - read not advertised size");
                }

                final UploadFile uploadFile = new UploadFile();
                uploadFile.setFilename(submittedFileName);
                uploadFile.setContentType(contentType);
                uploadFile.setSize(size);
                uploadFile.setData(data);

                final UploadFile uploadFilePersisted = this.uploadFileService.createTemporaryUpload(uploadFile);
                uploads.add(uploadFilePersisted);
            }
        }

        // Create json response of uploads
        final JsonArrayBuilder builder = Json.createArrayBuilder();
        for (final UploadFile upload : uploads) {
            final JsonObjectBuilder objBuilder = Json.createObjectBuilder();
            objBuilder.add("logoId", upload.getUploadId());
            if(upload.isTemporary()) {
                objBuilder.add("imageUrl", "file?kind=" + KIND_ASSET_TEMP_LOGO + "&uploadId=" + upload.getUploadId());
            } else {
                throw new RuntimeException("Not yet");
            }
            builder.add(objBuilder);
        }
        response.setContentType("application/json");

        try(JsonWriter writer = Json.createWriter(response.getWriter())) {
            writer.writeArray(builder.build());
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String kindParam = request.getParameter("kind");

        if(null == kindParam){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        switch (kindParam) {
            case KIND_ASSET_LOGO:
                getAssetLogo(request,response);
                break;
            case  KIND_ASSET_TEMP_LOGO:
                getAssetTemporaryLogo(request,response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                break;
        }
    }

    private void getAssetTemporaryLogo( final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        final String uploadIdParam = request.getParameter("uploadId");
        if(null == uploadIdParam){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        final Long uploadId = Long.valueOf(uploadIdParam);
        final UploadFile uploadFile = this.uploadFileService.findTemporary(uploadId);

        if(uploadFile == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            send( response,uploadFile);
        }
    }

    private void getAssetLogo(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        final String assetParam = request.getParameter("asset");
        if(null == assetParam) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        final Long assetID = Long.valueOf(assetParam);
        final Asset asset = this.assetManagementService.getAsset(assetID);

        if(asset == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            if(!asset.hasLogo()) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            } else {
                final UploadFile logo = asset.getLogo();
                send(response,logo);
            }
        }

    }

    private static void send(final HttpServletResponse response, final UploadFile file) throws IOException {
        response.setContentLength((int) file.getSize());
        response.setContentType(file.getContentType());
        response.getOutputStream().write(file.getData());
    }









































}
