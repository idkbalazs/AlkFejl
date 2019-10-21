## Fejlesztői környezet:

* Github: (/idkbalazs/AlkFejl)
* IDE: IntelliJ IDEA
* Database: H2


## Adatbázis terv:

![Database UML diagramm](/uml.PNG)


## Könyvtárstruktúra:

* controllers
  * BarberController.java
  * LabelController.java
  * ReservationController.java
  * ShopController.java
  * UserController.java
* entities
  * Barber.java
  * Label.java
  * Reservation.java
  * Shop.java
  * User.java
* repositories
  * BarberRepository.java
  * LabelRepository.java
  * ReservationRepository.java
  * ShopRepository.java
  * UserRepository.java
* security
  * AuthenticatedUser.java
  * CustomBasicAuthenticationEntryPoint.java
  * MyUserDetailsService.java
  * WebSecurityConfig.java
* BarbershopApplication.java


## Végpontok:

### GET
    /barbers                  Összes barber listázása
    /barbars/id               Egy barber oldalának megtekintése
    /barbers/id/reservations  Barberhez tartozó foglalások
    /barbers/id/labels        Barberhez tartozó vélemények
    /reservations             Összes foglalás listázása
    /reservations/id          Egy foglalás oldalának megtekintése
    /labels                   Összes vélemény listázása
    /labels/id                Egy vélemény oldalának megtekintése
    /shops                    Összes barbershop listázása
    /shops/id                 Egy barbershop listázása
    /shops                    Összes barbershop listázása
    
### POST
    /register                 Új felhasználó regisztrálása
    /login                    Felhasználó bejelentkezése
    /barbers                  Új barbert adunk az adatbázishoz
    /barbers/id/reservations  Új foglalást tudunk hozzáadni egy barberhez
    /barbers/id/labels        Új véleményt tudunk hozzáadni egy barberhez
    /reservations             Új foglalást adunk az adatbázishoz
    /labels                   Új véleményt adunk az adatbázishoz
    /shops                    Új barbershopot adunk az adatbázishoz
    
### PUT
    /barbers/id           Barberhez tartozó adatok módosítása
    /barbers/id/labels    Barberhez tartozó vélemények móosítása
    /labels/id            Véleményhez tartozó adatok módosítása
    /reservations/id      Foglaláshoz tartozó adatok módosítása
    /shops/id             Barbershophoz tartozó adatok módosítása
    
### DELETE
    /barbers/id           Barber törlése az adatbázisból
    /labels/id            Vélemény törlése az adatbázisból
    /reservations/id      Foglalás törlése az adatbázisból 
    /shops/id             Barbershop törlése az adatbázisból


## Egy végpont bemutatása:

