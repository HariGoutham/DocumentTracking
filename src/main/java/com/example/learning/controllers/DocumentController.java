package com.example.learning.controllers;

import com.example.learning.entity.Document;
import com.example.learning.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
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
 public ResponseEntity<Document> patch(@PathVariable String uuid ,@Valid @RequestBody Document docDetails) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
  Document doc = docService.findByUUID(uuid);
  Field[] fields = Document.class.getDeclaredFields();
  for(Field f : fields){
   String fName = f.getName();
   if(Objects.nonNull(callGetter(fName, docDetails))) {
    callSetter(doc, fName, callGetter(fName, docDetails));
   }
  }
  Document updateddoc = docService.save(doc);
  return ResponseEntity.ok(updateddoc);
 }

 private static Object callGetter(String fieldName, Object obj) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
  PropertyDescriptor pd = new PropertyDescriptor(fieldName, obj.getClass());
  return pd.getReadMethod().invoke(obj);
 }

 private static void callSetter(Object obj, String fieldName, Object value) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
  PropertyDescriptor pd = new PropertyDescriptor(fieldName, obj.getClass());
  pd.getWriteMethod().invoke(obj, value);
 }

 @DeleteMapping("/documents/{uuid}")
 public ResponseEntity<Document> deleteDocument(@PathVariable String uuid) {
  docService.deleteById(uuid);
  return ResponseEntity.ok().build();
 }
}
