<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<style>
    #validationDefault02 {
    }
</style>
<main id="main" class="main">

    <div class="pagetitle">
        <h1>Zamówienie</h1>

    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-6">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Twoje zamówienie</h5>

                        <div  class="col-md-4">

                                <c:forEach items="${weaponslist}" var="weaponsord">
                                ${weaponsord.name}
                                    </br>

                                    ${weaponsord.price}
                                    </br>
                                    <button class="btn btn-primary" type="submit"><a href="/deleteweaponfromlist/${weaponsord.id}">Usuń z koszyka</a></button>
                                </c:forEach>
                            </br>
                            <c:forEach items="${ammunitionlist}" var="ammunitionord">
                                ${ammunitionord.name}
                                </br>
                                ${ammunitionord.price}
                                </br>

                                <button class="btn btn-primary" type="submit"><a href="/deleteammunitionfromlist/${ammunitionord.id}">Usuń z koszyka</a></button>
                            </c:forEach>

                            <c:forEach items="${earandeyesrecoverAccesorieslist}" var="earandeyesrecoverAccesoriesord">
                                ${earandeyesrecoverAccesoriesord.name}
                                </br>
                                ${earandeyesrecoverAccesoriesord.price}
                                </br>

                                <button class="btn btn-primary" type="submit"><a href="/deleteearandeyesrecoverAccesoriesfromlist/${earandeyesrecoverAccesoriesord.id}">Usuń z koszyka</a></button>
                            </c:forEach>

                            <c:forEach items="${guncoverslist}" var="guncoversord">
                                ${guncoversord.name}
                                </br>
                                ${guncoversord.price}
                                </br>

                                <button class="btn btn-primary" type="submit"><a href="/deleteguncoversfromlist/${guncoversord.id}">Usuń z koszyka</a></button>
                            </c:forEach>

                            <c:forEach items="${opticaccesorieslist}" var="opticaccesoriesord">
                                ${opticaccesoriesord.name}
                                </br>
                                ${opticaccesoriesord.price}
                                </br>

                                <button class="btn btn-primary" type="submit"><a href="/deleteopticaccesoriesfromlist/${opticaccesoriesord.id}">Usuń z koszyka</a></button>
                            </c:forEach>

                        </div>


                    </div>

                </div>

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Adres wysyłki</h5>
                            ${purchaseraddres.street}
                        ${purchaseraddres.housenumber}
                        ${purchaseraddres.flatnumber}
                        ${purchaseraddres.postcode}
                        <div  class="col-md-4">
                        </div>

                    </div>
                    <c:if test="${canbuy==1}">
                    <h5 class="card-title">Zapłać</h5>

                        <button class="btn btn-primary" type="submit"><a href="/payform">Płacę</a></button>
                    </c:if>
<c:if test="${canbuy==0}">
    <h5 class="card-title">Aby zapłacić musisz potwierdzić adres email i licencję na broń</h5>
</c:if>


                </div>
            </div>

        </div>
    </section>

</main><!-- End #main -->



<%@ include file="footer.jsp" %>

