package org.retana.repository;

import java.util.List;

import org.retana.bean.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "usuario")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Integer>{	
	public List<Usuario> findByIdUsuario(Integer id);
	public Usuario findByEmail(@Param("email") String  email);
	public List<Usuario> findAll();
}
