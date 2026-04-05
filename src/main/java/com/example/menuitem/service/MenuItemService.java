package com.example.menuitem.service;
import java.util.List;

import com.example.menuitem.entity.*;

public interface MenuItemService {
	public List<MenuItem> getMenuItemList();
	public MenuItem getMenuItem(int menuItemId);
	public MenuItem addMenuItem(MenuItem menuItem);
	public MenuItem modifyMenuItem(int menuItemId,MenuItem menuItem);

}
