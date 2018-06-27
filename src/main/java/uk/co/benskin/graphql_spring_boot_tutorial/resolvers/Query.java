package uk.co.benskin.graphql_spring_boot_tutorial.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import java.util.Optional;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import uk.co.benskin.graphql_spring_boot_tutorial.entities.Pet;
import uk.co.benskin.graphql_spring_boot_tutorial.enums.Animal;
import uk.co.benskin.graphql_spring_boot_tutorial.repositories.PetRepository;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final PetRepository PetRepository;

    public Iterable<Pet> pets() {
        return PetRepository.findAll();
    }
    
    public Optional<Pet> petsId(Long id) {
        return PetRepository.findById(id);
    }
    
}