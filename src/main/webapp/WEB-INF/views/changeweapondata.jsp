
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>


<main id="main" class="main">

    <div class="pagetitle">
        <h1>Podaj nazwę broni którą chcesz zmienić </h1>

    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-6">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Witamy w formularzu rejestracji, wypełnij poniższe dane aby móc coś kupić</h5>
                        <p>Jeśli nie chcesz zmieniać danych o cenie i ratingu wpisz 0, jeśli chcesz aby zdjęcie się nie zmieniło zostaw puste miejsce</p>
                        <div  class="col-md-4">
                            <form class="row g-3" action="/changeweapondata/${name}" method="post"  >
                                Zmień cenę:
                                <input name="price" placeholder="cena" type="number"  class="form-control" />
                                Zmień rating:
                                <input name="rating" placeholder="rating" type="number"  class="form-control" />
                                Zmień zdjęcie:
                                <input name="photo" placeholder="zdjęcie" type="text"  class="form-control" />
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