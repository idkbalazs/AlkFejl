package hu.elte.barbershop.repositories;

import hu.elte.barbershop.entities.Barber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberRepository extends CrudRepository<Barber, Integer> {

}
