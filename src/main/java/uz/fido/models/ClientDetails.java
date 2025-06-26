package uz.fido.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ClientDetails {

    @Id
    @GeneratedValue()
    private int id;
}
