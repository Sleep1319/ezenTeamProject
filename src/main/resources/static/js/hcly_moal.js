// Modal을 가져옵니다.
var modals = document.getElementsByClassName("product_modal");
// Modal을 띄우는 클래스 이름을 가져옵니다.
var btns = document.getElementsByClassName("product_btn");
// Modal을 닫는 close 클래스를 가져옵니다.
var spanes = document.getElementsByClassName("product_close");
var funcs = [];
 
// Modal을 띄우고 닫는 클릭 이벤트를 정의한 함수
function Modal(num) {
  return function() {
    // 해당 클래스의 내용을 클릭하면 Modal을 띄웁니다.
    btns[num].onclick =  function() {
        modals[num].style.display = "block";
        console.log(num);
    };
 
    // <span> 태그(X 버튼)를 클릭하면 Modal이 닫습니다.
    spanes[num].onclick = function() {
        modals[num].style.display = "none";
    };
  };
}
 
// 원하는 Modal 수만큼 Modal 함수를 호출해서 funcs 함수에 정의합니다.
for(var i = 0; i < btns.length; i++) {
  funcs[i] = Modal(i);
}
 
// 원하는 Modal 수만큼 funcs 함수를 호출합니다.
for(var j = 0; j < btns.length; j++) {
  funcs[j]();
}
 
// Modal 영역 밖을 클릭하면 Modal을 닫습니다.
window.onclick = function(event) {
  if (event.target.className == "product_modal") {
      event.target.style.display = "none";
  }
};

//================================================
    
// 상세페이지 함수

//할인 변수 설정
const before_Price = 10000; // 원래 금액
const discount_Price = 40; // 할인율 (20% 할인)
//할인율 계산 및 결과값 변수 설정
const after_Price = discount_Price-(discount_Price * (before_Price / 100));

// id=p0이 있는 곳의 strong공간에 변수 before_Price 출력
document.querySelector("#p0 strong").textContent = before_Price;
// p1의 경우 출력값에 언더스코어가 나와서 제거하고 공백넣는 코드 추가
document.querySelector(".p1 span").textContent = after_Price.toString().replace('-', '');
document.querySelector(".p2 span").textContent = discount_Price;
//밑에는 쿠폰적용 페이지에 출력됨
document.querySelector(".page_if_head_price #p3").textContent = discount_Price;
document.querySelector(".page_if_head_price #p4").textContent = after_Price.toString().replace('-', '');


//상세 페이지 옵션
// 초기 수량 설정
let quantity = 1;

// 원래 금액과 할인율 설정

// 함수를 만들어 할인된 가격 계산
function calculatediscount_Price(before_Price, after_Price, quantity) {
  const discount_Price = before_Price - (before_Price * (after_Price / 100));
  return discount_Price * quantity; // 수량을 곱하여 반환
}

// 초기화면에 할인된 가격 표시
document.querySelector(".p1 span").textContent = calculatediscount_Price(before_Price, discount_Price, quantity).toString().replace('-', '');

// 수량 및 가격 업데이트 함수
function updateQuantityAndPrice() {
  document.getElementById("quantity").textContent = quantity; // 수량 표시 업데이트
  const updatedPrice = calculatediscount_Price(before_Price, discount_Price, quantity);
  document.querySelector(".p1 span").textContent = updatedPrice.toString().replace('-', ''); // 가격 표시 업데이트
}

// 수량 늘리기 버튼 클릭 시
document.querySelector("#increase-quantity").addEventListener("click", function () {
  quantity++; // 수량 증가
  updateQuantityAndPrice(); // 수량 및 가격 업데이트
});

// 수량 줄이기 버튼 클릭 시
document.querySelector("#decrease-quantity").addEventListener("click", function () {
  if (quantity > 1) {
    quantity--; // 수량 감소 (최소 1개 이상 유지)
    updateQuantityAndPrice(); // 수량 및 가격 업데이트
  }
});


// 수량과 가격 업데이트 함수
function updateQuantityAndPrice() {
  document.getElementById("quantity").textContent = quantity; // 수량 표시 업데이트
  const updatedPrice = calculatediscount_Price(before_Price, discount_Price, quantity);
  document.querySelector(".p_updatedPrice span").textContent = updatedPrice.toString().replace('-', ''); // 가격 표시 업데이트
}



//=================상세페이지 상세보기===========================
function toggleButtons() {
  let sang_detailinfo = document.querySelector('.sang_detailinfo');
  let btnOpen = document.querySelector('.sang_btn_open');
  let btnClose = document.querySelector('.btn_close');

  if (sang_detailinfo.classList.contains('showstep1')) {
      sang_detailinfo.classList.remove('showstep1');
      btnOpen.style.display = 'none';
      btnClose.style.display = 'block';
  } else if (sang_detailinfo.classList.contains('showstep1')) {
      sang_detailinfo.classList.add('showstep1');
      btnOpen.style.display = 'block';
      btnClose.style.display = 'none';
  }
}

document.addEventListener('DOMsang_ContentLoaded', function () {
  let sang_contentHeight = document.querySelector('.sang_detailinfo > .sang_content').offsetHeight;
  if (sang_contentHeight <= 300) {
      document.querySelector('.sang_detailinfo').classList.remove('showstep1');
      document.querySelector('.sang_btn_open').style.display = 'none';
  }
});