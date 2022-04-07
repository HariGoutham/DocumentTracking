package com.example.learning.controllers;

import com.example.learning.entity.Document;
import com.example.learning.repository.DocumentRepository;
import com.example.learning.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DocumentController {

 @Autowired
 private DocumentService docService;

 @GetMapping("/documents/{uuid}")
 public Document getDoc(@PathVariable String uuid) {
  return docService.findByUUID(uuid);
 }
}
