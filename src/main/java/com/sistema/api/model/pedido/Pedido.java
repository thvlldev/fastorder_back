package com.sistema.api.model.pedido;
import jakarta.persistence.*;
import lombok.*;

@Entity 
@Table (name = "produtos")
@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
public class Pedido {
    
    @Id 
    @GeneratedValue (GenerationType.UUID);
    private String id;

}
