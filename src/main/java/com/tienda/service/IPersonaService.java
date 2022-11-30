/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Persona;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joel Mora
 */
@Service
public interface IPersonaService {
    List<Persona> getAllPersona();
    Persona getPersonaById(long id);
    Persona findByNombre(String nombre);
    void savePersona(Persona persona);
    void delete(long id);

}
