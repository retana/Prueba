package org.retana.repository;

import java.util.List;

import org.retana.bean.Pais;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource( path = "pais")
public interface PaisRepository extends PagingAndSortingRepository<Pais, Integer>{
	public List<Pais> findAll();
	public List<Pais> findByIdPais(Integer id);
}
