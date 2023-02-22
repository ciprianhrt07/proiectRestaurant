package net.java.springboot.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bauturi" , uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Bauturi {


    //------------------------cheia primara ---> identificator unic pentru tabela-------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    //--------field-uri specifice --> nume produs, descriere,pret si specificarea continutului de alcool--------

    @Column(name = "nume")
    private String nume;

    @Column(name = "descriere")
    private String descriere;

    @Column(name = "contine_alcool")
    private boolean contineAlcool;

    @Column(name = "pret")
    private double pret;

    @Column(name = "volum")
    private int volum;

  /*  @ManyToMany
    @JoinTable(
            name = "bautura_nota"
            ,
            joinColumns = @JoinColumn(name="bauturaId")
            ,
            inverseJoinColumns = @JoinColumn(name="notaId")
    )
    private List<NotaDePlata> notaDePlataList;*/

    //-------------------------------------------------------Constructori----------------------------------------

    public Bauturi() {
    }

    public Bauturi(String nume, String descriere, boolean contineAlcool, double pret , int volum) {
        this.nume = nume;
        this.descriere = descriere;
        this.contineAlcool = contineAlcool;
        this.pret = pret;
        this.volum = volum;
    }

    //------------------------------------------------------------------------------------------------------------


    //-----------------------------------------------------Gettere & Settere--------------------------------------

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

   /* public List<NotaDePlata> getNotaDePlataList() {
        return notaDePlataList;
    }

    public void setNotaDePlataList(List<NotaDePlata> notaDePlataList) {
        this.notaDePlataList = notaDePlataList;
    }*/

    //------------------------------------------------------------------------------------------------------------

    //----------------------------------------------------------------toString()----------------------------------
    @Override
    public String toString() {
        return "Bauturi{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", descriere='" + descriere + '\'' +
                ", contineAlcool=" + contineAlcool +
                ", pret=" + pret +
                ", volum=" + volum +
                '}';
    }

    //------------------------------------------------------------------------------------------------------------
}
