<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <script src="/assets/js/main.js"></script>-->
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Broń się - portal z bronią</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="/assets/img/favicon.png" rel="icon">
    <link href="/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="/assets/vendor/quill/quill.snow.css" rel="stylesheet">
    <link href="/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
    <link href="/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="/assets/vendor/simple-datatables/style.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="/assets/css/style.css" rel="stylesheet">

    <!-- =======================================================
    * Template Name: NiceAdmin - v2.2.2
    * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->
</head>

<body>

<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
        <a href="/mainview/true" class="logo d-flex align-items-center">
            <img src="http://localhost:8080/assets/img/bron2.jpg" alt="" class="rounded-circle">
            <span class="d-none d-lg-block">Broń się</span>
        </a>

    </div><!-- End Logo -->


    <c:if test="${zalogowany>-1}">

    <nav class="header-nav ms-auto">
        <ul class="d-flex align-items-center">

            <li class="nav-item d-block d-lg-none">
                <a class="nav-link nav-icon search-bar-toggle " href="#">
                    <i class="bi bi-search"></i>
                </a>
            </li><!-- End Search Icon-->

            </li><!-- End Notification Nav -->

            <li class="nav-item dropdown">

                <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                    <i class="bi bi-chat-left-text"></i>
                    <span class="badge bg-success badge-number">${numbrermyorders}</span>
                </a><!-- End Messages Icon -->

                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow messages">
                    <li class="dropdown-header">
                       Moje zamówienia
                        <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View all</span></a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>
<c:forEach items="${myorders}" var="myorder">
                    <li class="message-item">
                        <a href="#">
                            <img src="assets/img/messages-1.jpg" alt="" class="rounded-circle">
                            <div>
                                <h4>Zamówienie numer ${myorder.id}</h4>
                                <p><c:if test="${myorder.paid==true}">Zamówienie opłacono i potwierdzono</c:if></p>
                                <p><c:if test="${myorder.active==true}">Zamówienie wysłano</c:if></p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    </c:forEach>




                </ul><!-- End Messages Dropdown Items -->

            </li><!-- End Messages Nav -->

            <li class="nav-item dropdown pe-3">

                <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
                    <span class="d-none d-md-block dropdown-toggle ps-2">${namesurname}</span>
                </a><!-- End Profile Iamge Icon -->

                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                    <li class="dropdown-header">
                        <h6>Witaj, ${namesurname} </h6>
                        <span>Panel kupującego</span>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="/myprofilepurchaser">
                            <i class="bi bi-person"></i>
                            <span>Mój profil</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="/changeaddres">
                            <i class="bi bi-gear"></i>
                            <span>Zmień dane adresowe</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="/changepasswordpurchaser">
                            <i class="bi bi-gear"></i>
                            <span>Zmień hasło</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="/logout">
                            <i class="bi bi-box-arrow-right"></i>
                            <span>Wyloguj</span>
                        </a>
                    </li>

                </ul><!-- End Profile Dropdown Items -->
            </li><!-- End Profile Nav -->

        </ul>
    </nav><!-- End Icons Navigation -->
    </c:if>
<%--    dla pracownika--%>
    <c:if test="${userzalogowany<1}">


        <nav class="header-nav ms-auto">
            <ul class="d-flex align-items-center">

                <li class="nav-item d-block d-lg-none">
                    <a class="nav-link nav-icon search-bar-toggle " href="#">
                        <i class="bi bi-search"></i>
                    </a>
                </li><!-- End Search Icon-->

                </li><!-- End Notification Nav -->

                <li class="nav-item dropdown">

                    <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                        <i class="bi bi-chat-left-text"></i>
                        <span class="badge bg-success badge-number">${existnotpaidacticver}</span>
                    </a><!-- End Messages Icon -->

                    <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow messages">
                        <li class="dropdown-header">
                            Wykonano ${existnotpaidacticver} zamówień, jeśli możesz obsłuż je
<%--                            <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View all</span></a>--%>
                        </li>
        <c:forEach var="ordnotpaidnotactive" items="${ordersnotactvenotpaid}">
                        <li>
                            <hr class="dropdown-divider">
                        </li>

                        <li class="message-item">
                            <a href="#">
                                <img src="assets/img/messages-1.jpg" alt="" class="rounded-circle">
                                <div>
                                    <h4>Zamówienie numer: ${ordnotpaidnotactive.id}</h4>
                                    <c:if test="${ordnotpaidnotactive.paid==false}">
                                    <p>Potwierdź opłacenie zamówienia  <a href="/veryfpaid/${ordnotpaidnotactive.id}">Zatwierdź</a> </p>
                                    </c:if>
                                    <c:if test="${ordnotpaidnotactive.active==false}">
                                    <p>Potwierdź wysłanie zamówienia <a href="/veryfactive/${ordnotpaidnotactive.id}">Zatwierdź</a> </p>
                                    </c:if>
                                </div>
                            </a>
                        </li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        </c:forEach>

