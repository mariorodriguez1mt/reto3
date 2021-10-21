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
public class ServicesClient {
    @Autowired
    private RepositoryClient metodosCrudClient;
    
    public List<Client> getAll(){
        return metodosCrudClient.getAll();
    }
     
    public Optional<Client> getClient(int clientId) {
        return metodosCrudClient.getCliente(clientId);
    }
    
    public Client save(Client client){
        if(client.getIdClient()==null){
            return metodosCrudClient.save(client);
        }else{
            Optional<Client> e= metodosCrudClient.getCliente(client.getIdClient());
            if(e.isEmpty()){
                return metodosCrudClient.save(client);
            }else{
                return client;
            }
        }
    }
    
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= metodosCrudClient.getCliente(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                /**
                 * se agregó el atributo email para que se modifique tambien
                 */
                if(client.getEmail()!=null){
                    e.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                metodosCrudClient.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    
    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrudClient.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }  
}
