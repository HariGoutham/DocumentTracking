package com.example.learning.controllers;

import com.example.learning.entity.Document;
import com.example.learning.repository.DocumentRepository;
import com.example.learning.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DocumentController {

 @Autowired
 private DocumentService docService;

 @GetMapping("/documents/{uuid}")
 public Document getDoc(@PathVariable String uuid) {
  return docService.findByUUID(uuid);
 }

 @PatchMapping({"/documents/{uuid}"})
 public ResponseEntity<Document> patch(@PathVariable String uuid , @RequestBody Document docdetails){

  Document doc = docService.findByUUID(uuid);
  if (docdetails.getDocumentType()!=null ) {

   doc.setDocumentType(docdetails.getDocumentType());
  }
  final Document updateddoc = docService.save(doc);
  return ResponseEntity.ok(updateddoc);
 }
}
