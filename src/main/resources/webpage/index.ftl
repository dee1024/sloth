
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="Chihche">
    <!-- <link rel="icon" href="../../favicon.ico"> -->
    <title>sloth - Bbuild Tool</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/cover.css" rel="stylesheet">
</head>
<style type="text/css">
    .help-white{
        display: block;
        margin-top: 5px;
        margin-bottom: 10px;
        color: #eee;
    }
    #messageModal{
        color: #333;
        text-shadow: 0px 0px rgba(0,0,0,0);
    }
</style>
<body>
<div class="site-wrapper">

    <div class="site-wrapper-inner">

        <div class="cover-container">

            <div class="masthead clearfix">
                <div class="inner">
                    <h3 class="masthead-brand">sloth</h3>
                    <nav>
                        <ul class="nav masthead-nav">
                            <li id="homeTab" class="active"><a href="#home" data-toggle="tab">Home</a></li>
                            <li id="buildTab"><a href="#build" data-toggle="tab">Build</a></li>
                            <li id="aboutTab"><a href="#about" data-toggle="tab">About</a></li>
                        </ul>
                    </nav>
                </div>
            </div>

            <div class="tab-content">
                <div class="tab-pane fade in active" id="home">
                    <div class="inner cover">
                        <h1 class="cover-heading">sloth - 构建工具</h1>
                        <p class="lead">轻松、简单、快速，帮您踏出第一步的工具</p>
                        <p class="lead">透过数据库的结构，自动生成项目，帮您略过繁杂且重复的动作！</p>
                        <p class="lead">目前提供框架</p>
                        <br>

                        <ul class="text-left">
                            <li>Spring + SpringMVC + MyBatis</li>
                            <li>Spring + SpringMVC + SpringJdbcTemplate</li>
                            <li>Spring + SpringMVC + Jooq</li>
                        </ul>
                        <br>
                        <br>

                        <p class="lead">
                            <a href="#build" id="start" data-toggle="tab" class="btn btn-lg btn-default">Start</a>
                        </p>
                    </div>
                </div>

                <div class="tab-pane fade" id="build" style="padding-bottom:12%;">
                    <div class="inner cover">
                        <h1 class="cover-heading">Build</h1>
                        <nav>
                            <ul class="nav masthead-nav">
                                <li id="dbTab" class="active"><a href="#dbset" data-toggle="tab">DB设置</a></li>
                                <li id="projextTab"><a href="#projextset" data-toggle="tab">项目设置</a></li>
                            </ul>
                        </nav>
                        <form id="detail" role="form" class="center-block">
                            <div class="tab-content">
                                <div class="tab-pane fade in active" id="dbset">
                                    <div class="form-group">
                                        <label for="inputDBHost" class="sr-only">host</label>
                                        <input type="text" id="inputDBHost" name="host" class="form-control" placeholder="Host" value="localhost" required autofocus>
                                        <p class="text-left help-white">数据库地址</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputDBPort" class="sr-only">port</label>
                                        <input type="number" id="inputDBPort" name="port" class="form-control" placeholder="Port" required value="3306">
                                        <p class="text-left help-white">数据库Port</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputDBUsername" class="sr-only">username</label>
                                        <input type="text" id="inputDBUsername" name="username" class="form-control" placeholder="Username" required value="root">
                                        <p class="text-left help-white">数据库使用者</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputDBPassword" class="sr-only">password</label>
                                        <input type="text" id="inputDBPassword" name="password" class="form-control" placeholder="Password" required>
                                        <p class="text-left help-white">数据库密码</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputDBSchema" class="sr-only">schema</label>
                                        <input type="text" id="inputDBSchema" name="schema" class="form-control" placeholder="Database Schema" required>
                                        <p class="text-left help-white">数据库名</p>
                                    </div>

                                    <button type="button" id="next" class="btn btn-default btn-lg" data-toggle="tab">Next</button>
                                </div>

                                <div class="tab-pane fade" id="projextset">
                                    <div class="form-group">
                                        <label for="inputProjectname" class="sr-only">projectName</label>
                                        <input type="text" id="inputProjectname" name="projectName" class="form-control" placeholder="generated-sources-by-sloth" required>
                                        <p class="text-left help-white">项目名称</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputPackage" class="sr-only">packageName</label>
                                        <input type="text" id="inputPackage" name="packageName" class="form-control" placeholder="com.sloth.generated" required>
                                        <p class="text-left help-white">项目包名</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputPath" class="sr-only">path</label>
                                        <input type="text" id="inputPath" name="path" class="form-control" placeholder="Path" required>
                                        <p class="text-left help-white">生成目标地址 如:/Users/Chihche/Documents/Project</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputStrategy" class="sr-only">strategy</label>
                                        <select class="form-control" id="inputStrategy" name="strategy">
                                            <option value="ssm">Spring + SpringMVC + MyBatis</option>
                                            <option value="sss">Spring + SpringMVC + SpringJdbcTemplate</option>
                                            <option value="ssj">Spring + SpringMVC + Jooq</option>
                                        </select>
                                        <p class="text-left help-white">生成模式</p>
                                    </div>

                                    <button type="button" id="submit" class="btn btn-default btn-lg" data-loading-text="<i class='fa fa-spinner fa-spin'></i> 请稍等..">送出</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="tab-pane fade" id="about">
                    <div class="inner cover">
                        <h1 class="cover-heading">About</h1>
                        <p class="lead">轻松、简单、快速，帮您踏出第一步的工具</p>
                        <p class="lead">透过数据库的结构，自动生成项目，帮您略过繁杂且重复的动作！</p>
                    </div>
                </div>
            </div>

            <div class="mastfoot">
                <div class="inner">
                    <p>sloth Build Tool 2016</p>
                    <p>V1.0 (Beta)</p>
                </div>
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
                <h4 class="modal-title" id="myModalLabel">构建结果</h4>
            </div>
            <div class="modal-body">
                <p id="messageText" class="text-left"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Ok</button>
            </div>
        </div>
    </div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
        $('#start').click(function(e){
            $("#homeTab").attr("class","");
            $("#buildTab").attr("class","active");
        });

        $('#next').click(function(e){
            $('a[href="#projextset"]').tab('show');
            $("#dbTab").attr("class","");
            $("#projextTab").attr("class","active");
        });

        $("#submit").click(function(){
            var $this = $(this);
            $this.button('loading');

            $.ajax({
                url: "build",
                data: $('#detail').serialize(),
                type:"post",
                dataType:'text',

                success: function(msg){
                    var obj = JSON.parse(msg);
                    if (obj.code==1){
                        $("#messageText").html("完成<br>"+obj.msg);
                        $('#messageModal').modal('toggle');
                    }
                    $this.button('reset');
                },
                error:function(xhr, ajaxOptions, thrownError){
                    $("#messageText").html("失败，请重试<br>"+thrownError);
                    $('#messageModal').modal('toggle');
                    $this.button('reset');
                }
            });
        });
    });
</script>
</body>
</html>
