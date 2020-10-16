<%@ page contentType="text/html;charset=UTF-8" %>
<%--<c:set var="contextPath" value="${pageContext.request.contextPath}"/>--%>
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
                    <h3 class="page-title"> Reader Location Registraion </h3>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Assets</a></li>
                            <li class="breadcrumb-item" aria-current="page">Reader Location</li>
                            <li class="breadcrumb-item active" aria-current="page">Register New</li>
                        </ol>
                    </nav>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Reader Location Registration</h4>
                                <form id="readerLocationForm" class="form-sample">
                                    <p class="card-description"> Information </p>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-5 col-form-label">Location Name</label>
                                                <div class="col-sm-7">
                                                    <input name="readerLocationName" type="text" class="form-control">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-5 col-form-label">Date Created</label>
                                                <div class="col-sm-7">
                                                    <input name="dateCreated" type="date" class="form-control">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-4 col-form-label">Status</label>
                                                <div class="col-sm-4">
                                                    <div class="form-check">
                                                        <label class="form-check-label">
                                                            <input type="radio"  class="form-check-input" name="status" id="membershipRadios1" value="" checked=""> UP <i class="input-helper"></i></label>
                                                    </div>
                                                </div>
                                                <div class="col-sm-4">
                                                    <div class="form-check">
                                                        <label class="form-check-label">
                                                            <input type="radio" class="form-check-input" name="status" id="membershipRadios2" value="option2"> Not UP <i class="input-helper"></i></label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <input type="button" id="submit" class="btn btn-gradient-primary mr-2" value="Submit" />
                                                <input class="btn btn-light" value="Cancle">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                            </div>
                                        </div>
                                    </div>
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
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script src="assets/vendors/sweetalert/sweetalert.min.js"></script>
<script src="assets/vendors/jquery.avgrund/jquery.avgrund.min.js"></script>
<script src="assets/vendors/js/vendor.bundle.base.js"></script>
<script src="assets/vendors/chart.js/Chart.min.js"></script>
<script src="assets/js/off-canvas.js"></script>
<script src="assets/js/hoverable-collapse.js"></script>
<script src="assets/js/misc.js"></script>
<script src="assets/js/dashboard.js"></script>
<script src="assets/js/todolist.js"></script>
<script>
    $(document).ready(function(){
       $("#submit").click(function(){
          var readerLocation = {};
          readerLocation["readerLocationName"]=$("input[name=readerLocationName]").val();
          readerLocation["dateCreated"]=$("input[name=dateCreated]").val();
          readerLocation["status"]=$("input[name=status]").val();
           $.ajax({
               type: "POST",
               contentType : "application/json",
               url : "/readerLocationRegistration",
               data : JSON.stringify(readerLocation),
               dataType : 'text',
               success : function(data) {
                   swal({
                       title: "Reader Location Saved",
                       text: "Reader Location Information Saved Successfully.",
                       type: "success"}).then(okay => {
                       if (okay) {
                           window.location.href = "/readerLocationList";
                       }
                   });
               },
               error: function(error){
                   swal("Error", "Something went Wrong..!!!", "error");
               }
           })
       });
    });
</script>
</body>
</html>