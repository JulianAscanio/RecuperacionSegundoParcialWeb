package com.mangas.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangas.entidades.Manga;
import com.mangas.repositorio.MangaRepository;

@Service
public class MangaService {

    @Autowired
    private MangaRepository mangaRepository;

    public List<Manga> findAll() {
        return mangaRepository.findAll();
    }

    public Manga findById(int id) {
        return mangaRepository.findById(id).orElse(null);
    }

    public Manga save(Manga manga) {
        return mangaRepository.save(manga);
    }

    public void deleteById(int id) {
        mangaRepository.deleteById(id);
    }
}