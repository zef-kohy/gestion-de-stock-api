package com.dago.gestion_de_stock.models;

import com.dago.gestion_de_stock.enumerations.EtatCommande;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "commande_client")
public class CommandeClient extends AbstractEntity{

    private String codeCommande;

    private LocalDate dateCommande;

    private EtatCommande etatCommande;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
