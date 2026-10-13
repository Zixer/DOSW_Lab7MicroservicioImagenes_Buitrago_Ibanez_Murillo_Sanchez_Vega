package edu.eci.dosw.imageservice.service;

import edu.eci.dosw.imageservice.model.document.ImagenDocument;
import edu.eci.dosw.imageservice.repository.ImagenRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service 
public class ImagenService {
    
    private final ImagenRepository imagenRepository;

    public ImagenService(ImagenRepository imagenRepository){
        this.imagenRepository = imagenRepository;
    }

    public ImagenDocument guardar(MultipartFile archivo, String referenciaExterna){
        if(archivo == null || archivo.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El archivo es obligatorio");
        }

        String tipo = archivo.getContentType();
        if(tipo == null || !tipo.startsWith("image/")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El archivo debe ser una imagen");
        }

        try{
            ImagenDocument imagen = new ImagenDocument(archivo.getOriginalFilename(),
                    tipo,
                    archivo.getSize(),
                    archivo.getBytes(),
                    LocalDateTime.now(),
                    referenciaExterna
                );
            return imagenRepository.save(imagen);
        }catch(IOException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo leer el archivo", e);
        }
    }

    public List<ImagenDocument> listar() {
        return imagenRepository.findAll();
    }

    public ImagenDocument buscarPorId(String id) {
        return imagenRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Imagen no encontrada: " + id));
    }

    public List<ImagenDocument> listarPorReferencia(String referenciaExterna){
        return imagenRepository.findByReferenciaExterna(referenciaExterna);
    }

    public void eliminar(String id){
        ImagenDocument imagen = buscarPorId(id);
        imagenRepository.delete(imagen);
    }
}
