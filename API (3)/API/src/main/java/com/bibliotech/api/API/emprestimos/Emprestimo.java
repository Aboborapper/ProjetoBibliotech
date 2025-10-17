package com.bibliotech.api.API.emprestimos;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "Emprestimo")
@Entity(name = "Emprestimos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Emprestimo {
}
