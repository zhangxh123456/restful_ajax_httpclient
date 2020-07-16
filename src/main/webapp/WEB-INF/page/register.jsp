<%--
  Created by IntelliJ IDEA.
  User: dj
  Date: 2020/7/11
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/res/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        function register() {
            var formObject = {};
            var formArray = $("#frm").serializeArray();
            $.each(formArray,function(i,item){
                formObject[item.name] = item.value;
            });
            $.ajax({
                url:"/users",
                type:"post",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(formObject),
                dataType: "json",
                success:function(result){
                    if(result.code == 200){
                        window.location.href="/toLogin";
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
        <table width="410" border="1" align="center">
            <tr>
                <td colspan="2" align="center" bgcolor="#00ffff">信息注册页面</td>
            </tr>
            <tr>
                <td width="90" align="right">学号：</td>
                <td width="320"><input type="text" name="userNumber"></td>
            </tr>
            <tr>
                <td align="right">姓名：</td>
                <td><input type="text"  name="userName"></td>
            </tr>
            <tr>
                <td align="right">密码：</td>
                <td><input type="password" name="userPwd"></td>
            </tr>
            <tr>
                <td align="right">用户学科：</td>
                <td>
                    <select name="userSubject">
                            <optgroup label="专业">专业</optgroup>
                            <option value="1">计算机科学与技术</option>
                            <option value="2">电子商务</option>
                            <option value="3">软件工程</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="提交" onclick="register()">
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
