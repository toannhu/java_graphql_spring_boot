package uk.co.benskin.graphql_spring_boot_tutorial.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uk.co.benskin.graphql_spring_boot_tutorial.entities.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
//    @Query("select o from Owner o where o.name LIKE %:name%")
//    public List<Owner> findAllByName(@Param("name") String name);
}
