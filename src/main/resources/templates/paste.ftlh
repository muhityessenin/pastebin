<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${paste.get().title}</title>
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
        }
        .header {
            text-align: center;
            border-bottom: 1px solid #ddd;
            margin-bottom: 20px;
        }
        .content {
            white-space: pre-wrap; /* Preserve whitespace and line breaks */
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h1>${paste.get().title}</h1>
        <p><em>Author: ${paste.get().author}</em></p>
    </div>
    <div class="content">
        <p>${content}</p>
    </div>
</div>
</body>
</html>
