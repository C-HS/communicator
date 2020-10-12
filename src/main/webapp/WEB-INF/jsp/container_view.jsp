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
    <link rel="stylesheet" href="assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="assets/css/style.css">
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
                    <h3 class="page-title"> Container </h3>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Asset</a></li>
                            <li class="breadcrumb-item"><a href="#">Container</a></li>
                            <li class="breadcrumb-item active" aria-current="page">View</li>
                        </ol>
                    </nav>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Container ID  ${container.getContainerId()}</h4>

                                   <!--  <p class="card-description"> Container ID  ${container.getContainerId()} </p> -->
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="row">
                                                <label class="col-sm-5">Container No.</label>
                                                <div class="col-sm-7">
                                                    ${container.getContainerNumber()}
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="row">
                                                <label class="col-sm-5">Container Type</label>
                                                <div class="col-sm-7">
                                                    ${container.getContainerType()}
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="row">
                                                <label class="col-sm-5">Container Info</label>
                                                <div class="col-sm-7">
                                                    ${container.getContainerInfo()}
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="row">
                                                <label class="col-sm-5">Tag ID</label>
                                                <div class="col-sm-7">
                                                    ${container.getTid()}
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="row">
                                                <label class="col-sm-5">Registrations Date</label>
                                                <div class="col-sm-7">
                                                    ${container.getRegisterDate()}
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="row">
                                                <label class="col-sm-5">Tagging Status</label>
                                                <div class="col-sm-7">
                                                    ${container.getTaggingStatus()}
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="row">
                                                <label class="col-sm-5">Tagging Date</label>
                                                <div class="col-sm-7">
                                                    ${container.getTaggingDate()}
                                                </div>
                                           </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="row">
                                                <label class="col-sm-5">Status</label>
                                                <div class="col-sm-7">
                                                    ${container.getStatus()}
                                                </div>
                                           </div>
                                        </div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-md-6">
                                            <a href="editContainer">
                                                <input class="btn btn-gradient-dark btn-icon-text btn-sm" type="button" value="Edit"/> 
                                              </a>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                            </div>
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
<script src="assets/vendors/js/vendor.bundle.base.js"></script>
<script src="assets/vendors/chart.js/Chart.min.js"></script>
<script src="assets/js/off-canvas.js"></script>
<script src="assets/js/hoverable-collapse.js"></script>
<script src="assets/js/misc.js"></script>
<script src="assets/js/dashboard.js"></script>
<script src="assets/js/todolist.js"></script>

<script>
    $('#asset-Link').addClass("active");
    $('#ui-asset').addClass("show");
    $('#containerLink').addClass("active");
</script>

</body>
</html>