<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="index.css">
</head>
<body>
<div class="wrapper">
    <!-- Sidebar -->
    <nav id="sidebar">
        <div class="sidebar-header">
            <img src="images/Black%20Orange%20minimalistic%20construction%20company%20logo%20(1).png" alt="ConstructionXpert Logo" class="logo">
        </div>
        <ul class="list-unstyled components">
            <li>
                <a href="#">
                    <i class="fas fa-home"></i>
                    Home
                </a>
            </li>

            <li>
                <a href="ServletAfficher" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="fas fa-project-diagram"></i>
                    Projects
                </a>

            </li>
            <li>
                <a href="#tasksSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="fas fa-tasks"></i>
                    Tasks
                </a>

            </li>
            <li>
                <a href="#resourcesSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="fas fa-boxes"></i>
                    Resources
                </a>

            </li>

            <li>
                <a href="#">
                    <i class="fas fa-cog"></i>
                    Services
                </a>
            </li>

        </ul>
        <div class="sidebar-footer">
            <p>Subscribe for newsletter</p>
            <input type="email" placeholder="Enter Email Address" class="form-control">
        </div>
    </nav>
    <!-- Page Content -->
    <div id="content">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <button type="button" id="sidebarCollapse" class="btn btn-info">
                    <i class="fas fa-align-left"></i>
                    <span>Toggle Sidebar</span>
                </button>
            </div>
        </nav>
        <h2>Sidebar #05</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua...</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua...</p>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script src="index.js"></script>
</body>
</html>
