package com.bibliotheque.app.repository;

import com.bibliotheque.app.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    @Query(value = "SELECT * FROM utilisateurs WHERE email = :email AND mot_de_passe = :password", nativeQuery = true)
    Utilisateur loging(@Param("email") String email, @Param("password") String password);

}
