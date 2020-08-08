ClassicEditor
			.create( document.querySelector( '.editor' ), {
				toolbar: {
					items: [
						'heading',
						'bold',
						'italic',
						'link',
						'bulletedList',
						'numberedList',
						'indent',
						'outdent',
						'imageUpload',
						'blockQuote',
						'insertTable',
						'mediaEmbed',
						'undo',
						'redo',
						'ckFinder',
						'fontColor',
						'fontBackgroundColor',
						'fontFamily',
						'highlight',
						'horizontalLine',
						'underline'
					]
				},
				language: 'ko',
				licenseKey: '',
				ckfinder: {
					// Upload the images to the server using the CKFinder QuickUpload command.
					uploadUrl: 'http://localhost:8080/api/img/img',
					resourceType: 'Images',
					privateDir:{
						backend: 'default',
						path: '.ckfinder/'
					},
					backends:{
					  name: 'default',
						adapter: 'local',
						baseUrl: 'http://localhost:8080',
						root: '/path/upload',
						disallowUnsafeCharacters: true,
						forceAscii: false,
						hideFolders: ['.*', 'CVS', '__thumbs'],
						hideFiles: ['.*'],
						htmlExtensions: ['html', 'htm', 'xml', 'js'],
						overwriteOnUpload: false,
						useProxyCommand: false
					}
				},
				image: {
					toolbar: [
						'imageTextAlternative',
						'imageStyle:full',
						'imageStyle:side'
					]
				},
				table: {
					contentToolbar: [
						'tableColumn',
						'tableRow',
						'mergeTableCells'
					]
				}
				
			} )
			.then( editor => {
				window.editor = editor;				

			    // 완료버튼 변수담기
			    let ansBtn = document.querySelector(".edit-button");
				let titleInput = document.querySelector("input[name='title']");
				let pubInput = document.querySelector("input[name='pub']");
				let id = ansBtn.nextElementSibling.innerText;

			    // 완료버튼 눌렀을 시 콜백함수
			    ansBtn.addEventListener("click", () => {
	
					let editorData = editor.getData();
					if(pubInput.checked)
						pubInput.value = true;
					else
						pubInput.value = false;
				    
					
					console.log(pubInput.value)
					
					let xhr = new XMLHttpRequest();

					xhr.open("POST", 'edit', true);
					xhr.setRequestHeader("Content-type", "application/json");

					xhr.onload = function () {
	  
						window.location.href = "list";
	  
					};
					
					let json = {id: id, title: titleInput.value, content: editorData, pub: pubInput.value};
					let data = JSON.stringify(json);
					xhr.send(data);

			      
			    });
				
				
				
			} )
			.catch( error => {
				console.error( 'Oops, something gone wrong!' );
				console.error( 'Please, report the following error in the https://github.com/ckeditor/ckeditor5 with the build id and the error stack trace:' );
				console.warn( 'Build id: 10ge4teti4fh-7y3lpv23ta33' );
				console.error( error );
			} );
