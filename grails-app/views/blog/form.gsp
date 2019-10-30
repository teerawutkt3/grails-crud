<%--
  Created by IntelliJ IDEA.
  User: Teerawut
  Date: 10/28/2019
  Time: 5:38 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Form</title>
</head>

<body>
%{--    <g:hiddenField name="blog.id" value="${blog.id}">--}%
    <div class="row">
    <div class="col-sm-5">
        <h3>Blog</h3>
        <g:form controller="blog" action="save" method="post">
            <input type="hidden" name="blog.id" value="${blog.id}">

                <div class="form-group">
                    <g:textField name="blog.title" value="${blog.title}"  class="form-control" placeholder="Title"/>
                </div>

                <div class="form-group">
                   <g:textField name="blog.description" value="${blog.description}" class="form-control" placeholder="Description" />
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Save</button>&nbsp;
                    <button type="reset" class="btn btn-default">Reset</button>
                    <g:actionSubmit class="btn btn-dark" value="Back" action="index" />
                </div>
            </g:form>
        </div>
    </div>
</body>
</html>