
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>


<main id="main" class="main">

    <div class="pagetitle">
        <h1>Usuń amunicję </h1>

    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-6">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Podaj id amunicji którą chcesz usunąć</h5>
                        <div  class="col-md-4">
                            <form class="row g-3" action="/deleteammunitions" method="post"  >
                                <input name="id" placeholder="numer amunicji" type="number" step="1" min="1" max="${maxamm}" class="form-control" />


                                <button class="btn btn-primary" type="submit">Submit form</button>
                                Lista nazw broni w sklepie i ich numer id
                                <c:forEach var="ammunition" items="${ammunitions}">
                                    <p class="card-text">${ammunition.id}.${ammunition.name}</p>
                                    </br>
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