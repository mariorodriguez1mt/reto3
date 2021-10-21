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
public class RepositoryClient {
    @Autowired
    private InterfaceClient crudClient;
    
    public List<Client> getAll(){
        return (List<Client>) crudClient.findAll();
    }
    public Optional<Client> getCliente(int id){
        return crudClient.findById(id);
    }
    public Client save(Client cliente){
        return crudClient.save(cliente);
    }
    public void delete(Client cliente){
        crudClient.delete(cliente);
    }
    
}
