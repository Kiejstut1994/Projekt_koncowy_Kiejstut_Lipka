
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
        <h1>Zmiana akcesoriów optyki</h1>

    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-6">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Zmiana akcesoriów optyki</h5>
                        <div  class="col-md-4">
                            <form:form class="row g-3" action="/changeopticsdata/${opticAccesories.id}" method="post" modelAttribute="peropticAccesories" >
                                Nazwa:
                                <form:input path="name" name="name" placeholder="Nazwa" class="form-control" type="text"/>
                                <form:errors path="name" />
                                </br>
                                Opis:
                                <form:input path="description" name="description" placeholder="Opis" class="form-control" type="text"  />
                                <form:errors path="description" />
                                </br>
                                Cena:
                                <form:input path="price" name="price" placeholder="Cena (zł)" class="form-control" type="number" step="0.01" />
                                <form:errors path="price" />
                                </br>
                                Ocena:
                                <form:input path="rating" name="rating" placeholder="Ocena" class="form-control" type="number" max="10" step="0.1" />
                                <form:errors path="rating" />
                                </br>
                                Wybierz typ optyki dodawanej
                                <c:forEach items="${typesofopticacessories}" var="typesofopticacessorie">
                                    <form:radiobutton path="type" multiple="false" value="${typesofopticacessorie}" /> ${typesofopticacessorie}
                                </c:forEach>
                                </br>
                                <form:errors path="type" />
                                Nazwa zdjęcia(proszę wstawić plik jpg do pliku /assets/img)
                                <form:input path="photo" name="photo" class="form-control"/>
                                <form:errors path="photo" />
                                </br>
                                <button class="btn btn-primary" type="submit">Zmień dane na temat optyki</button>
                            </form:form>
                        </div>

                    </div>

                </div>
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Optyka do zmiany dane:</h5>
                        <div  class="col-md-4">
                            Nazwa:    ${opticAccesories.name}
                            </br>
                            </br>
                            Opis:    ${opticAccesories.description}
                            </br>
                            </br>
                            Cena:    ${opticAccesories.price}
                            </br>
                            </br>
                            Ocena:    ${opticAccesories.rating}
                            </br>
                            </br>
                            Typ:    ${opticAccesories.type}
                            </br>
                            </br>
                            Zdjęcie:   ${opticAccesories.photo}
                        </div>

                    </div>

                </div>

            </div>

        </div>
    </section>

</main><!-- End #main -->


<%@ include file="footer.jsp" %>