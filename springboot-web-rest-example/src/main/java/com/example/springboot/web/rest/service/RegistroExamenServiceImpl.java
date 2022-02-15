package com.example.springboot.web.rest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springboot.web.rest.entity.RegistroExamen;
import com.example.springboot.web.rest.manejador.ManejadorZonaHoraria;
import com.example.springboot.web.rest.repository.RegistroExamenRepository;


@Service
public class RegistroExamenServiceImpl implements RegistroExamenService{
	
	@Autowired
	private RegistroExamenRepository repository;

	@Override
	@Transactional
	public String save(RegistroExamen registro) {
		ManejadorZonaHoraria zona= new ManejadorZonaHoraria();
		String manejador= zona.manejador(registro.getFechaExamen(), registro.getEstudiante().getZonaHoraria());
		repository.save(registro);
		return manejador;
	}

}