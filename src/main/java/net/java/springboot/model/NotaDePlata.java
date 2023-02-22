package net.java.springboot.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nota_de_plata" , uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class NotaDePlata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinTable(
            name = "nota_bautura"
            ,
            joinColumns = @JoinColumn(name="notaId")
            ,
            inverseJoinColumns = @JoinColumn(name="bauturaId")
    )
    private List<Bauturi> bauturiList;

    @ManyToMany
    @JoinTable(
            name = "nota_felPrincipal"
            ,
            joinColumns = @JoinColumn(name="notaId")
            ,
            inverseJoinColumns = @JoinColumn(name="felPrincipalId")
    )
    private List<FelPrincipal> felPrincipalList;

    @ManyToMany
    @JoinTable(
            name = "nota_desert"
            ,
            joinColumns = @JoinColumn(name="notaId")
            ,
            inverseJoinColumns = @JoinColumn(name="desertId")
    )
    private List<Desert> desertList;

    public NotaDePlata() {

        this.felPrincipalList = new ArrayList<>();
        this.bauturiList = new ArrayList<>();
        this.desertList = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Bauturi> getBauturiList() {
        return bauturiList;
    }

    public void setBauturiList(List<Bauturi> bauturiList) {
        this.bauturiList = bauturiList;
    }

    public List<FelPrincipal> getFelPrincipalList() {
        return felPrincipalList;
    }

    public void setFelPrincipalList(List<FelPrincipal> felPrincipalList) {
        this.felPrincipalList = felPrincipalList;
    }

    public List<Desert> getDesertList() {
        return desertList;
    }

    public void setDesertList(List<Desert> desertList) {
        this.desertList = desertList;
    }
}
