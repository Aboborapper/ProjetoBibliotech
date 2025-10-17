package com.bibliotech.api.API.emprestimos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepositorio extends JpaRepository<Emprestimo, Long> {
}
