
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
        <h1>Zmień dane szafy</h1>

    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-6">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Zmień dane szafy</h5>
                        <div  class="col-md-4">
                            <form:form class="row g-3" action="/changeguncoverdata/${changeguncovers.id}" method="post" modelAttribute="perguncover" >
                                Nazwa:
                                <form:input path="name" name="name" placeholder="Nazwa" class="form-control" />
                                <form:errors path="name" />
                                </br>
                                Cena:
                                <form:input path="price" name="price" placeholder="Cena (zł)" class="form-control" type="number" min="1" step="0.01" />
                                <form:errors path="price" />
                                </br>
                                Opis:
                                <form:input path="description" name="description" placeholder="Opis" class="form-control" type="text"  />
                                <form:errors path="description" />
                                </br>
                                Nazwa zdjęcia(proszę wstawić plik jpg do pliku /assets/img)
                                <form:input path="photo" name="photo" class="form-control"/>
                                <form:errors path="photo" />
                                </br>
                                <button class="btn btn-primary" type="submit">Zmień dane szafy</button>
                            </form:form>

                        </div>

                    </div>

                </div>
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Dane szafy do zmiany:</h5>
                        <div  class="col-md-4">
                            Nazwa:    ${changeguncovers.name}
                            </br>
                            </br>
                            Cena:    ${changeguncovers.price}
                            </br>
                            </br>
                            Opis:    ${changeguncovers.description}
                            </br>
                            </br>
                            Zdjęcie:   ${changeguncovers.photo}
                        </div>

                    </div>

                </div>

            </div>

        </div>
    </section>

</main><!-- End #main -->


<%@ include file="footer.jsp" %>





