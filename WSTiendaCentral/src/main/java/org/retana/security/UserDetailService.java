package org.retana.security;

import java.util.HashSet;
import java.util.Set;

import org.retana.bean.Usuario;
import org.retana.repository.UsuarioRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailService implements UserDetailsService{
	private UsuarioRepository usuarioRepository;
	public  UserDetailService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository=usuarioRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		try {
			Usuario usuario=usuarioRepository.findByEmail(email);
			if(usuario==null){
				return null;
			}
			return new User(usuario.getEmail(),usuario.getContrasena(),getAuthorities(usuario));
		} catch (Exception e) {
			throw new UsernameNotFoundException("Verifique sus credenciales, Usuario no encontrado");
		}
	}
	public Set<GrantedAuthority> getAuthorities(Usuario usuario){
		Set<GrantedAuthority> authorities=new HashSet<GrantedAuthority>();
		GrantedAuthority grantedAuthority=new SimpleGrantedAuthority(usuario.getRol().getNombre());
		authorities.add(grantedAuthority);
		return authorities;
	}
}
