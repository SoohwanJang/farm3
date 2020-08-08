
$(function(){
	
    let searchBtn = $(".search-pop-button");
    
    let search = $(".search-pop");
    let idMenu = search.find(".id-menu");
    let pwdMenu = search.find(".pwd-menu");
	let searchSection = search.find(".search-section");
	let idSection = search.find(".id-search-section");	
	let pwdSection = search.find(".pwd-search-section");
	

	let idSearchEmail = idSection.find("input[name='email']");

	let pwdSearchUid = search.find("input[name='uid']");
	let pwdSearchEmail = pwdSection.find("input[name='email']");

	let submitIdBtn = idSection.find("input[type='submit']");
	let submitPwdBtn = pwdSection.find("input[type='submit']");
	let updatePwd = searchSection.find(".pwd-update-button");
	let resetBtn = idSection.find(".reset-button");
	
	searchBtn.click(()=>{
		window.open("popup", "아이디 / 비밀번호 찾기", "width=550, height=500, left=600, top=100");
    });
    
    idMenu.click(()=>{

        idMenu.addClass("click");
        pwdMenu.removeClass("click");

        pwdSection.hide();
        idSection.show();
        
    });
    
    pwdMenu.click(()=>{

        pwdMenu.addClass("click");
        idMenu.removeClass("click");
        
        idSection.hide();
        pwdSection.show();
        
    });
	
	submitIdBtn.click(()=>{
		
		if(idSearchEmail.val()=="")
            alert("이메일을 입력해주세요.");
            
		else {
			
			fetch('checkEmail',{
	            method: "POST",
	            headers: {
	            	"Content-Type": "application/json"
	            },
	            body: JSON.stringify({
	                email: idSearchEmail.val()
	            })
	        })
	        .then(res => res.json())
	        .then(json=>{

	            if(json != 1)
	                alert("등록된 이메일이 없습니다.")
	                
	            else {
	            	fetch('idSearch',{
	                    method: "POST",
	                    headers: {
	                        "Content-Type": "application/json"
	                    },
	                    body: JSON.stringify({
	                        email: idSearchEmail.val()
	                    })
	                })
	                .then(res => res.json())
	                .then(json=>{
	                	
	                	changIdSection();
	                	bindId(json);
	                	
	                })
	            }
	        })
			
		}
    });
	
	submitPwdBtn.click(()=>{

		if(pwdSearchUid.val()=="" || pwdSearchEmail.val()=="")
			alert("모든 항목을 입력해주세요.");
		
		else {

			fetch('checkId',{
	            method: "POST",
	            headers: {
	            	"Content-Type": "application/json"
	            },
	            body: JSON.stringify({
	                uid: pwdSearchUid.val()
	            })
	        })
	        .then(res => res.json())
	        .then(json=>{

	            if(json != 1)
	                alert("등록된 아이디가 없습니다.")
	                
	            else {
	            	fetch('checkEmail',{
						method: "POST",
						headers: {
							"Content-Type": "application/json"
						},
						body: JSON.stringify({
							email: pwdSearchEmail.val()
						})
					})
					.then(res => res.json())
					.then(json=>{
		
						if(json != 1)
							alert("등록된 이메일이 없습니다.")
							
						else {
							fetch('pwdSearch',{
								method: "POST",
								headers: {
									"Content-Type": "application/json"
								},
								body: JSON.stringify({
									uid: pwdSearchUid.val(),
									email: pwdSearchEmail.val()
								})
							})
							.then(res => res.json())
							.then(json=>{
								
								changPwdSection();
								bindPwd(json);

								// fetch('/email',{
								// 	method: "POST",
								// 	headers: {
								// 		"Content-Type": "application/json"
								// 	},
								// 	body: JSON.stringify({
								// 		uid: pwdSearchUid.val(),
								// 		email: pwdSearchEmail.val(),
								// 		pwd: json.pwd
								// 	})
								// })
								// .then(()=>{

								// 	alert("성공")
								// })
								
								fetch('updatePwd',{
									method: "POST",
									headers: {
										"Content-Type": "application/json"
									},
									body: JSON.stringify({
										uid: pwdSearchUid.val(),
										email: pwdSearchEmail.val(),
										pwd: json.pwd
									})
								})
								
							})
	                		
	                		
						}
					})
	            }
	        })

		}	

	});

    const changIdSection = ()=>{
    	searchSection.remove();
        let newIdSection= $('<section class="id-search-section search-section"></section>');
        idSection = newIdSection;
        idSection.appendTo(search);
	}
	
	const changPwdSection = ()=>{
    	pwdSection.remove();
        let newPwdSection = $('<section class="pwd-search-section search-section"></section>');
        pwdSection = newPwdSection;
        newPwdSection.appendTo(search);
    }

    const bindId = (search)=>{

        let templete = $(`
        	<span>
				고객님의 아이디는 <b>${search.uid}</b> 입니다.<br />
				해당 아이디로 로그인 하신 후, 이용 부탁드립니다.
			</span>
        `);
        templete.appendTo(idSection);
	}
	
	const bindPwd = (search)=>{

		let templete = $(`
			<span>
				임시 비밀번호는 <b>${search.pwd}</b> 입니다.<br />
				확인 후, 마이페이지에서 꼭 변경해주세요.			
			</span>
        `);
        templete.appendTo(pwdSection);
    }
    
});