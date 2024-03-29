package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.example.demo.entity.SalasEntity;
import com.example.demo.service.ISalaService;

@Service("SalaServiceBdd")
public class SalaServiceImpl implements ISalaService {

	public List<SalasEntity> salas = new ArrayList<>();

	/**
	 * Metodo que devuelve una lista con todas las salas
	 */

	@Override
	public List<SalasEntity> findAll() {
		return salas;
	}

	/**
	 * Metodo que devuelve una sala segun el id
	 */

	@Override
	public SalasEntity findById(Long id) {
		Optional<SalasEntity> user = salas.stream().filter(p -> p.getId() == id).findFirst();

		return user.isPresent() ? user.get() : null;
	}

	/**
	 * Metodo que añade una sala
	 */

	@Override
	public SalasEntity add(SalasEntity user) {
		salas.add(user);

		return user;
	}

	/**
	 * Metodo que modifica una sala
	 */

	@Override
	public SalasEntity update(SalasEntity sala) {
		AtomicInteger index = new AtomicInteger();
		salas.stream().forEach(p -> {
			if (p.getId() == sala.getId()) {
				p.setNombre(sala.getNombre());
				p.setNumero(sala.getNumero());
				p.setLugar(sala.getLugar());
				salas.set(index.get(), p);
			}
			index.getAndIncrement();
		});

		return sala;
	}

	/**
	 * Meotod que elimina una sala
	 */

	@Override
	public void remove(Long id) {
		Optional<SalasEntity> sala = salas.stream().filter(p -> p.getId() == id).findFirst();

		if (sala.isPresent()) {
			salas.remove(sala.get());
		}
	}

}
