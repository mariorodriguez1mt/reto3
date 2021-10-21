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
public class RepositoryCategory {
    @Autowired
    private InterfaceCategory crudCategory;
    
    public List<Category> getAll(){
        return (List<Category>) crudCategory.findAll();
    }
    public Optional<Category> getCategory(int id){
        return crudCategory.findById(id);
    }
    public Category save(Category categoria){
        return crudCategory.save(categoria);
    }
    public void delete(Category categoria){
        crudCategory.delete(categoria);
    }
}
