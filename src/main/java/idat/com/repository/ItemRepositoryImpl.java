package idat.com.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import idat.com.model.Items;


@Repository
public class ItemRepositoryImpl implements ItemRepository{

	public List<Items> listar = new ArrayList<Items>();

	
	@Override
	public void guardarItem(Items items) {
		// TODO Auto-generated method stub
		listar.add(items);
		
	}

	@Override
	public void editarItem(Items items) {
		// TODO Auto-generated method stub
		listar.remove(obtenerItemId(items.getIdItem()));
		listar.add(items);
	}

	@Override
	public void eliminarItem(Integer id) {
		// TODO Auto-generated method stub
		listar.remove(obtenerItemId(id));
	}

	@Override
	public List<Items> listarItems() {
		// TODO Auto-generated method stub
		return listar;
	}

	@Override
	public Items obtenerItemId(Integer id) {
		// TODO Auto-generated method stub
		return listar.stream().filter(items -> items.getIdItem()==id).findFirst().orElse(null);
	}

}
