package de.spqrinfo.assetmanagement.service;

import de.spqrinfo.assetmanagement.persistence.UploadFile;

import javax.ejb.Schedule;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Felix on 03.03.2015.
 */
public class UploadFileService {

    private static final Logger log = Logger.getLogger(UploadFileService.class.getName());

    public static final long ONE_MINUTE_IN_MILLIS = 60000;

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public UploadFile createTemporaryUpload(final UploadFile uploadFile) {
        log.log(Level.INFO,"creating temporary upload file {0}", uploadFile.getFilename());
        uploadFile.setCreated(new Date());
        uploadFile.setTemporary(true);
        this.em.persist(uploadFile);
        return uploadFile;
    }

    @Transactional
    private void cleanTemporaryUploads(final Date past){
        final Query query = this.em.createNamedQuery("UploadFile.deleteOlderThan");
        query.setParameter("when",past);
        query.executeUpdate();
    }

    @Schedule(minute= "*/5", hour = "*")
    public void cleanUploads(){
        final Date minutesAgo = new Date(new Date().getTime() -5 * ONE_MINUTE_IN_MILLIS);
        log.log(Level.INFO,"cleaning uploads older than {0}",minutesAgo);
        cleanTemporaryUploads(minutesAgo);
    }

    @Transactional
    public UploadFile findTemporary(final Long uploadId) {
        final TypedQuery<UploadFile> query = this.em.createNamedQuery("UploadFile.findTemporary",UploadFile.class);
        query.setParameter("id",uploadId);
        return query.getSingleResult();
    }

    public UploadFile findTemporaryOrNull(final Long id){
        try {
            return findTemporary(id);
        } catch (final NoResultException ignored){
            return null;
        }
    }

    @Transactional
    public void markPermanent(final UploadFile uploadFile){
        uploadFile.setTemporary(false);
        this.em.persist(uploadFile);
    }
}
