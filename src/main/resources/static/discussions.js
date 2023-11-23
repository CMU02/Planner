var board = new Board();
function AskQuestion(){ //AskQuestion 버튼
    window.location.href = 'askQuestion';
}
function Search(){ //Search 버튼
    var keyword = prompt("Enter keyword to search:");
    var searchResult = board.searchQuestion(keyword);
    console.log(searchResult);
}
function Reset(){ //Reset 버튼

}


window.onload = function(){
    fetch('/discussions/new')
        .then(response => response.json())
        .then(result => {
            var question = result;
            for (let i = 0; i < question.length; i++) {
                board.questions.push(question[i]);
            }

        })
        .catch(error => console.error("ERROR"));

    const ul = document.getElementById("board_list")

    for(let i=0; i<board.questions.length; i++){
        let value = JSON.parse(board.questions[i]);
        let li = document.createElement("li");
        let first_div = document.createElement("div");
        first_div.className = "question";
        let first_p = document.createElement("p");
        first_p.className = "title";
        first_p.textContent = value.dcs_title;
        let second_p = document.createElement("p");
        second_p.className = "subtitle";
        second_p.textContent = value.dcs_content;

        let second_div = document.createElement("div")
        second_div.className="tags";

        let third_div = document.createElement("div")
        third_div.className="tag";
        third_div.textContent = value.cate_content;

        ul.appendChild(li);
        li.appendChild(first_div)
        first_div.appendChild(first_p);
        first_div.appendChild(second_p);
        first_div.appendChild(second_div);
        second_div.appendChild(third_div);
    }
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

