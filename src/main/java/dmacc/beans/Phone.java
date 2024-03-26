package dmacc.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Phuoc Tran - ptran9@dmacc.edu
 * CIS175 - Spring 2024
 * Mar 24, 2024
 */
@Entity
@Data
@NoArgsConstructor
public class Phone {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private String color;

    @OneToOne
    private Specification specification;
}
