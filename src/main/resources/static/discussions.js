var board = new Board();
function AskQuestion(){ //AskQuestion 버튼

    var title = prompt("제목을 입력하세요.");
    var content = prompt("내용을 입력하세요.");
    var tag = prompt("태그를 입력하세요. (쉼표 ','로 구분)");
    var tagList = tag.split(',');

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
function Search(){ //Search 버튼
    var keyword = prompt("Enter keyword to search:");
    var searchResult = board.searchQuestion(keyword);
    console.log(searchResult);
}
function Reset(){ //Reset 버튼

}




function Board(){ //질문들을 저장하는 보드 객체
    this.questions = []; //리스트에 질문을 담음
}
function Question(title, content, tag){ //질문 객체
    this.title = title; //질문 제목
    this.content = content; //질문 내용
    this.tag = tag; //질문 태그 (리스트로 받을 예정)
    this.timestamp = new Date(); //질문 올린 시간
}
/*
Board.prototype.addQuestion = function(post){ //질문 추가 메서드
    this.questions.push(post);
}
*/

Board.prototype.getQuestion = function() { //질문 가져오기 메서드
    return this.questions;
}
Board.prototype.searchQuestion = function(keyword){
    return this.questions.filter(function (question){
        var titleName = String(question.title)
        titleName = titleName.toLowerCase();
        keyward = String(keyword).toLowerCase();
        return titleName.includes(keyward);
    });
}
Board.prototype.searchQuestionWithTag = function (tag) {
    tag = String(tag);
    return this.questions.filter(function (question) {
        var tagList = tag.split(","); // 검색할 때 ','로 태그 분할 (Spring,Java)

        // question의 태그 목록 중에서 tagList에 포함된 태그 중 하나라도 있는지 확인
        return tagList.some(function (tag) {
            return question.tag.includes(tag.trim());
        });
    });
};