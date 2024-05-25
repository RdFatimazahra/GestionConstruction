package com.dao;

import com.model.Projet;
import com.model.Tache;
import java.sql.SQLException;
import java.util.List;

public interface Itache {
    void ajouterTache(Tache tache) throws SQLException;
    List<Tache> afficherListeTaches() throws SQLException;
    void modifierTache(Tache tache) throws SQLException;
    void supprimerTache(int idTache) throws SQLException;
    public Tache searchById(int id) throws SQLException;

}
