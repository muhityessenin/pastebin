<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Paste Created</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f9f9f9;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            text-align: center;
        }
        .message {
            margin: 20px 0;
            font-size: 1.2em;
        }
        .url {
            margin: 20px 0;
            font-size: 1.1em;
            word-break: break-all;
        }
        .url a {
            color: #007bff;
            text-decoration: none;
        }
        .url a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Paste Created Successfully</h1>
    <p class="message">Your paste has been created successfully. You can view it here:</p>
    <p class="url"><a href="/paste/${paste.url}">${paste.url}</a></p>
</div>
</body>
</html>
