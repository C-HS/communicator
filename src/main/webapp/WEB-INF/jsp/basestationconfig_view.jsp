<%@ page contentType="text/html;charset=UTF-8" %>
<%--<c:set var="contextPath" value="${pageContext.request.contextPath}"/>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import ="org.springframework.security.core.*,org.springframework.security.core.context.*" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Yard Management Console</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <link rel="stylesheet" href="assets/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="assets/css/demo_1/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="assets/images/favicon.ico" />
  </head>
<body>
<div class="container-scroller">
    <jsp:include page="./partials/navbar.jsp" />
    <div class="container-fluid page-body-wrapper">
        <jsp:include page="./partials/sidebar.jsp" />
        <div class="main-panel">
            <div class="content-wrapper">
               
                    <div class="page-header">
                      <h3 class="page-title">Base Station Configuration</h3>
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                              <li class="breadcrumb-item"><a href="#">Configuration</a></li>
                              <li class="breadcrumb-item"><a href="#">Base Station Config</a></li>
                              <li class="breadcrumb-item active" aria-current="page">View Configuration</li>
                            </ol>
                        </nav>
                    </div>

                    <div class="row">

                      <div class="col-md-12 grid-margin stretch-card">
                        <div class="card">
                          <div class="card-body">
                            <h4 class="card-title">Configuration ID</h4>
                            <p class="card-description">${baseStationConfig.getBsConfigId()} </p>
                       
<!--                               <div class="form-group row">
                                <label class="col-sm-2">Middleware IP</label>
                                <div class="col-sm-4">
                                  192.168.0.251
                                </div>

                                <label class="col-sm-2">Middleware Port</label>
                                <div class="col-sm-4">
                                  8111
                                </div>
                               </div> -->

                               <div class="form-group row">
                                <label class="col-sm-2">MQTT Host</label>
                                <div class="col-sm-4">
                                  ${baseStationConfig.getMqttHost()}
                                </div>

                                <label class="col-sm-2">Data Topic</label>
                                <div class="col-sm-4">
                                  ${baseStationConfig.getMqttDataTopic()}
                                </div>
                               </div>

                               <div class="form-group row">
                                <label class="col-sm-2">MQTT Client ID</label>
                                <div class="col-sm-4">
                                  ${baseStationConfig.getMqttClientId()}
                                </div>

<!--                                 <label for="dataserviceURL" class="col-sm-2 col-form-label">Data Service URL</label>
                                <div class="col-sm-4">
                                  <input type="text" class="form-control" id="dataserviceURL" placeholder="http://">
                                </div> -->
                               </div>
                            
                               <a href="basestationconfig_edit">
                                <input class="btn btn-gradient-dark btn-icon-text btn-sm" type="button" value="Edit"/> 
                              </a>

                              <a href="#">
                                <input class="btn btn-light btn-sm" type="button" value="Cancel"/>
                              </a>
                                
                               
                      
                            
                          </div>
                        </div>
                      </div>
                    </div>

                
            </div>
            <jsp:include page="./partials/footer.jsp" />
        </div>
    </div>
</div>
<!-- <script src="assets/vendors/js/vendor.bundle.base.js"></script>
<script src="assets/vendors/chart.js/Chart.min.js"></script>
<script src="assets/js/off-canvas.js"></script>
<script src="assets/js/hoverable-collapse.js"></script>
<script src="assets/js/misc.js"></script>
<script src="assets/js/dashboard.js"></script>
<script src="assets/js/todolist.js"></script> -->

    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src="assets/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <script src="assets/vendors/datatables.net/jquery.dataTables.js"></script>
    <script src="assets/vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="assets/js/off-canvas.js"></script>
    <script src="assets/js/hoverable-collapse.js"></script>
    <script src="assets/js/misc.js"></script>
    <script src="assets/js/settings.js"></script>
    <script src="assets/js/todolist.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page -->
    <!-- <script src="assets/js/data-table.js"></script> -->

    <script>

           
$('#configurationLink').addClass("active");
     $('#ui-confoguration').addClass("show");
     $('#basestationconfigLink').addClass("active");

        </script>
    <!-- End custom js for this page -->
</body>
</html>