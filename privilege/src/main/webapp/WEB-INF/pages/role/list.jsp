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
					url : 'role/dataList.action',
					idField : 'id',
					columns : [ [ {
						field : 'id',
						title : 'id',
						width : 100,
						sortable : true,
					}, {
						field : 'roleName',
						title : 'roleName',
						width : 100,
						editor : {
							type : 'validatebox',
							options : {}
						},
						sortable : true,
					}, {
						field : 'roleDesc',
						title : 'roleDesc',
						width : 100,
						editor : {
							type : 'validatebox',
							options : {}
						},
						sortable : true,
					}
					] ],

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
										url : 'role/delete.action',
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
							hiddenPrivileges();
							hiddenUsers();
							$('#datalist').datagrid('endEdit', editIndex);
							
							editIndex =  selectedIndex;
						}
						
					},
					onAfterEdit : function(rowIndex, rowData, changes) {
						var url = 'role/add.action';
						var data = changes;
						if (rowData.id != null) {
							url = 'role/update.action';
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
				url : 'role/delete.action',
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
	 //设置权限
	 	function setPrivilege(){
			var checked = $('#privilegeTree').tree('getChecked');
			
			var row =$('#datalist').datagrid('getSelected');
			var data = new Array();
			data[0] = row.id;
			for(var i=0;i<checked.length;i++){
				data[i+1]=checked[i].id;
			}
			$.ajax({
				 type: "POST",
				   url: "role/setPrivilege.action",
				   traditional:true,
				   data: {'data':data},
				   success: function(msg){
				     alert( "Data Saved: " + msg );
				   }

			});
		}
	 	//加载权限树
		function loadTree(){
			showPrivileges();
			var  roleID = $('#datalist').datagrid('getSelected').id;
			$('#privilegeTree').tree({    
			    url:"role/selectPrivileges.action",
			    animate:true,
			    lines:true,
			    queryParams:{'roleID':roleID},
			    checkbox:true,
			    onLoadSuccess:function( node, data ){
			    	$('#privilegeTree').tree('expandAll');    
			    }
			}); 
		}
	 	function hiddenPrivileges(){
	 		$('#privilegeDiv').css('display','none');
	 	}
	 	
	 	function showPrivileges(){
	 		$('#privilegeDiv').css('display','block');
	 	}
	 	
	 	function hiddenUsers(){
	 		$('#usersDiv').css('display','none');
	 	}
	 	
	 	function showUsers(){
	 		$('#usersDiv').css('display','block');
	 	}
	 	function selectUsers(){
	 		showUsers();
	 		var  roleID = $('#datalist').datagrid('getSelected').id;
	 		$('#userSelect').combobox({
	 			multiple:true,
	 			queryParams:{'id':roleID},
	 		    url:'role/selectUsers.action',    
	 		    valueField:'id',    
	 		    textField:'text',
	 		   
	 		});  
	 	}
	 	function setUsers(){
	 		var  roleID = $('#datalist').datagrid('getSelected').id;
	 		var usersID =$('#userSelect').combobox('getValues');
	 		var data = new Array();
	 		data[0] = roleID;
	 		for(var i = 0;i<usersID.length;i++){
	 			var userID = usersID[i];
	 			data[i+1] = userID;
	 		}
	 		$.ajax({
	 			type:'post',
	 			url:'role/setUsers.action',
	 			traditional:true,
	 			data:{'data':data},
	 			datatype:'json',
	 			success:function(msg){
	 				$('#userSelect').combobox('reload');
	 			}
	 		});
	 	}
	 	
	</script>
	<style type="text/css">
		#privilegeDiv{
			display:none;
		}
		#usersDiv{
			display:none;
		}
	</style>
	<div style="position: relative; float: left; width: 50%; height: 100%;">
		<table id="datalist" height="100%"></table>
	</div>
	<div id="rightMenu" style="width: 120px;">
		<div onclick="addRow1()" iconCls="icon-add">增加</div>
		<div onclick="removeRow1()" iconCls="icon-remove">删除</div>
		<div onclick="editRow1()" iconCls="icon-edit">修改</div>
		<div onclick="loadTree()" >查看权限</div>
		<div onclick="selectUsers()" >查看用户 </div>
	</div>

	<div id="privilegeDiv" style=" position: relative; float: left; width: 20%; height: 100%; padding-top: 30px;">
		<center>
		<ul id="privilegeTree"></ul>
		<a href="#" onclick="setPrivilege()">设置权限</a>
		</center>
	</div>
	<div id="usersDiv"  style=" position: relative; float: left; width: 30%; height: 100%; padding-top: 30px;">
		<input id="userSelect" style="width: auto;"/>
		<a href="#" onclick="setUsers()">选择用户</a>
	</div>

</body>
</html>




