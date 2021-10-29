/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retos.reto3cab;

import java.util.ArrayList;
import java.util.Date;
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
    public List<Reservation> ReservationStatus(String status){
        return crudReservation.findAllByStatus(status);
    }
    
     public List<Reservation> ReservacionTiempoRepositorio (Date a, Date b){
         return crudReservation.findAllByStartDateAfterAndStartDateBefore(a, b);
     }
     
     public List<ContadorClientes> getClientesRepositorio(){
         List<ContadorClientes> res = new ArrayList<>();
         List<Object[]> report = crudReservation.countTotalReservationsByClient();
         for(int i=0; i<report.size(); i++){
             res.add(new ContadorClientes((Long)report.get(i)[1],(Client) report.get(i)[0]));
         }
         return res;
     }

}
