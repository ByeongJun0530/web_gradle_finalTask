console.log("wait.js opened")

let List = [];

// 명단 등록 함수 
function waitRegist(){
    const phoneInput = document.querySelector('.phoneInput')
    const memberNumInput = document.querySelector('.memberNumInput')
    // value 호출
    const phone = phoneInput.value;
    const memberNum = memberNumInput.value;
    
    console.log(phone, memberNum);

    const waitList = {
        phone : phone,
        memberNum : memberNum
    };

    // 객체 저장 
    List.push(waitList);
    console.log(waitList);
    // option
    let option = {
        method : "POST",
        headers : {'Content-Type':'application/json'},
        body : JSON.stringify(waitList)
    }
    // fetch
    fetch('/waitRegist.do', option)
        .then(r => r.json())
        .then(d => {console.log(d)
            if(d == true){
                alert('명단 등록에 성공했습니다.')
                location.href="/waitPrint"
            }else{
                alert('명단 등록에 실패했습니다.')
            }
        })
        .catch(e => console.log(e))
}

// 명단 출력 함수 
function waitPrint(){
    const waitbody = document.querySelector('.waitbody')
    let HTML = '';
    
    fetch('/waitPrint.do')
        .then(r => r.json())
        .then(data => {
            console.log(data)
            for(let index = 0; index <= data.length-1; index++){
                const row = data[index]
                HTML += `<tr>
                            <td>${row.waitNum}</td>
                            <td>${row.phone}</td>
                            <td>${row.memberNum}</td>
                        </tr>`
            }

            waitbody.innerHTML = HTML;
        })
        .catch(e => console.log(e))
}

waitPrint();
