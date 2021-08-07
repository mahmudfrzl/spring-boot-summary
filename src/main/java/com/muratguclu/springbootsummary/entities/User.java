package com.muratguclu.springbootsummary.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class User extends BaseEntity{
    @Id
    @SequenceGenerator(name = "gen_user_seq",sequenceName = "gen_seq",initialValue = 100,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen_user_seq")
    private int id;
    private String firstName;
    private String lastName;
}
