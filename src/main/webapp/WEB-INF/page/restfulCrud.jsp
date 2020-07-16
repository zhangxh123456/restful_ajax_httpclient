<%--
  Created by IntelliJ IDEA.
  User: dj
  Date: 2020/7/12
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/res/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">



        function load() {
            $.post(
                "/users/list02",
                $("#frm").serialize(),
                function (result) {
                    alert(result.data);
                     var str = eval('(' + result.data + ')');
                     var user = str.data;
                     var html = "";
                        html += "<tr>";
                        html += "<td>"+user.id+"</td>";
                        html += "<td>"+user.userName+"</td>";
                        html += "<td>"+user.userPwd+"</td>";
                        html += "<td>"+user.userAge+"</td>";
                        html += "<td>"+user.userSex+"</td>";
                        html += "<td>"+user.userNumberId+"</td>";
                        html += "<td>"+user.createTime+"</td>";
                        html += "<td>"+user.updateTime+"</td>";
                        html += "</tr>";
                        $("#tbd").html(html);

                }

            );
        }
    </script>
</head>
<body>
    <form id="frm">
        查找restful_CRUD项目中的信息：<br/>
        用户名：<input type="text" name="userName" /><br/>
        密码：<input type="text" name="userPwd" /><br/>
        <input type="button" value="跳转其他项目" onclick="load()" />
    </form>
    <table border="1px" bordercolor="blue">
        <tr>
            <th>id</th>
            <th>用户名</th>
            <th>密码</th>
            <th>年龄</th>
            <th>用户性别</th>
            <th>身份证号</th>
            <th>创建时间</th>
            <th>update_time</th>
        </tr>
        <tbody id="tbd"></tbody>
    </table>
</body>
</html>
