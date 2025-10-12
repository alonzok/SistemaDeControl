package com.example.SistemaDeControl.Controllers;

import com.example.SistemaDeControl.Models.ActuadorModel;
import com.example.SistemaDeControl.Services.ActuadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador para manejar las operaciones relacionadas con los actuadores.
 * Proporciona endpoints para crear, obtener, actualizar y eliminar actuadores.
 */
@RestController
public class ActuadorController{

    @Autowired
    private ActuadorService actuadorService;

    /**
     * Crea o actualiza un actuador.
     * @param actuador El objeto ActuadorModel que contiene los datos del actuador a crear o actualizar.
     * @return
     */
    @PostMapping
    public ResponseEntity<ActuadorModel> postPutActuador(@RequestBody ActuadorModel actuador){

        return new ResponseEntity<ActuadorModel>(actuadorService.postPutActuador(actuador), HttpStatus.ACCEPTED);
    }

    /**
     * Obtiene todos los actuadores.
     * @return Una lista de todos los actuadores.
     */
    @GetMapping(path = "/getAllActuador")
    public ResponseEntity<List<ActuadorModel>> getTodoActuador(){
        return new ResponseEntity<List<ActuadorModel>>(actuadorService.getTodoActuador(), HttpStatus.ACCEPTED);
    }

    /**
     * Obtiene un actuador por su ID.
     * @param id El ID del actuador a obtener.
     * @return El actuador correspondiente al ID proporcionado, si existe.
     */
    @GetMapping(path = "/getActuador/{id}")
    public ResponseEntity<Optional<ActuadorModel>> getActuador(@PathVariable("id") int id){
        return new ResponseEntity<Optional<ActuadorModel>>(actuadorService.getActuador(id), HttpStatus.ACCEPTED);
    }

    /**
     * Activa o desactiva un actuador.
     * @return Un booleano que indica si la operación fue exitosa.
     */
    @GetMapping(path = "/setActiveActuador")
    public ResponseEntity<Boolean> setActiveActuador(){
        return new ResponseEntity<Boolean>(actuadorService.setActiveActuador(), HttpStatus.ACCEPTED);
    }

//    @PutMapping("/updateActuador/{id}")
//    public ResponseEntity<Optional<ActuadorModel>> putActuador(@PathVariable("id") int id, ActuadorModel actuador){
//        return new ResponseEntity<Optional<ActuadorModel>>(actuadorService.putActuador(id, actuador), HttpStatus.ACCEPTED);
//    }

    /**
     * Elimina un actuador por su ID.
     * @param id El ID del actuador a eliminar.
     * @return Un booleano que indica si la eliminación fue exitosa.
     */
    @DeleteMapping(path = "/deleteActuador/{id}")
    public boolean eliminarActuador(@PathVariable("id") int id) {
        return actuadorService.deleteActuador(id);
    }

    @GetMapping(path = "")
    public void mostrarMensaje(){
        System.out.println("evento");
    }

}
