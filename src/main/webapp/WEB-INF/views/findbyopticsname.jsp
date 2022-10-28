
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>


<main id="main" class="main">

    <div class="pagetitle">
        <h1>Podaj nazwę akcesoriów optyki które chcesz zmienić </h1>

    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-6">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Podaj nazwę akcesoriów optyki której dane chcesz zmienić</h5>
                        <div  class="col-md-4">
                            <form class="row g-3" action="/findbyopticsname" method="post"  >
                                <input name="id" placeholder="id optyki" type="number" min="1" max="${maxopt}"  class="form-control" />
                                <button class="btn btn-primary" type="submit">Submit form</button>
                                Lista nazw akcesoriów optyki w sklepie
                                <c:forEach var="opticAccesorie" items="${opticAccesories}">
                                    <p class="card-text">${opticAccesorie.id}.${opticAccesorie.name}</p>
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