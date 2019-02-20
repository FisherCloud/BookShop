<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--公共的头部开始--%>
<%--引入公共的头部文件--%>
<jsp:include page="common/header.jsp"/>
<%--公共的头部结束--%>


<!--轮播图-->
<div class="container">
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="${pageContext.request.contextPath}/static/img/1.jpg" alt="...">
                <div class="carousel-caption">
                    ...
                </div>
            </div>
            <div class="item">
                <img src="${pageContext.request.contextPath}/static/img/2.jpg" alt="...">
                <div class="carousel-caption">
                    ...
                </div>
            </div>
            <div class="item">
                <img src="${pageContext.request.contextPath}/static/img/3.jpg" alt="...">
                <div class="carousel-caption">
                    ...
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>

<!--为你推荐-->
<div class="container" style="margin-top: 20px;">
    <!--上面的文字内容-->
    <div class="row">
        <div id="" style="font-size: 20px;padding-left: 33px;font-weight: bold;">
            <span class="glyphicon glyphicon-star-empty"></span> 为您推荐
            <hr/>
        </div>
    </div>
    <!--图片内容-->
    <div class="row">
        <div class="col-md-2 col-sm-2 hidden-sm hidden-xs" style="height: 400px;">
            <img src="${pageContext.request.contextPath}/static/img/book/l1.jpg" height="100%"/>
        </div>
        <div class="col-md-10 col-sm-10" style="padding-left: 10px;" id="forYou">
            <c:forEach items="${recoList}" var="book">
                <div class="col-md-2 col-sm-4 col-xs-6" align="center">
                    <a href="${pageContext.request.contextPath}/detail.action?id=${book.goods_id}"><img class="pic"
                                                                                                        src="${pageContext.request.contextPath}/file/book/${book.goods_img}"/></a>
                    <p class="price">¥ ${book.goods_price}点券</p>
                    <p class="bookname"><a href="#">${book.goods_name}</a></p>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<!--广告图片-->
<div class="container" style="margin-top: 10px;">
    <div class="row">
        <div class="hidden-md hidden-sm hidden-xs " style="padding-left: 14px;">
            <img src="${pageContext.request.contextPath}/static/img/ad.jpg" style="width: 98%;"/>
        </div>
    </div>
</div>

<!--新书上架-->
<div class="container" style="margin-top: 20px;">
    <!--上面的文字内容-->
    <div class="row">
        <div id="" style="font-size: 20px;padding-left: 33px;font-weight: bold;">
            <span class="glyphicon glyphicon-star-empty"></span> 新书上架
            <hr/>
        </div>
    </div>
    <!--图片内容-->
    <div class="row">
        <div class="col-md-2 col-sm-2 hidden-sm hidden-xs" style="height: 400px;">
            <img src="${pageContext.request.contextPath}/static/img/book/l2.jpg" height="100%"/>
        </div>
        <div class="col-md-10 col-sm-10" style="padding-left: 10px;" id="forYou">
            <div class="row">
                <div class="col-md-2 col-sm-4 col-xs-6" align="center">
                    <a href="#"><img class="pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg"/></a>
                    <p class="price">¥ 20点券</p>
                    <p class="bookname"><a href="#">全球最美</a></p>
                </div>
                <div class="col-md-2 col-sm-4 col-xs-6" align="center">
                    <a href="#"><img class="pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg"/></a>
                    <p class="price">¥ 20点券</p>
                    <p class="bookname"><a href="#">全球最美</a></p>
                </div>
                <div class="col-md-2 col-sm-4 col-xs-6" align="center">
                    <a href="#"><img class="pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg"/></a>
                    <p class="price">¥ 20点券</p>
                    <p class="bookname"><a href="#">全球最美</a></p>
                </div>
                <div class="col-md-2 col-sm-4 col-xs-6" align="center">
                    <a href="#"><img class="pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg"/></a>
                    <p class="price">¥ 20点券</p>
                    <p class="bookname"><a href="#">全球最美</a></p>
                </div>
                <div class="col-md-2 col-sm-4 col-xs-6" align="center">
                    <a href="#"><img class="pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg"/></a>
                    <p class="price">¥ 20点券</p>
                    <p class="bookname"><a href="#">全球最美</a></p>
                </div>
                <div class="col-md-2 col-sm-4 col-xs-6" align="center">
                    <a href="#"><img class="pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg"/></a>
                    <p class="price">¥ 20点券</p>
                    <p class="bookname"><a href="#">全球最美</a></p>
                </div>
                <div class="col-md-2 col-sm-4 col-xs-6" align="center">
                    <a href="#"><img class="pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg"/></a>
                    <p class="price">¥ 20点券</p>
                    <p class="bookname"><a href="#">全球最美</a></p>
                </div>
                <div class="col-md-2 col-sm-4 col-xs-6" align="center">
                    <a href="#"><img class="pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg"/></a>
                    <p class="price">¥ 20点券</p>
                    <p class="bookname"><a href="#">全球最美</a></p>
                </div>
                <div class="col-md-2 col-sm-4 col-xs-6" align="center">
                    <a href="#"><img class="pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg"/></a>
                    <p class="price">¥ 20点券</p>
                    <p class="bookname"><a href="#">全球最美</a></p>
                </div>
                <div class="col-md-2 col-sm-4 col-xs-6" align="center">
                    <a href="#"><img class="pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg"/></a>
                    <p class="price">¥ 20点券</p>
                    <p class="bookname"><a href="#">全球最美</a></p>
                </div>
                <div class="col-md-2 col-sm-4 col-xs-6" align="center">
                    <a href="#"><img class="pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg"/></a>
                    <p class="price">¥ 20点券</p>
                    <p class="bookname"><a href="#">全球最美</a></p>
                </div>
                <div class="col-md-2 col-sm-4 col-xs-6" align="center">
                    <a href="#"><img class="pic" src="${pageContext.request.contextPath}/static/img/book/1.jpg"/></a>
                    <p class="price">¥ 20点券</p>
                    <p class="bookname"><a href="#">全球最美</a></p>
                </div>
            </div>
        </div>
    </div>
</div>

<!--页脚-->
<div class="container" style="margin-top: 10px;">
    <div class="row">
        <div class="hidden-md hidden-sm hidden-xs " style="padding-left: 14px;">
            <img src="${pageContext.request.contextPath}/static/img/footer.jpg" style="width: 98%;"/>
        </div>
    </div>
</div>
<hr/>

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