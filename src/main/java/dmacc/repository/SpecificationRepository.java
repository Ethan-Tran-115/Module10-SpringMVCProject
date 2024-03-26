package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Specification;

/**
 * @author Phuoc Tran - ptran9@dmacc.edu
 * CIS175 - Spring 2024
 * Mar 25, 2024
 */
public interface SpecificationRepository extends JpaRepository<Specification, Long> {

}
