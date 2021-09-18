<%--
  Created by IntelliJ IDEA.
  User: w
  Date: 2021/9/15
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <script src="https://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>
    <br>
    <h1 style="color: red">RESTful风格请求</h1>
    <a href="/static/RESTful/index.html">点击跳转</a><br>
    <br><hr><br>

    <br>
    <h1 style="color: red">文件操作</h1>
    <form action="/file/upload" enctype="multipart/form-data" method="post">
        选择文件:<input type="file" name="file"/><br>
        <input type="submit" value="上传文件"/><br>
    </form>
    <br><hr><br>

    <br>
    <h1 style="color: red">异常处理</h1>
    <form action="/err/iderr">
        <input type="submit"  value="抛出自定义IdErr异常"/>
        <input type="text" value="9" name="id"/><br>
    </form>
    <form action="/err/nameerr">
        <input type="submit" value="抛出自定义NameErr异常"/>
        <input type="text" value="" name="name"/><br>
    </form>
    <form action="/err/err">
        <input type="submit" value="全局异常"/>
        <input type="text" value="0" name="num"/><br>
    </form>
    <br><hr><br>

    <br>
    <h1 style="color: red">页面导航</h1>
    <a href="/nav/forwardstring">String转发</a><br>
    <a href="/nav/forwardmodelandview">ModelAndView转发</a><br>
    <a href="/nav/redirectstring">String重定向</a><br>
    <a href="/nav/redirectmodelandview">ModelAndView重定向</a><br>
    <a href="/nav/forwardtohandle">ModelAndView转发到处理器</a><br>
    <a href="/nav/forwardtohandle2">Spring转发到处理器</a><br>
    <a href="/nav/redirecttohandle">ModelAndView重定向到处理器</a>
    <br><hr><br>


    <br>
    <h1 style="color: red">Controller返回值</h1>
    <h3>1.返回ModelAndView类型</h3>
    <a href="/return/modelandview">点击跳转</a><br>

    <h3>2.返回String类型</h3>
    <a href="/return/string">点击跳转</a><br>

    <h3>3.返回Object类型, 不跳转页面, 发送ajax</h3>
    <button id="butobj" type="button">点击发送</button><br>
    <div id="resultobj"></div>
    <script>
        $(function () {
            $("#butobj").on("click", function(){
                $.ajax({
                    type: "POST",
                    url: "/return/obj",
                    data: null,
                    success: function(result){
                        $("#resultobj").html(result.msg)
                    }
                });
            })
        })
    </script>
    <br><hr><br>

    <br>
    <h1 style="color: red">八种处理器方法的参数</h1>
    <h4>8.接收集合类型</h4>
    <form action="/param/add7" method="post">
        名字1: <input type="text" name="names" value="小茶"/><br>
        名字1: <input type="text" name="names" value="小柯"/><br>
        名字1: <input type="text" name="names" value="小爱"/><br>
        名字1: <input type="text" name="names" value="小萌"/><br>

        编号: <input type="text" name="cats[0].catId" value="1"/><br>
        名字: <input type="text" name="cats[0].name" value="小茶"/><br>
        颜色: <input type="text" name="cats[0].color" value="白色"/><br>
        耳朵: <input type="text" name="cats[0].ear" value="卷耳朵"/><br>
        生日: <input type="date" name="cats[0].birthday" value="2021-08-11"><br>
        编号: <input type="text" name="cats[1].catId" value="1"/><br>
        名字: <input type="text" name="cats[1].name" value="小茶"/><br>
        颜色: <input type="text" name="cats[1].color" value="白色"/><br>
        耳朵: <input type="text" name="cats[1].ear" value="卷耳朵"/><br>
        生日: <input type="date" name="cats[1].birthday" value="2021-08-11"><br>

        <input type="submit" value="提交"/>
    </form>
    <br>

    <h4>7.接收数组类型参数</h4>
    <form action="/param/add6" method="post">
        名字1: <input type="text" name="name" value="小茶"/><br>
        名字1: <input type="text" name="name" value="小柯"/><br>
        名字1: <input type="text" name="name" value="小爱"/><br>
        名字1: <input type="text" name="name" value="小萌"/><br>
        <input type="submit" value="提交"/>
    </form>
    <br>

    <h4>6.通过HttpServletRequest接收参数</h4>
    <form action="/param/add5" method="post">
        编号: <input type="text" name="catId" value="1"/><br>
        名字: <input type="text" name="name" value="小茶"/><br>
        颜色: <input type="text" name="color" value="白色"/><br>
        耳朵: <input type="text" name="ear" value="卷耳朵"/><br>
        生日: <input type="date" name="birthday" value="2021-08-11"><br>
        <input type="submit" value="提交"/>
    </form>
    <br>

    <h4>5.通过地址URL传值 ULR-->/param/add4/1/小茶/白色/卷耳朵/2021-08-11</h4>
    <a href="/param/add4/1/小茶/白色/卷耳朵/2021-08-11">点击提交1</a>
    <h4>5.通过地址URL传值 ULR-->/param/add4/1/小茶/白色/卷耳朵</h4>
    <a href="/param/add4/1/小茶/白色/卷耳朵">点击提交2</a><br>
    <br>

    <h4>4.矫正参数名称, 后端添加注解处理</h4>
    <form action="/param/add3" method="post">
        编号: <input type="text" name="catId1" value="1"/><br>
        名字: <input type="text" name="name1" value="小茶"/><br>
        颜色: <input type="text" name="color1" value="白色"/><br>
        耳朵: <input type="text" name="ear1" value="卷耳朵"/><br>
        生日: <input type="date" name="birthday1" value="2021-08-11"><br>
        <input type="submit" value="提交"/>
    </form>
    <br>

    <h4>3.通过对象接收参数, 前端部分不变</h4>
    <form action="/param/add2" method="post">
        编号: <input type="text" name="catId" value="1"/><br>
        名字: <input type="text" name="name" value="小茶"/><br>
        颜色: <input type="text" name="color" value="白色"/><br>
        耳朵: <input type="text" name="ear" value="卷耳朵"/><br>
        生日: <input type="date" name="birthday" value="2021-08-11"><br>
        <input type="submit" value="提交"/>
    </form>
    <br>

    <h4>2.接收日期类型, 后端添加注解处理</h4>
    <form action="/param/add1" method="post">
        编号: <input type="text" name="catId" value="1"/><br>
        名字: <input type="text" name="name" value="小茶"/><br>
        颜色: <input type="text" name="color" value="白色"/><br>
        耳朵: <input type="text" name="ear" value="卷耳朵"/><br>
        生日: <input type="date" name="birthday" value="2021-08-11"><br>
        <input type="submit" value="提交"/>
    </form>
    <br>

    <h4>1.参数名称匹配接收</h4>
    <form action="/param/add" method="post">
        编号: <input type="text" name="catId" value="1"/><br>
        名字: <input type="text" name="name" value="小茶"/><br>
        颜色: <input type="text" name="color" value="白色"/><br>
        生日: <input type="date" name="birthday" value="2021-08-11"><br>
        <input type="submit" value="提交"/>
    </form>
    <br><hr><br>

    <br>
    <h1 style="color: red">SpringMVC简单实例</h1>
    <a href="/hello/test">点击跳转DemoController --> /hello/test</a><br><hr><br>

</body>
</html>
