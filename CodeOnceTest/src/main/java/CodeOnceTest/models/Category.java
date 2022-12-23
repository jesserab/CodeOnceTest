package CodeOnceTest.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class Category {

    public Category(String name , String description){
        this.name = name ;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "product name should not be empty")
    @Column(unique = true)
    //prevent the user from creating two categories with the same name
    private String name;

    private String description ;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.ALL})
    private List<Product> products;
}