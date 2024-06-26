package com.mangas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mangas.entidades.Manga;
import com.mangas.entidades.Usuario;
import com.mangas.servicios.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public List<Usuario> findAll() {
		return usuarioService.findAll();
	}

	@GetMapping("/{id}")
	public Usuario findById(@PathVariable int id) {
		return usuarioService.findById(id);
	}

	@GetMapping("/{username}/favoritos")
	public List<Manga> getFavoritos(@PathVariable String username) {
		Usuario usuario = usuarioService.findByUsername(username);
		return usuario.getMangas();
	}

	@PostMapping
	public Usuario save(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}

	@PostMapping("/{username}/favoritos")
	public List<Manga> addFavorito(@PathVariable String username, @RequestBody Manga manga) {
		Usuario usuario = usuarioService.findByUsername(username);
		usuario.getMangas().add(manga);
		usuarioService.save(usuario);
		return usuario.getMangas();
	}

	@DeleteMapping("/{username}/favoritos/{mangaId}")
	public List<Manga> removeFavorito(@PathVariable String username, @PathVariable int mangaId) {
		Usuario usuario = usuarioService.findByUsername(username);
		Manga manga = usuario.getMangas().stream().filter(m -> m.getId() == mangaId).findFirst().orElse(null);
		if (manga != null) {
			usuario.getMangas().remove(manga);
			usuarioService.save(usuario);
		}
		return usuario.getMangas();
	}
}
