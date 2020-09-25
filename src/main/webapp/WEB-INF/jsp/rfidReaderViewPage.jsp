<%@ page contentType="text/html;charset=UTF-8" %>
<%--<c:set var="contextPath" value="${pageContext.request.contextPath}"/>--%>
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
                        <h3 class="page-title">FIXED RFID Readers</h3>
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="#">Asset</a></li>
                                <li class="breadcrumb-item"><a href="#">FIXED RFID Readers</a></li>
                                <li class="breadcrumb-item active" aria-current="page">View</li>
                            </ol>
                        </nav>
                    </div>

                    <div class="row">

                      <div class="col-md-6 grid-margin stretch-card">
                        <div class="card">
                          <div class="card-body">
                            <h4 class="card-title">Reader ID : 001</h4>
                            <!-- <p class="card-description"> Horizontal form layout </p> -->
                            
                              <div class="row">
                                <label class="col-sm-4">Reader IP</label>
                                <div class="col-sm-8">
                                  192.168.2.253
                                </div>
                              </div>
                              <div class="row">
                                <label class="col-sm-4">Reader Port</label>
                                <div class="col-sm-8">
                                  8451
                                </div>
                               
                              </div>
                               <div class="row">
                                <label class="col-sm-4">Location Mapped</label>
                                <div class="col-sm-8">
                                  Main Gate
                                </div>
                              </div>
                              
                              <div class="row">
                                <label class="col-sm-4">Reader Type</label>
                                <div class="col-sm-8">
                                  Motorola
                                </div>
                               </div>

                               <div class="row">
                                <label class="col-sm-4">Rigister Date</label>
                                <div class="col-sm-8">
                                  24-09-2020
                                </div>
                               </div>

                               <div class="row">
                                <label class="col-sm-4">Status</label>
                                <div class="col-sm-8">
                                  Ready
                                </div>
                               </div>
                            
                            
                              <a href="rfidReaderEditPage">
                                <input class="btn btn-gradient-dark btn-icon-text btn-sm" type="button" value="Edit"/> 
                              </a>
                                
                               
                         
                            
                          </div>
                        </div>
                      </div>
                   
                      <div class="col-md-6 grid-margin stretch-card">
                        <div class="card">
                          <div class="card-body">
                            <h4 class="card-title">Reader Added To Middleware Status</h4>

                              <div class="row">
                                <label class="col-sm-4">Status</label>
                                <div class="col-sm-8">
                                 Added
                                </div>
                               </div>

                               <div class="row">
                                <label class="col-sm-4">Reference ID</label>
                                <div class="col-sm-8">
                                  Moto_1
                                </div>
                               </div>

                               <div class="row">
                                <label class="col-sm-4">Date</label>
                                <div class="col-sm-8">
                                  24-09-2020
                                </div>
                              </div>
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

           
     $('#asset-Link').addClass("active");
     $('#ui-asset').addClass("show");
     $('#rfidLink').addClass("active");

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