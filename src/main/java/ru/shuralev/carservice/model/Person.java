package ru.shuralev.carservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PERSON")
@RequiredArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_generator")
    @SequenceGenerator(name = "person_id_generator", sequenceName = "sq_person_id", allocationSize = 1)
    private Long id;
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @JsonSerialize(using = DateSerializer.class)
    private Date birthdate;

    @OneToMany(mappedBy = "person")
    private List<Car> cars;
}
