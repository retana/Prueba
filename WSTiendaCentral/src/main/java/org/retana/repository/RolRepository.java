package org.retana.repository;

import java.util.List;

import org.retana.bean.Rol;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "rol")
public interface RolRepository extends PagingAndSortingRepository<Rol, Integer>{
	public List<Rol> findByIdRol(Integer id);
	public List<Rol> findAll();
}
