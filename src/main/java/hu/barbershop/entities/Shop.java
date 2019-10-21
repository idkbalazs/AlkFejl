package hu.barbershop.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Shop implements Serializable {
  @javax.persistence.Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column
  @NotNull
  private String name;

  @Column(unique = true)
  @NotNull
  private String place;

  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime created_at;

  @Column
  @UpdateTimestamp
  private LocalDateTime updated_at;
}
