<!-- AngularJs Bootstrap Script -->
<script src="${js}/angular.js"></script>

<!-- DataTable Bootstrap Script -->
<script src="${js}/productsController.js"></script>
<div class="container" ng-app="ShoppingApp" ng-controller="ProductController as pCtrl" >
      <div class="row" ng-init="pCtrl.fetchProducts()">
        <div class="col-lg-3">
          <%@include file="./shared/sidebar.jsp" %>
        </div>
        <!-- /.col-lg-3 -->
        <div class="col-lg-9">
          <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
              <div class="carousel-item active">
                <img class="d-block img-fluid" src="${images}/banner1.jpg" alt="First slide">
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="${images}/banner2.jpg" alt="Second slide">
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="${images}/banner3.jpg" alt="Third slide">
              </div>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="${images}/banner4.jpg" alt="Third slide">
              </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>

          <div class="row">

            <div class="col-lg-4 col-md-6 mb-4" ng-repeat="product in pCtrl.mvProducts">
              <div class="card h-100">
                <a ng-href="${contextRoot}/show/{{product.id}}/product"><img class="card-img-top" ng-src="${images}/{{product.code}}.jpg" alt=""></a>
                <div class="card-body">
                  <h4 class="card-title">
                    {{product.name}}
                  </h4>
                  <h5>{{product.unitPrice}} dt</h5>
                  <p class="card-text">{{product.description}}</p>
                </div>
              </div>
            </div>
          <!-- /.row -->

        </div>
        <!-- /.col-lg-9 -->

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->