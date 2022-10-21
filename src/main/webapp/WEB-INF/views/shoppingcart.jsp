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
                            <c:forEach items="${orders}" var="order">
                                <c:forEach items="${order.weapons}" var="ordwepon">
                                ${ordwepon.name}
                                    ${ordwepon.price}


                                </c:forEach>


                            </c:forEach>
<%--                            <c:forEach items="${orders}" var="order">--%>
<%--                                <c:forEach items="${order.getGuncovers()}" var="ordguncov">--%>
<%--                                    ${ordguncov.getName()}--%>
<%--                                    ${ordguncov.getPrice()}--%>


<%--                                </c:forEach>--%>


<%--                            </c:forEach>--%>
<%--                            <c:forEach items="${orders}" var="order">--%>
<%--                                <c:forEach items="${ordereareyes.getEarandeyesrecoverAccesories()}" var="ordereareye">--%>
<%--                                    ${ordereareye.getName()}--%>
<%--                                    ${ordereareye.getPrice()}--%>
<%--                                </c:forEach>--%>


<%--                            </c:forEach>--%>
<%--                            <c:forEach items="${orders}" var="order">--%>
<%--                                <c:forEach items="${orderamm.getAmmunitions()}" var="orderamm">--%>
<%--                                    ${orderamm.getName()}--%>
<%--                                    ${orderamm.getPrice()}--%>
<%--                                </c:forEach>--%>


<%--                            </c:forEach>--%>
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

                </div>
            </div>

        </div>
    </section>

</main><!-- End #main -->



<%@ include file="footer.jsp" %>

