package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import play.test.Fixtures;

public class Application extends Controller {

    public static void index() {
        renderText("welcome");
    }


    public void InicializarBD() {
        Fixtures.deleteDatabase();

        //renderText Base de dades actualizada
        Diari d1 = new Diari("Pais", "Català").save();
        Diari d2 = new Diari("Pais", "Castella").save();
        Diari d3 = new Diari("Times", "Anglès").save();

        Subscriptor s1 = new Subscriptor("Pedro", 15).save();
        Subscriptor s2 = new Subscriptor("Toni", 49).save();
        Subscriptor s3 = new Subscriptor("Paula", 14).save();
        Subscriptor s4 = new Subscriptor("Carmena", 45).save();


        d1.subscriptorList.add(s1);
        d1.subscriptorList.add(s2);
        d1.subscriptorList.add(s3);
        d1.save();
        s1.diariList.add(d1);
        s2.diariList.add(d1);
        s3.diariList.add(d1);

        d3.subscriptorList.add(s4);
        d3.save();
        s4.diariList.add(d3);

        d2.subscriptorList.add(s2);
        d2.save();
        s2.diariList.add(d2);

        s1.save();
        s2.save();
        s3.save();
        s4.save();

        renderText("Base de datos actualizada");
    }

    public void SubscripcionsPerSubscriptor() {
        List<Subscriptor> subscriptorList = Subscriptor.findAll();
        List<Diari> diariList = Diari.findAll();

        float subcripcions = 0;

      /*  for (int i=0; i<subscriptorList.size();i++){
            subcripcions+=subscriptorList.get(i).diariList.size();
        }*/

        for (int i = 0; i < diariList.size(); i++) {
            subcripcions += diariList.get(i).subscriptorList.size();
        }
        float subs = subscriptorList.size();
        float result = subcripcions / subs;
        String res = Float.toString(result);
        if (subscriptorList.size() == 0 || diariList.size() == 0) {
            //renderText("-2");
        } else if (subcripcions == 0) {
            //renderText("-1");
        }

        renderText("algo");

    }
}