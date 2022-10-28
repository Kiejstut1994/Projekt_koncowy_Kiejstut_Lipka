
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>


<main id="main" class="main">

    <div class="pagetitle">
        <h1>Usuń szafę na broń </h1>

    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-6">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Podaj id szafy którą chcesz usunąć</h5>
                        <div  class="col-md-4">
                            <form class="row g-3" action="/deleteguncoversform" method="post"  >
                                <input name="id" placeholder="id szafy" type="number" min="1" max="${maxgcov}"  class="form-control" />
                                <button class="btn btn-primary" type="submit">Submit form</button>
                                Lista szaf na broń w sklepie
                                <c:forEach var="guncover" items="${guncovers}">
                                    <p class="card-text">${guncover.id}.${guncover.name}</p>
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
