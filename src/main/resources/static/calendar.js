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

const form = document.getElementById('form')

form.addEventListener('submit', event => {
  event.preventDefault();

  const payload = new FormData(form)
  const data = Object.fromEntries(payload)

  fetch('/api/v1/user/plan', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  }).then(() => {
    alert('일정 등록이 완료 되었습니다.')
  }).catch(() => {
    alert('일정 등록이 실패 했습니다.')
  })
})

