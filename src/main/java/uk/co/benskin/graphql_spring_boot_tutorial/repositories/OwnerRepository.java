package uk.co.benskin.graphql_spring_boot_tutorial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.benskin.graphql_spring_boot_tutorial.entities.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    
    default public void getAllPets() {
        return;
    }
}

