package CodeOnceTest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor

public class Product {

    public Product (String name , String description , Double quantity){
        this.name = name;
        this.description = description;
        this.quantity = quantity ;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "product name should not be empty")
    private String name ;

    private Double quantity;

    private String description;

    @JsonIgnore
    @ManyToOne
    private Category category;

}
