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
                    <h3 class="page-title"> Vehicle Registraion </h3>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Assets</a></li>
                            <li class="breadcrumb-item" aria-current="page">Vehicle</li>
                            <li class="breadcrumb-item active" aria-current="page">Registration New</li>
                        </ol>
                    </nav>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Vehicle Registration</h4>
                                <form class="form-sample" id="vehicleForm">
                                    <p class="card-description"> Information </p>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-5 col-form-label">Vehicle No.</label>
                                                <div class="col-sm-7">
                                                    <input name="vehicleNumber" id="vehicleNumber" type="text" class="form-control">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-5 col-form-label">Vehicle Type</label>
                                                <div class="col-sm-7">
                                                    <input name = "vehicleType" id="vehicleType" type="text" class="form-control">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-5 col-form-label">Vehicle Info</label>
                                                <div class="col-sm-7">
                                                    <input name="vehicleInfo" id="vehicleInfo" type="text" class="form-control">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-5 col-form-label">Vehicle Device ID</label>
                                                <div class="col-sm-7">
                                                    <input name="vehicleDeviceId" id="vehicleDeviceId" type="text" class="form-control">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                           <!--              <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-5 col-form-label">Registrations Date</label>
                                                <div class="col-sm-7">
                                                    <input name="registerDate" class="form-control" type="date" placeholder="dd/mm/yyyy">
                                                </div>
                                            </div>
                                        </div> -->
                                        <!-- <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-4 col-form-label">Mounting Status</label>
                                                <div class="col-sm-4">
                                                    <div class="form-check">
                                                        <label class="form-check-label">
                                                            <input type="radio" class="form-check-input" name="mountingStatus" id="mountingStatus1" value="" checked=""> Mounted <i class="input-helper"></i></label>
                                                    </div>
                                                </div>
                                                <div class="col-sm-4">
                                                    <div class="form-check">
                                                        <label class="form-check-label">
                                                            <input type="radio" class="form-check-input" name="mountingStatus" id="mountingStatus2" value="option2"> Un-Mounted <i class="input-helper"></i></label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div> -->
                                    </div>
                                    <div class="row">
                                        <!-- <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-5 col-form-label">Mounting Date</label>
                                                <div class="col-sm-7">
                                                    <input name="mountingDate" type="date" class="form-control">
                                                </div>
                                            </div>
                                        </div> -->
                                        <!-- <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-5 col-form-label">Status</label>
                                                <div class="col-sm-7">
                                                    <input name="status" type="text" class="form-control">
                                                </div>
                                            </div>
                                        </div> -->
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <input type="button" id="submit" class="btn btn-gradient-primary mr-2" value="Submit" />
                                                <input type="button" class="btn btn-light" value="Clear" />
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
    $(document).ready(function () {

     $('#asset-Link').addClass("active");
     $('#ui-asset').addClass("show");
     $('#vehicleLink').addClass("active");

        $("#submit").click(function(){
            var vehicle = {};
            vehicle["vehicleNumber"] = $("input[name=vehicleNumber]").val();
            vehicle["vehicleType"] = $("input[name=vehicleType]").val();
            vehicle["vehicleInfo"] = $("input[name=vehicleInfo]").val();
            vehicle["vehicleDeviceId"] = $("input[name=vehicleDeviceId]").val();
            vehicle["mountingStatus"] = $("input[name=mountingStatus]").val();
            vehicle["registerDate"] = $("input[name=registerDate]").val();
            vehicle["mountingDate"] = $("input[name=mountingDate]").val();
            vehicle["status"] = $("input[name=status]").val();
            $.ajax({
                type : "POST",
                contentType : "application/json",
                url : "/addVehicle",
                data : JSON.stringify(vehicle),
                dataType : 'text',
                success : function(data) {
                    swal({
                        title: "Vehicle Saved",
                        text: "Vehicle Information Saved Successfully.",
                        type: "success"}).then(okay => {
                        if (okay) {
                            window.location.href = "/vehicleList";
                        }
                    });
                },
                error: function(error){
                    swal("Error", "Some Error Happened", "error");
                }
            });
        });
    });
</script>
</body>
</html>