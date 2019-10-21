package hu.barbershop.repositories;

import hu.barbershop.entities.Shop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Integer> {
  Shop findByName(String name);
}
