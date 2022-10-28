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
                        <h5 class="card-title">Witamy w formularzu rejestracji, dodaj pracownika sklepu</h5>

                        <div  class="col-md-4">
                            <form:form class="row g-3" action="/userform" method="post" modelAttribute="user" >
                                Imię:
                                <form:input name="name" placeholder="Podaj imię" type="text"  class="form-control"  path="name"/>
                                <form:errors path="name" />
                                </br>
                                Nazwisko:
                                <form:input path="surname" name="surname" type="text" placeholder="Podaj nazwisko" class="form-control" />
                                <form:errors path="surname"  />
                                </br>
                                <button class="btn btn-primary" type="submit">Przejdź dalej</button>
                                <div class="form-message"></div>
                            </form:form>
                        </div>

                    </div>

                </div>

            </div>

        </div>
    </section>

</main><!-- End #main -->



<%@ include file="footer.jsp" %>