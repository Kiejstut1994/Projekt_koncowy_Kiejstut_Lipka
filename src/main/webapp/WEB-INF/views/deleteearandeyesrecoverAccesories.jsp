<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>


<main id="main" class="main">

    <div class="pagetitle">
        <h1>Usuń akcesoria wzroku i słuchu </h1>

    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-6">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Podaj id akcesoriów do ochrony słuchu i wzroku które chcesz usunąć</h5>
                        <div  class="col-md-4">
                            <form class="row g-3" action="/deleteearandeyesrecoverAccesories" method="post"  >
                                <input name="id" placeholder="numer id akesoria" type="number" step="1" min="1" max="${maxeae}"  class="form-control" />
                                <button class="btn btn-primary" type="submit">Submit form</button>
                                Lista nazw akcesoriów do ochrony słuchu i wzroku w sklepie
                                <c:forEach var="earandeyesrecoverAccesorie" items="${earandeyesrecoverAccesories}">
                                    <p class="card-text">${earandeyesrecoverAccesorie.id}.${earandeyesrecoverAccesorie.name}</p>
                                </c:forEach>
                            </form>



                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>

</main><!-- End #main -->
<%@ include file="footer.jsp" %>