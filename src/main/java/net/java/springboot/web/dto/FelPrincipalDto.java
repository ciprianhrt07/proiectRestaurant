package net.java.springboot.web.dto;

public class FelPrincipalDto {

    private String nume;

    private String descriere;

    private double pret;

    private int cantitate;

    public FelPrincipalDto() {
    }

    public FelPrincipalDto(String nume, String descriere, double pret, int cantitate) {
        this.nume = nume;
        this.descriere = descriere;
        this.pret = pret;
        this.cantitate = cantitate;
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

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

}
