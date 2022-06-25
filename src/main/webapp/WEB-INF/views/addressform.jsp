
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

                            <form:form class="row g-3" action="/addressform/${purchaser_id}" method="post"  modelAttribute="address" >
                                <form:input path="street" name="street" type="text" class="form-control" placeholder="Street" />
                                <form:errors path="street"  />
                                <form:input path="flatnumber" min="1" name="flatnumber" type="number"  class="form-control"  placeholder="Flatnumber" />
                                <form:errors path="flatnumber"  />
                                <form:input path="housenumber" min="1" name="housenumber" type="number" class="form-control"  placeholder="Housenumber" />
                                <form:errors path="housenumber"  />
                                <form:input path="postcode" pattern = "[0-9][0-9][0-9][0-9][0-9]" name="postcode" type="text" class="form-control" placeholder="postcode" />
                                <form:errors path="postcode" />

                                <button class="btn btn-primary" type="submit">Submit form</button>

                            </form:form>
                        </div>

                    </div>

                </div>

            </div>

        </div>
    </section>

</main><!-- End #main -->



<%@ include file="footer.jsp" %>



