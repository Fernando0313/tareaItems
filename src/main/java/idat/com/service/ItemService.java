package idat.com.service;

import java.util.List;


import idat.com.model.Items;

public interface ItemService {

	public void guardarItem(Items items);
	public void editarItem(Items items);
	public void eliminarItem(Integer id);
	public List<Items> listarItem();
	public Items obtenerItemId(Integer id);
}
