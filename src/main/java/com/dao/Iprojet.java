package com.dao;

import com.model.Projet;
import java.sql.SQLException;
import java.util.List;



public interface Iprojet {

    void ajouterProjet(Projet projet) throws SQLException;
    List<Projet> afficherListeProjets() throws SQLException;
    void modifierProjet(Projet projet) throws SQLException;
    void supprimerProjet(int idProjet) throws SQLException;
}




