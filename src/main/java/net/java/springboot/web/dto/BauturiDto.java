package net.java.springboot.web.dto;

public class BauturiDto {

    private String nume;

    private String descriere;

    private boolean contineAlcool;

    private double pret;

    private int volum;

    public BauturiDto() {
    }

    public BauturiDto(String nume, String descriere, boolean contineAlcool, double pret, int volum) {
        this.nume = nume;
        this.descriere = descriere;
        this.contineAlcool = contineAlcool;
        this.pret = pret;
        this.volum = volum;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public boolean isContineAlcool() {
        return contineAlcool;
    }

    public void setContineAlcool(boolean contineAlcool) {
        this.contineAlcool = contineAlcool;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getVolum() {
        return volum;
    }

    public void setVolum(int volum) {
        this.volum = volum;
    }
}
