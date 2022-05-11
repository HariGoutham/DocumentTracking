package com.example.learning.domain;

import java.util.Date;

public class DocumentSuccessResponse {

    private String documentUuid;
    private String businessId;
    private String study;
    private String uuid;
    private String studyName;
    private String studyEnvironment;
    private String studyEnvironmentUuid;
    private String oid;
    //SE custom name. Available only for custom study environments. i.e, SEs with oid =other
    private String name;
    private String studyEnvironmentCountry;
    private String studyEnvironmentSite;
    private String documentType;
    private String documentName;
    private String DocumentVersion;
    private Date VersionDate;
    private String externalId;
    private Date createdAt;
    private Date modifiedAt;
    private String createdByUri;
    private Boolean superseded;
    private Boolean inactive;

    public String getDocumentUuid() {
        return documentUuid;
    }

    public void setDocumentUuid(String documentUuid) {
        this.documentUuid = documentUuid;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStudyName() {
        return studyName;
    }

    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

    public String getStudyEnvironment() {
        return studyEnvironment;
    }

    public void setStudyEnvironment(String studyEnvironment) {
        this.studyEnvironment = studyEnvironment;
    }

    public String getStudyEnvironmentUuid() {
        return studyEnvironmentUuid;
    }

    public void setStudyEnvironmentUuid(String studyEnvironmentUuid) {
        this.studyEnvironmentUuid = studyEnvironmentUuid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudyEnvironmentCountry() {
        return studyEnvironmentCountry;
    }

    public void setStudyEnvironmentCountry(String studyEnvironmentCountry) {
        this.studyEnvironmentCountry = studyEnvironmentCountry;
    }

    public String getStudyEnvironmentSite() {
        return studyEnvironmentSite;
    }

    public void setStudyEnvironmentSite(String studyEnvironmentSite) {
        this.studyEnvironmentSite = studyEnvironmentSite;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentVersion() {
        return DocumentVersion;
    }

    public void setDocumentVersion(String documentVersion) {
        DocumentVersion = documentVersion;
    }

    public Date getVersionDate() {
        return VersionDate;
    }

    public void setVersionDate(Date versionDate) {
        VersionDate = versionDate;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
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

    public Boolean getSuperseded() {
        return superseded;
    }

    public void setSuperseded(Boolean superseded) {
        this.superseded = superseded;
    }

    public Boolean getInactive() {
        return inactive;
    }

    public void setInactive(Boolean inactive) {
        this.inactive = inactive;
    }
}