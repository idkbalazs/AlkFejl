package hu.barbershop.controllers;

import hu.barbershop.entities.Barber;
import hu.barbershop.entities.Label;
import hu.barbershop.entities.Reservation;
import hu.barbershop.repositories.BarberRepository;
import hu.barbershop.repositories.LabelRepository;
import hu.barbershop.repositories.ReservationRepository;
import hu.barbershop.security.AuthenticatedUser;

import java.util.List;
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
@RequestMapping("/barbers")
public class BarberController {

    @Autowired
    private BarberRepository barberRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private LabelRepository labelRepository;
    
    @Autowired 
    private AuthenticatedUser authenticatedUser;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Barber>> getAll() {
        return ResponseEntity.ok(barberRepository.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Barber> get(@PathVariable Integer id) {
        Optional<Barber> barber = barberRepository.findById(id);
        if (barber.isPresent()) {
            return ResponseEntity.ok(barber.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Barber> post(@RequestBody Barber barber) {
        Barber savedBarber = barberRepository.save(barber);
        return ResponseEntity.ok(savedBarber);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Barber> put(@RequestBody Barber barber, @PathVariable Integer id) {
        Optional<Barber> oBarber = barberRepository.findById(id);
        if (oBarber.isPresent()) {
            barber.setId(id);
            return ResponseEntity.ok(barberRepository.save(barber));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Barber> oBarber = barberRepository.findById(id);
        if (oBarber.isPresent()) {
            barberRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/reservations")
    public ResponseEntity<Iterable<Reservation>> messages(@PathVariable Integer id) {
        Optional<Barber> oBarber = barberRepository.findById(id);
        if (oBarber.isPresent()) {
            return ResponseEntity.ok(oBarber.get().getReservations());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/reservations")
    public ResponseEntity<Reservation> insertMessage(@PathVariable Integer id, @RequestBody Reservation reservation) {
        Optional<Barber> oBarber = barberRepository.findById(id);
        if (oBarber.isPresent()) {
            Barber barber = oBarber.get();
            reservation.setBarber(barber);
            return ResponseEntity.ok(reservationRepository.save(reservation));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/labels")
    public ResponseEntity<Iterable<Label>> labels(@PathVariable Integer id) {
        Optional<Barber> oBarber = barberRepository.findById(id);
        if (oBarber.isPresent()) {
            return ResponseEntity.ok(oBarber.get().getLabels());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/labels")
    public ResponseEntity<Label> insertLabel(@PathVariable Integer id, @RequestBody Label label) {
        Optional<Barber> oBarber = barberRepository.findById(id);
        if (oBarber.isPresent()) {
            Barber barber = oBarber.get();
            Label newLabel = labelRepository.save(label);
            barber.getLabels().add(newLabel);
            barberRepository.save(barber);  // have to trigger from the @JoinTable side
            return ResponseEntity.ok(newLabel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/labels")
    public ResponseEntity<Iterable<Label>> modifyLabels(@PathVariable Integer id, @RequestBody List<Label> labels) {
        Optional<Barber> oBarber = barberRepository.findById(id);
        if (oBarber.isPresent()) {
            Barber barber = oBarber.get();

            // if we would like to add new labels as well
            for (Label label: labels) {
                if (label.getId() == null) {
                    labelRepository.save(label);
                }
            }

            barber.setLabels(labels);
            barberRepository.save(barber);
            return ResponseEntity.ok(labels);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
