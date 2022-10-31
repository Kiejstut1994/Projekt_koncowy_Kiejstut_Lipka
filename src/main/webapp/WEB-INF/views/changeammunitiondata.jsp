
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
        <h1>Zmiana amunicji</h1>

    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-6">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Zmień ammunicję</h5>
                        <div  class="col-md-4">
                            <form:form class="row g-3" action="/changeammunitiondata/${ammtochange.id}" method="post" modelAttribute="persamm" >
                                Nazwa:
                                <form:input path="name" name="name" placeholder="Nazwa" class="form-control" />
                                <form:errors path="name" />
                                </br>
                                Masa wszystkich naboi:
                                <form:input path="weight" name="weight" placeholder="Masa(kg)" class="form-control" type="number" step="0.01" />
                                <form:errors path="weight" />
                                </br>
                                Kaliber:
                                <form:input path="caliber" name="caliber" placeholder="Kaliber" class="form-control" />
                                <form:errors path="caliber" />
                                </br>
                                Wybierz typ amunicji
                                <c:forEach items="${types}" var="typen">
                                    <form:radiobutton path="type" multiple="false" value="${typen}" /> ${typen}
                                </c:forEach>
                                <form:errors path="type" />
                                </br>
                                Cena za paczkę:
                                <form:input path="price" name="price" placeholder="Cena (zł)" class="form-control" type="number" step="0.01" />
                                <form:errors path="price" />
                                </br>
                                Liczba naboi w paczce:
                                <form:input path="numberinpack" name="numberinpack" placeholder="Liczba naboi" class="form-control" type="number"  step="1" />
                                <form:errors path="numberinpack" />
                                </br>
                                Nazwa zdjęcia(proszę wstawić plik jpg do pliku /assets/img)
                                <form:input path="photo" name="photo" class="form-control"/>
                                <form:errors path="photo" />
                                </br>
                                <button class="btn btn-primary" type="submit">Wstaw</button>
                            </form:form>
                        </div>

                    </div>

                </div>
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Amunicja do zmiany dane:</h5>
                        <div  class="col-md-4">
                            Nazwa:    ${ammtochange.name}
                            </br>
                                </br>
                            Masa:    ${ammtochange.weight}
                                </br>
                                </br>
                            Kaliber:    ${ammtochange.caliber}
                                </br>
                                </br>
                            Typ:    ${ammtochange.type}
                                </br>
                                </br>
                            Cena:    ${ammtochange.price}
                                </br>
                                </br>
                            Liczba w paczce:    ${ammtochange.numberinpack}
                                </br>
                                </br>
                             Zdjęcie:   ${ammtochange.photo}
                        </div>

                    </div>

                </div>

            </div>

        </div>
    </section>

</main><!-- End #main -->


<%@ include file="footer.jsp" %>