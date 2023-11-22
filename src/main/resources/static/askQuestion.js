const cancelBtn = document.getElementById("cancel");
const postBtn = document.getElementById("post");

cancelBtn.onclick = function(){
    window.location.href = 'discussions.html';
}

postBtn.onclick = function(){
    fetch('/discussions/post', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({title: title, subTitle: content, tags: tagList})
    })
        .then(response => {
            if (response.ok) {
                console.log('데이터를 서버로 전송했습니다.');
            }
        })
        .catch(error => {
            console.error('데이터 전송 중 오류 발생: ' + error);
        });
    //var question = new Question(title, content, tagList);
    //board.addQuestion(question);
}