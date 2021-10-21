/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retos.reto3cab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @MarioR
 * @version 1.1
 */
@Entity
@Table(name = "cabin")
public class Cabin implements Serializable{
    /**
     *Creacion de la tabla con sus etiquetas
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * declaración de las columnas, sus headers y tipos de valor
     * se inicia con el Id
     */
    private Integer CabinId;
    @Column(nullable = false,length = 45)
    /**
     *nombre de la cabaña
     */
    private String name;
    @Column(nullable = false,length = 45)
    /**
     * marca de la cabaña
     */
    private String brand;
    /**
     * numero de cuartos de cabaña
     */
    private Integer rooms;
    @Column(nullable = false,length = 250)
    /**
     * Descripción de cabaña
     */
    private String description;
    
    /**
     * creación de relaciones con la tabla categoría de muchos a uno
     */
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("cabins")
    /**
     * atributo relación con categoría
     */
    private Category category;
    
    /**
     * creación de las relaciones con la tabla mensajes de uno a muchos
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "cabin")
    @JsonIgnoreProperties({"cabin", "client"})
    /**
     * atributo relación con mensajes
     */
    private List<Message> messages;
    
    /**
     * creación de las relaciones con la tabla mensajes de uno a muchos
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "cabin")
    @JsonIgnoreProperties({"cabin", "client"})
    /**
     * atributo relación con reservaciones
     */
    private List<Reservation> reservations;

    public Integer getCabinId() {
        return CabinId;
    }

    public void setCabinId(Integer CabinId) {
        this.CabinId = CabinId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    
    
}
