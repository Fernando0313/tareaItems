package idat.com.repository;

import java.util.List;

import idat.com.model.Items;



public interface ItemRepository {

	public void guardarItem(Items items);
	public void editarItem(Items items);
	public void eliminarItem(Integer id);
	public List<Items> listarItems();
	public Items obtenerItemId(Integer id);
	
}
