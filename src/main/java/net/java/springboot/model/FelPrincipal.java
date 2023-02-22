package net.java.springboot.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "fel_principal" , uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class FelPrincipal {


    //-------------------------------cheia primara ----> identificator unic pentru tabela------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //--------------------------------field-uri specifice -----> nume, descriere, pret---------------------------

    @Column(name = "nume")
    private String nume;

    @Column(name = "descriere")
    private String descriere;

    @Column(name = "pret")
    private double pret;

    @Column(name = "cantitate")
    private int cantitate;

   /* @ManyToMany
    @JoinTable(
            name = "felPrincipal_nota"
            ,
            joinColumns = @JoinColumn(name="felPrincipalId")
            ,
            inverseJoinColumns = @JoinColumn(name="notaId")
    )
    private List<NotaDePlata> notaDePlataList;*/

    //-------------------------------------------------------Constructori----------------------------------------

    public FelPrincipal() {
    }

    public FelPrincipal(String nume, String descriere, double pret, int cantitate) {
        this.nume = nume;
        this.descriere = descriere;
        this.pret = pret;
        this.cantitate = cantitate;
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

    //------------------------------------------------------------------------------------------------------------

    //----------------------------------------------------------------toString()----------------------------------

    @Override
    public String toString() {
        return "FelPrincipal{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", descriere='" + descriere + '\'' +
                ", pret=" + pret +
                ", cantitate=" + cantitate +
                '}';
    }
    //------------------------------------------------------------------------------------------------------------


}
