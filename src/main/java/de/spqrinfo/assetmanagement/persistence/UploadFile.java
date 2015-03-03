package de.spqrinfo.assetmanagement.persistence;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Felix on 03.03.2015.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "UploadFile.deleteOlderThan",
            query= "delete FROM UploadFile c where c.temporary = true and c.created <= :when"),
        @NamedQuery(name="UploadFile.findTemporary",
            query = "select uf from UploadFile uf where uf.temporary = true and uf.uploadId =:id")
})
public class UploadFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uploadId;

    @NotNull
    private String filename;

    @NotNull
    private String contentType;

    @NotNull
    private long size;

    @NotNull
    @Column(length = 1024 * 1024 *10)
    private byte[] data;

    @NotNull
    private Date created;

    private boolean temporary = true;

    public Long getUploadId() {
        return uploadId;
    }

    public void setUploadId(Long uploadId) {
        this.uploadId = uploadId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isTemporary() {
        return temporary;
    }

    public void setTemporary(boolean temporary) {
        this.temporary = temporary;
    }
}
