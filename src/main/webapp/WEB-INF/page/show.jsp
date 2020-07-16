<%--
  Created by IntelliJ IDEA.
  User: dj
  Date: 2020/7/12
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/res/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">

        $(function () {
            load();
        })

        function load() {
            var formObject = {};
            var formArray = $("#frm").serializeArray();
            $.each(formArray,function(i,item){
                formObject[item.name] = item.value;
            });
            $.ajax({
                url:"/users/list01",
                type:"post",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(formObject),
                dataType: "json",
                success:function(result){
                    if(result.code == 200){
                       var users = result.data;
                       var html = "";
                       for (var i = 0; i < users.length; i++) {
                           var user = users[i];
                           html += "<tr>";
                           html += "<td>"+user.id+"</td>";
                           html += "<td>"+user.userNumber+"</td>";
                           html += "<td>"+user.userName+"</td>";
                           html += "<td>"+user.userPwd+"</td>";
                           html += "<td>"+user.userSubject+"</td>";
                           html += "<td>"+user.userPicture+"</td>";
                           html += "</tr>";
                       }
                       $("#tbd").html(html);
                    }
                },
                error:function(e){
                    alert("错误！！");
                }
             });
        }


    </script>
</head>
<body>
    <form id="frm">

    </form>
     <table>
         <tr>
             <td>id</td>
             <td>身份证号</td>
             <td>姓名</td>
             <td>密码</td>
             <td>用户学科</td>
             <td>头像</td>
         </tr>
         <tbody id="tbd"></tbody>
     </table>
</body>
</html>
