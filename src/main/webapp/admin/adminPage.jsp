<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%><html xmlns:th="http://www.thymeleaf.org" xmlns:tiles="http://www.thymeleaf.org">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
    <title tiles:fragment="title">Messages : Create</title>
</head>
<body>
<div tiles:fragment="content">
    <form name="f5" th:action="@{/admin/adminPage}" method="post">
        <fieldset>
            <label for="personName">Имя</label>
            <input type="text" id="personName" name="personName"/>
            <label for="personMiddleName">Отчество</label>
            <input type="text" id="personMiddleName" name="personMiddleName"/>
            <label for="personSurName">Фамилия</label>
            <input type="text" id="personSurName" name="personSurName"/>
            <br>
            <label for="address">Адрес</label>
            <input type="text" id="address" name="address"/>
            <label for="phone">Номер телефона</label>
            <input type="text" id="phone" name="phone"/>
            <label for="birthdate">Дата рождения</label>
            <input type="text" id="birthdate" name="birthdate"/>
            <input type="text" style="display: none;" id="addPerson" name="action" value="addPerson"/>
            <div class="form-actions">
                <button type="submit" class="btn">Добавить избирателя</button>
            </div>
        </fieldset>
    </form>
    <c:if test="${not empty addedPerson}">

        <ul>
            <c:forEach var="personValue" items="${addedPerson}">
                <li>${personValue}</li>
            </c:forEach>
        </ul>
    </c:if>


    <form name="f6" th:action="@{/admin/adminPage}" method="post">
        <fieldset>
            <label for="description">Описание выборов</label>
            <input type="text" id="description" name="description"/>
            <label for="addressVote">Адрес голосования</label>
            <input type="text" id="addressVote" name="addressVote"/>
            <label for="voteDate">Дата голосования</label>
            <input type="text" id="voteDate" name="voteDate"/>
            <input type="text" style="display: none;" id="addVote" name="action" value="addVote"/>
            <div class="form-actions">
                <button type="submit" class="btn">Добавить выборы</button>
            </div>
        </fieldset>
    </form>
    <c:if test="${not empty addedVote}">

        <ul>
            <c:forEach var="personValue" items="${addedVote}">
                <li>${personValue}</li>
            </c:forEach>
        </ul>
    </c:if>

    <form name="f7" th:action="@{/admin/adminPage}" method="post">
        <fieldset>
            <form:select name="voteId" path="votes">
                <form:option value="0" label="Список выборов"/>
                <form:options items="${voteList}" />
            </form:select>
            <form:select name="personId"  path="people">
                <form:option value="0" label="Список избирателей"/>
                <form:options items="${personList}" />
            </form:select>
            <form:select name="voted"  path="personVote">
                <form:option value="false" label="Голосовал"/>
                <form:option value="true" label="Не голосовал"/>
            </form:select>
            <legend>Список участвовавших в выборах</legend>
            <input type="text" style="display: none;" id="showByVote" name="action" value="addPersonVote"/>
            <div class="form-actions">
                <button type="submit" class="btn" >Добавить факт голосования/право голоса</button>
            </div>
        </fieldset>
    </form>
    <c:if test="${not empty addedPersonVote}">

        <ul>
            <c:forEach var="personValue" items="${addedPersonVote}">
                <li>${personValue}</li>
            </c:forEach>
        </ul>
    </c:if>

    <form name="f8" th:action="@{/admin/adminPage}" method="post">
        <fieldset>
            <form:select name="voteId" path="votess">
                <form:option value="0" label="Список выборов"/>
                <form:options items="${voteList}" />
            </form:select>
            <legend>Удалить выборы</legend>
            <input type="text" style="display: none;" id="deleteVote" name="action" value="deleteVote"/>
            <div class="form-actions">
                <button type="submit" class="btn" >Удалить выборы</button>
            </div>
        </fieldset>
    </form>
    <c:if test="${not empty deletedVote}">

        <ul>
            <c:forEach var="personValue" items="${deletedVote}">
                <li>${personValue}</li>
            </c:forEach>
        </ul>
    </c:if>

    <form name="f9" th:action="@{/admin/adminPage}" method="post">
        <fieldset>
            <form:select name="personId" path="peoplee">
                <form:option value="0" label="Список избирателей"/>
                <form:options items="${personList}" />
            </form:select>
            <legend>Удалить избирателя</legend>
            <input type="text" style="display: none;" id="deletePerson" name="action" value="deletePerson"/>
            <div class="form-actions">
                <button type="submit" class="btn" >Удалить избирателя</button>
            </div>
        </fieldset>
    </form>
    <c:if test="${not empty deletedPerson}">

        <ul>
            <c:forEach var="personValue" items="${deletedPerson}">
                <li>${personValue}</li>
            </c:forEach>
        </ul>
    </c:if>

    <form name="f10" th:action="@{/admin/adminPage}" method="post">
        <fieldset>
            <form:select name="personVoteIds" path="personVotes">
                <form:option value="0-0" label="Список избирателей на выборах"/>
                <form:options items="${personVoteList}" />
            </form:select>
            <legend>Список избирателей на выборах</legend>
            <input type="text" style="display: none;" id="deletePersonVote" name="action" value="deletePersonVote"/>
            <div class="form-actions">
                <button type="submit" class="btn" >Удалить факт голосования/право голоса</button>
            </div>
        </fieldset>
    </form>
    <c:if test="${not empty deletedPersonVote}">

        <ul>
            <c:forEach var="personValue" items="${deletedPersonVote}">
                <li>${personValue}</li>
            </c:forEach>
        </ul>
    </c:if>
</div>
</body>
</html>