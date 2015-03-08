package com.privilege.tree;

import java.io.Serializable;
import java.util.Map;

public class EasyuiTreeNode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//：节点ID，对加载远程数据很重要。
	private String text;//：显示节点文本。
	private String state;//：节点状态，'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点。
	private boolean checked;//：表示该节点是否被选中。
	private Map<String, Object> attributes;//: 被添加到节点的自定义属性。
	private EasyuiTreeNode[] children; //: 一个节点数组声明了若干节点。
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public Map getAttributes() {
		return attributes;
	}
	public void setAttributes(Map attributes) {
		this.attributes = attributes;
	}
	public EasyuiTreeNode[] getChildren() {
		return children;
	}
	public void setChildren(EasyuiTreeNode[] children) {
		this.children = children;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
