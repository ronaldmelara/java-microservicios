package com.usuario.service.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.feignClients.AutoFeignClient;
import com.usuario.service.modelos.Auto;
import com.usuario.service.modelos.Moto;
import com.usuario.service.repositorio.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AutoFeignClient autoForeignClient;

	public List<Auto> getAutos(int usuarioId) {
		List<Auto> autos = restTemplate.getForObject("http://localhost:8002/auto/usuario/" + usuarioId, List.class);
		return autos;
	}

	public List<Moto> getMotos(int usuarioId) {
		List<Moto> motos = restTemplate.getForObject("http://localhost:8003/moto/usuario/" + usuarioId, List.class);
		return motos;
	}

	
	public Auto saveAuto(int usuarioId, Auto auto) {
		auto.setUsuarioId(usuarioId);
		Auto nuevoAuto = autoForeignClient.save(auto);
		return nuevoAuto;
	}
	public List<Usuario> getAll() {
		return usuarioRepository.findAll();
	}

	public Usuario getUsuarioById(int id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	public Usuario save(Usuario usuario) {
		Usuario nuevoUsuario = usuarioRepository.save(usuario);
		return nuevoUsuario;
	}
}
