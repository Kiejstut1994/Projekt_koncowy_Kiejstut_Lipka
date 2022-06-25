
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
        <h1>Formularz logowania</h1>

    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-6">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Zaloguj się</h5>
                        <div  class="col-md-4">
                            <form class="row g-3" action="/loginform" method="post" >
                                <input path="PESEL" name="PESEL" placeholder="PESEL" class="form-control" />
                                <input path="password" name="password" placeholder="Hasło" class="form-control" type="password" />
                                <button class="btn btn-primary" type="submit">Submit form</button>
                            </form>
                        </div>

                    </div>

                </div>

            </div>

        </div>
    </section>

</main><!-- End #main -->

<%@ include file="footer.jsp" %>