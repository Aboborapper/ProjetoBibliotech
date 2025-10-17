package com.bibliotech.api.API.generos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneroRepositorio extends JpaRepository<Genero, Long>{
    Optional<Genero> findByGenero(String nome);
}
