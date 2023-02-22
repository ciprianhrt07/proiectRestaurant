package net.java.springboot.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "desert" , uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Desert {


    //-------------------------cheia primara, identificator unic pentru tabela de deserturi---------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    //-----------------------------field-uri specifice pentru tabela de desert-uri.------------------------------
    @Column(name = "nume")
    private String nume;

    @Column(name = "descriere")
    private String descriere;

    @Column(name = "pret")
    private double pret;

    @Column(name = "cantitate")
    private int cantitate;

    /*@ManyToMany
    @JoinTable(
            name = "desert_nota"
            ,
            joinColumns = @JoinColumn(name="desertId")
            ,
            inverseJoinColumns = @JoinColumn(name="notaId")
    )
    private List<NotaDePlata> notaDePlataList;*/

    //-------------------------------------------------------Constructori----------------------------------------

    public Desert() {
    }

    public Desert(String nume, String descriere, double pret, int cantitate) {
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
        return "Desert{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", descriere='" + descriere + '\'' +
                ", pret=" + pret +
                ", cantitate=" + cantitate +
                '}';
    }

    //------------------------------------------------------------------------------------------------------------
}
