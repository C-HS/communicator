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
                      <h3 class="page-title">Container Area</h3>
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                              <li class="breadcrumb-item"><a href="#">Asset</a></li>
                              <li class="breadcrumb-item"><a href="#">Container Area</a></li>
                              <li class="breadcrumb-item active" aria-current="page">Add Area</li>
                            </ol>
                        </nav>
                    </div>

                    <div class="row">

                      <div class="col-md-12 grid-margin stretch-card">
                        <div class="card">
                          <div class="card-body">
                            <h4 class="card-title">New Area</h4>
                            <!-- <p class="card-description"> Horizontal form layout </p> -->
                            <form class="forms-sample">
                              <div class="form-group row">
                                <label for="areaName" class="col-sm-2 col-form-label">Area Name</label>
                                <div class="col-sm-4">
                                  <input type="text" class="form-control" id="areaName" placeholder="Name">
                                </div>

                                <label for="block" class="col-sm-2 col-form-label">Container Block </label>
                                <div class="col-sm-4">
                                 <!--  <input type="text" class="form-control" id="block" placeholder="Block"> -->
                                  <select class="form-control" id="block">
                                    <option>Select Block</option>
                                    <option>Left Block</option>
                                    <option>Right Block</option>
                                  </select>
                                </div>
                               </div>

                               <div class="form-group row">
                                <label for="lat1" class="col-sm-2 col-form-label">Latitude 1</label>
                                <div class="col-sm-4">
                                  <input type="text" class="form-control" id="lat1" placeholder="Latitude 1">
                                </div>

                                <label for="long1" class="col-sm-2 col-form-label">Longitude 1</label>
                                <div class="col-sm-4">
                                  <input type="text" class="form-control" id="long1" placeholder="Longitude 1">
                                </div>
                               </div>

                               <div class="form-group row">
                                <label for="lat2" class="col-sm-2 col-form-label">Latitude 2</label>
                                <div class="col-sm-4">
                                  <input type="text" class="form-control" id="lat2" placeholder="Latitude 2">
                                </div>

                                <label for="long2" class="col-sm-2 col-form-label">Longitude 2</label>
                                <div class="col-sm-4">
                                  <input type="text" class="form-control" id="long2" placeholder="Longitude 2">
                                </div>
                               </div>

                               <div class="form-group row">
                                <label for="lat3" class="col-sm-2 col-form-label">Latitude 3</label>
                                <div class="col-sm-4">
                                  <input type="text" class="form-control" id="lat3" placeholder="Latitude 3">
                                </div>

                                <label for="long3" class="col-sm-2 col-form-label">Longitude 3</label>
                                <div class="col-sm-4">
                                  <input type="text" class="form-control" id="long3" placeholder="Longitude 3">
                                </div>
                               </div>

                               <div class="form-group row">
                                <label for="lat4" class="col-sm-2 col-form-label">Latitude 4</label>
                                <div class="col-sm-4">
                                  <input type="text" class="form-control" id="lat4" placeholder="Latitude 4">
                                </div>

                                <label for="long4" class="col-sm-2 col-form-label">Longitude 4</label>
                                <div class="col-sm-4">
                                  <input type="text" class="form-control" id="long4" placeholder="Longitude 4">
                                </div>
                               </div>

                            
                              <button type="submit" class="btn btn-gradient-primary btn-sm mr-2">Submit</button>

                              <a href="#">
                                <input class="btn btn-light btn-sm" type="button" value="Cancel"/>
                              </a>
                                
                               
                            </form>
                            
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