
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
        <h1>Dodaj broń</h1>

    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-6">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Dodaj broń</h5>
                        <div  class="col-md-4">
                            <form:form class="row g-3" action="/weaponsform" method="post" modelAttribute="weapons" >
                                Nazwa:
                                <form:input path="name" name="name" placeholder="Nazwa" class="form-control" />
                                <form:errors path="name" />
                                </br>
                                Masa z wypełnionym magazynkiem:
                                <form:input path="weight" name="weight" placeholder="Masa(kg)" class="form-control" type="number" step="0.01" />
                                <form:errors path="weight" />
                                </br>
                                Producent:
                                <form:input path="producent" name="producent" placeholder="Producent" class="form-control" />
                                <form:errors path="producent" />
                                </br>
                                Cena broni:
                                <form:input path="price" name="price" placeholder="Cena (zł)" class="form-control" type="number" step="0.01" />
                                <form:errors path="price" />
                                </br>
                                Kaliber:
                                <form:input path="caliber" name="caliber" placeholder="Kaliber" class="form-control" />
                                <form:errors path="caliber" />
                                </br>
                                Ocena:
                                <form:input path="rating" name="rating" placeholder="Ocena" class="form-control" type="number" min="0" max="10" step="0.1" />
                                <form:errors path="rating" />
                                Wybierz typ broni
                                <c:forEach items="${typewepon}" var="typewepo">
                                    <form:radiobutton path="type" multiple="false" value="${typewepo}" /> Broń ${typewepo}
                                </c:forEach>
                                <form:errors path="type" />
                                </br>
                                Nazwa zdjęcia(proszę wstawić plik jpg do pliku /assets/img)
                                <form:input path="photo" name="photo" class="form-control"/>
                                <form:errors path="photo" />
                                </br>
                                <button class="btn btn-primary" type="submit">Dodaj broń</button>
                            </form:form>
                        </div>

                    </div>

                </div>

            </div>

        </div>
    </section>

</main><!-- End #main -->


<%@ include file="footer.jsp" %>