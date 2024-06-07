package com.mangas.entidades;

import java.io.Serializable;

import lombok.Data;

@Data
public class Favorito implements Serializable {
	
	private Usuario usuario_id;
	private Manga manga_id;
	
}
