<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>黑马商城后台管理</title>
	<link rel="stylesheet" href="themes/default/easyui.css"/>
	<link rel="stylesheet" href="themes/icon.css"/>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
  </head>
  
  <body>
    <div id="cc" class="easyui-layout" data-options="fit:true">   
	    <div data-options="region:'north',collapsible:false" style="height:100px;">
	    	<div style="font-size:20px;text-align:center;line-height:20px;"><h1>黑马商城后台管理系统</h1></div>
	    </div>   
	    <div data-options="region:'south',collapsible:false" style="height:100px;">
	    	<footer>黑马商城版权所有</footer>
	    </div>

	    <div data-options="region:'west',title:'系统菜单',collapsible:false" style="width:200px;">
	    	<div id="menu" class="easyui-accordion" data-options="fit:true">   
			    <div title="功能一" data-options="" style="overflow:auto;padding:10px;">   
			        <ul class="easyui-tree" data-options="animate:true,lines:true">
					    <li>
					        <span>类别管理</span>
					        <ul>
					            <li><span>
				                	<a style="text-decoration:none;" href="javascript:void(0);" onclick="getAllCategories()">
				                	查询所有类别</a>
				                </span></li>
					            <li><span>
					            	<a style="text-decoration:none;" href="javascript:void(0);">
					            	同步数据</a>
					            </span></li>
					        </ul>
					    </li>
					    <li>
					        <span>商品管理</span>
					        <ul>
					            <li><span>
					            	<a style="text-decoration:none;" href="javascript:void(0);">
					           		 查询所有商品</a>
					            </span></li>
					        </ul>
					    </li>
					</ul>
			    </div>
			    <div title="功能二" data-options=" " style="padding:10px;">
			        <span>功能二</span>
			    </div>
			    <div title="功能三" data-options=" ">
			        <span>功能三</span>
			    </div>
			</div>
	    </div>
	    
	    <div data-options="region:'center',title:'',collapsible:false" style="background:#eee;">
	    	<!-- 在中间嵌入tabs控件 -->
	    	<div id="tabsContainer" class="easyui-tabs" data-options="fit:true,border:false">   
			  <!-- <div title="tab1" style="padding:20px;display:none;">   
			        tab1    
			    </div> -->
			</div> 
	    </div>
	</div> 
	
	<script>
	
		//查询所有类别
		function getAllCategories(){
			//如果tabs容器中包含有标题为"查询所有类别"的选项卡，则选中该选项卡
			if($("#tabsContainer").tabs("exists","查询所有类别")){
				$("#tabsContainer").tabs("select","查询所有类别");
			}else{
				//否则创建该选项卡
				$("#tabsContainer").tabs("add",{
					"title":"查询所有类别",
					"closable":true,
					"selected":true,
					"href":"category_list.jsp"	// 链接到该页面，内容为该页面<body>中的内容
				});
			}
		}
		
	</script>
	
  </body>
</html>
