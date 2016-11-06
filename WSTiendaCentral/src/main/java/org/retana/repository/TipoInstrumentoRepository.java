package org.retana.repository;

import java.util.List;

import org.retana.bean.TipoInstrumento;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "tipoInstrumento")
public interface TipoInstrumentoRepository extends PagingAndSortingRepository<TipoInstrumento, Integer>{
	public List<TipoInstrumento> findAll();
}
