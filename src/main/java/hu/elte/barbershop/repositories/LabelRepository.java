package hu.elte.barbershop.repositories;

import hu.elte.barbershop.entities.Label;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends CrudRepository<Label, Integer> {

}
