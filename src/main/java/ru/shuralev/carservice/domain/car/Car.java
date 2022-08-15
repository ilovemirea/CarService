package ru.shuralev.carservice.domain.car;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import ru.shuralev.carservice.domain.person.Person;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CAR")
@Getter
@Setter
public class Car {
    @Id
    private Long id;
    @NotNull
    private String model;
    @NotNull
    private Integer horsepower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private Person person;

    public Car() {

    }

    public Car(Long id, String model, Integer horsepower, Long ownerId) {
        this.id = id;
        this.model = model;
        this.horsepower = horsepower;
        setOwnerId(ownerId);
    }

    public void setOwnerId(Long id) {
        person = new Person();
        person.setId(id);
    }
}
