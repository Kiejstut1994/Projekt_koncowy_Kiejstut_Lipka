
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
                        <h5 class="card-title">Podaj adres wysyłki</h5>
                        <p>Żadne dane nie mogą być fałszywe. Wprowadzenie w błąd grozi karą do 3 lat więzienia</p>
                        <div  class="col-md-4">

                            <form:form class="row g-3" action="/addressform" method="post"  modelAttribute="address" >
                                Nazwa ulicy
                                <form:input path="street" name="street" type="text" class="form-control" placeholder="Street" />
                                <form:errors path="street"  />
                                </br>
                                Numer bloku/domu
                                <form:input path="flatnumber"  name="flatnumber" type="number" step="1"  class="form-control"  placeholder="Flatnumber" />
                                <form:errors path="flatnumber"  />
                                </br>
                                Numer mieszkania(opcjonalnie)
                                <form:input path="housenumber" value="" name="housenumber" type="number" class="form-control"  placeholder="Housenumber"  />
                                <form:errors path="housenumber"  />
                                </br>
                                Kod pocztowy (bez kreski)
                                <form:input path="postcode"   name="postcode" type="text" class="form-control" placeholder="postcode" />
                                <form:errors path="postcode" />
                                </br>

                                <button class="btn btn-primary" type="submit">Wprowadź dane</button>

                            </form:form>
                        </div>

                    </div>

                </div>

            </div>

        </div>
    </section>

</main><!-- End #main -->



<%@ include file="footer.jsp" %>



