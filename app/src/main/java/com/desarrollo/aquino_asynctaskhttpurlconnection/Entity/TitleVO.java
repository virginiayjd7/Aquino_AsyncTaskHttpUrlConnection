package com.desarrollo.aquino_asynctaskhttpurlconnection.Entity;

import java.io.Serializable;

public class TitleVO implements Serializable {
     String title;
     String descripcion;
     String descripciondet;
     int image;

    public TitleVO(String title, String descripcion, String descripciondet, int image) {
        this.title = title;
        this.descripcion = descripcion;
        this.descripciondet = descripciondet;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripciondet() {
        return descripciondet;
    }

    public void setDescripciondet(String descripciondet) {
        this.descripciondet = descripciondet;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
