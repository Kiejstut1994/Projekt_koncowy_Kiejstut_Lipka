
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
                        <h5 class="card-title">Logowanie admina</h5>
                        <div  class="col-md-4">



                            <form class="row g-3" action="/loginformuser" method="post" >
                                <input path="name" name="name" placeholder="Imię" class="form-control" />
                                <input path="surname" name="surname" placeholder="Nazwisko" class="form-control" />
                                <input path="password" name="password" placeholder="Hasło osobiste" class="form-control" type="password" />
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