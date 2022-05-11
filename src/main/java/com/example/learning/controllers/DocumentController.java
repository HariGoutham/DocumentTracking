package com.example.learning.controllers;

import com.example.learning.entity.DocumentEntity;
import com.example.learning.service.DocumentService;
import com.example.learning.utility.DocTrackUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

@RestController
public class DocumentController {

 @Autowired
 private DocumentService docService;

 @GetMapping("/documents/{uuid}")
 public DocumentEntity getDoc(@PathVariable String uuid) {
  return docService.findByUUID(uuid);
 }


 @PostMapping("/documents")
 ResponseEntity<DocumentEntity>createDocument(@RequestBody DocumentEntity document) throws URISyntaxException {
  DocumentEntity doc = docService.save(document);
  return new ResponseEntity(doc, HttpStatus.CREATED);
 }

 @PatchMapping({"/documents/{uuid}"})
 public ResponseEntity<DocumentEntity> patch(@PathVariable String uuid , @Valid @RequestBody DocumentEntity docRequest) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
  DocumentEntity docDB = docService.findByUUID(uuid);
  DocTrackUtility.setFields(docRequest, docDB);
  return ResponseEntity.ok(docService.save(docDB));
 }

 @DeleteMapping("/documents/{uuid}")
 public ResponseEntity<DocumentEntity> deleteDocument(@PathVariable String uuid) {
  docService.deleteById(uuid);
  return ResponseEntity.ok().build();
 }

 @PostMapping("/bulk/documents")
 ResponseEntity<DocumentEntity> createBulkDocument(@RequestBody DocumentEntity document) throws URISyntaxException {
  DocumentEntity doc = docService.save(document);
  return new ResponseEntity(doc, HttpStatus.CREATED);
 }
}
