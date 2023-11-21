document.write('<script src="/src/main/resources/static/index.global.js"></script>');

// 달력 메서드
document.addEventListener('DOMContentLoaded', function() {
  var calendatEI = document.getElementById('calendar');

  var calendar = new FullCalendar.Calendar(calendatEI, {
    headerToolbar: {
      left : 'prev,today,next',
      center : 'title',
      right: 'dayGridMonth,timeGridWeek,timeGridDay'
    },
    initialData: 'today',
    navLinks : true,
    businessHours: true,
    editable: true,
    selectable : true,
  });
  calendar.render();
});


const submit = document.getElementById("create-btn");

if(submit) {
  submit.addEventListener("click", (event) => {
    fetch("/api/planList", {
      method: "POST",
      headers: {
        "Content-Type" : "application/json",
      },
      body: JSON.stringify({
        title: document.getElementById("title")
      }),
    })
  })
}