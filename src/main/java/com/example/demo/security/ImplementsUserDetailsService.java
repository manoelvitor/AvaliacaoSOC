package com.example.demo.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UsuarioEntity;
import com.example.demo.repository.UsuarioRepository;


@Service
public class ImplementsUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository ur;
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		UsuarioEntity usuario = ur.findByLogin(login);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}
		return usuario;
	}

}
