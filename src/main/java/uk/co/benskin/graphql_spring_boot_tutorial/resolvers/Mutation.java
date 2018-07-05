package uk.co.benskin.graphql_spring_boot_tutorial.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import uk.co.benskin.graphql_spring_boot_tutorial.entities.Pet;
import uk.co.benskin.graphql_spring_boot_tutorial.enums.Animal;
import uk.co.benskin.graphql_spring_boot_tutorial.repositories.PetRepository;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final PetRepository PetRepository;

    public Pet newPet(Animal type, String name, int age, long ownerId) {
        return PetRepository.saveAndFlush(new Pet(type, name, age, ownerId));
    }
    
    public Pet updatePet(long id, Animal type, String name, int age, long ownerId) {
        return PetRepository.saveAndFlush(new Pet(id, type, name, age, ownerId));
    }

}
