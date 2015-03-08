/*
日期格式化	
*/
function dateFormat(date){
	var format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
	return format.format(date);
};
/**
 * 切换主题
 * @param themeName
 */
function  changeTheme(themeName){
	console.info(themeName);
	var themeLink = $('#themeLink');
	var url = themeLink.attr('href');
	var href = url.substring(0,url.indexOf('themes'))+'themes/'+themeName+'/easyui.css';
	themeLink.attr('href',href);
	$.cookie('themeName',themeName,{
		expires:7
	})
};