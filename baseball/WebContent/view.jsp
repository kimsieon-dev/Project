<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/calendar.css" />
<link href='full/core/main.css' rel='stylesheet' />
<link href='full/daygrid/main.css' rel='stylesheet' />
<link href='full/timegrid/main.min.css' rel='stylesheet' />
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/view.js"></script>
<script src='full/core/main.js'></script>
<script src='full/core/locales/ko.js'></script>
<script src='full/daygrid/main.js'></script>
<script src="full/interaction/main.min.js"></script>
<script src="full/timegrid/main.min.js"></script>
</head>
<body>
<div id="external-events">
    <p>
      <strong>Draggable Events</strong>
    </p>
    <div class="fc-event">My Event 1</div>
    <div class="fc-event">My Event 2</div>
    <div class="fc-event">My Event 3</div>
    <div class="fc-event">My Event 4</div>
    <div class="fc-event">My Event 5</div>
    <p>
      <input type="checkbox" id="drop-remove">
      <label for="drop-remove">remove after drop</label>
    </p>
  </div>
<div id='calendar'></div>
</body>
</html>