<%--                        <li class="dropdown-footer">--%>
<%--                            <a href="#">Show all messages</a>--%>
<%--                        </li>--%>

                    </ul><!-- End Messages Dropdown Items -->

                </li><!-- End Messages Nav -->


                <li class="nav-item dropdown pe-3">

                    <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
                        <span class="d-none d-md-block dropdown-toggle ps-2">${usernamesurname}</span>
                    </a><!-- End Profile Iamge Icon -->

                    <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                        <li class="dropdown-header">
                            <h6>Witaj, ${usernamesurname} </h6>
                            <span>Panel pracownika</span>
                        </li>
<%--                        <li>--%>
<%--                            <hr class="dropdown-divider">--%>
<%--                        </li>--%>

<%--                        <li>--%>
<%--                            <a class="dropdown-item d-flex align-items-center" href="/change">--%>
<%--                                <i class="bi bi-person"></i>--%>
<%--                                <span>Mój profil</span>--%>
<%--                            </a>--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <hr class="dropdown-divider">--%>
<%--                        </li>--%>

                        <li>
                            <a class="dropdown-item d-flex align-items-center" href="/changeuserpassword">
                                <i class="bi bi-gear"></i>
                                <span>Zmień hasło</span>
                            </a>
                        </li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>

                            <%--                    <li>--%>
                            <%--                        <a class="dropdown-item d-flex align-items-center" href="pages-faq.html">--%>
                            <%--                            <i class="bi bi-question-circle"></i>--%>
                            <%--                            <span>Need Help?</span>--%>
                            <%--                        </a>--%>
                            <%--                    </li>--%>
<%--                        <li>--%>
<%--                            <hr class="dropdown-divider">--%>
<%--                        </li>--%>

                        <li>
                            <a class="dropdown-item d-flex align-items-center" href="/logout">
                                <i class="bi bi-box-arrow-right"></i>
                                <span>Wyloguj</span>
                            </a>
                        </li>

                    </ul><!-- End Profile Dropdown Items -->
                </li><!-- End Profile Nav -->

            </ul>
        </nav><!-- End Icons Navigation -->
    </c:if>
