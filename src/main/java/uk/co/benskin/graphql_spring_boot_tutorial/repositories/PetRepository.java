package uk.co.benskin.graphql_spring_boot_tutorial.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uk.co.benskin.graphql_spring_boot_tutorial.entities.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
    @Query("select p from Pet p where p.name LIKE %:name%")
    public List<Pet> findAllByName(@Param("name") String name);
}
