/**
 * 一句话描述该类：文件类VO<br/>
 * @author 黄记新
 * @date 2015-11-10,下午12:12:01
 *
 */
package com.jcin.cms.modules.channel.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FileVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private List<FileVO> children = new ArrayList<FileVO>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FileVO> getChildren() {
		return children;
	}

	public void setChildren(List<FileVO> children) {
		this.children = children;
	}

	public String getId() {
		return name;
	}

	public String getText() {
		/*if(name!=null){
			int dot = name.indexOf(".jsp");
//			int html = name.indexOf(".html");
			if(dot!=-1){
				dot = name.indexOf(".");
				name = name.substring(0, dot);
			}
		}*/
		return name;
	}
}
