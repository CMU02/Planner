document.write('<script src="/src/main/resources/static/index.global.js"></script>');

document.addEventListener('DOMContentLoaded', function() {
  var calendatEI = document.getElementById('calendar');

  var calendar = new FullCalendar.Calendar(calendatEI, {
    headerToolbar: {
      left : 'prev,next,today',
      center : 'title',
      right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
    },
    initialData: 'today',
    navLinks : true,
    businessHours: true,
    editable: true,
    selectable : true
  });
  calendar.render();
});