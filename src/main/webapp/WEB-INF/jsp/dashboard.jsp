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
    <link rel="stylesheet" href="assets/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
    <link rel="stylesheet" href="assets/css/demo_1/style.css">
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
                        <h3 class="page-title">Search Container</h3>
                    </div>

                    <div class="row">

                            <div class="col-md-12 grid-margin stretch-card">
                                <div class="card">
                                <div class="card-body">
                                    <form action="searchContainerHistory" method="POST" class="forms-sample">
                                        <div class="form-group row">
                                        <label for="containerNo" class="col-sm-2 col-form-label">Container Number</label>
                                        <div class="col-sm-4">
                                            <input id="containerNo" name="containerNo" type="text" class="form-control"  placeholder="Container No">
                                        </div>
        
                                        
                                        <div class="col-sm-2">

                                            <input id="searchButton" name="searchButton" type="button" class="form-control  btn-gradient-primary btn-sm mr-2" value ="Search">
                                        </div>
                                        </div>
                                        </form>
                                </div>
                                </div>
                            </div>
                    </div>

                    <div class="row">

                            <div class="col-md-12 grid-margin stretch-card">
                                <div class="card">
                                <div class="card-body">
                                    <h4 class="card-title">Container History</h4>

                                    <div id="parentDev">
                                        <div id="tableDiv"></div>
                                    </div>

                                     <!-- <table id="container_history_table" class="table table-hover  table-responsive-lg table-bordered">
                                        <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Date Time</th>
                                            <th>Container No</th>
                                            <th>Movement Type</th>
                                            <th>Reader ID</th>
                                            <th>Location</th>
                                            <th>Vehicle No</th>
                                            <th>Area</th>
                                            <th>Altitude</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                           
                                        </tbody>
                                    </table>  -->
                                </div>
                                </div>
                            </div>
                    </div>

        
                
            
            </div>
            <jsp:include page="./partials/footer.jsp" />
        </div>
      </div>
    </div>
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

    <script>

    (function($) {
        'use strict';
        $("#searchButton").click(function(e){

            var cno =$("#containerNo").val();
          //  alert("hello"+cno);
            $("#tableDiv").remove();
          
             $.ajax({
                    type:"GET",
                    url: 'containerHistory/'+cno,
                    success:function(result){
 
                        $("#parentDev").append('<div id="tableDiv"><table id="container_history_table" class="table table-hover  table-responsive-lg table-bordered"></table</div>')
                        $('#tableDiv table').append( '<thead><tr><th>#</th><th>Date Time</th><th>Container No</th><th>Movement Type</th><th>Reader ID</th><th>Location</th><th>Vehicle No</th><th>Area</th><th>Altitude</th></tr></thead>' );
                        $('#tableDiv table').append('<tbody></tbody');
                        var i  =0;

                        for(i=0; i<result.length; i++)
                        {
                           // var d = new Date(result[i].dateTime);
                            //var dateString = formatDateTime(result[i].dateTime);

                            $("#container_history_table").find('tbody')
                            .append($('<tr>')
                                .append($('<td>')
                                .text(i+1))
                                 .append($('<td>')
                                .text(formatDateTime(result[i].dateTime)))
                                .append($('<td>')
                                .text(result[i].containerNo))
                                .append($('<td>')
                                .text(result[i].movementType))
                                .append($('<td>')
                                .text(result[i].readerId))
                                .append($('<td>')
                                .text(result[i].readerLocationName))
                                .append($('<td>')
                                .text(result[i].vehicleNo))
                                .append($('<td>')
                                .text(result[i].areaName))
                                .append($('<td>')
                                .text(result[i].altitude))
                            );
                        }
                        
                            $('#container_history_table').DataTable({
                            "aLengthMenu": [
                                [5, 10, 15, -1],
                                [5, 10, 15, "All"]
                            ],
                            "iDisplayLength": 10,
                            "language": {
                                search: ""
                            }
                            });

                            $('#container_history_table').each(function() {
                                var datatable = $(this);
                                // SEARCH - Add the placeholder for Search and Turn this into in-line form control
                                var search_input = datatable.closest('.dataTables_wrapper').find('div[id$=_filter] input');
                                search_input.attr('placeholder', 'Search');
                                search_input.removeClass('form-control-sm');
                                // LENGTH - Inline-Form control
                                var length_sel = datatable.closest('.dataTables_wrapper').find('div[id$=_length] select');
                                length_sel.removeClass('form-control-sm');
                                });                        
                    },
                    error:function() {
                        alert("error");
                    }
            }); 
          });

          function formatDateTime(dateStr)
          {
                            var d = new Date(dateStr);
                            var day = d.getDate() + "";
                            var month = (d.getMonth() + 1) + "";
                            var year = d.getFullYear() + "";
                            var hour = d.getHours() + "";
                            var minutes = d.getMinutes() + "";
                            var seconds = d.getSeconds() + "";

                            day = checkZero(day);
                            month = checkZero(month);
                            year = checkZero(year);
                            hour = checkZero(hour);
                            minutes = checkZero(minutes);
                            seconds = checkZero(seconds);

                     return day+"/"+month+"/"+year+" "+hour+":"+minutes+":"+seconds;
          }

          function checkZero(data){
                if(data.length == 1){
                    data = "0" + data;
                }
                return data;
                }

        })(jQuery);
    </script>
 </body>
</html>