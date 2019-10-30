<%--
  Created by IntelliJ IDEA.
  User: Teerawut
  Date: 19/8/2562
  Time: 21:54
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>blog</title>
</head>

<body>

    <h1 class="text-center">Blog</h1>

    <g:form controller="blog" action="index" method="POST">

        <div class="row justify-content-center pt-4">
            <div class="form-group col-sm-4">
                <g:textField name="blog.title" id="title" value="${blog.title}"  class="form-control" placeholder="Title"/>
            </div>

            <div class="form-group col-sm-4">
                <g:textField name="blog.description" value="${blog.description}" class="form-control" placeholder="Description" />
            </div>

        </div>

        <div class="row">
            <div class="col-sm-12 text-center">
                <button type="submit" class="btn btn-primary">Search</button>&nbsp;
%{--                <button type="reset" class="btn btn-default">Reset</button>--}%
                <g:actionSubmit class="btn btn-success" value="Create" action="create" />
            </div>
        </div>
    </g:form>
    <div class="row">
        <div class="col-sm-12">
            <table id="blogTable" class="table table-striped table-hover table-secondary" width="100%">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <g:each status="idx" var="rs" in="${list}">
                    <tr>
                        <td>${idx + 1}</td>
                        <td>${rs.title}</td>
                        <td>${rs.description}</td>
                        <td class="text-right">
                        <g:link controller="blog" action="update" id="${rs.id}" class="btn btn-warning btn-sm">Edit</g:link>
                        <g:link controller="blog" action="delete" id="${rs.id}" class="btn btn-danger btn-sm">Delete</g:link>
                        </td>
                    </tr>
                </g:each>

                </tbody>
            </table>
        </div>
    </div>
</body>
</html>