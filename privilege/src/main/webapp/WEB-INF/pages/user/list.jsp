<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
					url : 'user/dataList.action',
					idField : 'id',
					columns : [ [ {
						field : 'id',
						title : 'id',
						width : 100,
						sortable : true,
					}, {
						field : 'username',
						title : 'username',
						width : 100,
						editor : {
							type : 'validatebox',
							options : {}
						},
						sortable : true,
					}, {
						field : 'password',
						title : 'password',
						width : 100,
						editor : {
							type : 'validatebox',
							options : {}
						},
						sortable : true,
					},{
						field : 'roles',
						title : 'roleName',
						width : 100,
						sortable : true,
					}, 
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
										url : 'user/delete.action',
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
							hiddenDiv();
							$('#datalist').datagrid('endEdit', editIndex);
							editIndex =  selectedIndex;
						}
					},
					onAfterEdit : function(rowIndex, rowData, changes) {
						var url = 'user/add.action';
						var data = changes;
						console.info(rowData);
						if (rowData.id != null) {
							url = 'user/update.action';
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
				url : 'user/delete.action',
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
	 function setRoles(){
		 var userID = $('#datalist').datagrid('getSelected').id;
		 var roleID = $('input[name=roles]:checked').val();
		 $.ajax({
			 type: "POST",
			   url: "user/setRole.action",
			   traditional:true,
			   data: {'userID':userID,'roleID':roleID},
			   success: function(msg){
			     alert( "Data Saved: " + msg );
			   }
		 });
	 }
	 function selectRoles(){
		 var userID = $('#datalist').datagrid('getSelected').id;
		 $.ajax({
			 type: "POST",
			   url: "user/selectRoles.action",
			   traditional:true,
			   data: {'id':userID},
			   success: function(msg){
					
				   var role = $('input[name=roles]')
				   for(var i = 0;i<role.size();i++){
					   role[i].checked = false;
					   if(msg.length>0 && role[i].value == msg[0].id){
						   role[i].checked = true;
				  	   }
					}
				   var div = $('div[name=roleDiv]');
				   div.style="display:block";
				   console.info(div[0]);
			   }
		 });
		showDiv();
		
	 }
	function showDiv(){
 		$('#roleDiv').css('display','block');
	}
	function hiddenDiv(){
 		$('#roleDiv').css('display','none');
 	}
	</script>
	<style type="text/css">
		#roleDiv{
			display:none;
		}
	</style>	<div style="position: relative; float: left; width: 50%; height: 100%;">
		<table id="datalist" height="100%"></table>
	</div>
	
	<div id="rightMenu" style="width: 120px;">
		<div onclick="addRow1()" iconCls="icon-add">增加</div>
		<div onclick="removeRow1()" iconCls="icon-remove">删除</div>
		<div onclick="editRow1()" iconCls="icon-edit">修改</div>
		<div onclick="selectRoles()" iconCls="icon-set">查看角色</div>
	</div>
	
	<div  id ="roleDiv" style="position: relative; float: left; width: 50%; height: 100%; background-color:#ff5; ">
				<label style="position: relative; top: 100px;">设置角色</label>

			<div  style="padding:20px; line-height:100%; relative; float: left;">
				<c:forEach var="item" items="${roles}">
					<input name="roles" type="radio" value="${item.id }"/> ${item.roleName }
				</c:forEach>
			</div>

		<a href="#" onclick="setRoles()">确定</a>
	</div>
	
	
	
</body>
</html>