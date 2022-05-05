package idat.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.com.model.Items;
import idat.com.repository.ItemRepository;

@Service
public class ItemsServiceImpl implements ItemService{

	@Autowired
	public ItemRepository repo;
	
	@Override
	public void guardarItem(Items items) {
		// TODO Auto-generated method stub
		repo.guardarItem(items);
	}

	@Override
	public void editarItem(Items items) {
		// TODO Auto-generated method stub
		
		repo.editarItem(items);
	}

	@Override
	public void eliminarItem(Integer id) {
		// TODO Auto-generated method stub
		repo.eliminarItem(id);
	}

	@Override
	public List<Items> listarItem() {
		// TODO Auto-generated method stub
		return repo.listarItems();
	}

	@Override
	public Items obtenerItemId(Integer id) {
		// TODO Auto-generated method stub
		return repo.obtenerItemId(id);
	}

}
