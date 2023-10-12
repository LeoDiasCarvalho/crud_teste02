package com.leo.crud_teste02.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.crud_teste02.entities.Telefone;
import com.leo.crud_teste02.exceptions.TelefoneException;
import com.leo.crud_teste02.repositories.TelefoneRepository;

@Service
public class TelefoneService {
	
	@Autowired
	private TelefoneRepository telRepo;

	public List<Telefone> buscarTodosTelefones(){
		List<Telefone> lista = telRepo.findAll();
		return lista;
	}
	
	public Telefone buscarTelefonePorId(Long id) throws TelefoneException {
		if(telRepo.existsById(id)) {
			Telefone tel = telRepo.findById(id).get();
			return tel;
		}else {
			throw new TelefoneException("Telefone com id:" + id + " não existe!");
		}
	}
	
	public Telefone salvarTelefone(Telefone tel) {
		return telRepo.save(tel);
	}
	
	public Telefone atualizarTelefone(Telefone tel) {
		return salvarTelefone(tel);
	}
	
	public void excluirTelefonePorId(Long id) throws TelefoneException {
		if(telRepo.existsById(id)) {
			telRepo.deleteById(id);
		}else {
			throw new TelefoneException("Telefone com id:" + id + "não existe!");
		}
	}
	
	public void excluirTelefone(Telefone tel) throws TelefoneException {
		if(telRepo.existsById(tel.getId_telefone())) {
			telRepo.delete(tel);
		}else {
			throw new TelefoneException("Telefone " + tel.getTel_principal() + " não existe!");
		}
	}
	
}
