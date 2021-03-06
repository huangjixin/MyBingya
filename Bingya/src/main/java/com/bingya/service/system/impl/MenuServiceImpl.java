/**
 * 
 */
package com.bingya.service.system.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.json.JSONObject;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bingya.dao.system.MenuMapper;
import com.bingya.dao.system.RoleMenuMapper;
import com.bingya.domain.system.Menu;
import com.bingya.domain.system.MenuExample;
import com.bingya.domain.system.RoleMenu;
import com.bingya.domain.system.RoleMenuExample;
import com.bingya.domain.system.UserExample;
import com.bingya.service.system.IMenuService;
import com.bingya.util.Page;

import flexjson.JSONException;

/**
 * @author huangjixin
 * 
 */
@Transactional
@Service(value = "menuService")
@RemotingDestination(value="menuServiceImpl",channels={"my-amf"})
public class MenuServiceImpl implements IMenuService {

	// ---------------------------------------------------
	// 常量（全部大写，用下划线分割），变量 （先常后私）
	// ---------------------------------------------------
	@Resource
	private MenuMapper menuMapper;
	@Resource
	private RoleMenuMapper roleMenuMapper;

	private String url;

	// ---------------------------------------------------
	// public 公有方法
	// ---------------------------------------------------
	/*
	 * 根据Id删除菜单，子菜单也会被删除。
	 * 
	 * @see
	 * com.mvcbasic.service.sys.IGenericService#deleteByPrimaryKey(java.lang
	 * .Integer)
	 */
	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		// 外键删除；
		RoleMenuExample roleMenuExample = new RoleMenuExample();
		roleMenuExample.createCriteria().andMenuIdEqualTo(id);
		List<RoleMenu> roleMenuList = roleMenuMapper
				.selectByExample(roleMenuExample);
		for (RoleMenu roleMenu : roleMenuList) {
			roleMenuMapper.deleteByPrimaryKey(roleMenu.getId());
		}

