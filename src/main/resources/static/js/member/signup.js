$(function(){
    let main = $(".main");
    let signupBtn = main.find(".signup-button");
    
    let signTable = main.find(".signup-table");
    let uid = signTable.find("input[name='uid']");
    let pwd = signTable.find("input[name='pwd']");
    let pwdChk = signTable.find("input[name='pwd-check']");
    let name = signTable.find("input[name='name']");
    let email = signTable.find("input[name='email']");
    let zip = signTable.find(".zip");
    let address1 = signTable.find(".address-basic");
    let address2 = signTable.find(".address-detail");
    let address3 = signTable.find(".address-ect");
    let mobile1 = signTable.find("select[name='mobile1']");
    let mobile2 = signTable.find("input[name='mobile2']");
    let mobile3 = signTable.find("input[name='mobile3']");
    let phone1 = signTable.find("select[name='phone1']");
    let phone2 = signTable.find("input[name='phone2']");
    let phone3 = signTable.find("input[name='phone3']");
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

    uid.focusout(()=>{

        fetch('checkId',{
            method: "POST",
            headers: {
            	"Content-Type": "application/json"
            },
            body: JSON.stringify({
                uid: uid.val()
            })
        })
        .then(res=>res.json())
        .then(json=>{
            if(!regId.test(uid.val())){
            	idErr.removeClass("d-none");
            	idConfirm.addClass("d-none");

            	idCheck=false;

                return;
            } else {
            	idErr.addClass("d-none");
                
                if(json == 1) {
                	idDupleErr.removeClass("d-none");
                	idConfirm.addClass("d-none");
                    
                	idCheck=false;

                    return;
                }
                else {
                	idDupleErr.addClass("d-none");
                    idConfirm.removeClass("d-none");
                    
                    idCheck = true;
                }
            }
            
        })
    })

    pwd.focusout(()=>{
        if(!regPwd.test(pwd.val())){
            pwdErr.removeClass("d-none");            
            pwdCheck = false;
            return;
        } else {
            pwdErr.addClass("d-none");
            pwdCheck = true;
        }
    })

    pwdChk.focusout(()=>{

        if(pwd.val()!=pwdChk.val()) {
            pwdChkErr.removeClass("d-none");
            pwdCheck = false;
            return;
        } else {
            pwdChkErr.addClass("d-none");
            pwdCheck = true;
        }

    })

    email.focusout(()=>{

        fetch('checkEmail',{
            method: "POST",
            headers: {
            	"Content-Type": "application/json"
            },
            body: JSON.stringify({
                email: email.val()
            })
        })
        .then(res=>res.json())
        .then(json=>{

            if(!regEmail.test(email.val())){
                emailErr.removeClass("d-none");
                emailDupleErr.addClass("d-none");
                emailCheck = false;
                return;
                
            } else {
                emailErr.addClass("d-none");
                emailCheck = true;
                if(json == 1) {
                	emailDupleErr.removeClass("d-none");                	
                	emailCheck = false;
                    return;
                }
                else {
                    emailDupleErr.addClass("d-none");
                    emailCheck = true;
                }
            }
            
        })
    })
    
    numInput.on("keyup", function() {
	    $(this).val($(this).val().replace(/[^0-9]/g,""));
    });
    
    signupBtn.click((e)=>{


        let role = signTable.find("input[name='role']:checked");

        if((!(idCheck&&pwdCheck&&emailCheck)) || requireInput.val()=="") {
           alert("회원가입 항목을 정확히 입력해주세요!");
           e.preventDefault();
           
           return;
        }
        
        fetch('signup',{
            method: "POST",
            headers: {
            	"Content-Type": "application/json"
            },
            body: JSON.stringify({
                role: role.val(),
                uid: uid.val(),
                pwd: pwd.val(),
                name: name.val(),
                email: email.val(),
                address: zip.val()+"/"+address1.val()+"/"+address2.val()+"/"+address3.val(),
                mobile: mobile1.val() + "-" + mobile2.val() + "-" + mobile3.val(),
                phone: phone1.val() + "-" + phone2.val() + "-" + phone3.val()
            })
        })
        .then(()=>{
        	alert("회원가입이 완료되었습니다!")
        	window.location.href = "/index";
        });
    })


});