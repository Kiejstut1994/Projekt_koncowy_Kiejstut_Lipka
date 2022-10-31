<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<main id="main" class="main">

    <div class="pagetitle">
        <h1>Przelew</h1>

    </div><!-- End Page Title -->

    <section class="section">
        <!-- Card with header and footer -->
        <div class="card">

            <div class="card-header">Dane do przelewu</div>
                mBank
            </br>
                Nr konta 89 1140 2004 0000 3102 7685 5918
            </br>
                Tytuł: "Opłata za zamówienie numer ${numerzam}"
            </br>
                Opłata:${payment}
            </br>
                Sklep Broń się
            </br>
                Mokry Mariusz
            </br>
                08-110 Siedlce
            </br>
                ul. C.K.Norwida 2
            </br>
                NIP 821-265-17-69
            </br>
                REGON 367131108
            </br>
                nr koncesji MSWiA B-91/2017 , B-92/2017
            </br>
            <div class="card-header">PROSZĘ PRZESŁAĆ POTWIERDZENIE PRZELEWU</div>
        </div>


    </section>

</main>
<!-- End #main -->

<%@ include file="footer.jsp" %>