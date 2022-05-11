package com.example.learning.service;

import com.example.learning.domain.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestMain {

    public static void main(String[] args) {
        Document doc = new Document();
        doc.setName("N3");
        doc.setBusinessId("B2");
        doc.setContextUri("C3");


        Document doc1 = new Document();
        doc1.setName("N1");
        doc1.setBusinessId("B1");
        doc1.setContextUri("C4");

        Document doc2 = new Document();
        doc2.setName("N2");
        doc2.setBusinessId("B2");
        doc2.setContextUri("C2");

        Document doc3= new Document();
        doc3.setName("N2");
        doc3.setBusinessId("B3");
        doc3.setContextUri("C1");

        Document doc4 = new Document();
        doc4.setName("N3");
        doc4.setBusinessId("B1");
        doc3.setContextUri("C5");


        List<Document> docList = new ArrayList<>();
        docList.add(doc);
        docList.add(doc1);
        docList.add(doc2);
        docList.add(doc3);
        docList.add(doc4);

        for(Document doce : docList){
            System.out.println(doce.getName());
            System.out.println(doce.getBusinessId());
            System.out.println(doce.getContextUri());
            System.out.println("******************");
        }


       // System.out.println(docList.stream().map(a -> a.getName()).distinct().collect(Collectors.toList()));


        Comparator<Document> compare  = Comparator.comparing(Document :: getName).
                thenComparing(Document :: getBusinessId)
                .thenComparing(Document :: getContextUri);

        Collections.sort(docList, compare);

        System.out.println("-----------------------------------------------------------------");

        for(Document doce : docList){
            System.out.println(doce.getName());
            System.out.println(doce.getBusinessId());
            System.out.println(doce.getContextUri());
            System.out.println("******************");
        }
    }

}
