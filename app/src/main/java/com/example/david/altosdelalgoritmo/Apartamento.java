package com.example.david.altosdelalgoritmo;

/**
 * Created by david on 31/05/2017.
 */

public class Apartamento {
    private String foto,nomenclatura,piso,metros,precio,balcon,sombra;

    public Apartamento(String foto, String nomenclatura, String piso, String metros, String precio, String balcon, String sombra) {
        this.foto = foto;
        this.nomenclatura = nomenclatura;
        this.piso = piso;
        this.metros = metros;
        this.precio = precio;
        this.balcon = balcon;
        this.sombra = sombra;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getMetros() {
        return metros;
    }

    public void setMetros(String metros) {
        this.metros = metros;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getBalcon() {
        return balcon;
    }

    public void setBalcon(String balcon) {
        this.balcon = balcon;
    }

    public String getSombra() {
        return sombra;
    }

    public void setSombra(String sombra) {
        this.sombra = sombra;
    }
}
