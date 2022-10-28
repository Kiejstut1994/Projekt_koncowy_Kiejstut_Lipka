
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<style>
    #validationDefault02 {
    }
</style>
<main id="main" class="main">

    <div class="pagetitle">
        <h1>Formularz rejestracji</h1>

    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-6">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Witamy w formularzu rejestracji, wypełnij poniższe dane aby móc coś kupić</h5>
                        <p>Żadne dane nie mogą być fałszywe. Wprowadzenie w błąd grozi karą do 3 lat więzienia</p>
                        <div  class="col-md-4">
                        <form:form class="row g-3" action="/purchaserform" method="post" modelAttribute="purchaser" >
                            Imię:
                            <form:input name="name" placeholder="Podaj imię" type="text"  class="form-control"  path="name"/>
                            <form:errors path="name" />
                            </br>
                            Nazwisko:
                            <form:input path="surname" name="surname" type="text" placeholder="Podaj nazwisko" class="form-control" />
                            <form:errors path="surname"  />
                            </br>
                            PESEL:
                            <form:input name="PESEL" path="PESEL" type="text" class="form-control" placeholder="PESEL" />
                            <form:errors path="PESEL"  />
                            </br>
                            <c:if test="${repeatpesel==1}">
                                Taki PESEL już istnieje w bazie danych
                            </c:if>
                            </br>
                            Email:
                            <form:input path="email" name="email" type="text" class="form-control" placeholder="Email" />
                            <form:errors path="email" />
                            </br>
                            <c:if test="${repeatemail==1}">
                                Taki email już istnieje w bazie danych
                            </c:if>

                            </br>
                                        <label class="form-check-label" for="invalidCheck2">
                                            Akceptuję regulamin
                                        </label>
                                <input class="form-check-input" type="checkbox" placeholder="Akceptuję warunki regulaminu" value="agreement" id="invalidCheck2" required>
                            </br>
                                <button class="btn btn-primary" type="submit">Dodaj kupującego</button>

                            </form:form>
                            </div>

                    </div>

                </div>

            </div>

        </div>
    </section>

</main><!-- End #main -->

<%--<form:input path="age" />--%>
<%--<form:errors path="age" cssClass="error" />--%>
<%--<span id="age.errors" class="error">Musi mieć przynajmniej 18 lat</span>--%>



<%--<form class="row g-3" action="/purchaserform" method="post">--%>
<%--    <div  for="validationCustom01" class="col-md-4">--%>
<%--        <label  class="form-label">First name</label>--%>
<%--        <input name="name" type="text"  class="form-control" placeholder="name"/>--%>
<%--    </div>--%>
<%--    <div  for="validationCustom05" class="col-md-4">--%>
<%--        <label  class="form-label">Second name</label>--%>
<%--        <input name="surname"type="text" class="form-control" placeholder="secondname" required>--%>
<%--    </div>--%>
<%--    <div  for="validationCustom05" class="col-md-4">--%>
<%--        <label  class="form-label">Password</label>--%>
<%--        <input name="password" class="form-control" placeholder="password" type="password" required>--%>
<%--    </div>--%>
<%--    <div  for="validationCustom05" class="col-md-4">--%>
<%--        <label  class="form-label">PESEL</label>--%>
<%--        <input name="PESEL" type="text" class="form-control" placeholder="PESEL" required>--%>
<%--    </div>--%>
<%--    <div  for="validationCustom05" class="col-md-4">--%>
<%--        <label  class="form-label">Email</label>--%>
<%--        <input name="email" type="text" class="form-control" placeholder="email" required>--%>
<%--    </div>--%>
<%--    <div  for="validationCustom05" class="col-md-4">--%>
<%--        <label  class="form-label">Street</label>--%>
<%--        <input name="street" type="text" class="form-control" placeholder="street" required>--%>
<%--    </div>--%>
<%--    <div  for="validationCustom05" class="col-md-4">--%>
<%--        <label  class="form-label">Flatnumber</label>--%>
<%--        <input name="flatnumber" type="text"  class="form-control"  placeholder="flatnumber" required>--%>
<%--    </div>--%>
<%--    <div for="validationCustom05" class="col-md-4">--%>
<%--        <label  class="form-label">Housenumber</label>--%>
<%--        <input name="housenumber" type="text" class="form-control" id="validationCustom05" placeholder="housenumber" >--%>
<%--    </div>--%>
<%--    <div for="validationCustom05" class="col-md-4">--%>
<%--        <label  class="form-label">Postcode</label>--%>
<%--        <input name="postcode" type="text" class="form-control" placeholder="postcode" >--%>
<%--    </div>--%>
<%--    <div class="col-12">--%>
<%--        <div class="form-check">--%>
<%--            <input class="form-check-input" type="checkbox" value="agreement" id="invalidCheck2" required>--%>
<%--            <label class="form-check-label" for="invalidCheck2">--%>
<%--                Agreement due to rules--%>
<%--            </label>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div class="col-12">--%>
<%--        <button class="btn btn-primary" type="submit">Submit form</button>--%>
<%--    </div>--%>
<%--</form>--%>


<%@ include file="footer.jsp" %>