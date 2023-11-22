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
    console.log(document.getElementById('title'))

    fetch("/api/planList", {
      method: "POST",
      headers: {
        "Content-Type" : "application/json",
      },
      body: JSON.stringify({
        title: document.getElementById("title").value,
        start: document.getElementById("start").value,
        end : document.getElementById("end").value,
        memo: document.getElementById("memo").vlaue
      })
    }) .then(() => {
        alert('등록이 완료 되었습니다.')
        location.replace('/Calendar');
    })
  })
}