</header><!-- End Header -->

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">


        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-menu-button-wide"></i><span>Broń</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="components-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="/weapondisplay/długa">
                        <i class="bi bi-circle"></i><span>Broń długa</span>
                    </a>
                </li>
                <li>
                    <a href="/weapondisplay/krótka">
                        <i class="bi bi-circle"></i><span>Broń krótka</span>
                    </a>
                </li>
                <li>
                    <a href="/weapondisplay/kolekcjonerska">
                        <i class="bi bi-circle"></i><span>Broń kolekcjonerska</span>
                    </a>
                </li>
                <li>
                    <a href="/weapondisplay/do paintballa">
                        <i class="bi bi-circle"></i><span>Broń do paintballa</span>
                    </a>
                </li>

            </ul>
        </li><!-- End Components Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#forms-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-journal-text"></i><span>Amunicja</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="forms-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="/ammunitiondisplay/do pistoletu">
                        <i class="bi bi-circle"></i><span>Do pistoletu</span>
                    </a>
                </li>
                <li>
                    <a href="/ammunitiondisplay/do karabinu">
                        <i class="bi bi-circle"></i><span>Do karabinu</span>
                    </a>
                </li>

                <li>
                    <a href="/ammunitiondisplay/do paintballa">
                        <i class="bi bi-circle"></i><span>Do paintballa</span>
                    </a>
                </li>
                <li>
                    <a href="/ammunitiondisplay/treningowa">
                        <i class="bi bi-circle"></i><span>Treningowa</span>
                    </a>
                </li>
            </ul>
        </li><!-- End Forms Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-layout-text-window-reverse"></i><span>Optyka</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="tables-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="/opticaccesoriesdisplay/lornetki">
                        <i class="bi bi-circle"></i><span>Lornetki</span>
                    </a>
                </li>
                <li>
                    <a href="/opticaccesoriesdisplay/celowniki">
                        <i class="bi bi-circle"></i><span>Celowniki</span>
                    </a>
                </li>
                <li>
                    <a href="/opticaccesoriesdisplay/lunety">
                        <i class="bi bi-circle"></i><span>Lunety</span>
                    </a>
                </li>
                <li>
                    <a href="/opticaccesoriesdisplay/pozostałe">
                        <i class="bi bi-circle"></i><span>Pozostałe</span>
                    </a>
                </li>
            </ul>
        </li><!-- End Tables Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#charts-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-bar-chart"></i><span>Ochrona wzroku i słuchu</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="charts-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="/earandeyesrecoverAccesoriesdisplay/wzrok" class="active">
                        <i class="bi bi-circle"></i><span>Ochrona wzroku</span>
                    </a>
                </li>
                <li>
                    <a href="/earandeyesrecoverAccesoriesdisplay/słuch">
                        <i class="bi bi-circle"></i><span>Ochrona słuchu</span>
                    </a>
                </li>

            </ul>
        </li><!-- End Charts Nav -->



        <li class="nav-item">
            <a class="nav-link collapsed" href="/guncoversdisplay">
                <i class="bi bi-grid"></i>
                <span>Szafy na broń</span>
            </a>
        </li><!-- End Dashboard Nav -->


        <li class="nav-heading">Działania</li>
        <c:if test="${zalogowany>-1}">
        <li class="nav-item">
            <a class="nav-link collapsed" href="/myprofilepurchaser">
                <i class="bi bi-person"></i>
                <span>Mój profil</span>
            </a>
        </li><!-- End Profile Page Nav -->
        </c:if>
        <c:if test="${noord==1}">
        <li class="nav-item">
            <a class="nav-link collapsed" href="/shoppingcart">
                <i class="bi bi-envelope"></i>
                <span>Koszyk</span>
            </a>
        </li><!-- End Contact Page Nav -->
        </c:if>

        <li class="nav-item">
            <a class="nav-link collapsed" href="/purchaserform">
                <i class="bi bi-card-list"></i>
                <span>Rejestracja kupującego</span>
            </a>
        </li><!-- End Register Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/userform">
                <i class="bi bi-card-list"></i>
                <span>Rejestracja pracownika</span>
            </a>
        </li><!-- End Register Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/loginform">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Zaloguj się(dla osób fizycznych)</span>
            </a>
        </li><!-- End Login Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/loginformuser">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Zaloguj się(dla pracowników sklepu)</span>
            </a>
        </li><!-- End Login Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/rights">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Regulamin</span>
            </a>
        </li><!-- End Login Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/weaponsform">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Dodaj broń</span>
            </a>
        </li><!-- End Login Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/ammunitionsform">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Dodaj amunicję</span>
            </a>
        </li><!-- End Login Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/opticaccesoriesform">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Dodaj optykę</span>
            </a>
        </li><!-- End Login Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/earandeyesrecoverAccesoriesform">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Dodaj ochronę wzroku i słuchu</span>
            </a>
        </li><!-- End Login Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/guncoversform">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Dodaj szafę na broń</span>
            </a>
        </li><!-- End Login Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="/findbyweaponname">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Zmień dane broni</span>
            </a>
        </li><!-- End Login Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/findbyammoname">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Zmień dane amunicji</span>
            </a>
        </li><!-- End Login Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/findbyopticsname">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Zmień dane akcesoriów optycznych</span>
            </a>
        </li><!-- End Login Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/findbyearandeyesrecoverAccesoriesname">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Zmień dane akcesoriów do ochrony słuchu i wzroku</span>
            </a>
        </li><!-- End Login Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/findbyguncovername">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Zmień dane szaf na broń</span>
            </a>
        </li><!-- End Login Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/deleteweaponbyname">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Usuń broń</span>
            </a>
        </li><!-- End Login Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/deleteammunitions">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Usuń amunicję</span>
            </a>
        </li><!-- End Login Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/deleteopticaccesoriesform">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Usuń optykę</span>
            </a>
        </li><!-- End Login Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/deleteguncoversform">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Usuń szafę</span>
            </a>
        </li><!-- End Login Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/deleteearandeyesrecoverAccesories">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Usuń akcesoria ochronne</span>
            </a>
        </li><!-- End Login Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/findbyPESEL">
                <i class="bi bi-card-list"></i>
                <span>Zweryfikuj mail i licencję kupującego</span>
            </a>
        </li><!-- End Register Page Nav -->



    </ul>


</aside><!-- End Sidebar-->
