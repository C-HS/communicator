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
                        <h3 class="page-title">Container Block</h3>
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="#">Asset</a></li>
                                <li class="breadcrumb-item"><a href="#">Container Block</a></li>
                                <li class="breadcrumb-item active" aria-current="page">View</li>
                            </ol>
                        </nav>
                    </div>

                    <div class="row">

                      <div class="col-md-12 grid-margin stretch-card">
                        <div class="card">
                          <div class="card-body">
                            <h4 class="card-title">Block ID :  ${containerBlock.getBlockId()}</h4>
                            <!-- <p class="card-description"> Horizontal form layout </p> -->
                            
                              <div class="row">
                                <label class="col-sm-4">Block Name</label>
                                <div class="col-sm-8">
                                  ${containerBlock.getBlockName()}
                                </div>
                              </div>
                              <div class="row">
                                <label class="col-sm-4">Description</label>
                                <div class="col-sm-8">
                                  ${containerBlock.getDescription()}
                                </div>
                               
                              </div>
                               <div class="row">
                                <label class="col-sm-4">Register Date</label>
                                <div class="col-sm-8">
                                  ${containerBlock.getDateCreated()}
                                </div>
                              </div>
                              
                              <div class="row">
                                <label class="col-sm-4">Status</label>
                                <div class="col-sm-8">
                                  ${containerBlock.getStatus()}
                                </div>
                               </div>
                            
                            
                              <a href="editContainerBlock">
                                <input class="btn btn-gradient-dark btn-icon-text btn-sm" type="button" value="Edit"/> 
                              </a>
                                
                               
                         
                            
                          </div>
                        </div>
                      </div>
                   
                     <!--  <div class="col-md-6 grid-margin stretch-card">
                        <div class="card">
                          <div class="card-body">
                            <h4 class="card-title">Attach To Vehicle</h4>

                              <div class="row">
                                <label class="col-sm-4">Status</label>
                                <div class="col-sm-8">
                                 Attached
                                </div>
                               </div>

                               <div class="row">
                                <label class="col-sm-4">Vehicle No</label>
                                <div class="col-sm-8">
                                 787878
                                </div>
                               </div>

                               <div class="row">
                                <label class="col-sm-4">Attach Date</label>
                                <div class="col-sm-8">
                                  24-09-2020
                                </div>
                              </div>
                          </div>
                        </div>
                      </div>
                    -->
                    </div>

                    <div class="row">

                      <div class="col-md-12 grid-margin stretch-card">
                        <div class="card">
                          <div class="card-body">
                            <h4 class="card-title">Block Coordinates</h4>
                            <!-- <p class="card-description"> Horizontal form layout </p> -->
                            <table id="assigned_tag_table" class="table table-hover  table-responsive-lg table-bordered">
                              <thead>
                                <tr>
                                  <th>SNo</th>
                                  <th>Coordinate ID</th>
                                  <th>Latitude</th>
                                  <th>Longitude</th>
                                  <th>Register Date</th>
                                  <th>Action</th>
                                </tr>
                              </thead>
                              <tbody>

                                <c:set var="counter" value="1"/>  
                                  <c:forEach var="coordinate" items="${coordinateList}" varStatus="fieldRow">
                                  <tr>
                                      <td><c:out value="${counter}"/></td>
                                      <td><c:out value="${coordinate.getCoordinateId()}"/></td>
                                      <td><c:out value="${coordinate.getLatitude()}"/></td>
                                      <td><c:out value="${coordinate.getLongitude()}"/></td>
                                      <td>
                                               <c:out value="${coordinate.getDateCreated()}"/>
                                      </td>
                                      <td>
                                        <i class="mdi mdi-delete"></i>
                                      </td>
                                  </tr>
                                  <c:set var="counter" value="${counter + 1}"/>
                                  </c:forEach>

<!--                                 <tr>
                                  <td>1</td>
                                  <td>12</td>
                                  <td>134562</td>
                                  <td>454646</td>
                                  <td>24-09-2020</td>
                                  <td>
                                        <i class="mdi mdi-delete"></i>
                                 </td>
                                </tr>
                                <tr>
                                  <td>2</td>
                                  <td>13</td>
                                  <td>787594</td>
                                  <td>45795</td>
                                  <td>18-09-2020</td>
                                  <td >
                                    <i class="mdi mdi-delete"></i>
                                </td>
                                </tr> -->
                              </tbody>
                            </table>
                            
                          </div>
                        </div>
                      </div>
                   

                    </div>

                    <div class="card">
                        <div class="row">
                          <div class="col-lg-8">
                            <div class="card-body">
                              <h4 class="card-title">Add Coordinates</h4>
                              <form class="form-inline repeater" action="createContainerBlockCoordinate" method="POST">

                                <button data-repeater-create type="button" class="btn btn-gradient-info btn-sm icon-btn ml-2 mb-2">
                                  <i class="mdi mdi-plus"></i>
                                </button>

                                <div data-repeater-list="coordinate">
                                  <div data-repeater-item class="d-flex mb-2">
                                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                      <div class="input-group-prepend">
                                        <span class="input-group-text">Latitude</span>
                                      </div>
                                      <input name="0" type="text" class="form-control form-control-sm" id="inlineFormInputGroup1" placeholder="Latitude">
        
                                          &nbsp; &nbsp;&nbsp;
                                      <div class="input-group-prepend">
                                        <span class="input-group-text">Longitude</span>
                                      </div>
                                      <input name="1" type="text" class="form-control form-control-sm" id="inlineFormInputGroup1" placeholder="Longitude">
                                    </div>
                                    <button data-repeater-delete type="button" class="btn btn-gradient-danger btn-sm icon-btn ml-2">
                                      <i class="mdi mdi-delete"></i>
                                    </button>
                                  </div>
                                <input name="blockId" type="text" class="form-control form-control-sm" id="inlineFormInputGroup1" value="${containerBlock.getBlockId()}" hidden> 
                                </div>
                                <button type="submit" class="btn btn-gradient-success btn-sm">Submit</button>
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
    <script src="assets/vendors/jquery.repeater/jquery.repeater.min.js"></script>

    <script src="assets/vendors/sweetalert/sweetalert.min.js"></script>
    <script src="assets/vendors/jquery.avgrund/jquery.avgrund.min.js"></script>
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
                    title: 'Coordinate Added',
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
                title: 'Unable To Add',
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
                title: 'Unable To Add',
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