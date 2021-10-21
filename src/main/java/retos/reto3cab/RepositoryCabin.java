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
 * @version 1.1
 */
@Repository
public class RepositoryCabin {
    @Autowired
    private InterfaceCabin crudCabin;
    
    public List<Cabin> getAll(){
        return (List<Cabin>) crudCabin.findAll();
    }
    
    public Optional<Cabin> getCabin(int id){
        return crudCabin.findById(id);
    }
    
    public Cabin save(Cabin cabana){
        return crudCabin.save(cabana);
    }
    
    public void delete(Cabin cabana){
        crudCabin.delete(cabana);
    }
    
}
