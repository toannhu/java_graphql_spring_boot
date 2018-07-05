package uk.co.benskin.graphql_spring_boot_tutorial.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.co.benskin.graphql_spring_boot_tutorial.entities.Owner;

import uk.co.benskin.graphql_spring_boot_tutorial.entities.Pet;
import uk.co.benskin.graphql_spring_boot_tutorial.repositories.OwnerRepository;
import uk.co.benskin.graphql_spring_boot_tutorial.repositories.PetRepository;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    @Autowired
    private final PetRepository PetRepository;
    
    @Autowired
    private final OwnerRepository OwnerRepository;

    public Iterable<Pet> pets() {
        return PetRepository.findAll();
    }
    
    public Optional<Pet> petId(Long id) {
        return PetRepository.findById(id);
    }

    public List<Pet> petName(String name) {
        return PetRepository.findAllByName(name);
    }
    
    public Iterable<Owner> owners() {
        return OwnerRepository.findAll();
    }

    public Optional<Owner> ownerId(Long id) {
        return OwnerRepository.findById(id);
    }

}
