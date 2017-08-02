<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>
    <title>商品类别</title>
    <script src="js/jquery.min.js"></script>
  </head>
  
  <body>
  	<table class="easyui-datagrid" id="dataTable">   
	   
	</table>
  
	<script>
		/**
			本页面<body>中的内容作为index.jsp中的"查询所有类别"选项卡中的内容
			创建datagrid控件，数据源为后台查询后形成的json字符串
		*/
		$("#dataTable").datagrid({
			fit:true,
			url:"${pageContext.request.contextPath}/CategoryServlet?action=getAllCategories",	// 数据源
			columns:[[	// 列数据
			      {field:"cid", title:"编号", width:100, align:"center"},//field与返回的Json字符串中的键名相同
			      {field:"cname", title:"名称", width:100, align:"center"},
			      {
			    	  field:"operate", 
			    	  title:"操作", 
			    	  width:100, 
			    	  align:"center",
			    	  formatter:function(value,rowData,rowIndex){//用于规定单元格中的内容
			    		  //value:当前列的名称
			    		  //rowData:行记录数据
			    		  //rowIndex:行索引，从0开始
			    		  return "<a href='#' onclick='getCategoryByCid("+rowData.id+")'>编辑</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href='#' onclick='deleteCategoryByCid("+rowData.id+",\""+rowData.name+"\")'>删除</a>";
			    	  }
			      }
			 ]],
			 fitColumns:true,	//列水平适应大小,以免出现水平滚动条
			 singleSelect:true,	//只能选中单行
			 pagination:true,	//在底部显示分页工具栏
			 pageNumber:1,	//设置默认显示第1页数据
			 pageSize:5,	//设置默认每页显示5条数据
			 pageList:[3,5,10]	//设置每页可以显示的数据条数
			 
		});
	</script>
  </body>
</html>