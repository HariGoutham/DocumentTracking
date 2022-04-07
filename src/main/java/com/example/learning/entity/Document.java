package com.example.learning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Document {

    @Id
    @Column(name = "study_environment_uuid")
    private String studyEnvironmentUuid;

    @Column(name = "context_uri")
    private String contextUri;

    @Column(name = "oid")
    private String oid;

    @Column(name = "study")
    private String study;

    @Column(name = "study_name")
    private String studyName;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "document_version")
    private String documentVersion;

    @Column(name = "version_date")
    private Date versionDate;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "superseded")
    private Boolean superseded;

    @Column(name = "business_id")
    private String businessId;

    @Column(name = "name")
    private String name;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "modified_at")
    private Date modifiedAt;

    @Column(name = "created_by_uri")
    private String createdByUri;

    @Column(name = "inactive")
    private Boolean inactive;

    public String getStudyName() {
        return studyName;
    }

    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentVersion() {
        return documentVersion;
    }

    public void setDocumentVersion(String documentVersion) {
        this.documentVersion = documentVersion;
    }

    public Date getVersionDate() {
        return versionDate;
    }

    public void setVersionDate(Date versionDate) {
        this.versionDate = versionDate;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Boolean getSuperseded() {
        return superseded;
    }

    public void setSuperseded(Boolean superseded) {
        this.superseded = superseded;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getCreatedByUri() {
        return createdByUri;
    }

    public void setCreatedByUri(String createdByUri) {
        this.createdByUri = createdByUri;
    }

    public Boolean getInactive() {
        return inactive;
    }

    public void setInactive(Boolean inactive) {
        this.inactive = inactive;
    }

    public String getStudyEnvironmentUuid() {
        return studyEnvironmentUuid;
    }

    public void setStudyEnvironmentUuid(String studyEnvironmentUuid) {
        this.studyEnvironmentUuid = studyEnvironmentUuid;
    }

    public String getContextUri() {
        return contextUri;
    }

    public void setContextUri(String contextUri) {
        this.contextUri = contextUri;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }
}
