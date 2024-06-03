package com.mangas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mangas.entidades.Manga;
import com.mangas.servicios.MangaService;

import java.util.List;

@RestController
@RequestMapping("/mangas")
public class MangaController {

    @Autowired
    private MangaService mangaService;

    @GetMapping
    public List<Manga> findAll() {
        return mangaService.findAll();
    }

    @GetMapping("/{id}")
    public Manga findById(@PathVariable int id) {
        return mangaService.findById(id);
    }

    @PostMapping
    public Manga save(@RequestBody Manga manga) {
        return mangaService.save(manga);
    }

    @PutMapping("/{id}")
    public Manga update(@PathVariable int id, @RequestBody Manga manga) {
        Manga existingManga = mangaService.findById(id);
        if (existingManga != null) {
            manga.setId(id);
            return mangaService.save(manga);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Manga deleteById(@PathVariable int id) {
        Manga manga = mangaService.findById(id);
        if (manga != null) {
            mangaService.deleteById(id);
        }
        return manga;
    }
}
