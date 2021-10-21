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
public class ServicesCategory {
    @Autowired
    private RepositoryCategory metodosCrudCategory;
    
    public List<Category> getAll() {
        return metodosCrudCategory.getAll();
    }

    public Optional<Category> getCategory(int CategoriaId) {
        return metodosCrudCategory.getCategory(CategoriaId);
    }
    
    public Category save(Category category) {
        if (category.getId()== null) {
            return metodosCrudCategory.save(category);
        } else {
            Optional<Category> category1 = metodosCrudCategory.getCategory(category.getId());
            if (category1.isEmpty()) {
                return metodosCrudCategory.save(category);
            } else {
                return category;
            }
        }
    }
    
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> g=metodosCrudCategory.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                return metodosCrudCategory.save(g.get());
            }
        }
        return category;
    }
    
    public boolean deletecategory(int categoryId){
        Boolean d=getCategory(categoryId).map(category -> {
            metodosCrudCategory.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
    
}
