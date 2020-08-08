$(function(){
    let main = $(".main");
    let signupBtn = main.find(".signup-button");
    
    let signTable = main.find(".signup-table");
    let email = signTable.find("input[name='email']");
    let zip = signTable.find(".zip");
   
    let numInput = signTable.find(".num-input");
    let requireInput = signTable.find(".required");
    
    let idErr = signTable.find(".id-err");
    let idDupleErr = signTable.find(".id-duple-err");
    let idConfirm = signTable.find(".id-confirm");

    let pwdErr = signTable.find(".pwd-err");
    let pwdChkErr = signTable.find(".pwd-check-err");
    
    let emailErr = signTable.find(".email-err");
    let emailDupleErr = signTable.find(".email-duple-err");

    let regId = RegExp(/^[a-zA-Z0-9]{6,12}$/);
    let regPwd = RegExp(/^[a-zA-Z0-9]{4,12}$/);
    let regEmail = RegExp(/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/);
    let regNum = RegExp(/^[0-9]*$/);

    let idCheck = false;
    let pwdCheck = false;
    let emailCheck = false;

    
    email.focusout(()=>{


            if(!regEmail.test(email.val())){
                emailErr.removeClass("d-none");
                emailDupleErr.addClass("d-none");
                emailCheck = false;
                return;
                
            } else {
                emailErr.addClass("d-none");
                emailCheck = true;
            }
          
    })
    
    numInput.on("keyup", function() {
	    $(this).val($(this).val().replace(/[^0-9]/g,""));
    });
    
    signupBtn.click((e)=>{


        let role = signTable.find("input[name='role']:checked");

        if(requireInput.val()=="") {
           alert("항목을 정확히 입력해주세요!");
           e.preventDefault();
           
           return;
        }
    })


});