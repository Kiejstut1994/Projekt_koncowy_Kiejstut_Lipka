<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<main id="main" class="main">

    <div class="pagetitle">
        <h1>Mój profil</h1>

    </div><!-- End Page Title -->

    <section class="section">
        <!-- Card with header and footer -->
        <div class="card">
            <div class="card-header"> Dane:</div>
            <div class="card-body">
                <h5 class="card-title">Imię: ${purchasershow.name}  </h5>
                </br>
                <h5 class="card-title">Nazwisko: ${purchasershow.surname}  </h5>
                </br>
                <h5 class="card-title">Email: ${purchasershow.email}  </h5>
                </br>
                <h5 class="card-title">Pesel: ${purchasershow.PESEL}  </h5>
                </br>
                <c:if test="${purchasershow.emailveryfication==false}">
                    <h5 class="card-title">Wejdź na skrzynkę mailową i zatwierdz email !</h5>
                    </br>
                </c:if>
                <c:if test="${purchasershow.emailveryfication==true}">
                    <h5 class="card-title">Email zweryfikowany</h5>
                    </br>
                </c:if>
                <c:if test="${purchasershow.firearmslicensce==false}">
                    <h5 class="card-title">Przyjedź do sklepu w celu weryfikacji pozwolenia na broń !</h5>
                    </br>
                </c:if>
                <c:if test="${purchasershow.firearmslicensce==true}">
                    <h5 class="card-title">Pozwolenie na broń zweryfikowano</h5>
                    </br>
                </c:if>


                <div class="card-header">Dane adresowe</div>
                </br>
                <h5 class="card-title">Ulica: ${addressshow.street}  </h5>
                </br>
                <h5 class="card-title">Numer domu (bloku): ${addressshow.flatnumber}  </h5>
                </br>
<c:if test="${addressshow.housenumber!=0}">
                <h5 class="card-title">Numer mieszkania: ${addressshow.housenumber}  </h5>
                </br>
</c:if>
                <h5 class="card-title">Kod pocztowy: ${addressshow.postcode}  </h5>
                </br>
            </div>

        </div>


    </section>

</main>
<!-- End #main -->

<%@ include file="footer.jsp" %>