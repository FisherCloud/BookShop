<%--
  Created by IntelliJ IDEA.
  User: chenjunan
  Date: 19-2-16
  Time: 下午9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>国信安图书借阅在线首页</title>
    <!-- 引入Bootstrap核心样式文件 -->
    <link href="../static/css/bootstrap.css" rel="stylesheet">
    <!-- 引入jQuery核心js文件 -->
    <script src="../static/js/jquery-1.11.3.min.js"></script>
    <!-- 引入BootStrap核心js文件 -->
    <script src="../static/js/bootstrap.min.js"></script>

    <style>
        body {
            margin-top: 20px;
            margin: 0 auto;
        }

        font {
            color: #666;
            font-size: 22px;
            font-weight: normal;
            padding-right: 17px;
        }
        ol li{
            margin-top: 10px;
            margin-bottom: 10px;
        }
    </style>
</head>

<body>

<!--logo部分-->
<div class="container">
    <div class="row">
        <div class="col-lg-4 col-md-4 col-sm-6">
            <img src="../static/img/logo.png" />
        </div>
        <div class="col-lg-5 col-md-4 hidden-xs col-sm-6">
            <img src="../static/img/header.png" />
        </div>
        <div class="col-lg-3 col-md-4 col-sm-12 text-right" style="padding-top: 30px;">
            <a href="../static/login.html">登录</a>&nbsp;&nbsp;&nbsp;
            <a href="../static/regist.html">注册</a>
        </div>
    </div>
</div>

<!--导航栏-->
<div class="container" style="margin-top: 10px;">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-book"></span></a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="#">计算机 <span class="sr-only">(current)</span></a>
                    </li>
                    <li>
                        <a href="#">文学</a>
                    </li>
                    <li>
                        <a href="#">小说</a>
                    </li>
                    <li>
                        <a href="#">历史</a>
                    </li>
                    <li>
                        <a href="#">励志</a>
                    </li>
                    <li>
                        <a href="#">养生</a>
                    </li>
                    <li>
                        <a href="#">科技</a>
                    </li>
                    <li>
                        <a href="#">传记</a>
                    </li>
                    <li>
                        <a href="#">育儿</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其他分类 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#">宗教</a>
                            </li>
                            <li>
                                <a href="#">哲学</a>
                            </li>
                            <li>
                                <a href="#">心理学</a>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li>
                                <a href="#">法律</a>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li>
                                <a href="#">烹饪美食</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="请输入书名">
                    </div>
                    <button type="submit" class="btn btn-default">查询</button>
                </form>
            </div>
        </div>
    </nav>
</div>

<!--付款成功-->
<div class="container" style="height: 650px;">
    <div class="row text-center" style="margin-top: 50px;">
        <h1><img src="../static/img/success.jpg" /> 付款成功!</h1>
    </div>
    <hr />

    <div class="row">
        <p class="lead">${consigneeName },授权码已发送至邮箱${consigneeEmail },请尽快去邮箱收取,然后就能在知识的海洋中遨游了.</p>
        <ul>
            <li><a href="">网易163邮箱</a></li>
            <li><a href="">网易126邮箱</a></li>
            <li><a href="">网易yeah.net邮箱</a></li>
            <li><a href="">搜狐sohu邮箱</a></li>
            <li><a href="">qq邮箱</a></li>
        </ul>
    </div>
    <hr />
    <div class="row">
        <h4>还没有收到邮件?</h4>
        <ol>
            <li>稍等片刻,从新检查你的邮箱(由于网络延迟,请耐心等待1-3分钟)</li>
            <li>您可以尝试在广告邮件中查找</li>
            <li>也可以选则<a class="btn btn-primary">重新发送邮件</a></li>
        </ol>
    </div>
</div>

<hr />

<!--友情链接和版权信息-->
<div class="container" style="margin-top: 10px;">
    <div class="row">
        <div class="" align="center">
            <ul class="list-inline">
                <li><a>关于我们</a></li>
                <li><a>联系我们</a></li>
                <li><a>招贤纳士</a></li>
                <li><a>法律声明</a></li>
                <li><a>友情链接</a></li>
                <li><a>支付方式</a></li>
                <li><a>配送方式</a></li>
                <li><a>服务声明</a></li>
                <li><a>广告声明</a></li>
            </ul>
        </div>
        <div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
            Copyright &copy; 2003-2017 国信安书城 版权所有
        </div>
    </div>
</div>

</body>

</html>
