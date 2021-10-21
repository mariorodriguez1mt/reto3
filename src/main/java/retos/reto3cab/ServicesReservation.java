/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retos.reto3cab;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @MarioR
 * @version 1.1
 */
@Service
public class ServicesReservation {
    @Autowired
    private RepositoryReservation metodosCrudReservation;
    
    public List<Reservation> getAll(){
        return metodosCrudReservation.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId) {
        return metodosCrudReservation.getReservation(reservationId);
    }
    
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrudReservation.save(reservation);
        }else{
            Optional<Reservation> e= metodosCrudReservation.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrudReservation.save(reservation);
            }else{
                return reservation;
            }
        } 
    }
    
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= metodosCrudReservation.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){
                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrudReservation.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrudReservation.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
