<%--
  Created by IntelliJ IDEA.
  User: mystic_alex
  Date: 16/07/16
  Time: 23:38
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Random Quote</title>
        <asset:javascript src="jquery.js"/>

        %{--<g:javascript library="jquery" />--}%
    </head>
    <body>
        <ul id="menu">
            <li>
                <g:remoteLink action="ajaxRandom" update="quote">
                    Next Quote
                </g:remoteLink>
            </li>

            <li>
                <g:link action="index">
                    Admin
                </g:link>
            </li>
        </ul>

        <div id="quote">
            <q>${quote.content}</q>
            <p><i>${quote.author}</i></p>
        </div>
    </body>
</html>