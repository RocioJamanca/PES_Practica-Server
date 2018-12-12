package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subscriptor extends Model {
    public int edat;
    public String nom;

@ManyToMany
public List<Diari> diariList=new ArrayList<>();
public Subscriptor( String nom ,int edat){
    this.edat=edat;
    this.nom=nom;

}
}
