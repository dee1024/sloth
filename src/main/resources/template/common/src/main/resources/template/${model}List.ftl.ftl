<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Game List</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/dashboard.css" rel="stylesheet">
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">管理后台</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <!-- Single button -->
                <li><a href="../../index">主页</a></li>
                <!-- <li><a href="#">设置</a></li> -->
                <li role="presentation" class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
                        个人中心 <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">个人资料</a></li>
                        <li><a href="#">登出</a></li>
                    </ul>
                </li>
            </ul>
            <!-- <form class="navbar-form navbar-right">
              <input type="text" class="form-control" placeholder="Search...">
            </form> -->
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <p>表单</p>
            <ul class="nav nav-sidebar">
                <li><a href="../../index">总览 <span class="sr-only">(current)</span></a></li>
        <#assign tables = allTablesName?replace(" ","")?split(",")>
        <#list tables as table>
            <#if table == name>
                <li class="active"><a href="/p/${table}/list">${table}</a></li>
            <#else>
                <li><a href="/p/${table}/list">${table}</a></li>
            </#if>
        </#list>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h2 class="sub-header">${name}</h2>
            <div class="table-responsive">
                <table class="table table-condensed table-hover">
                    <thead>
                    <tr>
                        <#list columns as column>
                        <th>${column.name}</th>
                        </#list>
                    </tr>
                    </thead>
                    <tbody>
                    ${r'<#list rows as row>'}
                    <tr>
                        <#list 0..columns?size-1 as i>
                            <td <#if columns[i].name == primaryKey >name="id"</#if>>${r'<#if row.'}${columns[i].name}${r'??>${row.'}${columns[i].name}<#if columns[i].type?index_of("Integer") gt -1 >${r'?c}</#if>'}<#elseif columns[i].type?index_of("Date") gt -1>${r'?date}</#if>'}<#else>${r'}</#if>'}</#if></td>
                        </#list>
                            <td><a href="detail/${r'${row.'}${columns[0].name}${r'}'}" class="btn btn-primary" role="button">Detail</a></td>
                    </tr>
                    ${r'</#list>'}
                    </tbody>
                </table>

                <nav class="pull-right">
                  <ul class="pagination">

                  </ul>
                </nav>
                <a href="create" class="btn btn-info">新增一笔</a>
            </div>
        </div>
    </div>
</div>

<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/holder.min.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
        var count = 0;
        $.ajax({
            url: "../../${lowerFirstLetterName}/count",
            type:"get",
            dataType:'text',
            success: function(msg){
                count = msg;
                count = count / 10;
                if (count%1 != 0)
                    count++;

                count = parseInt(count);

                if (count != 1){
                    var countMax = 5; //页数按钮限制

                    var currentPage = parseInt(getParameterByName("p"));
                    if (isNaN(currentPage))
                        currentPage = 1;

                    //上一页按钮
                    if (currentPage == 1){
                        $(".pagination").append('<li class="disabled"><a href="#"><span aria-hidden="true">&laquo;</span><span class="sr-only">上一页</span></a></li>');
                    }else{
                        $(".pagination").append('<li><a href="?p=' + (currentPage-1) +'"><span aria-hidden="true">&laquo;</span><span class="sr-only">上一页</span></a></li>');
                    }

                    var firstPage = currentPage - parseInt(countMax/2) > 0 ? currentPage - parseInt(countMax/2) : 1;
                    var endPage = firstPage + countMax > count + 1? count+1 : firstPage + countMax;
                    if (endPage - firstPage < countMax)
                        firstPage = endPage - countMax > 0 ? endPage - countMax : 1;


                    for (var i = firstPage; i < endPage; i++) {
                        if (currentPage == i){
                            $(".pagination").append('<li class="active"><a href="?p='+i+'">'+i+'</a></li>');
                        }else{
                            $(".pagination").append('<li><a href="?p='+i+'">'+i+'</a></li>');
                        }
                    };

                    //下一页按钮
                    if (currentPage == count){
                        $(".pagination").append('<li class="disabled"><a href="#"><span aria-hidden="true">&raquo;</span><span class="sr-only">下一页</span></a></li>');
                    }else{
                        $(".pagination").append('<li><a href="?p=' + (currentPage+1) +'"><span aria-hidden="true">&raquo;</span><span class="sr-only">下一页</span></a></li>');
                    }
                }
            },
            error:function(xhr, ajaxOptions, thrownError){

            }
        });

        $("tbody tr").click(function(){
            var id = $(this).children().filter("td[name=id]").html();
            window.location.href="detail/"+id;
        });
    });

    function getParameterByName(name, url) {
        if (!url) url = window.location.href;
        name = name.replace(/[\[\]]/g, "\\$&");
        var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
                results = regex.exec(url);
        if (!results) return null;
        if (!results[2]) return '';
        return decodeURIComponent(results[2].replace(/\+/g, " "));
    }
</script>

</body>
</html>