		List<Menu> menuList = getByParentId(id, null);
		for (Menu menu : menuList) {
			deleteByPrimaryKey(menu.getId());
		}
		// 外键删除完毕；
		int i = menuMapper.deleteByPrimaryKey(id);
		return i;
	}

	/*
	 * 添加菜单。
	 * 
	 * @see
	 * com.mvcbasic.service.sys.IGenericService#insert(java.io.Serializable)
	 */
	@Override
	public String insert(Menu entity) {
//		Date date = new Date();
//		Long time = date.getTime();
		// entity.setId(time);
		if(entity.getId()==null||"".equals(entity.getId())){
			 int count = menuMapper.countByExample(new MenuExample());
			 entity.setId(count+1+"");
		}
		if ("".equals(entity.getParentid())) {
			entity.setParentid(null);
		}
		menuMapper.insertSelective(entity);

		return entity.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mvcbasic.service.sys.IGenericService#selectAll()
	 */
	@Override
	public List<Menu> selectAll() {
		return menuMapper.selectByExample(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mvcbasic.service.sys.IGenericService#selectByPrimaryKey(java.lang
	 * .Integer)
	 */
	@Override
	public Menu selectByPrimaryKey(String id) {

		return menuMapper.selectByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mvcbasic.service.sys.IGenericService#update(java.io.Serializable)
	 */
	@Override
	public String update(Menu entity) {
		return menuMapper.updateByExampleSelective(entity, null) + "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mvcbasic.service.sys.IGenericService#query(com.mvcbasic.util.Page,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public Page query(Page page, String key, String orderCondition) {
		key = "%" + key + "%";
		MenuExample menuExample = new MenuExample();
		// menuExample.createCriteria().andDescriptionLike(key);
		menuExample.setPage(page);
		int total = menuMapper.countByExample(menuExample);
		page.setTotal(total);
		List<Menu> list = menuMapper.selectByExample(menuExample);
		page.setRows(list);
		return page;
	}

	@Override
	public List getMenuTreeByRoleId(String roleId) {
		MenuExample menuExample = new MenuExample();
		menuExample.createCriteria().andParentidIsNull();

		List<Menu> list = menuMapper.selectByExample(menuExample);
		List<RoleMenu> roleMenus = null;
		if (roleId != null) {
			RoleMenuExample roleMenuExample = new RoleMenuExample();
			roleMenuExample.createCriteria().andRoleIdEqualTo(roleId);
			roleMenus = roleMenuMapper.selectByExample(roleMenuExample);
			for (Menu menu : list) {
				Boolean flag = false;
				for (RoleMenu roleMenu : roleMenus) {
					if (roleMenu.getMenuId().equals(menu.getId())) {
						flag = true;
						break;
					}
				}
				if (false == flag) {
					list.remove(menu);
				}
			}
		}

		List children = new ArrayList();
		try {
			for (Menu object : list) {
				JSONObject jsonObject;

				jsonObject = searialMenu(object, roleMenus);
				children.add(jsonObject);
			}
		} catch (org.json.JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return children;
	}

	@Override
	public List<Menu> getByParentId(String id, List<RoleMenu> roleMenus) {
		MenuExample menuExample = new MenuExample();
		menuExample.createCriteria().andParentidEqualTo(id);
		List<Menu> list = menuMapper.selectByExample(menuExample);
		if (roleMenus != null) {
			for (Menu menu : list) {
				Boolean flag = false;
				for (RoleMenu roleMenu : roleMenus) {
					if (roleMenu.getMenuId().equals(menu.getId())) {
						flag = true;
						break;
					}
				}
				if (false == flag) {
					list.remove(menu);
				}
			}
		}

		return list;
	}

	@Override
	public String getMenuXmlStr(String basePath) {
		this.url = basePath;

		MenuExample menuExample = new MenuExample();
		menuExample.createCriteria().andParentidIsNull();

		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("ul");
		List<Menu> list = menuMapper.selectByExample(menuExample);
		for (Menu object : list) {
			Element element = searialMenuToElement(object, root, 0);
		}
		return doc.asXML();
	}

	/*
	 * 将菜单序列化为xml字符串。
	 * 
	 * @see
	 * com.bingya.service.system.IMenuService#SerializMenuToXml(java.lang.String
	 * )
	 */
	@Override
	public String serializMenuToXml(String roleId) {
		MenuExample menuExample = new MenuExample();
		menuExample.createCriteria().andParentidIsNull();

		List<Menu> list = menuMapper.selectByExample(menuExample);// 查询出来所有菜单。

		List<RoleMenu> roleMenus = null;
		if (roleId != null) { // 过滤没有权限的菜单
			RoleMenuExample roleMenuExample = new RoleMenuExample();
			roleMenuExample.createCriteria().andRoleIdEqualTo(roleId);
			roleMenus = roleMenuMapper.selectByExample(roleMenuExample);
			List<Menu> toBeRemovedList = new ArrayList<Menu>();
			for (Menu menu : list) {
				Boolean flag = false;
				for (RoleMenu roleMenu : roleMenus) {
					if (roleMenu.getMenuId().equals(menu.getId())) {
						flag = true;
						break;
					}
				}
				if (false == flag) {
					toBeRemovedList.add(menu);
				}
			}
			for (Menu menu : toBeRemovedList) {
				list.remove(menu);
			}
		}

		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("MenuItem");
		for (Menu object : list) {
			searialMenuToElementForFlex(object, root, 0, roleMenus);
		}
		return doc.asXML();
	}

	// ---------------------------------------------------
	// protected 方法
	// ---------------------------------------------------

	// ---------------------------------------------------
	// private 私有方法
	// ---------------------------------------------------

	public JSONObject searialMenu(Menu menu, List<RoleMenu> roleMenus)
			throws org.json.JSONException {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("id", menu.getId());
			jsonObject.put("parentid", menu.getParentid());
			jsonObject.put("name", menu.getName());

			List list = searialChild(menu, roleMenus);
			if (null != list) {
				jsonObject.put("children", list);
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObject;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List searialChild(Menu menu, List<RoleMenu> roleMenus) {
		List children = null;
		List<Menu> list = getByParentId(menu.getId(), roleMenus);
		if (list != null && list.size() > 0) {
			children = new ArrayList();
		}
		try {
			for (Menu object : list) {
				JSONObject jsonObject = searialMenu(object, roleMenus);
				children.add(jsonObject);
			}
		} catch (Exception e) {

		}
		return children;
	}

	/**
	 * 序列化菜单为Element。
	 * 
	 * @param menu
	 * @return
	 */
	private Element searialMenuToElement(Menu menu, Element parentEle,
			Integer index) {
		Element element = parentEle.addElement("li");
		Element hrefElement = element.addElement("a");
		hrefElement.addText(menu.getName());
		if (null != menu.getPath()) {
			hrefElement.addAttribute("href", url + menu.getPath());
		} else {
			hrefElement.addAttribute("href", url + "#");
		}

		searialChildToElement(menu, element, index);

		return element;
	}

	private Element searialChildToElement(Menu menu, Element parentEle,
			Integer index) {
		Element element = null;

		List<Menu> list = getByParentId(menu.getId(), null);
		if (list != null && list.size() > 0) {
			Element hrefElement = parentEle.element("a");
			hrefElement.addAttribute("class", "sub" + index);
			@SuppressWarnings("unused")
			Attribute attribute = hrefElement.attribute("class");
			// if(attribute == null){
			// parentEle.addAttribute("class", "parent");
			// }
			element = parentEle.addElement("ul");

			for (Menu object : list) {
				searialMenuToElement(object, element, index + 1);
			}
		}

		return element;
	}

	/**
	 * 序列化菜单为Element。
	 * 
	 * @param menu
	 * @return
	 */
	private Element searialMenuToElementForFlex(Menu menu, Element parentEle,
			Integer index, List<RoleMenu> roleMenus) {
		Element element = parentEle.addElement("MenuItem");
		element.addAttribute("id", menu.getId());
		element.addAttribute("name", menu.getName());
		element.addAttribute("parentId", menu.getParentid());
		element.addAttribute("path", menu.getPath());
		element.addAttribute("icon", menu.getIcon());

		searialChildToElementForFlex(menu, element, index, roleMenus);

		return element;
	}

	private Element searialChildToElementForFlex(Menu menu, Element parentEle,
			Integer index, List<RoleMenu> roleMenus) {
		Element element = null;

		List<Menu> list = getByParentId(menu.getId(), roleMenus);
		if (list != null && list.size() > 0) {
			for (Menu object : list) {
				searialMenuToElementForFlex(object, parentEle, index + 1,
						roleMenus);
			}
		}

		return element;
	}

}
// 不使用Spring，怎样能在Listener启动的Thread中获取web目录，还真不完全确定。其实我觉得实际代码也很简单。
// 就是基于普通的listener，然后在listener中获取web目录并放到JRE全局变量中。
//
// 但使用Spring，就可以用一种比较优雅的方式来获取了。
//
// 在web.xml中的<web-app>节点内加入：
//
//
// <context-param>
// <param-name>webAppRootKey</param-name>
// <param-value>tansungWeb.root</param-value>
// </context-param>
// <listener>
// <listener-class>org.springframework.web.util.WebAppRootListener</listener-class>
// </listener>
//
// 然后在普通的Java类中（不是action中），就可以通过System.getProperty("tansungWeb.root")获取了web根目录了。
//
// 然后再拼凑路径的时候，最好不要直接使用/或者\，最好使用File.separatorChar
// 参考：http://blog.csdn.net/hellostory/archive/2010/12/30/6106930.aspx
//
// 这样的做法，适用于Spring配置中启动的线程需要获取web目录。例如删除临时文件的线程，定时发送邮件的线程。