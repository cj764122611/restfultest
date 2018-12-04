$(function() {
	selectInfo(1);
});
function selectInfo(page) {
	var pagesize = $("#pagesize").val();
	if (pagesize == 0 || pagesize == null) {
		pagesize = 2;
	}
	$
			.ajax({
				url : '/person/all',
				data : 'pages=' + page + "&pagesize=" + pagesize,
				dataType : 'json',
				type:'get',
				success : function(data) {
					if (data.code == 1) {
						var obj = data.obj.list;
						var str = "<table border='1px' ><tr> <td>编号</td> <td>姓名</td><td>操作</td></tr>";
						for (var i = 0; i < obj.length; i++) {
							str += "<tr><td id = 'did'>" + obj[i].id + "</td>" + "<td>"
									+ obj[i].name + "</td>";
							str += "<td>"
									+ "<a href='javascript:void()' onclick='toUpdate("
									+ obj[i].id;
							str += ")'>修改</a> <a href='javascript:void()' onclick='delect("
									+ obj[i].id + ")'>删除</a></td> </tr>";
						}
						str += "</table>";
						str += "共" + data.obj.pageNum + "页/当前第"
								+ data.obj.pages + "页" + ",每页"
								+ data.obj.pagesize + "条/共 " + data.obj.total
								+ "条 &nbsp;&nbsp;&nbsp;&nbsp;";
						str += "<a href='javascript:void()' onclick='selectInfo(1)'>首页</a>&nbsp;&nbsp;&nbsp;&nbsp;";
						str += "<a href='javascript:void()' onclick='selectInfo("
								+ (data.obj.pages - 1 > 0 ? data.obj.pages - 1
										: 1)
								+ ")'>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;";
						str += "<a href='javascript:void()' onclick='selectInfo("
								+ (data.obj.pages + 1 < data.obj.pageNum ? data.obj.pages + 1
										: data.obj.pageNum)
								+ ")'>下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;";
						str += "<a href='javascript:void()' onclick='selectInfo("
								+ data.obj.pageNum
								+ ")'>尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;";

						str += "分页：<select id='pagesize' onblur='selectInfo("
								+ data.obj.pages + ")'>";
						for (var i = 1; i < 5; i++) {
							if (i == data.obj.pagesize) {
								str += "<option selected>" + i + "</option>"
							} else {
								str += "<option>" + i + "</option>"
							}
						}
						str += " </select> <br />"
						$("#addInfo").css("display", "block");
						$("#personInfo").html(str);
					} else {
						alert(data.errorMsg);
					}
				}
			});
}

function addPerson() {
	var name = $("#pname").val();
	if (name == null || name == '') {
		alert("请添加姓名");
	} else {
		$.ajax({
			url : '/person/post/one',
			data : 'name=' + name,
			dataType : 'json',
			type : 'post',
			success : function(data) {
				if (data.code == 1) {
					alert("添加信息成功");
					selectInfo(1);
				} else {
					alert(data.errormsg);
				}
			}
		})
	}
}

function toUpdate(id) {
	$
			.ajax({
				url : "/person/one",
				data : "id=" + id,
				dataType : "json",
				success : function(data) {
					if (data.code == 1) {
						var str = "<input type='hidden' value='" + data.obj.id
								+ "' id='pid'>";
						str += "<input type='text' value='" + data.obj.name
								+ "' id='newName'>";
						str += "<input type='button' onclick='updatePerson()' value='修改信息'>"
						$("#addInfo").css("display", "none");
						$("#personInfo").html(str);
					}
				}

			});

}
function updatePerson() {
	var name = $("#newName").val();
	var id = $("#pid").val();
	if (name == null || name == '') {
		alert("请添加姓名");
	} else {
		$.ajax({
			url : '/person/update/' + id,
			data : 'name=' + name + "&id=" + id,
			dataType : 'json',
			type : 'patch',
			success : function(data) {
				if (data.code == 1) {
					alert("更新信息成功");
					selectInfo(1);
				} else {
					alert(data.errormsg);
				}
			}
		})
	}
}

function delect() {
	var id = $("#did").text();
	$.ajax({
		url : '/person/delete/' + id,
		data : "id=" + id,
		dataType : 'json',
		type : 'delete',
		success : function(data) {
			if (data.code == 1) {
				alert("删除用户信息成功....");
				selectInfo(1);
			} else {
				alert(data.errorMsg);
			}
		}
	})
}