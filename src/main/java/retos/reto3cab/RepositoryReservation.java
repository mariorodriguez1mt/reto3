/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retos.reto3cab;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @MarioR
 * @version 
 */
@Repository
public class RepositoryReservation {
    @Autowired
    private InterfaceReservation crudReservation;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) crudReservation.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return crudReservation.findById(id);
    }
    public Reservation save(Reservation reservacion){
        return crudReservation.save(reservacion);
    }
    public void delete(Reservation reservacion){
        crudReservation.delete(reservacion);
    }
}
