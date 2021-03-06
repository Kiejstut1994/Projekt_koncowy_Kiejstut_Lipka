<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
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
            <img src="assets/img/bron.jpg" alt="" class="rounded-circle">
            <span class="d-none d-lg-block">Broń się</span>
        </a>

    </div><!-- End Logo -->



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
                    <span class="badge bg-success badge-number">3</span>
                </a><!-- End Messages Icon -->

                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow messages">
                    <li class="dropdown-header">
                        You have 3 new messages
                        <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View all</span></a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li class="message-item">
                        <a href="#">
                            <img src="assets/img/messages-1.jpg" alt="" class="rounded-circle">
                            <div>
                                <h4>Maria Hudson</h4>
                                <p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
                                <p>4 hrs. ago</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li class="message-item">
                        <a href="#">
                            <img src="assets/img/messages-2.jpg" alt="" class="rounded-circle">
                            <div>
                                <h4>Anna Nelson</h4>
                                <p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
                                <p>6 hrs. ago</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li class="message-item">
                        <a href="#">
                            <img src="assets/img/messages-3.jpg" alt="" class="rounded-circle">
                            <div>
                                <h4>David Muldon</h4>
                                <p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
                                <p>8 hrs. ago</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li class="dropdown-footer">
                        <a href="#">Show all messages</a>
                    </li>

                </ul><!-- End Messages Dropdown Items -->

            </li><!-- End Messages Nav -->

            <li class="nav-item dropdown pe-3">

                <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
                    <img src="assets/img/profile-img.jpg" alt="Profile" class="rounded-circle">
                    <span class="d-none d-md-block dropdown-toggle ps-2">K. Anderson</span>
                </a><!-- End Profile Iamge Icon -->

                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                    <li class="dropdown-header">
                        <h6>Kevin Anderson</h6>
                        <span>Web Designer</span>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
                            <i class="bi bi-person"></i>
                            <span>Mój profil</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
                            <i class="bi bi-gear"></i>
                            <span>Account Settings</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="pages-faq.html">
                            <i class="bi bi-question-circle"></i>
                            <span>Need Help?</span>
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
                    <a href="tables-general.html">
                        <i class="bi bi-circle"></i><span>Lornetki</span>
                    </a>
                </li>
                <li>
                    <a href="tables-data.html">
                        <i class="bi bi-circle"></i><span>Celowniki</span>
                    </a>
                </li>
                <li>
                    <a href="tables-data.html">
                        <i class="bi bi-circle"></i><span>Lunety</span>
                    </a>
                </li>
                <li>
                    <a href="tables-data.html">
                        <i class="bi bi-circle"></i><span>Pozostałe</span>
                    </a>
                </li>
            </ul>
        </li><!-- End Tables Nav -->

        <li class="nav-item">
            <a class="nav-link " data-bs-target="#charts-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-bar-chart"></i><span>Ochrona wzroku i słuchu</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="charts-nav" class="nav-content collapse show" data-bs-parent="#sidebar-nav">
                <li>
                    <a href="charts-chartjs.html" class="active">
                        <i class="bi bi-circle"></i><span>Ochrona wzroku</span>
                    </a>
                </li>
                <li>
                    <a href="charts-apexcharts.html">
                        <i class="bi bi-circle"></i><span>Ochrona słuchu</span>
                    </a>
                </li>
                <!--          <li>-->
                <!--            <a href="charts-echarts.html">-->
                <!--              <i class="bi bi-circle"></i><span>ECharts</span>-->
                <!--            </a>-->
                <!--          </li>-->
            </ul>
        </li><!-- End Charts Nav -->



        <li class="nav-item">
            <a class="nav-link collapsed" href="index.html">
                <i class="bi bi-grid"></i>
                <span>Szafy na broń</span>
            </a>
        </li><!-- End Dashboard Nav -->


        <li class="nav-heading">Pages</li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="users-profile.html">
                <i class="bi bi-person"></i>
                <span>Mój profil</span>
            </a>
        </li><!-- End Profile Page Nav -->

        <!--      <li class="nav-item">-->
        <!--        <a class="nav-link collapsed" href="pages-faq.html">-->
        <!--          <i class="bi bi-question-circle"></i>-->
        <!--          <span>F.A.Q</span>-->
        <!--        </a>-->
        <!--      </li>&lt;!&ndash; End F.A.Q Page Nav &ndash;&gt;-->

        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-contact.html">
                <i class="bi bi-envelope"></i>
                <span>Wiadomość do sklepu</span>
            </a>
        </li><!-- End Contact Page Nav -->


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
            <a class="nav-link collapsed" href="/findbyweaponname">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Zmień dane na temat broni</span>
            </a>
        </li><!-- End Login Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/deleteweaponbyname">
                <i class="bi bi-box-arrow-in-right"></i>
                <span>Usuń broń</span>
            </a>
        </li><!-- End Login Page Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="/findbyPESEL">
                <i class="bi bi-card-list"></i>
                <span>Zweryfikuj mail i licencję kupującego</span>
            </a>
        </li><!-- End Register Page Nav -->


        <!--      <li class="nav-item">-->
        <!--        <a class="nav-link collapsed" href="pages-error-404.html">-->
        <!--          <i class="bi bi-dash-circle"></i>-->
        <!--          <span>Error 404</span>-->
        <!--        </a>-->
        <!--      </li>&lt;!&ndash; End Error 404 Page Nav &ndash;&gt;-->

        <!--      <li class="nav-item">-->
        <!--        <a class="nav-link collapsed" href="pages-blank.html">-->
        <!--          <i class="bi bi-file-earmark"></i>-->
        <!--          <span>Blank</span>-->
        <!--        </a>-->
        <!--      </li>&lt;!&ndash; End Blank Page Nav &ndash;&gt;-->

    </ul>


</aside><!-- End Sidebar-->
