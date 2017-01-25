<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cz.capgemini.phonebook.domain.Person"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<jsp:useBean id="phoneBookEngine" class="cz.capgemini.phonebook.engine.PhoneBookEngine" scope="session"/>

<html>
    <head>
        <title>CG Phonebook</title>
        <link rel="SHORTCUT ICON" href="res/favicon.ico">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="styles.css">
        
        <script src="http://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
        <script src="scripts.js"></script>
        

    </head>
    <body>

        <div align="center">
            <IMG SRC="res/logo.png"><br/>               

            <input type ="text" cols="30" rows="1" NAME="input" placeholder="Search here.." id="inputField"/></br></br>

            <table id="phoneList" align="center">
                <tr>
                    <th>SURNAME</th>
                    <th>NAME</th>
                    <th>ID</th>
                    <th>PHONE</th>
                    <th>CELLPHONE</th>
                </tr> 

                <%
                    int odd = 0;
                    for (Person p : phoneBookEngine.getPersonsList()) {
                        odd++;
                %>

                <tr class="record <%= (odd % 2 == 0) ? "even" : "odd"%>">              

                    <td width="25%"><%=p.getSurname()%></td>
                    <td width="20%"><%=p.getName()%></td>
                    <td width="15%"><%=p.getId()%></td>
                    <td width="15%"><%=p.getPhone()%></td>
                    <td width="15%"><%=p.getCellphone()%></td>            

                </tr>            
                <% }%>

            </table><br/><br/>

            <font size="2"><i>@2016 Capgemini</i></font>
        </div>
    </body>
</html>
