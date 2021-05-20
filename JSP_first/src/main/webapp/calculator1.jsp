<%-- 
    Document   : calculator1
    Created on : May 17, 2021, 1:53:40 PM
    Author     : Latiude 7480
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculator</title>
    </head>
    <script>
        var text=""
        function setText(c){
            if(c=='='){
                text=eval(text);
                
            }
            else if(c=='C'){
                text="";
            }
            else{
                text+=c
                
            }
            document.getElementById("text").value = text
            
            
        }
    </script>
    <body>
        <input type="text" id="text">
        <div>
            <button onclick="setText('7')">7</button>
            <button onclick="setText('8')">8</button>
            <button onclick="setText('9')">9</button>
            <button onclick="setText('/')">/</button>
            
        </div>
                <div>
            <button onclick="setText('4')">4</button>
            <button onclick="setText('5')">5</button>
            <button onclick="setText('6')">6</button>
            <button onclick="setText('*')">x</button>
            
        </div>
                <div>
            <button onclick="setText('1')">1</button>
            <button onclick="setText('2')">2</button>
            <button onclick="setText('3')">3</button>
            <button onclick="setText('-')">-</button>
            
        </div>
                <div>
            <button onclick="setText('0')">0</button>
            <button onclick="setText('C')">C</button>
            <button onclick="setText('=')">=</button>
            <button onclick="setText('+')">+</button>
            
        </div>
    </body>
</html>
