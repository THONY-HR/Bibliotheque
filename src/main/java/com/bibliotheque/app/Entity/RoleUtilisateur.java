package com.bibliotheque.app.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "role_utilisateurs")
public class RoleUtilisateur {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "roles", length = 50)
    private String roles;

    @ColumnDefault("10")
    @Column(name = "quota")
    private Integer quota;

    @ColumnDefault("0")
    @Column(name = "prolongement")
    private Integer prolongement;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public Integer getProlongement() {
        return prolongement;
    }

    public void setProlongement(Integer prolongement) {
        this.prolongement = prolongement;
    }

}