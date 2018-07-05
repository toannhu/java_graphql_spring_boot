/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.benskin.graphql_spring_boot_tutorial.entities;

import java.util.List;

/**
 *
 * @author cpu11406-local
 */
public class NestedObject {
    
    private Owner owner;
    private List<Pet> pets;
    
    public Owner getOwner() {
        return this.owner;
    }
    
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    
    public List<Pet> getPets() {
        return this.pets;
    }
    
    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
    
}
