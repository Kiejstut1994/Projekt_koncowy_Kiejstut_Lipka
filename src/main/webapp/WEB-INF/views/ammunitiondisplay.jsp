
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp" %>


<%--</main><!-- End #main -->--%>
<main id="main" class="main">

  <div class="pagetitle">
    <h1>Amunicja</h1>
  </div><!-- End Page Title -->

  <section class="section">
    <div class="row">
      <div class="col-lg-6">
        <div class="card">
          <div class="card-body">

            <h5 class="card-title">Amunicja ${type}</h5>

            <!-- Slides with captions -->
            <%--                        <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">--%>

            <c:forEach var="ammunition" items="${ammunitions}">
              <div class="card">
                <img src="assets/img/${ammunition.photo}" class="card-img-top" >
                <div class="card-body">
                  <h5 class="card-title">${ammunition.name}</h5>
                  <p class="card-text">${ammunition.price}zł</p>
                </div>
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