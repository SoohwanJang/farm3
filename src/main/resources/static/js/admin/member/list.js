$(function(){
   
    var body = $(".admin-body");
    var adminTitle = body.find(".admin-menu-title");
    var pager = document.querySelector(".pager");
    var ul = pager.querySelector("ul");
    var nums = ul.querySelectorAll("a");
    var table = document.querySelector("table");
//    var asyncPage = $('.checked');
    var i = 0 ;

    

    adminTitle.click(function(){

        $(this).next().slideToggle();

        if(i%2==0)
            $(this).css('background-image','url("/images/up-icon.png")');
        else
            $(this).css('background-image','url("/images/down-icon.png")');
        
        i++;
    
    });
    
    
   //--------------------------- 권한 부여 영역 ---------------------------//
   
    // 권환 비활성화 ajax처리
    $(".member-unable").click(function(){
       console.log($(this).attr("data-rno"));
       let sellerId = $(this).attr("data-rno");   // id 값을 받아오는 'data-rno'를 넘겨 받아와서 스크립트
       
        $.ajax({
            type : "get",
            url : "/admin/member/changeEnabled?sellerId="+sellerId,
            success : function(data) {
                console.log("권한이 해제되었습니다.");
               
               },
               error: function(){
                  console.log("실패");
               }
               
        });
        
    });
    
    // 권환 활성화 ajax처리
    $(".member-enable").click(function(){
       console.log($(this).attr("data-rno"));
       let sellerId = $(this).attr("data-rno");   // id 값을 받아오는 'data-rno'를 넘겨 받아와서 스크립트
       
        $.ajax({
            type : "get",
            url : "/admin/member/changeEnabled2?sellerId="+sellerId,
            success : function(data) {
                console.log("권한이 부여되었습니다.");
               
               },
               error: function(){
                  console.log("실패");
               }
               
        });
        
    });
        

    
   //--------------------------- pager 영역 ---------------------------//
    
    // 페이지 로딩 없이 넘김 에이젝스 처리
    
//    $('.checked').click(function(e) {
//       event.preventDefault();
//
//       function asyncPage(url) {
//          $.ajax ({
//             type : 'GET',
//             url : seller.html,
//             async : false,
//             dataType : 'html',
//             success: function(data) {
//                // 성공 시, 로딩 없이 페이지 이동
//                $('.board-table').html(data);
//             }
//          
//          });
//          
//       }
//       
//   })
   
    //var notices = `${list}`;
    
    ul.onclick = function(e){
       // 엘리먼트 노드가 가지는 기본 행위를 막는 함수
       e.preventDefault();
       // A 태그가 클릭 된 것이 아닌 경우 함수를 끝내기 
       if(e.target.nodeName != "A") return;
       console.log(e.target);
       
       var page = e.target.innerText;
       console.log(page);
       
       // XmlHttpRequest : callback 개념의 라이브러리
       var xhr = new XMLHttpRequest();
       xhr.open('GET', '/admin/member/seller?p='+page+'&q=', true); // 비동기옵션
       xhr.onload = function () {
          notices = JSON.parse(xhr.responseText);
           bind(); // 호출
       };
       
       xhr.send(null);       
       //정의
       function bind(){
          var tbody = table.querySelector("tbody");
          var tbodyContent = "";
          for(var i in notices){
             var n = notices[i];
             var template = $(`<tr>
                   <td>${m.id }</td>
                   <td><a href="sellerDetail?id=${m.id }">${m.uid }</a></td>
                   <td>${m.name }</td>
                   <td>${m.comName }</td>
                   <td>${m.email }</td>
                   <td>${m.address }</td>
                   <td>${m.mobile }</td>
                   <td>${m.phone }</td>
                   <td>
                   <fmt:formatDate pattern="yyyy-MM-dd" value="${m.regDate }" />
                   </td>
                   <td>
                   <button class="member-unable" type="button" value="삭제">권한제거</button>
                   <button class="member-enable" type="button" value="삭제">권한부여</button>
                   </td>
             </tr>`);
             template.appendTo(tbody);
          }
          
       };
    };

});