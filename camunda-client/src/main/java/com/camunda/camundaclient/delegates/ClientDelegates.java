package com.camunda.camundaclient.delegates;

import com.camunda.camundaclient.api.ClientsApiDelegate;
import com.camunda.camundaclient.model.ClientDto;
import com.camunda.camundaclient.model.ClientResponse;
import com.camunda.camundaclient.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class ClientDelegates implements ClientsApiDelegate {

    private  final ClientService clientService;

    public ClientDelegates(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * DELETE /clients/{client_id} : Supprimer un client par ID
     * Supprime un exemple en utilisant son ID comme paramètre
     *
     * @param clientId ID du client à supprimer (required)
     * @return Aucun contenu (status code 204)
     * or client non trouvé (status code 404)
     * @see ClientsApi#deleteClientById
     */
    @Override
    public ResponseEntity<Void> deleteClientById(Integer clientId) {
        clientService.deleteClientById(clientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * GET /clients/{client_id} : Obtenir un client par ID
     * Récupère un client spécifique en fonction de son ID.
     *
     * @param clientId ID du client à récupérer (required)
     * @return Succès - Ressource récupérée (status code 200)
     * or Ressource non trouvée (status code 404)
     * or Erreur interne du serveur (status code 500)
     * @see ClientsApi#getClientById
     */
    @Override
    public ResponseEntity<ClientResponse> getClientById(Integer clientId) {
        ClientResponse clientById = clientService.getClientById(clientId);
        return new ResponseEntity<>(clientById,HttpStatus.OK);
    }

    /**
     * POST /clients : Enregistrement pour le formulaire du clients
     *
     * @param clientDto (optional)
     * @return Ajouté avec success (status code 201)
     * or BAD REQUEST - erreur liés aux l&#39;input (status code 400)
     * or Erreur interne du serveur (status code 500)
     * @see ClientsApi#saveClient
     */
    @Override
    public ResponseEntity<ClientDto> saveClient(ClientDto clientDto) {
        ClientDto saveClient = clientService.saveClient(clientDto);
        return new ResponseEntity<>(saveClient,HttpStatus.CREATED);
    }

    /**
     * PUT /clients/{client_id} : Mettre à jour la table client
     *
     * @param clientId  ID du client à mettre à jour&#39; (required)
     * @param clientDto (optional)
     * @return Client mis à jour avec succès (status code 200)
     * or Client non trouvé (status code 404)
     * or Erreur interne du serveur (status code 500)
     * @see ClientsApi#updateClientById
     */
    @Override
    public ResponseEntity<ClientDto> updateClientById(Integer clientId, ClientDto clientDto) {
        ClientDto client = clientService.updateClient(clientId, clientDto);
        return new ResponseEntity<>(client,HttpStatus.OK);
    }
}
