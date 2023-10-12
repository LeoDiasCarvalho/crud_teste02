package com.leo.crud_teste02.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.crud_teste02.entities.Telefone;
import com.leo.crud_teste02.repositories.TelefoneRepository;

@Service
public class TelefoneService {
	
	@Autowired
	private TelefoneRepository telRepo;

	public List<Telefone> buscarTodosTelefones(){
		List<Telefone> lista = telRepo.findAll();
		return lista;
	}
	
	public Telefone buscarTelefonePorId(Long id) {
		if(telRepo.existsById(id)) {
			Telefone tel = telRepo.findById(id).get();
			return tel;
		}else {
			return null;
		}
	}
	
	public Telefone salvarTelefone(Telefone tel) {
		return telRepo.save(tel);
	}
	
	public Telefone atualizarTelefone(Telefone tel) {
		return salvarTelefone(tel);
	}
	
	public void excluirTelefonePorId(Long id) {
		if(telRepo.existsById(id)) {
			telRepo.deleteById(id);
		}
	}
	
	public void excluirTelefone(Telefone tel) {
		if(telRepo.existsById(tel.getId_telefone())) {
			telRepo.delete(tel);
		}
	}
	
}
