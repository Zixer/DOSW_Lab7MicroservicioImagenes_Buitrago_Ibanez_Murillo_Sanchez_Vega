package edu.eci.dosw.imageservice.repository;

import edu.eci.dosw.imageservice.model.document.ImagenDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ImagenRepository extends MongoRepository<ImagenDocument, String> {

    List<ImagenDocument> findByReferenciaExterna(String referenciaExterna);
} 