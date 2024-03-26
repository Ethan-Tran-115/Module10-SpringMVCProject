package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Phone;

/**
 * @author Phuoc Tran - ptran9@dmacc.edu
 * CIS175 - Spring 2024
 * Mar 25, 2024
 */
public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
