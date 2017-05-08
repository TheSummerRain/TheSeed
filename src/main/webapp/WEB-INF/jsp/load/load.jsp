<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" ng-app>
<head>
    <meta charset="utf-8">
    <title></title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta content="yes" name="apple-mobile-web-app-capable" />
    <meta content="black" name="apple-mobile-web-app-status-bar-style" />
    <meta content="telephone=no" name="format-detection" />
    <style>


        /* css reset */
        body,p,h2,h3,h4,h5,ul,ol,li,form,input,td,th,dl,dd,td,th{margin:0;padding:0;}
        input{border:none;outline:none; background:none;}
        em{font-style:normal;}
        li{list-style:none; vertical-align:top;}
        img{border:none;vertical-align:top;}
        a{text-decoration:none; outline:none;}
        a:hover, a:focus{outline:none;text-decoration:none;}
        p{line-height: inherit;}
        .clear{zoom:1}
        .clear:after{content:"";display:block; clear:both;}

        .loader {font-size:10px;width: 1em;height: 1em;border-radius: 50%;position: absolute;text-indent: -9999em;left:46%;top:46%;-webkit-animation: load5 1.1s infinite ease;animation: load5 1.1s infinite ease;}
        @-webkit-keyframes load5 {
            0%,

            100% {

                box-shadow: 0em -2.6em 0em 0em #0a0, 1.8em -1.8em 0 0em rgba(0,170,0, 0.2), 2.5em 0em 0 0em rgba(0,170,0, 0.2), 1.75em 1.75em 0 0em rgba(0,170,0, 0.2), 0em 2.5em 0 0em rgba(0,170,0, 0.2), -1.8em 1.8em 0 0em rgba(0,170,0, 0.2), -2.6em 0em 0 0em rgba(0,170,0, 0.5), -1.8em -1.8em 0 0em rgba(0,170,0, 0.7);}

            12.5% {

                box-shadow: 0em -2.6em 0em 0em rgba(0,170,0, 0.7), 1.8em -1.8em 0 0em #0a0, 2.5em 0em 0 0em rgba(0,170,0, 0.2), 1.75em 1.75em 0 0em rgba(0,170,0, 0.2), 0em 2.5em 0 0em rgba(0,170,0, 0.2), -1.8em 1.8em 0 0em rgba(0,170,0, 0.2), -2.6em 0em 0 0em

                rgba(0,170,0, 0.2), -1.8em -1.8em 0 0em rgba(0,170,0, 0.5);

            }

            25% {

                box-shadow: 0em -2.6em 0em 0em rgba(0,170,0, 0.5), 1.8em

                -1.8em 0 0em rgba(0,170,0, 0.7), 2.5em 0em 0 0em #0a0, 1.75em

                1.75em 0 0em rgba(0,170,0, 0.2), 0em 2.5em 0 0em rgba(0,170,0, 0.2), -1.8em 1.8em 0 0em rgba(0,170,0, 0.2), -2.6em 0em 0 0em

                rgba(0,170,0, 0.2), -1.8em -1.8em 0 0em rgba(0,170,0, 0.2);

            }

            37.5% {

                box-shadow: 0em -2.6em 0em 0em rgba(0,170,0, 0.2), 1.8em

                -1.8em 0 0em rgba(0,170,0, 0.5), 2.5em 0em 0 0em rgba(0, 170,

                        0, 0.7), 1.75em 1.75em 0 0em rgba(0,170,0, 0.2), 0em 2.5em 0 0em

                rgba(0,170,0, 0.2), -1.8em 1.8em 0 0em rgba(0,170,0, 0.2),

                -2.6em 0em 0 0em rgba(0,170,0, 0.2), -1.8em -1.8em 0 0em rgba(0,170,0, 0.2);}

            50% {

                box-shadow: 0em -2.6em 0em 0em rgba(0,170,0, 0.2), 1.8em

                -1.8em 0 0em rgba(0,170,0, 0.2), 2.5em 0em 0 0em rgba(0,170,0, 0.5), 1.75em 1.75em 0 0em rgba(0,170,0, 0.7), 0em 2.5em 0 0em

                #0a0, -1.8em 1.8em 0 0em rgba(0,170,0, 0.2), -2.6em 0em 0 0em

                rgba(0,170,0, 0.2), -1.8em -1.8em 0 0em rgba(0,170,0, 0.2);

            }

            62.5% {

                box-shadow: 0em -2.6em 0em 0em rgba(0,170,0, 0.2), 1.8em

                -1.8em 0 0em rgba(0,170,0, 0.2), 2.5em 0em 0 0em rgba(0,170,0, 0.2), 1.75em 1.75em 0 0em rgba(0,170,0, 0.5), 0em 2.5em 0 0em

                rgba(0,170,0, 0.7), -1.8em 1.8em 0 0em #0a0, -2.6em 0em 0 0em

                rgba(0,170,0, 0.2), -1.8em -1.8em 0 0em rgba(0,170,0, 0.2);

            }

            75% {

                box-shadow: 0em -2.6em 0em 0em rgba(0,170,0, 0.2), 1.8em

                -1.8em 0 0em rgba(0,170,0, 0.2), 2.5em 0em 0 0em rgba(0,170,0, 0.2), 1.75em 1.75em 0 0em rgba(0,170,0, 0.2), 0em 2.5em 0 0em

                rgba(0,170,0, 0.5), -1.8em 1.8em 0 0em rgba(0,170,0, 0.7),

                -2.6em 0em 0 0em #0a0, -1.8em -1.8em 0 0em rgba(0,170,0, 0.2);

            }

            87.5% {

                box-shadow: 0em -2.6em 0em 0em rgba(0,170,0, 0.2), 1.8em

                -1.8em 0 0em rgba(0,170,0, 0.2), 2.5em 0em 0 0em rgba(0,170,0, 0.2), 1.75em 1.75em 0 0em rgba(0,170,0, 0.2), 0em 2.5em 0 0em

                rgba(0,170,0, 0.2), -1.8em 1.8em 0 0em rgba(0,170,0, 0.5),

                -2.6em 0em 0 0em rgba(0,170,0, 0.7), -1.8em -1.8em 0 0em #0a0;

            }

        }

        @keyframes load5 {

            0%,

            100% {

                box-shadow: 0em -2.6em 0em 0em #0a0, 1.8em -1.8em 0 0em rgba(0,170,0, 0.2), 2.5em 0em 0 0em rgba(0,170,0, 0.2), 1.75em 1.75em

                0 0em rgba(0,170,0, 0.2), 0em 2.5em 0 0em rgba(0,170,0,

                        0.2), -1.8em 1.8em 0 0em rgba(0,170,0, 0.2), -2.6em 0em 0 0em

                rgba(0,170,0, 0.5), -1.8em -1.8em 0 0em rgba(0,170,0, 0.7);

            }

            12.5% {

                box-shadow: 0em -2.6em 0em 0em rgba(0,170,0, 0.7), 1.8em

                -1.8em 0 0em #0a0, 2.5em 0em 0 0em rgba(0,170,0, 0.2), 1.75em

                1.75em 0 0em rgba(0,170,0, 0.2), 0em 2.5em 0 0em rgba(0,170,0, 0.2), -1.8em 1.8em 0 0em rgba(0,170,0, 0.2), -2.6em 0em 0 0em

                rgba(0,170,0, 0.2), -1.8em -1.8em 0 0em rgba(0,170,0, 0.5);

            }

            25% {

                box-shadow: 0em -2.6em 0em 0em rgba(0,170,0, 0.5), 1.8em

                -1.8em 0 0em rgba(0,170,0, 0.7), 2.5em 0em 0 0em #0a0, 1.75em

                1.75em 0 0em rgba(0,170,0, 0.2), 0em 2.5em 0 0em rgba(0,170,0, 0.2), -1.8em 1.8em 0 0em rgba(0,170,0, 0.2), -2.6em 0em 0 0em

                rgba(0,170,0, 0.2), -1.8em -1.8em 0 0em rgba(0,170,0, 0.2);

            }

            37.5% {

                box-shadow: 0em -2.6em 0em 0em rgba(0,170,0, 0.2), 1.8em

                -1.8em 0 0em rgba(0,170,0, 0.5), 2.5em 0em 0 0em rgba(255, 255,

                        255, 0.7), 1.75em 1.75em 0 0em rgba(0,170,0, 0.2), 0em 2.5em 0 0em

                rgba(0,170,0, 0.2), -1.8em 1.8em 0 0em rgba(0,170,0, 0.2),

                -2.6em 0em 0 0em rgba(0,170,0, 0.2), -1.8em -1.8em 0 0em rgba(0,170,0, 0.2);

            }

            50% {

                box-shadow: 0em -2.6em 0em 0em rgba(0,170,0, 0.2), 1.8em

                -1.8em 0 0em rgba(0,170,0, 0.2), 2.5em 0em 0 0em rgba(0,170,0, 0.5), 1.75em 1.75em 0 0em rgba(0,170,0, 0.7), 0em 2.5em 0 0em

                #0a0, -1.8em 1.8em 0 0em rgba(0,170,0, 0.2), -2.6em 0em 0 0em

                rgba(0,170,0, 0.2), -1.8em -1.8em 0 0em rgba(0,170,0, 0.2);

            }

            62.5% {

                box-shadow: 0em -2.6em 0em 0em rgba(0,170,0, 0.2), 1.8em

                -1.8em 0 0em rgba(0,170,0, 0.2), 2.5em 0em 0 0em rgba(0,170,0, 0.2), 1.75em 1.75em 0 0em rgba(0,170,0, 0.5), 0em 2.5em 0 0em

                rgba(0,170,0, 0.7), -1.8em 1.8em 0 0em #0a0, -2.6em 0em 0 0em

                rgba(0,170,0, 0.2), -1.8em -1.8em 0 0em rgba(0,170,0, 0.2);

            }

            75% {

                box-shadow: 0em -2.6em 0em 0em rgba(0,170,0, 0.2), 1.8em

                -1.8em 0 0em rgba(0,170,0, 0.2), 2.5em 0em 0 0em rgba(0,170,0, 0.2), 1.75em 1.75em 0 0em rgba(0,170,0, 0.2), 0em 2.5em 0 0em

                rgba(0,170,0, 0.5), -1.8em 1.8em 0 0em rgba(0,170,0, 0.7),

                -2.6em 0em 0 0em #0a0, -1.8em -1.8em 0 0em rgba(0,170,0, 0.2);

            }

            87.5% {

                box-shadow: 0em -2.6em 0em 0em rgba(0,170,0, 0.2), 1.8em

                -1.8em 0 0em rgba(0,170,0, 0.2), 2.5em 0em 0 0em rgba(0,170,0, 0.2), 1.75em 1.75em 0 0em rgba(0,170,0, 0.2), 0em 2.5em 0 0em

                rgba(0,170,0, 0.2), -1.8em 1.8em 0 0em rgba(0,170,0, 0.5),

                -2.6em 0em 0 0em rgba(0,170,0, 0.7), -1.8em -1.8em 0 0em #0a0;

            }

        }



    </style>
</head>
<body>
<div class="loader"></div>
<form action="<%=basePath %>/Wx/getUserFromWx" method="post" id="form">
    <input type="hidden" value="${code }" name="code" >
    <input type="hidden" value="<%=basePath %>/${targetUrl }" name="view">
</form>
</body>
<script type="text/javascript">
    window.document.getElementById("form").submit();
</script>
</html>