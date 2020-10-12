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
                        <h3 class="page-title">Vehicle Device</h3>
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="#">Asset</a></li>
                                <li class="breadcrumb-item active" aria-current="page">Vehicle Device</li>
                            </ol>
                        </nav>

                       <!--  <nav aria-label="breadcrumb" role="navigation">
                          <ol class="breadcrumb breadcrumb-custom bg-inverse-info">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Library</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><span>Data</span></li>
                          </ol>
                        </nav> -->
                    </div>

                    <div class="row">

                        <div class="col-lg-12 grid-margin stretch-card">
                            <div class="card">
                              <div class="card-body">
                                <div class="row">
                                  <div class="col-lg-11">
                                      <h4 class="card-title">Devices</h4>
                                      <!-- <p class="card-description"> List</p> -->
                                  </div>
                                  <div class="col-lg-1">
                                      <a href="/vehicledevice_registration">
                                        <button type="button" class="btn btn-gradient-primary btn-rounded btn-icon">
                                          <i class="mdi mdi-plus-outline"></i>
                                        </button>
                                  </a>
                                  </div>
                              </div>
                              <div class="row">
                                &nbsp;
                            </div>
                                <table id="vehicle_device_table" class="table table-hover  table-responsive-lg table-bordered">
                                  <thead>
                                    <tr>
                                      <th>SNo</th>
                                      <th>Device Id</th>
                                      <th>Device Number</th>
                                      <th>Register Date</th>
                                      <th>Attached To Vehicle</th>
                                      <th>Attach Date</th>
                                      <th>Status</th>
                                      <th>Action</th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <c:set var="counter" value="1"/>  
                                        <c:forEach var="vd" items="${vehicleDeviceList}" varStatus="fieldRow">
                                        <tr>
                                            <td><c:out value="${counter}"/></td>
                                            <td><a href="/vehicledevice_view?deviceNo=${vd.getVehicleDeviceId()}"><c:out value="${vd.getVehicleDeviceId()}"/></a></td>
                                            <td><c:out value="${vd.getVehicleDeviceNumber()}"/></td>
                                            <td><c:out value="${vd.getRegisterDate()}"/></td>
                                            <td>
                                              <c:if test="${vd.getAttachStatus().equals('UNATTACHED')}">

                                                <label class="badge badge-danger">Not Attached</label>
                                              </c:if>
                                              <c:if test="${vd.getAttachStatus().equals('ATTACHED')}">

                                                <label class="badge badge-success">Attached</label>
                                              </c:if>
                                            </td>
                                            <td><c:out value="${vd.getAttachDate()}"/></td>
                                            <td>
                                              <c:if test="${vd.getStatus().equals('Registered')}">

                                                <label class="badge badge-info">Ready</label>
                                              </c:if>
                                            </td>
                                            <td>
                                              <i class="mdi mdi-table-edit"></i>
                                               &nbsp;&nbsp;
                                              <i class="mdi mdi-delete"></i>
                                         </td>
                                        </tr>
                                        <c:set var="counter" value="${counter + 1}"/>
                                        </c:forEach>
<!--                                     <tr>
                                      <td>1</td>
                                      <td><a href="vehicledevice_view">100</a></td>
                                      <td>VD001</td>
                                      <td>24-09-2020</td>
                                      <td><label class="badge badge-success">Attached</label></td>
                                      <td>24-09-2020</td>
                                      <td><label class="badge badge-info">Ready</label></td>
                                      <td>
                                          <i class="mdi mdi-table-edit"></i>
                                           &nbsp;&nbsp;
                                          <i class="mdi mdi-delete"></i>
                                     </td>
                                    </tr>
                                    <tr>
                                      <td>2</td>
                                      <td><a href="vehicledevice_view">101</a></td>
                                      <td>VD002</td>
                                      <td>15-09-2020</td>
                                      <td><label class="badge badge-danger">Not Attached</label></td>
                                      <td></td>
                                      <td><label class="badge badge-info">Ready</label></td>
                                      <td >
                                        <i class="mdi mdi-table-edit"></i>
                                           &nbsp;&nbsp;
                                          <i class="mdi mdi-delete"></i>
                                    </td>
                                    </tr> -->
                                  </tbody>
                                </table>
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


            (function($) {
            'use strict';
            $(function() {
                $('#vehicle_device_table').DataTable({
                "aLengthMenu": [
                    [5, 10, 15, -1],
                    [5, 10, 15, "All"]
                ],
                "iDisplayLength": 10,
                "language": {
                    search: ""
                }
                });
                $('#vehicle_device_table').each(function() {
                var datatable = $(this);
                // SEARCH - Add the placeholder for Search and Turn this into in-line form control
                var search_input = datatable.closest('.dataTables_wrapper').find('div[id$=_filter] input');
                search_input.attr('placeholder', 'Search');
                search_input.removeClass('form-control-sm');
                // LENGTH - Inline-Form control
                var length_sel = datatable.closest('.dataTables_wrapper').find('div[id$=_length] select');
                length_sel.removeClass('form-control-sm');
                });
            });
            })(jQuery);
        </script>
    <!-- End custom js for this page -->
</body>
</html>