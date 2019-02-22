<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chenjunan
  Date: 19-2-21
  Time: 下午6:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8" />
    <!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>国信安图书借阅在线首页</title>
    <!-- 引入Bootstrap核心样式文件 -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet" />
    <!-- 引入jQuery核心js文件 -->
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.3.min.js"></script>
    <!-- 引入BootStrap核心js文件 -->
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <style>
        .carousel img{
            width: 350px;
            margin: auto;
        }
        .pic{
            width: 80%;
        }
        .history_pic{
            width: 70%;
        }
        .price{
            color:red;
            font-size: 13pt;
        }
        .bookname a{
            color:grey;
            font-size: 10pt;
        }
    </style>
</head>

<%@include file="common/header.jsp"%>

<div class="container">
    <div class="row">

        <br />
        <p style="font-size: 20px;padding-left: 40px">Search：&nbsp;&nbsp;&nbsp;${searchName}</p>
        <br />

        <c:forEach items="${pageUtil.content}" var="good">
            <div class="col-md-2 col-sm-4 col-xs-6" align="center">
                <a href="bookinfo.action?id=${good.goods_id}">
                    <img class="pic" src="${pageContext.request.contextPath}/static/img/book/${good.goods_img}" />
                </a>
                <p class="price">&yen; ${good.goods_price}点券</p>
                <p class="bookname">
                    <a href="bookinfo.action?id=${good.goods_id}">${good.goods_name}</a>
                </p>
            </div>
        </c:forEach>


        
    </div>
</div>
<!--分页 -->
<div class="container">
    <div class="row text-center" style="margin: 50px auto">
        <ul class="pagination" style="text-align:center; margin-top:10px;">
            <li class="disabled">
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach items="${pageUtil.pagesList}" var="page">
                <li class="${ pageUtil.nowPage == page ? "active" : ""}">
                    <a href="${pageContext.request.contextPath}/search.action?searchName=${searchName}&nowPage=${page}">${page}</a>
                </li>
            </c:forEach>

            <li>
                <a href="${pageContext.request.contextPath}/search.action?searchName=${searchName}&nowPage=${pageUtil.nowPage+1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </div>
</div>
<!-- 分页结束=======================-->
<!--商品浏览记录-->
<!-- <div style="width:1210px;margin:0 auto; padding: 0 9px;border: 1px solid #ddd;border-top: 2px solid #999;height: 246px;">

          <h4 style="width: 50%;float: left;font: 14px/30px " 微软雅黑 ";">浏览记录</h4>
          <div style="width: 50%;float: right;text-align: right;">
              <a href="">more</a>
          </div>
          <div style="clear: both;"></div>

          <div style="overflow: hidden;">

              <ul style="list-style: none;">
                  <li style="width: 150px;height: 216;float: left;margin: 0 8px 0 0;padding: 0 18px 15px;text-align: center;">
                      <img src="products/1/cs10001.jpg" width="130px" height="130px" />
                      <p>
                  </li>
              </ul>
          </div>
      </div> -->
<div class="container">
    <div class="row">
        <ul class="nav nav-tabs">
            <li role="presentation" class="active"><a style="color:green">浏览记录</a></li>
        </ul>
    </div>
    <div class="row" style="border: 1px solid #ddd;padding:30px ">
        <div class="col-md-2 col-sm-4 col-xs-6" align="center">
            <a href="#"><img class="history_pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg" /></a>
            <p class="price">&yen; 20点券</p>
            <p class="bookname"><a href="#">世界最美</a></p>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6" align="center">
            <a href="#"><img class="history_pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg" /></a>
            <p class="price">&yen; 20点券</p>
            <p class="bookname"><a href="#">世界最美</a></p>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6" align="center">
            <a href="#"><img class="history_pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg" /></a>
            <p class="price">&yen; 20点券</p>
            <p class="bookname"><a href="#">世界最美</a></p>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6" align="center">
            <a href="#"><img class="history_pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg" /></a>
            <p class="price">&yen; 20点券</p>
            <p class="bookname"><a href="#">世界最美</a></p>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6" align="center">
            <a href="#"><img class="history_pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg" /></a>
            <p class="price">&yen; 20点券</p>
            <p class="bookname"><a href="#">世界最美</a></p>
        </div>
        <div class="col-md-2 col-sm-4 col-xs-6" align="center">
            <a href="#"><img class="history_pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg" /></a>
            <p class="price">&yen; 20点券</p>
            <p class="bookname"><a href="#">世界最美</a></p>
        </div>
    </div>
</div>
<!--页脚-->
<div class="container" style="margin-top: 10px;">
    <div class="row">
        <div class="hidden-md hidden-sm hidden-xs " style="padding-left: 14px;">
            <img src="${pageContext.request.contextPath}/static/img/footer.jpg" style="width: 98%;" />
        </div>
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


<script type="text/javascript">


    function isLogin(){
        $.ajax({
            type:"get",
            url:"indexlogin.action",
            data:"",
            success:function (data) {
                if(data != "null") {
                    $('#login').empty();
                    var temp = "<p>欢迎您！<a>chenjunan</a>用户</p><a id='quit' onclick='quitLogin()'>退出</a>";
                    $('#login').html(temp);
                }else{
                    $('#login').empty();
                    var temp = " <a href=\"pages/login.jsp\">登录</a>&nbsp;&nbsp;&nbsp;\n" +
                        "      <a href=\"pages/register.jsp\">注册</a>";
                    $('#login').html(temp);
                }
            },
            error:function () {

            }
        });
    }
    function quitLogin(){
        $('#quit').click(function () {
            $.ajax({
                type:"get",
                url:"indexQuitlogin.action",
                data:"",
                success:function (data) {
                    // layui.use('layer',function () {
                    //   var layer = layui.layer;
                    //   layer.msg("退出成功！");
                    // });
                    $('#login').empty();
                    var temp = " <a href=\"pages/login.jsp\">登录</a>&nbsp;&nbsp;&nbsp;\n" +
                        "      <a href=\"pages/register.jsp\">注册</a>";
                    $('#login').html(temp);

                },
                error:function () {

                }
            });
        });

    }


    function search(){

        $('#searchSubmit').click(function () {

            var searchName = $('#search').val();

            if(searchName === ""){
                layui.use('layer',function () {
                    var layer = layui.layer;
                    layer.msg("未输入内容！");
                });
            }else
                window.location.href = '${pageContext.request.contextPath}/search.action?searchName='+searchName;
        });

    }

    $(function () {
        isLogin();
        quitLogin();
        search();
    });
</script>
</body>
</html>