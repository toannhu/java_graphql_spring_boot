package uk.co.benskin.graphql_spring_boot_tutorial.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="owner")
@Getter 
@Setter
@NoArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id")
    private List<Pet> pets;
    
    public Owner(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public Owner(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}