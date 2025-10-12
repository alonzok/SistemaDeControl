package com.example.SistemaDeControl.EventManager;

import com.example.SistemaDeControl.Listener.EventListener;
import com.example.SistemaDeControl.Models.SubscriberModel;
import com.example.SistemaDeControl.Services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase que gestiona eventos y notificaciones a suscriptores.
 * Permite suscribirse, desuscribirse y notificar a los suscriptores sobre eventos específicos.
 */
@RestController
public class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap<>();

    @Autowired
    private SubscriberService subscriberService;

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }


    /**
     * Registra un nuevo suscriptor para recibir notificaciones de eventos.
     * @param subscriberModel El modelo del suscriptor que contiene los detalles de la suscripción.
     * @return El modelo del suscriptor registrado.
     */
    @PostMapping(path = "/subscribe")
    public ResponseEntity<SubscriberModel> subscribe(@RequestBody SubscriberModel subscriberModel){

        return new ResponseEntity<SubscriberModel> (subscriberService.subscribe(subscriberModel), HttpStatus.ACCEPTED);
    }

    /**
     * Elimina un suscriptor de la lista de notificaciones.
     * @param subscriberModel El modelo del suscriptor que se desea eliminar.
     * @return Un booleano que indica si la desuscripción fue exitosa.
     */
    @PostMapping(path = "/unsubscribe")
    public ResponseEntity<Boolean> unsubscribe(@RequestBody SubscriberModel subscriberModel){
        return new ResponseEntity<Boolean>(subscriberService.unsubscribe(subscriberModel), HttpStatus.ACCEPTED);
    }

    /**
     * Actualiza el estado del sistema y notifica a los suscriptores sobre un evento.
     */
    @PostMapping(path = "/update")
    public void update(){
        //TODO Obtener el codigo de evento y dependiendo del codigo, hacer algo con eso.
        System.out.println("Hello");

    }

}
