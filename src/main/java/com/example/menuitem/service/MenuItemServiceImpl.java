package com.example.menuitem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.menuitem.exception.*;
import com.example.menuitem.entity.MenuItem;
import com.example.menuitem.repository.MenuItemRepository;
@Service
@Transactional
public class MenuItemServiceImpl implements MenuItemService{
@Autowired
MenuItemRepository menuRepo;
	@Override
	public List<MenuItem> getMenuItemList() {
		// TODO Auto-generated method stub
		List<MenuItem> list=menuRepo.findAll();
		if(list.isEmpty()==false) {
			return list;
			}
		else
			throw new ListEmptyException();
	}

	@Override
	public MenuItem getMenuItem(int menuItemId) {
		// TODO Auto-generated method stub
		MenuItem menuItem=menuRepo.findById(menuItemId).orElse(null);
		if(menuItem!=null) {
			return menuItem;}
		else
      throw new MenuItemNotFoundException();
		
	}

	@Override
	public MenuItem addMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		menuItem=menuRepo.save(menuItem);
		return menuItem;
	}

	@Override
	public MenuItem modifyMenuItem(int menuItemId,MenuItem menuItem) {
		// TODO Auto-generated method stub
		if(menuItem!=null) {
			menuItem.setId(menuItemId);
			menuItem = menuRepo.save(menuItem);
			return menuItem;
		}
		else
		throw new MenuItemNotFoundException();
		
	}

}
