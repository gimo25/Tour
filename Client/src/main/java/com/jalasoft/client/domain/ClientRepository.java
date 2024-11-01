package com.jalasoft.client.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Giordano Bortolini
 */
@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

}
