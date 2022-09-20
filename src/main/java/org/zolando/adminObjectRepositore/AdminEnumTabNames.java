package org.zolando.adminObjectRepositore;

public enum AdminEnumTabNames {
	ORDER_MANAGEMEN("Order Management"), MANAGE_USERS("Manage users"), CREATE_CATEGORY("Create Category"),
	SUB_CATEGORY("Sub Category"), INSERT_PRODUCT("Insert Product"), MANAGE_PRODUCTS("Manage Products"),
	USER_LOGIN_LOG("User Login Log"), CHANGE_PASSWORD("Change Password");
	
	String tabName;
	private AdminEnumTabNames(String tabName) {
		this.tabName=tabName;
	}
	
	public String getTabName() {
		return tabName;
	}
}
