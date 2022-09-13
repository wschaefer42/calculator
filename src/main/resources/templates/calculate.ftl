<html lang="en">
<head>
    <title>Calculate</title>
    <link href="/css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
<h2>Calculate</h2>
    <form action="/calculate/add" method="post">
        <div class="table-grid-2">
            <label for="first">First Value</label>
            <input type="number" id="first" name="first" value="${first}">
            <label for="second">Second Value</label>
            <input type="number" id="second" name="second" value="${second}">
            <div></div>
            <input type="submit" value="Add">
        </div>
        <br>
        <div id="result">
            ${result}
        </div>
    </form>
</body>
</html>