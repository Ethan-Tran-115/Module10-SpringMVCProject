package dmacc.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Phuoc Tran - ptran9@dmacc.edu
 * CIS175 - Spring 2024
 * Mar 25, 2024
 */
@Entity
@Data
@NoArgsConstructor
public class Manufacturer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
