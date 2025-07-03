package com.bibliotheque.app.controller;

import com.bibliotheque.app.entity.Utilisateur;
import com.bibliotheque.app.payload.ApiResponse;
import com.bibliotheque.app.service.UtilisateurService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.SimpleAttributeSet;
import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("message", "ADMINISTRATEUR");
        return "index"; // Correspond à /WEB-INF/jsp/index.jsp
    }

    // LOGIN
    @PostMapping("/login")
    public String loging(HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        ApiResponse<Utilisateur> response = utilisateurService.loging(email, password);
        model.addAttribute("data", response.getData());

        return response.getData().getNom(); // la page JSP d'accueil
    }


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
