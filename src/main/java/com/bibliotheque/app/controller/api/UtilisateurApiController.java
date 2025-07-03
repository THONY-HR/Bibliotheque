package com.bibliotheque.app.controller.api;

import com.bibliotheque.app.entity.Utilisateur;
import com.bibliotheque.app.payload.ApiResponse;
import com.bibliotheque.app.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurApiController {

    @Autowired
    private UtilisateurService utilisateurService;

    // GET ALL
    @GetMapping
    public ResponseEntity<ApiResponse<List<Utilisateur>>> getAllUtilisateurs() {
        ApiResponse<List<Utilisateur>> response = utilisateurService.getAllUtilisateurs();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Utilisateur>> getUtilisateurById(@PathVariable Integer id) {
        ApiResponse<Utilisateur> response = utilisateurService.getUtilisateurById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // LOGIN
    @PostMapping("/login/{email}/{password}")
    public ResponseEntity<ApiResponse<Utilisateur>> loging(@PathVariable String email, @PathVariable String password) {
        ApiResponse<Utilisateur> response = utilisateurService.loging(email, password);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // CREATE
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Utilisateur>> createUtilisateur(@RequestBody Utilisateur utilisateur) {
        ApiResponse<Utilisateur> response = utilisateurService.saveUtilisateur(utilisateur);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Utilisateur>> updateUtilisateur(@PathVariable Integer id, @RequestBody Utilisateur utilisateurDetails) {
        ApiResponse<Utilisateur> response = utilisateurService.updateUtilisateur(id, utilisateurDetails);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUtilisateur(@PathVariable Integer id) {
        ApiResponse<Void> response = utilisateurService.deleteUtilisateur(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
