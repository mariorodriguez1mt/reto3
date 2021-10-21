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
public class RepositoryMessage {
    @Autowired
    private InterfaceMessage crudMessage;
    
    public List<Message> getAll(){
        return (List<Message>) crudMessage.findAll();
    }
    public Optional<Message> getMessage(int id){
        return crudMessage.findById(id);
    }
    public Message save(Message mensaje){
        return crudMessage.save(mensaje);
    }
    public void delete(Message mensaje){
        crudMessage.delete(mensaje);
    }
    
}
