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
                                <li class="breadcrumb-item active" aria-current="page">Base Station Config</li>
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
                                    <h4 class="card-title">Base Station Config</h4>
                                    <!-- <p class="card-description"> List</p> -->
                                </div>
                                <div class="col-lg-1">
                                    <a href="/basestationconfig_registration">
                                      <button type="button" class="btn btn-gradient-primary btn-rounded btn-icon">
                                        <i class="mdi mdi-plus-outline"></i>
                                      </button>
                                </a>
                                </div>
                            </div>
                            <div class="row">
                              &nbsp;
                          </div>
                            
                          
                              <table id="rfidReader_table" class="table table-hover  table-responsive-lg table-bordered">
                                <thead>
                                  <tr>
                                    <th>SNo</th>
                                    <th>ID</th>
                                    <th>Data Topic</th>
                                    <!-- <th>Base Station IP</th> -->
                                    <th>MQTT Client ID</th>
                                    <th>MQTT Host</th>
                                    <th>Status</th>
                                  </tr>
                                </thead>
                                <tbody>

                                  <c:set var="counter" value="1"/>  
                                  <c:forEach var="bsConfig" items="${bsConfigList}" varStatus="fieldRow">
                                  <tr>
                                      <td><c:out value="${counter}"/></td>
                                      <td><a href="/basestationconfig_view?bsConfigId=${bsConfig.getBsConfigId()}"><c:out value="${bsConfig.getBsConfigId()}"/></a></td>
                                      <td><c:out value="${bsConfig.getMqttDataTopic()}"/></td>
                                      <td><c:out value="${bsConfig.getMqttClientId()}"/></td>
                                      <td>
                                               <c:out value="${bsConfig.getMqttHost()}"/>
                                      </td>
                                      <td>
                                        <c:if test="${bsConfig.getStatus().equals('ACTIVE')}">

                                          <label class="badge badge-info">ACTIVE</label>
                                        </c:if>
                                      </td>
                                  </tr>
                                  <c:set var="counter" value="${counter + 1}"/>
                                  </c:forEach>

<!-- 
                                  <tr>
                                    <td>1</td>
                                    <td><a href="basestationconfig_view">001</a></td>
                                    <td>gpsdata</td>
                                    <td>mqttBSClient1</td>
                                    <td>192.168.0.252:1883</td>
                                    <td><label class="badge badge-info">Active</label></td>
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
                $('#rfidReader_table').DataTable({
                "aLengthMenu": [
                    [5, 10, 15, -1],
                    [5, 10, 15, "All"]
                ],
                "iDisplayLength": 10,
                "language": {
                    search: ""
                }
                });
                $('#rfidReader_table').each(function() {
                var datatable = $(this);

                datatable.scrollLeft('overflow-x','auto')
                // SEARCH - Add the placeholder for Search and Turn this into in-line form control
                var search_input = datatable.closest('.dataTables_wrapper').find('div[id$=_filter] input');
                search_input.attr('placeholder', 'Search');
               // search_input.removeClass('form-control-sm');
                // LENGTH - Inline-Form control
                var length_sel = datatable.closest('.dataTables_wrapper').find('div[id$=_length] select');
              //  length_sel.removeClass('form-control-sm');
             
                });
            });
            })(jQuery);
        </script>
    <!-- End custom js for this page -->
</body>
</html>