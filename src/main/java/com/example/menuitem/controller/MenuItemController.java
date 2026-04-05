package com.example.menuitem.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.menuitem.entity.MenuItem;
import com.example.menuitem.service.MenuItemService;

@RestController
@RequestMapping(value = "/menuitem")
public class MenuItemController {
	@Autowired
	MenuItemService service;
	
	@PutMapping(value = "/modifymenuitem/{id}")
	public ResponseEntity<MenuItem> modifyMenuItem (@PathVariable Integer id,@RequestBody MenuItem menuItem){
		menuItem = service.modifyMenuItem(id,menuItem);
		ResponseEntity<MenuItem> response = new ResponseEntity<MenuItem>(menuItem,HttpStatus.OK);
		return response;
	}
	@GetMapping(value = "/getallmenuitems")
	public ResponseEntity<List<MenuItem>> getMenuItemList(){
		List<MenuItem> list = service.getMenuItemList();
		ResponseEntity<List<MenuItem>> response = new ResponseEntity<List<MenuItem>>(list,HttpStatus.OK);
		return response;
	}

	@GetMapping(value = "/getmenuitem/{id}")
	public ResponseEntity<MenuItem> getMenuItem(@PathVariable Integer id){
		MenuItem menuItem  = service.getMenuItem(id);
		ResponseEntity<MenuItem> response = new ResponseEntity<MenuItem>(menuItem,HttpStatus.OK);
		return response;
	}
	@PostMapping(value = "/addmenuitem")
	public ResponseEntity<MenuItem> addMenuItem (@RequestBody @Valid MenuItem menuItem){
		menuItem = service.addMenuItem(menuItem);
		ResponseEntity<MenuItem> response = new ResponseEntity<MenuItem>(menuItem,HttpStatus.OK);
		return response;
	}
}
