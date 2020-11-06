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
                      <h3 class="page-title">Container Blocks</h3>
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                              <li class="breadcrumb-item"><a href="#">Asset</a></li>
                              <li class="breadcrumb-item"><a href="#">Container Block</a></li>
                              <li class="breadcrumb-item active" aria-current="page">Add Block</li>
                            </ol>
                        </nav>
                    </div>

                    <div class="row">

                      <div class="col-md-12 grid-margin stretch-card">
                        <div class="card">
                          <div class="card-body">
                            <h4 class="card-title">New Block</h4>
                          
                            <form action="createContainerBlock" method="POST" class="forms-sample">
                              <div class="form-group row">
                                <label for="blockName" class="col-sm-2 col-form-label">Block Name</label>
                                <div class="col-sm-4">
                                  <input name="blockName" type="text" class="form-control" id="blockName" placeholder="Name">
                                </div>

                                <label for="desc" class="col-sm-2 col-form-label">Description </label>
                                <div class="col-sm-4">
                                  <input name="description" type="text" class="form-control" id="desc" placeholder="Description">
                                </div>
                               </div>
                               <div class="form-group row">
                                <label for="blockCoordinates" class="col-sm-2 col-form-label">Block JSON</label>
                                <div class="col-sm-10">
                                

                                  <textarea rows="30"  name="blockJson" type="text" class="form-control" id="blockCoordinates" placeholder="{}"></textarea>

                                </div>

                               </div>

                            
                              <button type="submit" class="btn btn-gradient-primary btn-sm mr-2">Submit</button>

                              <a href="#">
                                <input class="btn btn-light btn-sm" type="button" value="Cancel"/>
                              </a>
                                
                               
                            </form>

                            <!-- <form action="createContainerBlock" method="POST" class="forms-sample">
                              <div class="form-group row">
                                <label for="blockName" class="col-sm-2 col-form-label">Block Name</label>
                                <div class="col-sm-4">
                                  <input name="blockName" type="text" class="form-control" id="blockName" placeholder="Name">
                                </div>

                                <label for="desc" class="col-sm-2 col-form-label">Description </label>
                                <div class="col-sm-4">
                                  <input name="description" type="text" class="form-control" id="desc" placeholder="Description">
                                </div>
                               </div>

                            
                              <button type="submit" class="btn btn-gradient-primary btn-sm mr-2">Submit</button>

                              <a href="#">
                                <input class="btn btn-light btn-sm" type="button" value="Cancel"/>
                              </a>
                                
                               
                            </form> -->
                            
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

    <script src="assets/vendors/sweetalert/sweetalert.min.js"></script>
    <script src="assets/vendors/jquery.avgrund/jquery.avgrund.min.js"></script>
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

    <script src="assets/js/alerts.js"></script>
    <script src="assets/js/avgrund.js"></script>

    <c:choose>
         
    <c:when test = "${resp=='success'}">
        <script> var r = "success" </script>
    </c:when>
    
    <c:when test = "${resp=='already_exist'}">
        <script> var r = "already_exist" </script>
    </c:when>
    <c:when test = "${resp=='error'}">
        <script> var r = "error" </script>
    </c:when>
    <c:otherwise>
        
    </c:otherwise>
 </c:choose>


    <script>

           
    $('#yard-Link').addClass("active");
     $('#ui-yard').addClass("show");
     $('#containerBlockLink').addClass("active");

            (function($) {
        'use strict';

        if(r==='success')
        {
            swal({
                    title: 'Container Block Registered',
                    text: 'Successfully',
                    icon: 'success',
                    button: {
                    text: "Continue",
                    value: true,
                    visible: true,
                    className: "btn btn-primary"
                    }
                })
        }
        else if(r==='already_exist')
        {
            swal({
                title: 'Unable To Register',
                text: " Already Exist",
                icon: 'warning',
                confirmButtonColor: '#3f51b5',
                confirmButtonText: 'Great ',
                buttons: {
                confirm: {
                    text: "OK",
                    value: true,
                    visible: true,
                    className: "btn btn-primary",
                    closeModal: true
                }
                }
            })
        }
        else if(r==='error')
        {
            swal({
                title: 'Unable To Register',
                text: "Exception Occured",
                icon: 'warning',
                confirmButtonColor: '#3f51b5',
                confirmButtonText: 'Great ',
                buttons: {
                confirm: {
                    text: "OK",
                    value: true,
                    visible: true,
                    className: "btn btn-primary",
                    closeModal: true
                }
                }
            })
        }
            
        })(jQuery);
        </script>
    <!-- End custom js for this page -->
</body>
</html>