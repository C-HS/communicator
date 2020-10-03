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
                    <h3 class="page-title"> Container Registraion </h3>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">Assets</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Container Registration</li>
                        </ol>
                    </nav>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Container Registration</h4>
                                <form class="form-sample">
                                    <p class="card-description"> Information </p>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-5 col-form-label">Container No.</label>
                                                <div class="col-sm-7">
                                                    <input type="text" class="form-control">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-5 col-form-label">Container Type</label>
                                                <div class="col-sm-7">
                                                    <input type="text" class="form-control">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-5 col-form-label">Container Info</label>
                                                <div class="col-sm-7">
                                                    <input type="text" class="form-control">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-5 col-form-label">Tag ID</label>
                                                <div class="col-sm-7">
                                                    <input type="text" class="form-control">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-5 col-form-label">Registrations Date</label>
                                                <div class="col-sm-7">
                                                    <input class="form-control" placeholder="dd/mm/yyyy">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-4 col-form-label">Tagging Status</label>
                                                <div class="col-sm-4">
                                                    <div class="form-check">
                                                        <label class="form-check-label">
                                                            <input type="radio" class="form-check-input" name="membershipRadios" id="membershipRadios1" value="" checked=""> Tagged <i class="input-helper"></i></label>
                                                    </div>
                                                </div>
                                                <div class="col-sm-4">
                                                    <div class="form-check">
                                                        <label class="form-check-label">
                                                            <input type="radio" class="form-check-input" name="membershipRadios" id="membershipRadios2" value="option2"> UnTagged <i class="input-helper"></i></label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-5 col-form-label">Tagging Date</label>
                                                <div class="col-sm-7">
                                                    <input type="text" class="form-control">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-5 col-form-label">Status</label>
                                                <div class="col-sm-7">
                                                    <input type="text" class="form-control">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <button type="submit" class="btn btn-gradient-primary mr-2">Submit</button>
                                                <button class="btn btn-light">Cancel</button>
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
<script src="assets/vendors/js/vendor.bundle.base.js"></script>
<script src="assets/vendors/chart.js/Chart.min.js"></script>
<script src="assets/js/off-canvas.js"></script>
<script src="assets/js/hoverable-collapse.js"></script>
<script src="assets/js/misc.js"></script>
<script src="assets/js/dashboard.js"></script>
<script src="assets/js/todolist.js"></script>
</body>
</html>