package org.retana.repository;

import java.util.List;

import org.retana.bean.Marca;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "marca")
public interface MarcaRepository extends PagingAndSortingRepository<Marca, Integer>{
	public List<Marca> findAll();
	public List<Marca> findByIdMarca(Integer idMarca);
}
