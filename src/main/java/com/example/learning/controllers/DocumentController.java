package com.example.learning.controllers;

import com.example.learning.entity.Document;
import com.example.learning.service.DocumentService;
import com.example.learning.utility.DocTrackUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.Objects;

@RestController
public class DocumentController {

 @Autowired
 private DocumentService docService;

 @GetMapping("/documents/{uuid}")
 public Document getDoc(@PathVariable String uuid) {
  return docService.findByUUID(uuid);
 }


 @PostMapping("/documents")
 ResponseEntity<Document>createDocument( @RequestBody Document document) throws URISyntaxException {
  Document doc = docService.save(document);
  return new ResponseEntity(doc, HttpStatus.CREATED);
 }

 @PatchMapping({"/documents/{uuid}"})
 public ResponseEntity<Document> patch(@PathVariable String uuid ,@Valid @RequestBody Document docRequest) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
  Document docDB = docService.findByUUID(uuid);
  DocTrackUtility.setFieldsFromRequest(docRequest, docDB);
  return ResponseEntity.ok(docService.save(docDB));
 }

 @DeleteMapping("/documents/{uuid}")
 public ResponseEntity<Document> deleteDocument(@PathVariable String uuid) {
  docService.deleteById(uuid);
  return ResponseEntity.ok().build();
 }
}
