
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ include file="header.jsp" %>
<main id="main" class="main">

    <div class="pagetitle">
        <h1>Wykaz osób z niezweryfikowanym mailem i licencją na broń o zadanym peselu</h1>
    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-6">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Zweryfikuj:</h5>
                        <p>${purchaser.getPESEL()}</p>


    <form method="post" action="/emailandlisenceveryfication/${purchaser.id}"  multiple="">
<c:if test="${!purchaser.emailveryfication}">
        <input type="checkbox" name="weryf" value="tak"/>Aktywuj email
</c:if>
<c:if test="${!purchaser.firearmslicensce}">
        <input type="checkbox"  name="weryf" value="okej" />Aktywuj licencję
</c:if>
        <button class="btn btn-primary" type="submit">Wykonaj</button>
    </form>
<%--                        <c:if test="${not empty param.myName}">--%>
<%--                            Parametr istnieje.--%>
<%--                        </c:if>--%>


<%--                        <p><c:if test="${!purchaser.isEmailveryfication()}">--%>
<%--                            Nie zweryfikowany mail--%>
<%--                            <a href="/emailch/${purchaser.id}">Aktywuj email</a>--%>
<%--                        </c:if></p>--%>

<%--                        <p><c:if test="${!purchaser.isFirearmslicensce()}">--%>
<%--                            Nie zweryfikowana licencja na broń--%>
<%--                            <a href="/firelisece/${purchaser.id}">Aktywuj licencję</a>--%>
<%--                        </c:if></p>--%>

                        <!-- End Default Table Example -->
                    </div>
                </div>




                    </div>
                </div>

            </div>
        </div>
    </section>

</main><!-- End #main -->

<%@ include file="footer.jsp" %>