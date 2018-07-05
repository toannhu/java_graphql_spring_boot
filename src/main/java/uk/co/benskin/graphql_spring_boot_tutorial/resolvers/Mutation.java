package uk.co.benskin.graphql_spring_boot_tutorial.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.co.benskin.graphql_spring_boot_tutorial.entities.NestedObject;
import uk.co.benskin.graphql_spring_boot_tutorial.entities.Owner;

import uk.co.benskin.graphql_spring_boot_tutorial.entities.Pet;
import uk.co.benskin.graphql_spring_boot_tutorial.enums.Animal;
import uk.co.benskin.graphql_spring_boot_tutorial.repositories.OwnerRepository;
import uk.co.benskin.graphql_spring_boot_tutorial.repositories.PetRepository;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private final PetRepository PetRepository;
    
    @Autowired
    private final OwnerRepository OwnerRepository;

    public Pet newPet(Animal type, String name, int age, long ownerId) {
        Owner owner = new Owner();
        owner.setId(ownerId);
        return PetRepository.saveAndFlush(new Pet(type, name, age, owner));
    }
    
    public Pet updatePet(long id, Animal type, String name, int age, long ownerId) {
        Owner owner = new Owner();
        owner.setId(ownerId);
        return PetRepository.saveAndFlush(new Pet(id, type, name, age, owner));
    }
    
    public Owner newOwner(String name, int age) {
        return OwnerRepository.saveAndFlush(new Owner(name, age));
    }
    
    public Owner updateOwner(long id, String name, int age) {
        return OwnerRepository.saveAndFlush(new Owner(id, name, age));
    }
    
    public Owner addNestedObject(NestedObject obj) {
        Owner owner = OwnerRepository.save(obj.getOwner());
        
        PetRepository.saveAll(obj.getPets());
        OwnerRepository.flush();
        return owner;
    }

}
