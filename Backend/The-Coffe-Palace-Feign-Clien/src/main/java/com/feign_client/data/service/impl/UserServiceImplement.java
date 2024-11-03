package com.feign_client.data.service.impl;

import com.feign_client.data.model.Usuario;
import com.feign_client.data.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = repository.findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("No existe usuario con el correo: " + email));
        return new UserDetailImplement(usuario);
    }
}
