package uk.co.benskin.graphql_spring_boot_tutorial.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import java.util.Optional;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uk.co.benskin.graphql_spring_boot_tutorial.entities.Pet;
import uk.co.benskin.graphql_spring_boot_tutorial.enums.Animal;
import uk.co.benskin.graphql_spring_boot_tutorial.repositories.PetRepository;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final PetRepository PetRepository;
    
    public Pet newPet(Animal type, String name, int age) {
        Pet pet = new Pet();
        return PetRepository.save(pet.addPet(type, name, age));
    }
    
}