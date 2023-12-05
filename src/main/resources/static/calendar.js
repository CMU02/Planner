document.write('<script src="../static/index.global.js"></script>');




// 달력 메서드 & 이벤트 메서드
document.addEventListener('DOMContentLoaded', function() {
  let containerEl = document.getElementById('external-events-list')
  new FullCalendar.Draggable(containerEl, {
    itemSelector: '.card',
    eventData : function (evenEl) {
      return {
        title : evenEl.innerText.trim()
      }
    }
  });

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
    droppable : true,
  });
  calendar.render();
});

// 일정 만들기 메서드
const form = document.getElementById('form')
form.addEventListener('submit', event => {
  event.preventDefault();

  const payload = new FormData(form)
  const data = Object.fromEntries(payload)

  fetch('/user/plan', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  }).then(() => {
    alert('일정 등록이 완료 되었습니다.')
    location.reload()
  }).catch(() => {
    alert('일정 등록이 실패 했습니다.')
  })
})

// 일정 만드는 페이지 표현 메서드
let done = false
function openNewPlan() {
  if (done == false)
  {
    document.querySelector('#createPlanWrap').style.display = "none";
    document.getElementById('plus&minus').src = "../static/img/icon/Add-white.svg"
    done = true
  }
  else
  {
    document.querySelector('#createPlanWrap').style.display = "block";
    document.getElementById('plus&minus').src = "../static/img/icon/white-minus.svg"
    done = false
  }
}

