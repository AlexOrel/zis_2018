<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%><html xmlns:th="http://www.thymeleaf.org" xmlns:tiles="http://www.thymeleaf.org">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
    <title tiles:fragment="title">Messages : Create</title>
</head>
<body>
<div tiles:fragment="content">
    <form name="f" th:action="@{/page}" method="post">
        <fieldset>
            <legend>Нажмите на кнопку, чтобы вывести однофамильцев</legend>
            <input type="text" style="display: none;" id="showNameSakes" name="action" value="findNamesakes"/>
            <div class="form-actions">
                <button type="submit" class="btn" >Показать однофамильцев</button>
            </div>
        </fieldset>
    </form>
    <c:out value="${redPushkin}" escapeXml="false"/>
    <c:if test="${not empty lists}">

        <ul>
            <c:forEach var="listValue" items="${lists}">
                <li>${listValue}</li>
            </c:forEach>
        </ul>

    </c:if>
    <form name="f2" th:action="@{/page}" method="post">
        <fieldset>
            <legend>Нажмите на кнопку, чтобы найти всех, кто принимал участие в выборах</legend>
            <input type="text" style="display: none;" id="showVoted" name="action" value="findVoted"/>
            <div class="form-actions">
                <button type="submit" class="btn" >Показать принимавших участие в выборах</button>
            </div>
        </fieldset>
    </form>
    <c:if test="${not empty voted}">

        <ul>
            <c:forEach var="votedValue" items="${voted}">
                <li>${votedValue}</li>
            </c:forEach>
        </ul>

    </c:if>

    <form name="f3" th:action="@{/page}" method="post">
        <fieldset>
            <legend>Нажмите на кнопку, чтобы найти всех, кто не принимал участие в выборах</legend>
            <input type="text" style="display: none;" id="showUnVoted" name="action" value="findUnVoted"/>
            <div class="form-actions">
                <button type="submit" class="btn" >Показать не принимавших участие в выборах</button>
            </div>
        </fieldset>
    </form>
    <c:if test="${not empty unvoted}">

        <ul>
            <c:forEach var="unvotedValue" items="${unvoted}">
                <li>${unvotedValue}</li>
            </c:forEach>
        </ul>

    </c:if>


    <form name="f4" th:action="@{/page}" method="post">
        <fieldset>
            <form:select name="voteId"  path="votes">
                <form:option value="0" label="--- Select ---"/>
                <form:options items="${voteList}" />
            </form:select>
            <legend>Список участвовавших в выборах</legend>
            <input type="text" style="display: none;" id="showByVote" name="action" value="getByVote"/>
            <div class="form-actions">
                <button type="submit" class="btn" >Показать имеющих право голоса по адресу и дате выборов</button>
            </div>
        </fieldset>
    </form>

    <c:if test="${not empty peopleByVote}">

        <ul>
            <c:forEach var="personValue" items="${peopleByVote}">
                <li>${personValue}</li>
            </c:forEach>
        </ul>

    </c:if>

    <form name="f5" th:action="@{/page}" method="post">
        <fieldset>
            <label for="voteDateTime">Дата-время выборов</label>
            <input type="text" id="voteDateTime" name="voteDateTime"/>
            <input type="text" style="display: none;" id="showByDate" name="action" value="getByDate"/>
            <div class="form-actions">
                <button type="submit" class="btn">Показать имеющих право голоса по дате выборов</button>
            </div>
        </fieldset>
    </form>
    <c:if test="${not empty peopleByDate}">

        <ul>
            <c:forEach var="personValue" items="${peopleByDate}">
                <li>${personValue}</li>
            </c:forEach>
        </ul>

    </c:if>

    <form name="f5" th:action="@{/page}" method="post">
        <fieldset>
            <label for="voteAddress">Адрес выборов</label>
            <input type="text" id="voteAddress" name="voteAddress"/>
            <input type="text" style="display: none;" id="showByAddress" name="action" value="getByAddress"/>
            <div class="form-actions">
                <button type="submit" class="btn">Показать имеющих право голоса по адресу на текущую дату</button>
            </div>
        </fieldset>
    </form>
    <c:if test="${not empty peopleByAddress}">

        <ul>
            <c:forEach var="personValue" items="${peopleByAddress}">
                <li>${personValue}</li>
            </c:forEach>
        </ul>

    </c:if>
</div>
</body>
</html>