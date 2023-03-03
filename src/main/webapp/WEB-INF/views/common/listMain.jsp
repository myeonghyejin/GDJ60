<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row offset-md-3 col-md-3">
    <table class="table table-hover">
        <tbody>
            <c:forEach items="${list}" var="DTO" varStatus="i">
                <tr>
                    <td>${DTO.num}</td>
                    <td>
                        <a href="./detail?num=${DTO.num}">${DTO.title}</a>
                        
                        <c:if test="${i.first}">
                        	${DTO.contents}
                        </c:if>
                        
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${boardName eq 'notice'}">
                                관리자
                            </c:when>
                            <c:otherwise>
                                ${DTO.writer}
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>