package com.jalasoft.client.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

/**
 * @author Giordano Bortolini
 */
@Getter
@Entity(name = "client")
public class ClientEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column
  private String name;
  @Column
  private String lastName;
  @Column
  private String phone;

}
