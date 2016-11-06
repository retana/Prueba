package org.retana.repository;

import java.util.List;

import org.retana.bean.Producto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.lang.Integer;
import java.lang.String;


@RepositoryRestResource(path = "producto")
public interface ProductoRepository extends PagingAndSortingRepository<Producto, Integer>{
	public List<Producto> findAll();
	public List<Producto> findByModelo(@Param("modelo") String modelo);
}
