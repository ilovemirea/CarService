package ru.shuralev.carservice.domain.person;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.shuralev.carservice.domain.car.Car;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PERSON")
@RequiredArgsConstructor
@Getter
@Setter
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = -5449326074498337967L;

    @Id
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate birthdate;

    @OneToMany(mappedBy = "person",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Car> cars = new ArrayList<>();
}
