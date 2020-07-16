<%--
  Created by IntelliJ IDEA.
  User: dj
  Date: 2020/7/12
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/res/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        function add() {
            var formObject = {};
            var formArray = $("#frm").serializeArray();
            $.each(formArray,function(i,item){
                formObject[item.name] = item.value;
            });
            $.ajax({
                url:"/users/list",
                type:"post",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(formObject),
                dataType: "json",
                success:function(result){
                    if(result.code == 200){
                        alert(result.data);
                        alert("200");
                        window.location.href="/toShow";
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
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="userName"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="userPwd"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="button" value="登陆" onclick="add()"></td>
            </tr>
        </table>
    </form>
</body>
</html>
