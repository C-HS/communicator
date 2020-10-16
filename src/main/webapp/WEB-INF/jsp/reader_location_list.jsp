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
    <link rel="stylesheet" href="assets/css/demo_1/style.css">
    <link rel="shortcut icon" href="assets/images/favicon.ico" />
    <link rel="stylesheet" href="assets/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
</head>
<body>
<div class="container-scroller">
    <jsp:include page="./partials/navbar.jsp" />
    <div class="container-fluid page-body-wrapper">
        <jsp:include page="./partials/sidebar.jsp" />
     
     
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="page-header">
                    <h3 class="page-title"> Reader Location List </h3>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Asset</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Reader Location List</li>
                        </ol>
                    </nav>
                </div>

                <div class="row">
                    <div class="col-lg-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-11">
                                        <h4 class="card-title">Readers</h4>
                                    </div>
                                    <div class="col-lg-1">
                                        <a href="/readerLocationRegistration">
                                          <button type="button" class="btn btn-gradient-primary btn-rounded btn-icon">
                                            <i class="mdi mdi-plus-outline"></i>
                                          </button>
                                    </a>
                                    </div>
                                </div>
                                <div class="row">
                                    &nbsp;
                                </div>
                                <table id="readerLocationTable" class="table table-hover  table-responsive-lg table-bordered">
                                    <thead>
                                    <tr>
                                        <th>Reader Location Name</th>
                                        <th>Date Created</th>
                                        <th>Status</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <c:set var="counter" value="1"/>  
                                        <c:forEach var="readerLocation" items="${readerLocationList}" varStatus="fieldRow">
                                        <tr>
                                            <td><c:out value="${readerLocation.getReaderLocationName()}"/></td>
                                            <td><c:out value="${readerLocation.getDateCreated()}"/></td>
                                            <td><c:out value="${readerLocation.getStatus()}"/></td>
                                        </tr>
                                        <c:set var="counter" value="${counter + 1}"/>
                                        </c:forEach>
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
<script src="assets/vendors/js/vendor.bundle.base.js"></script>
<script src="assets/vendors/datatables.net/jquery.dataTables.js"></script>
<script src="assets/vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
<script src="assets/vendors/chart.js/Chart.min.js"></script>
<script src="assets/js/off-canvas.js"></script>
<script src="assets/js/hoverable-collapse.js"></script>
<script src="assets/js/misc.js"></script>
<script src="assets/js/dashboard.js"></script>
<script src="assets/js/todolist.js"></script>
<script>
    (function($) {
    'use strict';
    $(function() {
        $('#readerLocationTable').DataTable({
        "aLengthMenu": [
            [5, 10, 15, -1],
            [5, 10, 15, "All"]
        ],
        "iDisplayLength": 10,
        "language": {
            search: ""
        }
        });
        $('#container_table').each(function() {
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

</body>
</html>