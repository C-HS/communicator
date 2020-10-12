<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import ="org.springframework.security.core.*,org.springframework.security.core.context.*" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav class="sidebar sidebar-offcanvas" id="sidebar">
  <ul class="nav">
    <li class="nav-item nav-profile">
      <a href="#" class="nav-link">
        <div class="nav-profile-image">
          <img src="assets/images/faces/face1.jpg" alt="profile">
          <span class="login-status online"></span>
        </div>
        <div class="nav-profile-text d-flex flex-column">
          <span class="font-weight-bold mb-2">
            Mr. <%
              Authentication auth = SecurityContextHolder.getContext().getAuthentication();
              if(auth != null){
                String uname = StringUtils.capitalize(auth.getName());
                out.println(uname);
              }
            %>
          </span>
          <span class="text-secondary text-small">Project Manager
          </span>
        </div>
        <i class="mdi mdi-bookmark-check text-success nav-profile-badge"></i>
      </a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="dashboard">
        <span class="menu-title">Dashboard</span>
        <i class="mdi mdi-home menu-icon"></i>
      </a>
    </li>
    <li class="nav-item" id="asset-Link">
      <a class="nav-link" data-toggle="collapse" href="#ui-asset" aria-expanded="false" aria-controls="ui-basic">
        <span class="menu-title">Asset</span>
        <i class="menu-arrow"></i>
        <i class="mdi mdi-dropbox menu-icon"></i>
      </a>
      <div class="collapse" id="ui-asset">
        <ul class="nav flex-column sub-menu">
          <li class="nav-item"> <a class="nav-link" href="rfidtag_list">RFID Tag</a></li>
          <li class="nav-item"> <a id="containerLink" class="nav-link" href="/listContainer">Container</a></li>
          <li class="nav-item"> <a id="vdLink" class="nav-link" href="vehicledevice_list">Vehicle Device</a></li>
          <li class="nav-item"> <a class="nav-link" href="vehicleList">Vehicle</a></li>
          <li class="nav-item"> <a id="rfidLink" class="nav-link" href="rfidreader_list">Fixed RFID Reader</a></li>
          <li class="nav-item"> <a class="nav-link" href="listBaseStation">Base Station</a></li>
        </ul>
      </div>
    </li>
    <li class="nav-item" id="configurationLink">
      <a class="nav-link" data-toggle="collapse" href="#ui-confoguration" aria-expanded="false" aria-controls="ui-basic">
        <span class="menu-title">Configuration</span>
        <i class="menu-arrow"></i>
        <i class="mdi mdi-settings menu-icon"></i>
      </a>
      <div class="collapse" id="ui-confoguration">
        <ul class="nav flex-column sub-menu">
          <li class="nav-item"> <a class="nav-link" id="middlewareconfigLink" href="middlewareconfig_list">Middleware Config</a></li>
          <li class="nav-item"> <a class="nav-link" id="basestationconfigLink" href="basestationconfig_list">Base Station Config</a></li>
    <!--       <li class="nav-item"> <a class="nav-link" href="middlewareConfig">Middleware Config</a></li>
          <li class="nav-item"> <a class="nav-link" href="listBaseStation">Base Station Config</a></li> -->
        </ul>
      </div>
    </li>
    <li class="nav-item" id="yard-Link">
      <a class="nav-link" data-toggle="collapse" href="#ui-yard" aria-expanded="false" aria-controls="ui-basic">
        <span class="menu-title">Yard</span>
        <i class="menu-arrow"></i>
        <i class="mdi mdi-vector-square menu-icon"></i>
      </a>
      <div class="collapse" id="ui-yard">
        <ul class="nav flex-column sub-menu">
          <li class="nav-item"> <a id="rfidLocationLink" class="nav-link" href="/listRfidLoction">Fixed Reader Location</a></li>
          <li class="nav-item"> <a class="nav-link" href="containerBlock">Container Block</a></li>
          <li class="nav-item"> <a class="nav-link" href="containerArea">Container Area</a></li>
        </ul>
      </div>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="collapse" href="#ui-connectionStatus" aria-expanded="false" aria-controls="ui-basic">
        <span class="menu-title">Connection Status</span>
        <i class="menu-arrow"></i>
        <i class="mdi mdi-wifi menu-icon"></i>
      </a>
      <div class="collapse" id="ui-connectionStatus">
        <ul class="nav flex-column sub-menu">
          <li class="nav-item"> <a class="nav-link" href="liveStatus">Live Status</a></li>
          <li class="nav-item"> <a class="nav-link" href="middewareStatus">Middleware</a></li>
          <li class="nav-item"> <a class="nav-link" href="baseStationStatus">Base Station</a></li>
          <li class="nav-item"> <a class="nav-link" href="fixedReaderStatus">Fixed RFID Reader</a></li>
        </ul>
      </div>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="collapse" href="#ui-users" aria-expanded="false" aria-controls="ui-basic">
        <span class="menu-title">User</span>
        <i class="menu-arrow"></i>
        <i class="mdi mdi-account menu-icon"></i>
      </a>
      <div class="collapse" id="ui-users">
        <ul class="nav flex-column sub-menu">
          <li class="nav-item"> <a class="nav-link" href="/listUser">Users</a></li>
        </ul>
      </div>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="movemetAtFixedReader">
        <span class="menu-title">Movement</span>
        <i class="mdi mdi-cursor-move menu-icon"></i>
      </a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/mapview" >
        <span class="menu-title">Map</span>
        <i class="mdi mdi-google-maps menu-icon"></i>
      </a>
    </li>
  </ul>
</nav>