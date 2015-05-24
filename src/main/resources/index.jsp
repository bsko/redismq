<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>MQ Testing</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
</head>
<body>
    <div class="container">
        <div class="header clearfix">
            <h3>MQ Testing!</h3>
        </div>

        <div class="col-lg-6">
            <p><input type="text" id="newmessage" class="form-control"/></p>
            <p><button id="addMessage" class="btn btn-default">Add Message</button></p>
        </div>
        <div class="col-lg-6">
            <p><span><button id="start" class="btn btn-default">Start listening</button></span>
                <span><button id="stop" class="btn btn-default">Stop listening</button></span></p>
            <div id="messages" class="panel panel-info">
                <div class="panel-heading">
                    <h4>Incoming messages</h4>
                </div>
                <ul class="list-group">
                    <li class="list-group-item">Gagarina will win the Eurovision</li>
                    <li class="list-group-item">Putin visited some new organization and felt satisfied</li>
                    <li class="list-group-item">Donbas is on fire again</li>
                </ul>
            </div>
        </div>
    </div>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        var socket = new WebSocket("ws://localhost:8080/message-queue/wsocket/mq");
        socket.onmessage = onMessage;
        function onMessage(event) {
            alert(event.data);
        }
    </script>
</body>
</html>