package edu.eci.dosw.imageservice.model.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "imagenes")
public class ImagenDocument {

    @Id
    private String id;

    private String nombre;
    private String tipoContenido;
    private Long tamano;
    private byte[] datos;
    private LocalDateTime fechaCarga;
    private String referenciaExterna;

    public ImagenDocument() {
    }

    public ImagenDocument(String nombre, String tipoContenido, Long tamano,
                          byte[] datos, LocalDateTime fechaCarga, String referenciaExterna) {
        this.nombre = nombre;
        this.tipoContenido = tipoContenido;
        this.tamano = tamano;
        this.datos = datos;
        this.fechaCarga = fechaCarga;
        this.referenciaExterna = referenciaExterna;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoContenido() {
        return tipoContenido;
    }

    public Long getTamano() {
        return tamano;
    }

    public byte[] getDatos() {
        return datos;
    }

    public LocalDateTime getFechaCarga() {
        return fechaCarga;
    }

    public String getReferenciaExterna() {
        return referenciaExterna;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipoContenido(String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    public void setTamano(Long tamano) {
        this.tamano = tamano;
    }

    public void setDatos(byte[] datos) {
        this.datos = datos;
    }

    public void setFechaCarga(LocalDateTime fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public void setReferenciaExterna(String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }
} 
