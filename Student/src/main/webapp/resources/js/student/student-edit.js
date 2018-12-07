var StudentEdit = {
    init:function() {
        this.loadData();
    },
    loadData:function () {
        //加载年级和课程
        var stuGrade = $("#stu_grade");
        stuGrade.empty();
        stuGrade.append("<option value='0'>请选择...</option>");
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

        var stuSubject = $("#stu_subject");
        stuSubject.empty();
        stuSubject.append("<option value='0'>请选择...</option>");
        $.ajax({
            url: contextPath + "/loadSubject",
            contentType: "application/json; charset=utf-8",
            type: "get",
            dataType: "json",
            success: function (data) {
                var str = "";
                for (var i = 0; i < data.length; i++) {
                    str += "<option value='" + data[i].id + "'>" + data[i].name + "</option>";
                }
                stuSubject.append(str);
            },
            error: function (msg) {
                alert("出错了！");
            }
        });


        //修改
        var id = $("#stu_id").val();
        if(id!=''){
            $.post(contextPath+"/findStudentById?id="+id, function(data){
                $("#stu_name").val(data.name);
                $("#stu_age").val(data.age);
                $("#stu_gender").val(data.sex);
                $("#stu_grade").val(data.grade);
                $("#stu_subject").val(data.subject);
            });
        }
    },
};
$(function () {
    StudentEdit.init();
});
