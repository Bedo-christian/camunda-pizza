package com.camunda.camundaclient.delegates;

import com.camunda.camundaclient.api.PizzaApiDelegate;
import com.camunda.camundaclient.model.PizzaDto;
import com.camunda.camundaclient.model.PizzaResponse;
import com.camunda.camundaclient.service.PizzaServ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaDelegates implements PizzaApiDelegate {

    private PizzaServ pizzaServ;

    public PizzaDelegates(PizzaServ pizzaServ) {
        this.pizzaServ = pizzaServ;
    }

    /**
     * GET /pizza : Liste des toutes les Pizzas disponibles
     *
     * @return OK (status code 200)
     * or Erreur interne du serveur (status code 500)
     * @see PizzaApi#getAllPizza
     */
    @Override
    public ResponseEntity<List<PizzaResponse>> getAllPizza() {
        List<PizzaResponse> allListPizza = pizzaServ.getAllListPizza();
        return new ResponseEntity<>(allListPizza, HttpStatus.OK);
    }

    /**
     * GET /pizza/{pizza_id} : Obtenir une pizza par ID
     *
     * @param pizzaId ID du pizza à récupérer (required)
     * @return Succès - Ressource récupérée (status code 200)
     * or Ressource non trouvée (status code 404)
     * or Erreur interne du serveur (status code 500)
     * @see PizzaApi#getPizzaById
     */
    @Override
    public ResponseEntity<PizzaResponse> getPizzaById(Integer pizzaId) {
        return PizzaApiDelegate.super.getPizzaById(pizzaId);
    }

    /**
     * POST /pizza : Save Pizza by Admin
     *
     * @param pizzaDto (optional)
     * @return Ajout success (status code 201)
     * or Erreur interne du serveur (status code 500)
     * @see PizzaApi#savePizza
     */
    @Override
    public ResponseEntity<PizzaDto> savePizza(PizzaDto pizzaDto) {
        PizzaDto pizza = pizzaServ.createPizza(pizzaDto);
        return new ResponseEntity<>(pizza,HttpStatus.CREATED);
    }

    /**
     * PUT /pizza/{pizza_id} : Mettre à jour la table Pizza
     *
     * @param pizzaId  (required)
     * @param pizzaDto (optional)
     * @return Data mis à jour avec succès (status code 200)
     * or data non trouvé (status code 404)
     * or Erreur interne du serveur (status code 500)
     * @see PizzaApi#updatePizza
     */
    @Override
    public ResponseEntity<Void> updatePizza(Integer pizzaId, PizzaDto pizzaDto) {
        return PizzaApiDelegate.super.updatePizza(pizzaId, pizzaDto);
    }
}
