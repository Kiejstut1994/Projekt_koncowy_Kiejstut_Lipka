<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>


<main id="main" class="main">

    <div class="pagetitle">
        <h1>Podaj nazwę szafy na broń której dane chcesz zmienić </h1>

    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-6">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Podaj id szafy na broń której dane chcesz zmienić</h5>
                        <div  class="col-md-4">
                            <form class="row g-3" action="/findbyguncovername" method="post"  >
                                <input name="id" placeholder="id szafy" type="number" min="1" max="${maxgcov}"  class="form-control" />
                                <button class="btn btn-primary" type="submit">Submit form</button>
                                Lista szaf na broń w sklepie
                                <c:forEach var="changeguncover" items="${changeguncovers}">
                                    <p class="card-text">${changeguncover.id}.${changeguncover.name}</p>
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