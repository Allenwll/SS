var StudentList = {
    init: function () {
        this.loadData();
        this.setEvents();
    },
    loadData: function () {
        //加载年级
        var stuGrade = $("#stu_grade");
        stuGrade.empty();
        stuGrade.append("<option value='0'>全部</option>");
        $.ajax({
            url: contextPath + "/loadGrade",
            contentType: "application/json; charset=utf-8",
            type: "get",
            dataType: "json",
            success: function (data) {
                var str = "";
                for (var i = 0; i < data.length; i++) {
                    str += "<option value='" + data[i].id + "'>" + data[i].name + "</option>";
                }
                stuGrade.append(str);
            },
        });
    },
    setEvents: function () {
        //搜索
        $("#stu_search").click(function () {
            var name = $("#stu_name").val();
            var sex = $("#stu_gender").val();
            if (sex == '全部') {
                sex = '';
            }
            var grade = $("#stu_grade").val();
            $.ajax({
                url: contextPath + "/queryStudent?name=" + name + "&sex=" + sex + "&grade=" + grade,
                contentType: "application/json; charset=utf-8",
                type: "get",
                dataType: "json",
                success: function (data) {
                    var tab = $("#student_tab");
                    tab.empty();
                    var str = "<tr><td>序号</td><td>学号</td> <td>姓名</td>" +
                        "<td>性别</td> <td>年龄</td> <td>年级</td> <td>科目</td>" +
                        " <td>操作</td> </tr>";
                    var str1 = "";
                    for (var i = 0; i < data.length; i++) {
                        str1 += "<tr><td>" + (i + 1) + "</td><td>" + data[i].id + "</td><td>" + data[i].name + "</td><td>" + data[i].sex + "</td><td>" + data[i].age + "</td>" +
                            "<td>" + data[i].gradeName + "</td><td>" + data[i].subjectName + "</td>" +
                            "<td><span class='add' >新增</span>&emsp;&emsp;" +
                            "<span class='edit' data-id='" + data[i].id + "' >编辑</span>&emsp;&emsp;" +
                            "<span class='del' data-id='" + data[i].id + "' >删除</span></td></tr>";
                    }
                    tab.append(str + str1);
                },
            });
        });

        //新增
        $(".add").click(function () {
            window.open(contextPath + "/addStudentPage", '新增', 'height=500,width=800,top=200,left=500,' +
                'toolbar =no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
        });

        //修改
        $(".edit").click(function () {
            var id = this.dataset.id;
            window.open(contextPath + "/addStudentPage?id=" + id, '修改', 'height=500,width=800,top=200,left=500,toolbar =no,' +
                ' menubar=no, scrollbars=no, resizable=no, location=no, status=no');
        });
        //删除
        $(".del").click(function () {
            var id = this.dataset.id;
            if (window.confirm('你确定要删除吗')) {
                $.post(contextPath + "/delStudent?id=" + id, function (data) {
                    window.location.reload();
                });
                return true;
            } else {
                return false;
            }
        });
    },
};
$(function () {
    StudentList.init();
});
