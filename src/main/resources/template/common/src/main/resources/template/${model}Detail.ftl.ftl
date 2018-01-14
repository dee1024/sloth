<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Game Detail</title>
    <link href="../../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../../css/dashboard.css" rel="stylesheet">
    <link href="../../../css/jsoneditor.css" rel="stylesheet">
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
                <li><a href="../../../index">主页</a></li>
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
                <li><a href="../../../index">总览 <span class="sr-only">(current)</span></a></li>
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
        <div class="col-sm-9 col-sm-offset-3 col-md-8 col-md-offset-2 main">
            <h2 class="sub-header">${name}</h2>
            ${r'<#if row??>'}
            <form id="detail" role="form">
            ${r'<#escape x as x?html>'}
            <#list 0..columns?size-1 as i>
                <div class="form-group">
                    <label for="input${columns[i].name}">${columns[i].name} <#if columns[i]
                    .remark!="">- ${columns[i]
            .remark}</#if></label>
                    <input <#if columns[i].name== primaryKey >readonly</#if> type="text" class="form-control" id="input${columns[i].name}" name="${columns[i].name}" placeholder="${columns[i].name}" value="${r'<#if row.'}${columns[i].name}${r'??>${row.'}${columns[i].name}<#if columns[i].type?index_of("Integer") gt -1 || columns[i].type?index_of("Long") gt -1 >${r'?c}</#if>'}<#elseif columns[i].type?index_of("Date") gt -1>${r'?date}</#if>'}<#else>${r'}</#if>'}</#if>">
                </div>
            </#list>
            ${r'</#escape>'}
                <button type="button" id="submit" class="btn btn-primary btn-lg pull-right" data-loading-text="<i class='fa fa-spinner fa-spin'></i> 请稍等..">送出</button>

                <button type="button" id="delete" class="btn btn-danger btn-lg" data-loading-text="<i class='fa fa-spinner fa-spin'></i> 请稍等..">删除</button>
            </form>
            ${r'<#else>'}
            <p class="text-danger">查询不到相关资料</p>
            ${r'</#if>'}
        </div>

    </div>
</div>

<!-- json编辑器 -->
<div class="modal fade" id="jsonModal" tabindex="-1" role="dialog" aria-labelledby="jsonModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="jsonModalLabel">Json editor</h4>
                <h5 class="modal-title" id="jsonModalLabel">删除key即可删除字段</h5>
            </div>

            <div class="modal-body">
                <div id="editor" class="json-editor"></div>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-labelledby="messageLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="messageTitle">结果</h4>
            </div>
            <div class="modal-body">
                <p id="messageText" class="text-left"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="confirmDelete" class="btn btn-primary" data-loading-text="<i class='fa fa-spinner fa-spin'></i> 请稍等..">继续</button>
            </div>
        </div>
    </div>
</div>

<script src="../../../js/jquery.min.js"></script>
<script src="../../../js/bootstrap.min.js"></script>
<script src="../../../js/holder.min.js"></script>
<script src="../../../js/jquery.jsoneditor.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
        var deleteFlag = false;
        $("input").each(function(){
            $(this).click(function(){
                var input = $(this);
                var val = input.val();
                val = val.replace(/'/g,'"');

                if (tryParseJSON(val)) {
                    try { json = JSON.parse(val); }
                    catch (e) { alert('Error in parsing json. ' + e); }

                    $('#editor').jsonEditor(json, {
                        change: function(data){
                            json = data;
                            input.val(JSON.stringify(json));
                        },
                        propertyclick: function(path){
                            $('#path').text(path);
                        }
                    });

                    $('#jsonModal').modal('toggle');
                } else {
                    json = {};
                }
            });
        });

        $("#submit").click(function(){
            var $this = $(this);
            $this.button('loading');

            $.ajax({
                url: "../../../${lowerFirstLetterName}/update/",
                data: $('#detail').serialize(),
                type:"post",
                dataType:'text',

                success: function(msg){
                    $('#messageTitle').html("结果");
                    $("#confirmDelete").hide();
                    $("#messageText").html("修改成功");
                    $('#messageModal').modal('toggle');
                    $this.button('reset');
                },
                error:function(xhr, ajaxOptions, thrownError){
                    $('#messageTitle').html("结果");
                    $("#confirmDelete").hide();
                    $("#messageText").html("修改失败<br>"+thrownError);
                    $('#messageModal').modal('toggle');
                    $this.button('reset');
                }
            });
        });

        $("#delete").click(function(){
            $('#messageTitle').html("请确认");
            $("#messageText").html("执行后将无法找回数据，是否继续执行？");
            $("#confirmDelete").show();
            $('#messageModal').modal('toggle');
        });

        $("#confirmDelete").click(function(){
            var $this = $(this);
            $this.button('loading');
            $.ajax({
                url: "../../../${lowerFirstLetterName}/delete/" + $("#input${primaryKey}").val(),
                type:"post",
                dataType:'text',

                success: function(msg){
                    $('#messageTitle').html("结果");
                    $("#confirmDelete").hide();
                    $("#messageText").html("删除成功");
                    $this.button('reset');
                    deleteFlag = true;
                },
                error:function(xhr, ajaxOptions, thrownError){
                    $('#messageTitle').html("结果");
                    $("#confirmDelete").hide();
                    $("#messageText").html("删除失败<br>"+thrownError);
                    $this.button('reset');
                }
            });
        });

        $('#messageModal').on('hidden.bs.modal', function (e) {
            if (deleteFlag)
                window.location.href = "../list";
        });
    });

    function tryParseJSON (jsonString){
        try {
            var o = JSON.parse(jsonString);
            if (o && typeof o === "object" && o !== null) {
                return o;
            }
        }
        catch (e) { }

        return false;
    };
</script>

</body>

</html>