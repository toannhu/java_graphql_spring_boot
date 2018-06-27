package uk.co.benskin.graphql_spring_boot_tutorial.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import uk.co.benskin.graphql_spring_boot_tutorial.enums.Animal;

@Data
@Entity
@Table(name="pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    
    @Enumerated(EnumType.STRING)
    private Animal type;

    private int age;
    
    public Pet addPet(Animal type, String name, int age) {
        Pet pet = new Pet();
        pet.name = name;
        pet.age = age;
        pet.type = type;
        return pet;
    }
}