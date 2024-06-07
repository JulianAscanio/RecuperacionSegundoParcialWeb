package com.mangas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mangas.entidades.Manga;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Integer> {
}
