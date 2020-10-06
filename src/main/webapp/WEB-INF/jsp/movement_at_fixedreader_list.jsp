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
                        <h3 class="page-title">Container Movement At Fixed RFID Reader</h3>
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="#">Movement</a></li>
                               <!--  <li class="breadcrumb-item active" aria-current="page">Fixed RFID Reader</li> -->
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
                                      <h4 class="card-title">Container Movement</h4>
                                      <!-- <p class="card-description"> List</p> -->
                                  </div>
<!--                                   <div class="col-lg-1">
                                      <a href="/registerContainerArea">
                                        <button type="button" class="btn btn-gradient-primary btn-rounded btn-icon">
                                          <i class="mdi mdi-plus-outline"></i>
                                        </button>
                                  </a>
                                  </div> -->
                              </div>
                              <div class="row">
                                &nbsp;
                            </div>
                                <table id="fixed_reader_status_table" class="table table-hover  table-responsive-lg table-bordered">
                                  <thead>
                                    <tr>
                                      <th>SNo</th>
                                      <th>Reader ID</th>
                                      <th>Container ID</th>
                                      <th>Movement Type</th>
                                      <th>Date Time</th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <tr>
                                      <td>1</td>
                                      <td>Moto_1</td>
                                      <td>0001</td>
                                      <td>Departed</td>
                                      <td>05-10-2020 17:25:50</td>
                                    </tr>
                                    <tr>
                                      <td>2</td>
                                      <td>Moto_1</td>
                                      <td>0001</td>
                                      <td>Arrived</td>
                                      <td>05-10-2020 17:10:50</td>
                                    </tr>
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
                $('#fixed_reader_status_table').DataTable({
                "aLengthMenu": [
                    [5, 10, 15, -1],
                    [5, 10, 15, "All"]
                ],
                "iDisplayLength": 10,
                "language": {
                    search: ""
                }
                });
                $('#fixed_reader_status_table').each(function() {
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