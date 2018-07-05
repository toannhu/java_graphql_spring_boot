package uk.co.benskin.graphql_spring_boot_tutorial.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import uk.co.benskin.graphql_spring_boot_tutorial.enums.Animal;

@Data
@Entity
@Table(name="pets")
@Getter 
@Setter
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;
    
    @Enumerated(EnumType.STRING)
    @Column(name="type")
    private Animal type;

    @Column(name="age")
    private int age;
    
    @Column(name="owner_id")
    private long ownerId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", insertable = false, updatable = false)
    private Owner owner;
    
    public Pet(Animal type, String name, int age, long ownerId) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.ownerId = ownerId;
    }
    
    public Pet(long id, Animal type, String name, int age, long ownerId) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.age = age;
        this.ownerId = ownerId;
    }
}