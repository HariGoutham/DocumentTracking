package com.example.learning.service;


import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMain {

    public static void main(String[] args) {
        String uuid = "9b548608-f5f0-4be8-af16-a61e396ad4be";
        String studyUuid = "927a55a6-c46c-48db-bbae-6274391697f7";
        String studyEnvironmentUuid = "961cb6ba-c5e9-46fe-bcb3-8380d1bdcbed";
        String studyEnvironmentCountryUuid = "f7c650c5-dcf9-4337-bac2-0b14efe7b1c8";
        String studyEnvironment_siteUuid = "f9d82c31-8bc1-4e38-b097-7ec72ed8f6ce";
        String name = "document_name";
        String cdDocumentTypeUuid = "";
        String businessId = "DOC1";
        String version = "v1";
        String versionDate = "1990-12-13";
        String internalStatusOid = "created";
        String internalStatusChangeDate = "1990-12-13";
        String signatureDate = "1990-12-13";
        String expirationDate = "1990-12-13";
        String superseded = "false";
        String inactive = "false";
        String deleted = "false";
        String createdBy = "com:mdsol:users:ae1554cb-bfb5-40a7-8e10-bc58019cde62";
        String createdAt = "2022-05-19T12:02:58.049334";
        String whenAudited = "2022-05-19T12:02:58.373Z";

        String whichChanged = "{\"changes\":[{\"field\":\"uuid\",\"old\":null," +
                "\"new\":\""+uuid+"\"},{\"field\":\"study_uuid\",\"old\":null," +
                "\"new\":\""+studyUuid+"\"},{\"field\":\"study_environment_uuid\",\"old\":null," +
                "\"new\":\""+studyEnvironmentUuid+"\"},{\"field\":\"study_environment_country_uuid\",\"old\":null," +
                "\"new\":\""+studyEnvironmentCountryUuid+"\"},{\"field\":\"study_environment_site_uuid\",\"old\":null," +
                "\"new\":\""+studyEnvironment_siteUuid+"\"},{\"field\":\"name\",\"old\":null,\"new\":\""+name+"\"}," +
                "{\"field\":\"cd_document_type_uuid\",\"old\":null,\"new\":\""+cdDocumentTypeUuid+"\"},{\"field\":\"" +
                "business_id\",\"old\":null,\"new\":\""+businessId+"\"},{\"field\":\"version\",\"old\":null,\"new\":\""+version+"\"}," +
                "{\"field\":\"version_date\"" +
                ",\"old\":null,\"new\":\""+versionDate+"\"},{\"field\":\"internal_status_oid\",\"old\":null,\"new\":\""+internalStatusOid+"\"}," +
                "{\"field\":\"internal_status_change_date\",\"old\":null,\"new\":\""+internalStatusChangeDate+"\"},{\"field\":\"signature_date\"," +
                "\"old\":null,\"new\":\""+signatureDate+"\"},{\"field\":\"expiration_date\",\"old\":null,\"new\":\""+expirationDate+"\"}," +
                "{\"field\":\"superseded\",\"old\":null,\"new\":\""+superseded+"\"},{\"field\":\"inactive\",\"old\":null,\"new\":\""+inactive+"\"}," +
                "{\"field\":\"deleted\",\"old\":null,\"new\":\""+deleted+"\"},{\"field\":\"created_by\",\"old\":null," +
                "\"new\":\""+createdBy+"\"},{\"field\":\"created_at\"," +
                "\"old\":null,\"new\":\""+createdAt+"\"}]}";

        //System.out.println(whichChanged);

        ArrayList<String> s = Stream.of(1, 3, 2, 4)
                .map(Object::toString).collect(Collectors.toCollection(ArrayList::new));

       // System.out.println(s);
    }


}
