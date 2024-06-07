package com.mangas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mangas.entidades.Manga;

public interface MangaRepository extends JpaRepository<Manga, Integer> {
}
