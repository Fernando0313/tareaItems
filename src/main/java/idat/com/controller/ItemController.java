package idat.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import idat.com.model.Items;
import idat.com.service.ItemService;

@RestController
@RequestMapping("/item/v1")
public class ItemController {

	@Autowired
	private ItemService serv;
	
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Items>> listarItems(){
		
		return new ResponseEntity<List<Items>>(serv.listarItem(), HttpStatus.CREATED);  
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Items item){
		
		
		
		serv.guardarItem(item);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@RequestMapping(path = "/listar/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Items> listarPorId(@PathVariable Integer id) {
		
		Items p = serv.obtenerItemId(id);
		if(p != null)
			return new ResponseEntity<Items>(p, HttpStatus.OK);
		
		return new ResponseEntity<Items>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Items producto){
		
		Items p = serv.obtenerItemId(producto.getIdItem());

		if(p != null) {
			serv.editarItem(producto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		Items p = serv.obtenerItemId(id);
		if(p != null) {
			serv.eliminarItem(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		
	}
	
}
