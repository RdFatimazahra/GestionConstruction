package com.dao;

import com.model.Ressource;
import java.sql.SQLException;
import java.util.List;

public interface Iressource {
    void ajouterRessource(Ressource ressource) throws SQLException;
    List<Ressource> afficherListeRessources() throws SQLException;
    void modifierRessource(Ressource ressource) throws SQLException;
    void supprimerRessource(int idRessource) throws SQLException;

}
