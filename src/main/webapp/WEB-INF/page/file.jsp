<%--
  Created by IntelliJ IDEA.
  User: dj
  Date: 2020/7/12
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/res/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        function load(){
            var formData = new FormData($('#uploadForm')[0]);
            alert(formData);
            $.ajax({
                type: 'post',
                url: '/users/file',
                data: formData,
                cache: false,
                processData: false,
                contentType: false,
            }).success(function (data) {
                alert("上传成功");
            }).error(function () {
                alert("上传失败");
            });
        }

    </script>
</head>
<body>
    <form id="uploadForm" enctype="multipart/form-data">
        文件:<input id="file" type="file" name="file"/>
        <input type="button" value="上传文件" onclick="load()">
    </form>
</body>
</html>
