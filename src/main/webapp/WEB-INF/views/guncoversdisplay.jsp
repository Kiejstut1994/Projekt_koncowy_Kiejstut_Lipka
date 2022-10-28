<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>


<%--</main><!-- End #main -->--%>
<main id="main" class="main">

    <div class="pagetitle">
        <h1>Szafy na broń</h1>
    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-6">
                <div class="card">
                    <div class="card-body">

                        <h5 class="card-title">Szafy na broń</h5>

                        <!-- Slides with captions -->
                        <%--                        <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">--%>

                        <c:forEach var="guncover" items="${guncovers}">
                            <div class="card">
                                <img src="http://localhost:8080/assets/img/${guncover.photo}" class="card-img-top" >
                                <div class="card-body">
                                    <h5 class="card-title">${guncover.name}</h5>
                                    <p class="card-text">${guncover.price}zł</p>
                                </div>
                                                                    <c:if test="${zalogowany>-1}">
                                                                        <button class="btn btn-primary" type="submit"><a href="/addguncover/${guncover.id}">Kup</a></button>
                                                                    </c:if>


                            </div><!-- End Card with an image on top -->
                        </c:forEach>



                    </div><!-- End Slides with captions -->

                </div>
            </div>

        </div>
        </div>
    </section>

</main><!-- End #main -->
<%@ include file="footer.jsp" %>