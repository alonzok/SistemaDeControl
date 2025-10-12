package com.example.SistemaDeControl.Services;

import com.example.SistemaDeControl.Models.SubscriberModel;
import com.example.SistemaDeControl.Repositories.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Servicio que maneja la lógica de negocio relacionada con los suscriptores.
 * Proporciona métodos para suscribirse, desuscribirse y notificar eventos a los suscriptores.
 */
@Service
public class SubscriberService {

    @Autowired
    private SubscriberRepository subscriberRepository;
    @Autowired
    private static MongoTemplate mongoTemplate;

    public SubscriberModel subscribe(SubscriberModel subscriberModel){
        List<SubscriberModel> subscriberModelList = subscriberRepository.findAll();
        for (SubscriberModel subscriber: subscriberModelList) {
            if(subscriber.getUrl().equals(subscriberModel.getUrl()) && subscriber.getCodigoEvento() == subscriberModel.getCodigoEvento()){
                return subscriberModel;
            }
        }
        return subscriberRepository.save(subscriberModel);
    }

    public boolean unsubscribe(SubscriberModel subscriberModel){
        try {
            List<SubscriberModel> subscriberModelList = subscriberRepository.findAll();
            for (SubscriberModel subscriber: subscriberModelList) {
                if(subscriber.getUrl().equals(subscriberModel.getUrl()) && subscriber.getCodigoEvento() == subscriberModel.getCodigoEvento()){
                    System.out.println(subscriberModelList);
                    subscriberRepository.delete(subscriber);
                    return true;
                }
            }
            return true;
        } catch (Exception err) {
            System.out.println(err);
            return false;
        }
    }


    public static void nodity(int codigoEvento){
        try {
            Query query = new Query(Criteria.where("codigoEvento").is(codigoEvento));
            List<SubscriberModel> subscriberModelList = mongoTemplate.find(query, SubscriberModel.class);
            for (SubscriberModel subscriber: subscriberModelList) {

                RestTemplate restTemplate = new RestTemplate();
                String uri = subscriber.getUrl(); // or any other uri
                String result = restTemplate.postForObject(uri, null, String.class, "Change");
                System.out.println(result);

            }
        } catch (Exception err) {
            System.out.println(err);
        }
    }
}
