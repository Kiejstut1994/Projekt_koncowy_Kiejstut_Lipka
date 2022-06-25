
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
    <h1>Formularz dodania broni</h1>

  </div><!-- End Page Title -->

  <section class="section">
    <div class="row">
      <div class="col-lg-6">

        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Dodaj broń</h5>
            <div  class="col-md-4">
              <form:form class="row g-3" action="/ammunitionsform" method="post" modelAttribute="ammunition" >
                <form:input path="name" name="name" placeholder="Nazwa" class="form-control" />
                <form:errors path="name" />
                Masa wszystkich naboi:
                <form:input path="weight" name="weight" placeholder="Masa(kg)" class="form-control" type="number" step="0.01" />
                <form:errors path="weight" />
                <form:input path="caliber" name="caliber" placeholder="Kaliber" class="form-control" />
                <form:errors path="caliber" />
                Wybierz typ amunicji
                <input type="checkbox" name="type" value="do pistoletu"/>Amunicja do pistoletu
                <input type="checkbox" name="type" value="do karabinu"/>Amunicja do karabinu
                <input type="checkbox" name="type" value="do paintballa"/>Amunicja do paintballa
                <input type="checkbox" name="type" value="treningowa"/>Amunicja treningowa
                Cena za paczkę:
                <form:input path="price" name="price" placeholder="Cena (zł)" class="form-control" type="number" step="0.01" />
                <form:errors path="price" />
                Liczba naboi w paczce:
                <form:input path="numberinpack" name="numberinpack" placeholder="Liczba naboi" class="form-control" type="number" step="1" />
                <form:errors path="numberinpack" />
                Nazwa zdjęcia(proszę wstawić plik jpg do pliku /assets/img)
                <form:input path="photo" name="photo" class="form-control"/>
                <form:errors path="photo" />
                <button class="btn btn-primary" type="submit">Wstaw</button>
              </form:form>
            </div>

          </div>

        </div>

      </div>

    </div>
  </section>

</main><!-- End #main -->


<%@ include file="footer.jsp" %>