package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Diari extends Model {
    public String nom;
    public String idioma;

    public Diari(String nom,String idioma){
        this.idioma=idioma;
        this.nom=nom;
    }

    @ManyToMany
    public List<Subscriptor> subscriptorList= new ArrayList<Subscriptor>();
}
