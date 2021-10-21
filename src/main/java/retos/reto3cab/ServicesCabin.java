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
public class ServicesCabin {
    @Autowired
    private RepositoryCabin metodosCrudCabin;
    
    public List<Cabin> getAll(){
        return metodosCrudCabin.getAll();
    }
    public Optional<Cabin> getCabin(int cabinId){
        return metodosCrudCabin.getCabin(cabinId);
    }
    
    public Cabin save(Cabin cabana){
        if(cabana.getCabinId()==null){
            return metodosCrudCabin.save(cabana);
        }else{
            Optional<Cabin> e=metodosCrudCabin.getCabin(cabana.getCabinId());
            if(e.isEmpty()){
                return metodosCrudCabin.save(cabana);
            }else{
                return cabana;
            }
        }
    }
    
    public Cabin update(Cabin cabana){
        if(cabana.getCabinId()!=null){
            Optional<Cabin> e=metodosCrudCabin.getCabin(cabana.getCabinId());
            if(!e.isEmpty()){
                if(cabana.getBrand()!=null){
                    e.get().setBrand(cabana.getBrand());
                }
                if(cabana.getName()!=null){
                    e.get().setName(cabana.getName());
                }
                if(cabana.getRooms()!=null){
                    e.get().setRooms(cabana.getRooms());
                }
                if(cabana.getDescription()!=null){
                    e.get().setDescription(cabana.getDescription());
                }
                if(cabana.getCategory()!=null){
                    e.get().setCategory(cabana.getCategory());
                }
                metodosCrudCabin.save(e.get());
                return e.get();
            }else{
                return cabana;
            }
        }else{
            return cabana;
        }
    }
    
    public boolean deleteCabin(int cabinId) {
        Boolean aBoolean = getCabin(cabinId).map(cabin -> {
            metodosCrudCabin.delete(cabin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
