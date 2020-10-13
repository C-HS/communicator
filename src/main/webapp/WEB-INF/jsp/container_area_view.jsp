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
                        <h3 class="page-title">Container Area</h3>
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="#">Asset</a></li>
                                <li class="breadcrumb-item"><a href="#">Container Area</a></li>
                                <li class="breadcrumb-item active" aria-current="page">View</li>
                            </ol>
                        </nav>
                    </div>

                    <div class="row">

                      <div class="col-md-12 grid-margin stretch-card">
                        <div class="card">
                          <div class="card-body">
                            <h4 class="card-title">Area ID : ${containerArea.getAreaId()}</h4>
                            <!-- <p class="card-description"> Horizontal form layout </p> -->
                            
                              <div class="row">
                                <label class="col-sm-4">Area Name</label>
                                <div class="col-sm-8">
                                  ${containerArea.getAreaName()}
                                </div>
                              </div>
                              <div class="row">
                                <label class="col-sm-4">Block</label>
                                <div class="col-sm-8">
                                  ${containerArea.getBlockId()}
                                </div>
                               
                              </div>
                               <div class="row">
                                <label class="col-sm-4">Register Date</label>
                                <div class="col-sm-8">
                                  ${containerArea.getCreateDate()}
                                </div>
                              </div>
                              
                              <div class="row">
                                <label class="col-sm-4">Status</label>
                                <div class="col-sm-8">
                                  ${containerArea.getStatus()}
                                </div>
                               </div>

                               <div class="row">
                                <label class="col-sm-4">Lat - Long 1</label>
                                <div class="col-sm-8">
                                  ${containerArea.getLatitude1()} , ${containerArea.getLongitude1()}
                                </div>
                               </div>
                               <div class="row">
                                <label class="col-sm-4">Lat - Long 2</label>
                                <div class="col-sm-8">
                                  ${containerArea.getLatitude2()} , ${containerArea.getLongitude2()}
                                </div>
                               </div>
                               <div class="row">
                                <label class="col-sm-4">Lat - Long 3</label>
                                <div class="col-sm-8">
                                  ${containerArea.getLatitude3()} , ${containerArea.getLongitude3()}
                                </div>
                               </div>
                               <div class="row">
                                <label class="col-sm-4">Lat - Long 4</label>
                                <div class="col-sm-8">
                                  ${containerArea.getLatitude4()} , ${containerArea.getLongitude4()}
                                </div>
                               </div>
                            
                            
                              <a href="editContainerArea">
                                <input class="btn btn-gradient-dark btn-icon-text btn-sm" type="button" value="Edit"/> 
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
    <script src="assets/vendors/jquery.repeater/jquery.repeater.min.js"></script>
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="assets/js/off-canvas.js"></script>
    <script src="assets/js/hoverable-collapse.js"></script>
    <script src="assets/js/misc.js"></script>
    <script src="assets/js/settings.js"></script>
    <script src="assets/js/todolist.js"></script>
    <script src="assets/js/form-repeater.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page -->
    <!-- <script src="assets/js/data-table.js"></script> -->

    <script>

           
           
    $('#yard-Link').addClass("active");
     $('#ui-yard').addClass("show");
     $('#containerAreaLink').addClass("active");
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