package com.mangas.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangas.entidades.Usuario;
import com.mangas.repositorio.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario findById(int id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	public Usuario findByUsername(String username) {
		return usuarioRepository.findByUsername(username);
	}

	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void deleteById(int id) {
		usuarioRepository.deleteById(id);
	}
}