<%
String BasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
request.setAttribute( "BasePath",BasePath);
%>
