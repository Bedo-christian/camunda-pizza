package com.camunda.camundaclient.delegates;

import com.camunda.camundaclient.api.CommandeApiDelegate;
import com.camunda.camundaclient.model.CommandeDto;
import com.camunda.camundaclient.model.CommandeResponse;
import com.camunda.camundaclient.service.CommandeServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeDelegates implements CommandeApiDelegate {

    private final CommandeServ commandeServ;

    public CommandeDelegates(CommandeServ commandeServ) {
        this.commandeServ = commandeServ;
    }

    /**
     * POST /commande : Creer commande
     *
     * @param commandeDto (optional)
     * @return Ajout success (status code 201)
     * or Erreur interne du serveur (status code 500)
     * @see CommandeApi#createCommande
     */
    @Override
    public ResponseEntity<CommandeDto> createCommande(CommandeDto commandeDto) {
        CommandeDto dto = commandeServ.saveCommande(commandeDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    /**
     * GET /commande : Liste des toutes les Commandes
     *
     * @return OK (status code 200)
     * or Erreur interne du serveur (status code 500)
     * @see CommandeApi#getAllOrder
     */
    @Override
    public ResponseEntity<List<CommandeResponse>> getAllOrder() {
        List<CommandeResponse> allCommande = commandeServ.getAllCommande();
        return new ResponseEntity<>(allCommande,HttpStatus.OK);
    }

    /**
     * GET /commande/{status_command} : Obtenir une commande by status approuvé ou à traiter
     *
     * @param statusCommand ID du commande à recuperer (required)
     * @return OK (status code 200)
     * or Erreur interne du serveur (status code 500)
     * @see CommandeApi#getCommandesByStatus
     */
    @Override
    public ResponseEntity<List<CommandeResponse>> getCommandesByStatus(String statusCommand) {
        List<CommandeResponse> orderByStatus = commandeServ.getOrderByStatus(statusCommand);
        return new ResponseEntity<>(orderByStatus,HttpStatus.OK);
    }

    /**
     * GET /commande/{commande_id} : Details d&#39;une commande
     *
     * @param commandeId ID du commande à recuperer (required)
     * @return Succès - details d&#39;un commande récupérée (status code 200)
     * or Ressource non trouvée (status code 404)
     * or Erreur interne du serveur (status code 500)
     * @see CommandeApi#getDetailsCommandById
     */
    @Override
    public ResponseEntity<CommandeResponse> getDetailsCommandById(Integer commandeId) {
        CommandeResponse commandeResponse = commandeServ.getOrderById(commandeId);
        return new ResponseEntity<>(commandeResponse,HttpStatus.OK);
    }

    /**
     * PUT /commande/{commande_id} : Modification d&#39;une commande par le client
     *
     * @param commandeId  (required)
     * @param commandeDto (optional)
     * @return Modification à jour avec succès (status code 200)
     * or data non trouvé (status code 404)
     * or Erreur interne du serveur (status code 500)
     * @see CommandeApi#updateCommande
     */
    @Override
    public ResponseEntity<Void> updateCommande(Integer commandeId, CommandeDto commandeDto) {
        return CommandeApiDelegate.super.updateCommande(commandeId, commandeDto);
    }
}
