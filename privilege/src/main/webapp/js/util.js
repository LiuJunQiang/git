
$(function(){
	$('#centerpanel').panel({    
		  title: 'My Panel',
		  fit:true,//自适应父窗口
		  tools: [{    
		    iconCls:'icon-add',    
		    handler:function(){alert('new')}    
		  },{    
		    iconCls:'icon-save',    
		    handler:function(){alert('save')}    
		  }]    

	})
});
	
function init(id){
		$.ajax({
			 type: "POST",
			   url: "init/init.action",
			   data: {'id':id},
			   datatype:'json',
			   success: function(msg){
				 for(var i=0;i<msg.length;i++){
				     $('#menus').append('<div style="position: relative;float: right; padding: 10px;"><a href="javascript:void(0)" onclick="showCenter('+"'"+msg[i].url+"'"+')">'+ msg[i].privilegeName +'</a></div>')
				     ;
				 }
				 
			   }
		});
}
function showCenter(url){
	$('#centerpanel').panel('open').panel('refresh',url);
	
	destroy();
}
function destroy(){
	$('#rightMenu').menu('destroy');  
}
function changeTheme(){
	var themeName = $('#themes option:selected').val();
	var url = $('#themelink').attr('href');
	var href = url.substring(0,url.indexOf('themes'))+"themes/"+themeName+"/easyui.css"
	$('#themelink').attr('href',href);
	
	$.cookie('themeName',themeName,{
		expires:7
	});
	
}