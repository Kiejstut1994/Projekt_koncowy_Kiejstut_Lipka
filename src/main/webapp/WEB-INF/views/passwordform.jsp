
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
    <h1>Formularz rejestracji</h1>

  </div><!-- End Page Title -->

  <section class="section">
    <div class="row">
      <div class="col-lg-6">

        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Proszę o podanie hasła</h5>
            <p>Żadne dane nie mogą być fałszywe. Wprowadzenie w błąd grozi karą do 3 lat więzienia</p>
            <div  class="col-md-4">

              <form:form class="row g-3" action="/passwordform" method="post"  modelAttribute="password"  >
                <form:input path="password" name="password" placeholder="Hasło" class="form-control" type="password" />
                <form:errors path="password" />
                <button class="btn btn-primary" type="submit">Dodaj hasło</button>
              </form:form>
            </div>

          </div>

        </div>

      </div>

    </div>
  </section>

</main>


<%@ include file="footer.jsp" %>