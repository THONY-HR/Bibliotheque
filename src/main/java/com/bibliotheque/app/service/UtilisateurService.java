package com.bibliotheque.app.service;

import com.bibliotheque.app.entity.Utilisateur;
import com.bibliotheque.app.payload.ApiResponse;
import com.bibliotheque.app.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    // GET ALL
    public ApiResponse<List<Utilisateur>> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        if (utilisateurs.isEmpty()) {
            return new ApiResponse<>(204, "Aucun utilisateur trouvé", null);
        }
        return new ApiResponse<>(200, "Utilisateurs récupérés avec succès", utilisateurs);
    }

    // GET BY ID
    public ApiResponse<Utilisateur> getUtilisateurById(Integer id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if (utilisateur.isPresent()) {
            return new ApiResponse<>(200, "Utilisateur trouvé", utilisateur.get());
        } else {
            return new ApiResponse<>(404, "Utilisateur non trouvé", null);
        }
    }

    // CREATE
    public ApiResponse<Utilisateur> saveUtilisateur(Utilisateur utilisateur) {
        Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
        return new ApiResponse<>(201, "Utilisateur créé avec succès", savedUtilisateur);
    }

    // UPDATE
    public ApiResponse<Utilisateur> updateUtilisateur(Integer id, Utilisateur utilisateurDetails) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if (utilisateur.isPresent()) {
            Utilisateur existingUtilisateur = utilisateur.get();
            existingUtilisateur.setNom(utilisateurDetails.getNom());
            existingUtilisateur.setEmail(utilisateurDetails.getEmail());
            existingUtilisateur.setMotDePasse(utilisateurDetails.getMotDePasse());
            existingUtilisateur.setRole(utilisateurDetails.getRole());

            Utilisateur updatedUtilisateur = utilisateurRepository.save(existingUtilisateur);
            return new ApiResponse<>(200, "Utilisateur mis à jour avec succès", updatedUtilisateur);
        } else {
            return new ApiResponse<>(404, "Utilisateur non trouvé", null);
        }
    }

    // DELETE
    public ApiResponse<Void> deleteUtilisateur(Integer id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if (utilisateur.isPresent()) {
            utilisateurRepository.deleteById(id);
            return new ApiResponse<>(200, "Utilisateur supprimé avec succès", null);
        } else {
            return new ApiResponse<>(404, "Utilisateur non trouvé", null);
        }
    }

    // LOGIN
    public ApiResponse<Utilisateur> loging(String email, String password) {
        Utilisateur utilisateur = utilisateurRepository.loging(email, password);
        if (utilisateur != null) {
            return new ApiResponse<>(200, "Connexion réussie", utilisateur);
        } else {
            return new ApiResponse<>(401, "Email ou mot de passe incorrect", null);
        }
    }
}
