<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<script type="text/javascript" charset="utf-8">
	$(function() {
		var selectedIndex;
		var selectedRow;
		var editIndex;
		$('#rightMenu').menu({    
		    onClick:function(item){    
		        //...    
		    }    
		});  
		$('#datalist').datagrid(
				{
					url : 'privilege/dataList.action',
					idField : 'id',
					columns : [ [ {
						field : 'id',
						title : 'id',
						width : 100,
						sortable : true,
					}, {
						field : 'pid',
						title : 'pid',
						width : 100,
						editor : {
							type : 'validatebox',
							options : {}
						},
						sortable : true,
					},{
						field : 'privilegeName',
						title : 'privilegeName',
						width : 100,
						editor : {
							type : 'validatebox',
							options : {}
						},
						sortable : true,
					}, {
						field : 'url',
						title : 'url',
						width : 100,
						editor : {
							type : 'validatebox',
							options : {}
						},
						sortable : true,
					}, {
						field : 'icon',
						title : 'icon',
						width : 100,
						editor : {
							type : 'validatebox',
							options : {}
						},
						sortable : true,
					}, {
						field : 'orderNumber',
						title : 'orderNumber',
						width : 100,
						editor : {
							type : 'validatebox',
							options : {}
						},
						sortable : true,
					} ] ],

					toolbar : [
							{
								iconCls : 'icon-add',
								handler : function() {
									$('#datalist').datagrid('appendRow',
											{});
									editIndex = $('#datalist').datagrid(
											'getRows').length - 1;
									$('#datalist').datagrid('beginEdit',
											editIndex);
								}
							},
							'-',
							{
								iconCls : 'icon-remove',
								handler : function() {
									$.ajax({
										url : 'privilege/delete.action',
										type : 'post',
										data : {
											'id' : selectedRow.id
										},
										dataType : 'json',
										success : function(r) {
											if (r && r.success) {
												$('#datalist').datagrid(
														'load');
											}
										}
									});
								}
							}, '-', {
								iconCls : 'icon-edit',
								handler : function() {
									alert('编辑')
								}
							}, '-', {
								iconCls : 'icon-help',
								handler : function() {
									alert('帮助')
								}
							} ],

					rownumbers : true,
					pagination : true,
					fitColumns : true,
					pageSize : 20,
					pageList : [ 10, 20, 30 ],
					singleSelect : true,
					onSelect : function(rowIndex, rowData) {
						selectedRow = rowData;
						selectedIndex = rowIndex;
						if (editIndex != selectedIndex) {
							hiddenRoles();
							$('#datalist').datagrid('endEdit', editIndex);
							editIndex =  selectedIndex;
						}
					},
					onAfterEdit : function(rowIndex, rowData, changes) {
						var url = 'privilege/add.action';
						var data = changes;
						console.info(rowData);
						if (rowData.id != null) {
							url = 'privilege/update.action';
						}
						$.ajax({
							url : url,
							type : 'post',
							data : rowData,
							dataType : 'json',
							success : function(r) {
								if (r && r.success) {
									$('#datalist').datagrid(
											'load');
								}
							}
						});
					},
					onDblClickRow : function(rowIndex, rowData) {
						$('#datalist').datagrid('beginEdit', rowIndex);
						editIndex = rowIndex;
					},
					onRowContextMenu : function(e, rowIndex, rowData) {
						console.info(e);
						e.preventDefault();
						$('#rightMenu').menu('show', {    
							  left: e.pageX,    
							  top: e.pageY,
							});  
						$(this).datagrid('unselectAll');
						$(this).datagrid('selectRow',rowIndex);
						editIndex = rowIndex;
					},

				});
	});
	function editRow1(){
		var row = $('#datalist').datagrid('getSelected');
		var rowIndex = $('#datalist').datagrid('getRowIndex',row);
		$('#datalist').datagrid('beginEdit', rowIndex);
	}
	function addRow1() {
		var row = $('#datalist').datagrid('getSelected');
		var rowIndex = $('#datalist').datagrid('getRowIndex',row);
			$('#datalist').datagrid('insertRow',{index:rowIndex+1,row:{}});
			$('#datalist').datagrid('selectRow',rowIndex+1);
			$('#datalist').datagrid('beginEdit',
					rowIndex+1);
	}
	 function removeRow1() {
		 var selectedRow = $('#datalist').datagrid('getSelected');
			$.ajax({
				url : 'privilege/delete.action',
				type : 'post',
				data : {
					'id' : selectedRow.id
				},
				dataType : 'json',
				success : function(r) {
					if (r && r.success) {
						$('#datalist').datagrid(
								'load');
					}
				}
			});
		}
	 function selectRoles(){
		 	showRoles();
	 		var  privilegeID = $('#datalist').datagrid('getSelected').id;
	 		$('#roleSelect').combobox({
	 			multiple:true,
	 			queryParams:{'id':privilegeID},
	 		    url:'privilege/selectRoles.action',    
	 		    valueField:'id',    
	 		    textField:'text',
	 		   
	 		});  
	 	}
	 function setRoles(){
			var  privilegeID = $('#datalist').datagrid('getSelected').id;
	 		var rolesID =$('#roleSelect').combobox('getValues');
	 		var data = new Array();
	 		data[0] = privilegeID;
	 		for(var i = 0;i<rolesID.length;i++){
	 			var roleID = rolesID[i];
	 			data[i+1] = roleID;
	 		}
	 		$.ajax({
	 			type:'post',
	 			url:'privilege/setRoles.action',
	 			traditional:true,
	 			data:{'data':data},
	 			datatype:'json',
	 			success:function(msg){
	 				$('#roleSelect').combobox('reload');
	 			}
	 		});
	 	}
	function showRoles(){
 		$('#rolesDiv').css('display','block');
	}
	function hiddenRoles(){
 		$('#rolesDiv').css('display','none');
 	}
	 
	 
	</script>
	<style type="text/css">
		#rolesDiv{
			display: none;
		}
	</style>
	<div id="datadiv" style="position: relative; float: left; width: 50%; height: 100%;">
			<table id="datalist"></table>
	</div>
	<div id="rightMenu" style="width: 120px;">
		<div onclick="addRow1()" iconCls="icon-add">增加</div>
		<div onclick="removeRow1()" iconCls="icon-remove">删除</div>
		<div onclick="editRow1()" iconCls="icon-edit">修改</div>
		<div onclick="selectRoles()">查看角色</div>
	</div>
	<div style="position: relative; float: left; width: 50%; height: 100%;">
		<div id="rolesDiv"  style=" position: relative; float:left; width: 50%; height: 100%; padding-top: 30px; padding-left:100px;  margin: auto;">
			<input id="roleSelect" style="width: auto;"/>
			<a href="#" onclick="setRoles()">设置角色</a>
		</div>
	</div>
	
</body>
</html>