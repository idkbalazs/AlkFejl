package hu.barbershop.controllers;

import hu.barbershop.entities.Shop;
import hu.barbershop.repositories.ShopRepository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shops")
public class ShopController {
  @Autowired
  private ShopRepository shopRepository;

  @GetMapping("")
  public ResponseEntity<Iterable<Shop>> getAll() {
    return ResponseEntity.ok(shopRepository.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Shop> get(@PathVariable Integer id) {
    Optional<Shop> shop = shopRepository.findById(id);
    if (!shop.isPresent())
    {
      ResponseEntity.notFound();
    }
    
    return ResponseEntity.ok(shop.get());
  }

  @PostMapping("")
  public ResponseEntity<Shop> post(@RequestBody Shop shop) {
    Shop newShop = shopRepository.save(shop);
    return ResponseEntity.ok(newShop);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable Integer id) {
    Optional<Shop> shop = shopRepository.findById(id);
    if (!shop.isPresent())
    {
      ResponseEntity.notFound();
    }
    
    shopRepository.delete(shop.get());
    
    return ResponseEntity.ok().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Shop> put(@PathVariable Integer id, @RequestBody Shop shop) {
    Optional<Shop> oldShop = shopRepository.findById(id);
    if (!oldShop.isPresent())
    {
      ResponseEntity.notFound();
    }

    shop.setId(id);
    return ResponseEntity.ok(shopRepository.save(shop));
  }
}